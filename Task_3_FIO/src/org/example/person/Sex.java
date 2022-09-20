package org.example.person;

public enum Sex {
    FEMALE {
        @Override
        public String toTextCode() {
            return "f";
        }
    },
    MALE {
        @Override
        public String toTextCode() {
            return "m";
        }
    },
    UNKNOWN {
        @Override
        public String toTextCode() {
            return "u";
        }
    }
    ;

    public abstract String toTextCode();
}