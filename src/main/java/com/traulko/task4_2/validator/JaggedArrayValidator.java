package com.traulko.task4_2.validator;

public class JaggedArrayValidator {
    private static final int MIN_INDEX_VALUE = 0;

    public boolean isCorrect(int index, int length) {
        boolean isMoreMinIndex = index >= MIN_INDEX_VALUE;
        boolean isLessLength = index < length;
        return isLessLength && isMoreMinIndex;
    }
}
