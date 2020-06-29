package com.traulko.task4_1.reader;

import com.traulko.task4_1.console.ConsolePrint;
import com.traulko.task4_1.exception.IncorrectValueException;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    public int[] readArraySize(InputStream in) throws IncorrectValueException {
        Scanner scanner = new Scanner(in);
        ConsolePrint consolePrint = new ConsolePrint();
        try {
            consolePrint.printSizeRequest();
            int arraySize = scanner.nextInt();
            if (arraySize < 1) {
                throw new IncorrectValueException("Incorrect array size");
            }
            return new int[arraySize];
        } catch (IncorrectValueException e) {
            throw new IncorrectValueException("Incorrect array size");
        }
    }

    public int readArrayElement(int index, InputStream in) throws IncorrectValueException {
        Scanner scanner = new Scanner(in);
        ConsolePrint consolePrint = new ConsolePrint();
        consolePrint.printElementRequest(index);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IncorrectValueException("Incorrect array element");
        }
    }
}
