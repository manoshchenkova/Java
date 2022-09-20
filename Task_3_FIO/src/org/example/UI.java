package org.example;

import org.example.person.PersonData;
import org.example.person.parser.InvalidPersonDataException;
import org.example.person.parser.PersonDataParser;
import org.example.storage.Storage;

import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {
    private Storage storage;
    private PersonDataParser parser;

    public UI(Storage storage, PersonDataParser parser) {
        this.storage = storage;
        this.parser = parser;
    }

    public void run() {
        String fieldsFormat = parser.getFieldsFormat().collect(Collectors.joining(" "));
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Input person data or leave blank to finish");
                System.out.println("Expected format is separated by space fields: " + fieldsFormat);

                String line = scanner.nextLine();
                if (line.isBlank()) {
                    return;
                }

                try {
                    PersonData personData = parser.parse(line);
                    storage.add(personData);
                    System.out.println("Stored");
                } catch (InvalidPersonDataException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
