package ru.otus.calculator.exception;

public class UnsupportedCalculatorOperationException extends RuntimeException {
    public UnsupportedCalculatorOperationException() {
    }

    public UnsupportedCalculatorOperationException(String message) {
        super(message);
    }

    public UnsupportedCalculatorOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
