package ru.otus.exceptions.exception;

public class BirthDayFormatException extends RuntimeException {
    public BirthDayFormatException() {
    }

    public BirthDayFormatException(String message) {
        super(message);
    }

    public BirthDayFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
