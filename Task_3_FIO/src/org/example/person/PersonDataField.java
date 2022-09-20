package org.example.person;

import org.example.person.parser.BirthdayField;
import org.example.person.parser.SexDataField;

public enum PersonDataField {
    SURNAME {
        @Override
        public String getNameWithFormat() {
            return "Surname";
        }
    },
    NAME {
        @Override
        public String getNameWithFormat() {
            return "Name";
        }
    },
    FATHER_NAME {
        @Override
        public String getNameWithFormat() {
            return "Father-name";
        }
    },
    BIRTHDAY {
        @Override
        public String getNameWithFormat() {
            return String.format("Birthday(%s)", BirthdayField.describeFormat());
        }
    },
    PHONE {
        @Override
        public String getNameWithFormat() {
            return "Phone(only digits)";
        }
    },
    SEX {
        @Override
        public String getNameWithFormat() {
            return String.format("Sex(%s)", SexDataField.describeFormat());
        }
    };
    public abstract String getNameWithFormat();

}