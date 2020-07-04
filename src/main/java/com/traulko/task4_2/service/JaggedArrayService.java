package com.traulko.task4_2.service;

import com.traulko.task4_2.exception.IncorrectDataException;
import com.traulko.task4_2.type.SortType;
import com.traulko.task4_2.validator.JaggedArrayValidator;

public class JaggedArrayService {
    public void bubbleSort(int[][] numbers, SortType sortType, boolean isReverse) throws IncorrectDataException {
        if (numbers == null || sortType == null) {
            throw new IncorrectDataException("Incorrect parameters");
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (sortType.sortMethod(numbers[i]) > sortType.sortMethod(numbers[i + 1])) {
                    swapLines(numbers, i, i + 1);
                    flag = true;
                }
            }
        }
        if (isReverse) {
            reverseLines(numbers);
        }
    }

    private void swapLines(int[][] numbers, int firstIndex, int secondIndex) throws IncorrectDataException {
        JaggedArrayValidator validator = new JaggedArrayValidator();
        if (numbers == null) {
            throw new IncorrectDataException("Incorrect numbers array");
        }
        boolean isFirstIndexCorrect = validator.isCorrect(firstIndex, numbers.length);
        boolean isSecondIndexCorrect = validator.isCorrect(secondIndex, numbers.length);
        if (!isFirstIndexCorrect || !isSecondIndexCorrect) {
            throw new IncorrectDataException("Incorrect index parameters");
        }
        int[] firstNumber = numbers[firstIndex];
        numbers[firstIndex] = numbers[secondIndex];
        numbers[secondIndex] = firstNumber;
    }

    private void reverseLines(int[][] numbers) throws IncorrectDataException {
        if (numbers == null) {
            throw new IncorrectDataException("Incorrect number matrix");
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            int secondIndex = numbers.length - 1 - i;
            swapLines(numbers, i, secondIndex);
        }
    }
}
