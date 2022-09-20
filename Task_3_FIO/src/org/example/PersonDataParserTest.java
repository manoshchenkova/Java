package org.example;

import org.example.person.PersonData;
import org.example.person.Sex;
import org.example.person.PersonDataField;
import org.example.person.parser.PersonDataParser;
import org.example.person.parser.InvalidPersonDataException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class PersonDataParserTest {

    PersonDataParser parser = new PersonDataParser();

    @Test()
    void shouldRaiseValidationExceptionWhenNotEnoughPartsPresents() {
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse(null));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse(""));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F"));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I"));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O"));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01.01.2000"));
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01.01.2000 f"));
    }

    @Test
    void shouldRaiseValidationExceptionWhenInputContainsMoreThenExpectedParts() {
        Assertions.assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01.01.2000 f 123 extra"));
    }

    @Test
    void shouldRaiseValidationExceptionWhenBirthdayCantBeParsed() {
        InvalidPersonDataException e = assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01/01/2000 f 123"));
        Assertions.assertFalse(e.isFieldSet(PersonDataField.BIRTHDAY));
    }

    @Test
    void shouldRaiseValidationExceptionWhenSexCantBeParsed() {
        InvalidPersonDataException e = assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01.01.2000 X 123"));
        Assertions.assertFalse(e.isFieldSet(PersonDataField.SEX));
    }

    @Test
    void shouldRaiseValidationExceptionWhenPhoneCantBeParsed() {
        InvalidPersonDataException e = assertThrowsExactly(InvalidPersonDataException.class, () -> parser.parse("F I O 01.01.2000 f not-a-phone"));
        Assertions.assertFalse(e.isFieldSet(PersonDataField.PHONE));
    }

    @Test
    void shouldReturnPersonDataWhenTextIsValid() throws Exception {
        PersonData personData = parser.parse("F I O 01.01.2000 f 123");
        Assertions.assertEquals("F", personData.surname);
        Assertions.assertEquals("I", personData.name);
        Assertions.assertEquals("O", personData.fatherName);
        Assertions.assertEquals(LocalDate.of(2000, 1, 1), personData.birthDay);
        Assertions.assertEquals(Sex.FEMALE, personData.sex);
        Assertions.assertEquals("123", personData.phone.toString());
    }

    @Test
    void shouldReturnMalePersonDataWhenTextIsValid() throws Exception {
        PersonData personData = parser.parse("01.01.2000 m 123 F I O");
        Assertions.assertEquals("F", personData.surname);
        Assertions.assertEquals("I", personData.name);
        Assertions.assertEquals("O", personData.fatherName);
        Assertions.assertEquals(LocalDate.of(2000, 1, 1), personData.birthDay);
        Assertions.assertEquals(Sex.MALE, personData.sex);
        Assertions.assertEquals("123", personData.phone.toString());
    }

}