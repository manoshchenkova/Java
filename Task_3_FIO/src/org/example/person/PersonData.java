package org.example.person;

import java.time.LocalDate;

public class PersonData {
    public final String surname, name, fatherName;
    public final LocalDate birthDay;
    public final Sex sex;
    public final Phone phone;

    public PersonData(String surname, String name, String fatherName, LocalDate birthDay, Sex sex, Phone phone) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.birthDay = birthDay;
        this.sex = sex;
        this.phone = phone;
    }
}