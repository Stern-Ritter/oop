package ru.otus.exceptions.exception;

public class GenderFormatException extends RuntimeException {
    public GenderFormatException() {
    }

    public GenderFormatException(String message) {
        super(message);
    }

    public GenderFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
