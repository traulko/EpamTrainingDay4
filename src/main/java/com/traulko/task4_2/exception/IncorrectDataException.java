package com.traulko.task4_2.exception;

public class IncorrectDataException extends Exception {
    public IncorrectDataException(String message) {
        super(message);
    }

    public IncorrectDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
