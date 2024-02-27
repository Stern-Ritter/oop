package ru.otus.exceptions.exception;

public class InputReadException extends RuntimeException {
    public InputReadException() {
    }

    public InputReadException(String message) {
        super(message);
    }

    public InputReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
