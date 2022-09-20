package org.example;

import org.example.person.parser.PersonDataParser;
import org.example.storage.FileStorage;
import org.example.storage.Storage;

public class Main {
    private static final String STORAGE_DIRECTORY = "storage";

    public static void main(String[] args) {
        Storage storage = new FileStorage(STORAGE_DIRECTORY);
        PersonDataParser parser = new PersonDataParser();

        new UI(storage, parser).run();
    }

}