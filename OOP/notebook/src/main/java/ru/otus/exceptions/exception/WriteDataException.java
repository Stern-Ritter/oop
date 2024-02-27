package ru.otus.exceptions.exception;

public class WriteDataException extends RuntimeException {
    public WriteDataException() {
    }

    public WriteDataException(String message) {
        super(message);
    }

    public WriteDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
