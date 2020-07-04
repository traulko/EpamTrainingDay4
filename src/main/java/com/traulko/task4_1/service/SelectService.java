package com.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.validator.NumberValidator;

public class SelectService {

    public CustomArray selectPrimeNumbers(CustomArray array) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }

        int primeNumbersArraySize = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isPrimeNumber(array.get(i))) {
                primeNumbersArraySize++;
            }
        }

        int[] primeNumbers = new int[primeNumbersArraySize];
        int currentPrimeNumbersIndex = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isPrimeNumber(array.get(i))) {
                primeNumbers[currentPrimeNumbersIndex] = array.get(i);
                currentPrimeNumbersIndex++;
            }
        }
        return new CustomArray(primeNumbers);
    }

    public CustomArray selectFibonacciNumbers(CustomArray array) throws IncorrectValueException {
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        int fibonacciNumbersArraySize = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isFibonacciNumber(array.get(i))) {
                fibonacciNumbersArraySize++;
            }
        }

        int[] fibonacciNumbers = new int[fibonacciNumbersArraySize];
        int currentFibonacciNumbersIndex = 0;
        for (int i = 0; i < array.length(); i++) {
            if (isFibonacciNumber(array.get(i))) {
                fibonacciNumbers[currentFibonacciNumbersIndex] = array.get(i);
                currentFibonacciNumbersIndex++;
            }
        }
        return new CustomArray(fibonacciNumbers);
    }

    public CustomArray selectNumbersWithThreeUniqueDigits(CustomArray array) throws IncorrectValueException {
        NumberValidator numberValidator = new NumberValidator();
        if (array == null || array.length() < 1) {
            throw new IncorrectValueException("Incorrect array");
        }
        int numberArraySize = 0;
        int currentNumber;
        for (int i = 0; i < array.length(); i++) {
            currentNumber = array.get(i);
            if (numberValidator.isThreeDigitNumber(currentNumber)) {
                if (isUniqueDigits(currentNumber)) {
                    numberArraySize++;
                }
            }
        }

        int[] threeUniqueDigitsNumbers = new int[numberArraySize];
        int currentThreeUniqueDigitsNumbersIndex = 0;
        for (int i = 0; i < array.length(); i++) {
            currentNumber = array.get(i);
            if (numberValidator.isThreeDigitNumber(currentNumber)) {
                if (isUniqueDigits(currentNumber)) {
                    threeUniqueDigitsNumbers[currentThreeUniqueDigitsNumbersIndex] = currentNumber;
                    currentThreeUniqueDigitsNumbersIndex++;
                }
            }
        }
        return new CustomArray(threeUniqueDigitsNumbers);
    }

    private boolean isPrimeNumber(int number) {
        boolean result = true;
        if (number <= 0) {
            result = false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    result = false;
                }
            }
        }
        return result;
    }

    private boolean isFibonacciNumber(int number) {
        int first = 1;
        int second = 1;
        int sumOfFirstAndSecondNumbers = first + second;
        if (number == first || number == sumOfFirstAndSecondNumbers) {
            return true;
        } else {
            while (sumOfFirstAndSecondNumbers < number) {
                first = second;
                second = sumOfFirstAndSecondNumbers;
                sumOfFirstAndSecondNumbers = first + second;
            }
        }
        return sumOfFirstAndSecondNumbers == number;
    }

    private boolean isUniqueDigits(int number) throws IncorrectValueException {
        CustomArray customArray = brokeForDigitArray(number);
        boolean isUnique = true;
        for (int i = 0; i < customArray.length() - 1; i++) {
            if (customArray.get(i) == customArray.get(i + 1)) {
                isUnique = false;
            }
        }
        return isUnique;
    }

    private CustomArray brokeForDigitArray(int number) throws IncorrectValueException {
        if (number == 0) {
            throw new IncorrectValueException("Current number is zero");
        }
        number = Math.abs(number);
        int digitsCount = 0;
        for (int i = number; i > 0; i /= 10) {
            digitsCount++;
        }

        int modulo;
        int[] digitArray = new int[digitsCount];
        int currentIndex = 0;
        for (int i = number; i > 0; i /= 10) {
            modulo = i % 10;
            digitArray[currentIndex] = modulo;
            currentIndex++;
        }
        return new CustomArray(digitArray);
    }
}
