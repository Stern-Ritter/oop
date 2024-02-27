package ru.otus.oop.calculator.operation;

public enum OperationName {
    ADDITION(OperationType.BINARY),
    SUBTRACTION(OperationType.BINARY),
    MULTIPLICATION(OperationType.BINARY),
    DIVISION(OperationType.BINARY),
    ROOT(OperationType.UNARY);

    private final OperationType type;

    OperationName(OperationType type) {
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }
}
