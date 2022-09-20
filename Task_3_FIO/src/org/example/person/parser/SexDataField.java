package org.example.person.parser;

import org.example.person.PersonDataField;
import org.example.person.Sex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SexDataField extends DataField<Sex> {

    public SexDataField() {
        super(PersonDataField.SEX);
    }

    public static String describeFormat() {
        return Arrays.stream(Sex.values()).map(Sex::toTextCode).collect(Collectors.joining("/"));
    }

    @Override
    public boolean trySet(String value) {
        for (Sex sex : Sex.values()) {
            if (sex.toTextCode().equals(value)) {
                setValue(sex);
                return true;
            }
        }
        return false;
    }
}