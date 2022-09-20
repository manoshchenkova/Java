package org.example.storage;

import org.example.person.PersonData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

public class FileStorage implements Storage {

    private final String rootDirectory;

    public FileStorage(String rootDirectory) {
        this.rootDirectory = rootDirectory;
        initStorage(rootDirectory);
    }

    @Override
    public void add(PersonData personData) {
        File file = new File(rootDirectory, personData.surname);
        String personDataAsText = convertPersonDataToText(personData);
        try {
            Files.writeString(file.toPath(), personDataAsText + "\n", StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertPersonDataToText(PersonData personData) {
        return String.format("<%s><%s><%s><%s><%s><%s>",
                personData.surname,
                personData.name,
                personData.fatherName,
                personData.birthDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                personData.phone.toString(),
                personData.sex.toTextCode()
        );
    }

    private static void initStorage(String directory) {
        File storage = new File(directory);
        if (!storage.exists()) {
            if (!storage.mkdirs()) {
                throw new RuntimeException("Failed to initialize directory to store files");
            }
        }
    }
}