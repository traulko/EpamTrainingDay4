package com.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;

public class SearchService {
    public int binarySearch(CustomArray array, int number) throws IncorrectValueException {
        SortService sortService = new SortService();
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        int position = -1;
        int firstIndex = 0;
        int lastIndex = array.length() - 1;
        sortService.bubbleSort(array, false);
        while (firstIndex <= lastIndex) {
            int middlePosition = (firstIndex + lastIndex) / 2;
            if (array.get(middlePosition) == number) {
                position = middlePosition;
                break;
            } else if (array.get(middlePosition) < number) {
                firstIndex = middlePosition + 1;
            } else {
                lastIndex = middlePosition - 1;
            }
        }
        return position;
    }

    public int searchMinimalElement(CustomArray array) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }

        int minElement = array.get(0);
        for (int i = 0; i < array.length(); i++) {
            if (minElement > array.get(i)) {
                minElement = array.get(i);
            }
        }
        return minElement;
    }

    public int searchMaximalElement(CustomArray array) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }

        int maxElement = array.get(0);
        for (int i = 0; i < array.length(); i++) {
            if (maxElement < array.get(i)) {
                maxElement = array.get(i);
            }
        }
        return maxElement;
    }
}
