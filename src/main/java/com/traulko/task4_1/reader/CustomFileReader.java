package com.traulko.task4_1.reader;

import com.traulko.task4_1.exception.IncorrectValueException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomFileReader {
    private static final String DEFAULT_PATH = "data\\task4_1default.txt";
    private static final String REGEX = " ";

    public String[] readFromFile(String file) throws IncorrectValueException {
        Path path = Paths.get(DEFAULT_PATH);
        if (file != null) {
            path = Paths.get(file);
            if (Files.notExists(path)) {
                path = Paths.get(DEFAULT_PATH);
            }
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String stringLine = Files.readAllLines(path).get(0);
            return stringLine.split(REGEX);
        } catch (IOException | IndexOutOfBoundsException e) {
            throw new IncorrectValueException("File reader error", e);
        }
    }
}
