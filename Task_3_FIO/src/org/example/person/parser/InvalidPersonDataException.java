package org.example.person.parser;

import org.example.person.PersonDataField;

import java.util.Set;

public class InvalidPersonDataException extends Exception {

    private Set<PersonDataField> unsetFields;

    public InvalidPersonDataException(String message, Set<PersonDataField> unsetFields) {
        super(message);
        this.unsetFields = unsetFields;
    }

    public boolean isFieldSet(PersonDataField field) {
        return !unsetFields.contains(field);
    }
}