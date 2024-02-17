package ru.otus.calculator.operation;

import static ru.otus.calculator.operation.OperationType.BINARY;
import static ru.otus.calculator.operation.OperationType.UNARY;

public enum OperationName {
    ADDITION(BINARY),
    SUBTRACTION(BINARY),
    MULTIPLICATION(BINARY),
    DIVISION(BINARY),
    ROOT(UNARY);

    private final OperationType type;

    OperationName(OperationType type) {
        this.type = type;
    }

    public OperationType getType() {
        return type;
    }
}
