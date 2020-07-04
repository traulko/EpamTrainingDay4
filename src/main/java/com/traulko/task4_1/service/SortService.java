package com.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;

public class SortService {
    public void bubbleSort(CustomArray array, boolean isReverse) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        for (int i = 0; i < array.length(); i++) {
            for (int j = 0; j < array.length() - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    swap(array, j, j + 1);
                }
            }
        }
        if (isReverse) {
            reverse(array);
        }
    }

    public void selectionSort(CustomArray array, boolean isReverse) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        for (int i = 0; i < array.length(); i++) {
            int minValueIndex = i;
            for (int j = i; j < array.length(); j++) {
                if (array.get(minValueIndex) > array.get(j)) {
                    minValueIndex = j;
                }
            }
            swap(array, i, minValueIndex);
        }
        if (isReverse) {
            reverse(array);
        }
    }

    public void insertionSort(CustomArray array, boolean isReverse) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        for (int i = 1; i < array.length(); i++) {
            int currentElement = array.get(i);
            int j = i - 1;
            while (j >= 0 && currentElement < array.get(j)) {
                array.set(j + 1, array.get(j));
                j--;
            }
            array.set(j + 1, currentElement);
        }
        if (isReverse) {
            reverse(array);
        }
    }

    private void swap(CustomArray array, int firstIndex,
                      int secondIndex) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        if (!(array.isCorrect(firstIndex))
                || !(array.isCorrect(secondIndex))) {
            throw new IncorrectValueException("incorrect array index");
        }
        int firstNumber = array.get(firstIndex);
        int secondNumber = array.get(secondIndex);
        array.set(secondNumber, firstIndex);
        array.set(firstNumber, secondIndex);
    }

    private void reverse(CustomArray array) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        for (int i = 0; i < array.length() / 2; i++) {
            swap(array, i, (array.length() - 1) - i);
        }
    }
}
