package ru.gb.list.exception;

public class MyListIndexOutOfBoundException extends RuntimeException {
    public MyListIndexOutOfBoundException() {
    }

    public MyListIndexOutOfBoundException(String message) {
        super(message);
    }

    public MyListIndexOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
