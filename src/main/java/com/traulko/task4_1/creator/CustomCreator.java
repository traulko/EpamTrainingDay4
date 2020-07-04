package com.traulko.task4_1.creator;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.parser.ElementsParser;
import com.traulko.task4_1.reader.ConsoleReader;
import com.traulko.task4_1.reader.CustomFileReader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

public class CustomCreator {
    private static final int MAX_RANDOM_VALUE = 1000;
    private static final int MIN_RANDOM_VALUE = -1000;
    private static final String SIZE = "5";
    private static final String[] ELEMENTS = {"1", "2", "3", "4", "5"};

    public CustomArray createArrayFile(String fileName) throws IncorrectValueException {
        CustomFileReader customFileReader = new CustomFileReader();
        ElementsParser parser = new ElementsParser();
        String[] data = customFileReader.readFromFile(fileName);
        int[] elements = parser.parseToIntArray(data);
        return new CustomArray(elements);
    }

    public CustomArray createArrayConsole() throws IncorrectValueException {
        ConsoleReader consoleReader = new ConsoleReader();
        InputStream size = new ByteArrayInputStream(SIZE.getBytes());
        int[] numbers = consoleReader.readArraySize(size);
        InputStream currentElement;
        for (int i = 0; i < numbers.length; i++) {
            currentElement = new ByteArrayInputStream(ELEMENTS[i].getBytes());
            numbers[i] = consoleReader.readArrayElement(i, currentElement);
        }
        return new CustomArray(numbers);
    }

    public CustomArray createArrayRandom(int size) throws IncorrectValueException {
        if (size < 1) {
            throw new IncorrectValueException("Size should be > 1");
        }
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = MIN_RANDOM_VALUE + random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1);
        }
        return new CustomArray(array);
    }
}
