package ru.otus.oop.calculator.operation;

import java.util.List;

public interface Operation<T> {
    OperationName getName();

    OperationType getType();

    T evaluate(List<T> operands);
}
