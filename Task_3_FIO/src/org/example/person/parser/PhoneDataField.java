package org.example.person.parser;

import org.example.person.PersonDataField;
import org.example.person.Phone;

public class PhoneDataField extends DataField<Phone> {

    public PhoneDataField() {
        super(PersonDataField.PHONE);
    }

    @Override
    public boolean trySet(String value) {
        if (Phone.isValidPhone(value)) {
            setValue(new Phone(value));
            return true;
        }
        return false;
    }
}