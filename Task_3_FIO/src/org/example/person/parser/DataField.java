package org.example.person.parser;

import org.example.person.PersonDataField;

public abstract class DataField<T> {
    private final PersonDataField fieldName;

    private T value;

    public DataField(PersonDataField fieldName) {
        this.fieldName = fieldName;
    }

    public boolean set(String part) {
        if (isSet()) {
            return false;
        }

        return trySet(part);
    }

    public boolean isSet() {
        return value != null;
    }

    public PersonDataField getFieldName() {
        return fieldName;
    }

    public T getValue() {
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    protected abstract boolean trySet(String value);

}