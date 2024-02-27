package ru.otus.exceptions.exception;

public class NameFormatException extends RuntimeException {
    public NameFormatException() {
    }

    public NameFormatException(String message) {
        super(message);
    }

    public NameFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
