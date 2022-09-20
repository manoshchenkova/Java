package org.example.person.parser;

import org.example.person.PersonDataField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BirthdayField extends DataField<LocalDate> {

    private static final String DATE_FORMAT_HUMAN_READABLE = "dd.MM.yyyy";
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d.M.yyyy");

    public BirthdayField() {
        super(PersonDataField.BIRTHDAY);
    }

    public static String describeFormat() {
        return DATE_FORMAT_HUMAN_READABLE;
    }

    @Override
    public boolean trySet(String value) {
        try {
            LocalDate birthday = LocalDate.parse(value, dateFormat);
            setValue(birthday);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}