package com.traulko.task4_1.parser;

import com.traulko.task4_1.exception.IncorrectValueException;

public class ElementsParser {
    public int[] parseToIntArray(String... elementsStringFormat) throws IncorrectValueException {
        int arraySize = elementsStringFormat.length;
        int[] elements = new int[arraySize];
        try {
            for (int i = 0; i < arraySize; i++) {
                int element = Integer.parseInt(elementsStringFormat[i]);
                elements[i] = element;
            }
            return elements;
        } catch (NumberFormatException e) {
            throw new IncorrectValueException("Parser error", e);
        }
    }
}
