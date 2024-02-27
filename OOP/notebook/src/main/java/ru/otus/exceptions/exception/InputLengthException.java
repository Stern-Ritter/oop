package ru.otus.exceptions.exception;

public class InputLengthException extends RuntimeException {
    public InputLengthException() {
    }

    public InputLengthException(String message) {
        super(message);
    }

    public InputLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
