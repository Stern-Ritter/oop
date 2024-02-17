package ru.otus.calculator.core;

import ru.otus.calculator.operation.OperationName;

import java.util.List;

public interface Calculator<T> {
    T evaluate(OperationName operation, List<T> operands);
}
