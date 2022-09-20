package org.example.person.parser;

import org.example.person.PersonDataField;

public class StringDataField extends DataField<String> {

    public StringDataField(PersonDataField fieldName) {
        super(fieldName);
    }

    @Override
    public boolean trySet(String value) {
        setValue(value);
        return true;
    }
}