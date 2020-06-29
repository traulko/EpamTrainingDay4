package com.traulko.task4_1.validator;

public class NumberValidator {
    public static final int MAX_THREE_DIGIT_NUMBER = 999;
    public static final int MIN_THREE_DIGIT_NUMBER = 100;

    public boolean isThreeDigitNumber(int number) {
        boolean isMoreThanMin = number >= MIN_THREE_DIGIT_NUMBER;
        boolean isLessThanMax = number <= MAX_THREE_DIGIT_NUMBER;
        return isLessThanMax && isMoreThanMin;
    }
}
