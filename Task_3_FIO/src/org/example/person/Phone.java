package org.example.person;

public class Phone {
    final private String value;

    public Phone(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static boolean isValidPhone(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}