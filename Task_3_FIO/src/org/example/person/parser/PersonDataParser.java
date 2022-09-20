package org.example.person.parser;

import org.example.person.PersonData;
import org.example.person.PersonDataField;
import org.example.person.Phone;
import org.example.person.Sex;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonDataParser {

    private static final String PARTS_DELIMITER = " ";

    public PersonData parse(String line) throws InvalidPersonDataException {
        List<String> parts = splitAndTrim(line);

        PersonDataFields personDataFields = new PersonDataFields();

        checkExpectedSizeOrThrow(parts, personDataFields.size());
        for (String part : parts) {
            personDataFields.setApplicableField(part);
        }

        checkThatAllFieldsAreSetOrThrow(personDataFields);
        return toPersonData(personDataFields);
    }

    private static PersonData toPersonData(PersonDataFields personDataFields) {
        Map<PersonDataField, Object> fields = personDataFields.toMap();
        return new PersonData(
                (String) fields.get(PersonDataField.SURNAME),
                (String) fields.get(PersonDataField.NAME),
                (String) fields.get(PersonDataField.FATHER_NAME),
                (LocalDate) fields.get(PersonDataField.BIRTHDAY),
                (Sex) fields.get(PersonDataField.SEX),
                (Phone) fields.get(PersonDataField.PHONE)
        );
    }

    private static List<String> splitAndTrim(String line) {
        if (line == null)
            line = "";
        return Arrays.stream(line.split(PARTS_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void checkThatAllFieldsAreSetOrThrow(PersonDataFields personDataFields) throws InvalidPersonDataException {
        Set<PersonDataField> unsetFields = personDataFields.getUnsetFields();
        if (!unsetFields.isEmpty()) {
            throw new InvalidPersonDataException("Some fields were not set: " + unsetFields, unsetFields);
        }
    }

    private static void checkExpectedSizeOrThrow(List<String> parts, int expectedSize) throws InvalidPersonDataException {
        if (parts.size() != expectedSize) {
            throw new InvalidPersonDataException(
                    String.format("Personal data should contains %d parts separated by space", expectedSize),
                    Set.of(PersonDataField.values()));
        }
    }

    public Stream<String> getFieldsFormat() {
        return Arrays.stream(PersonDataField.values())
                .map(PersonDataField::getNameWithFormat);
    }

    private static class PersonDataFields {
        private final List<DataField<? extends Object>> dataFields;

        public PersonDataFields() {
            this.dataFields = List.of(
                    new SexDataField(),
                    new PhoneDataField(),
                    new BirthdayField(),
                    new StringDataField(PersonDataField.SURNAME),
                    new StringDataField(PersonDataField.NAME),
                    new StringDataField(PersonDataField.FATHER_NAME)
            );

        }

        public int size() {
            return dataFields.size();
        }

        public void setApplicableField(String text) {
            for (DataField<?> dataField : dataFields) {
                if (dataField.set(text)) {
                    break;
                }
            }
        }

        public Map<PersonDataField, Object> toMap() {
            return dataFields.stream().collect(Collectors.toMap(DataField::getFieldName, DataField::getValue));
        }

        public Set<PersonDataField> getUnsetFields() {
            return dataFields.stream()
                    .filter(Predicate.not(DataField::isSet))
                    .map(DataField::getFieldName)
                    .collect(Collectors.toSet());
        }
    }
}