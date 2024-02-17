package ru.otus.calculator.operation;

import java.util.List;

public interface Operation<T> {
    OperationName getName();

    OperationType getType();

    T evaluate(List<T> operands);
}
