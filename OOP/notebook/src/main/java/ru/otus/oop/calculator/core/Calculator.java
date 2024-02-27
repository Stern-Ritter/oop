package ru.otus.oop.calculator.core;

import ru.otus.oop.calculator.operation.OperationName;

import java.util.List;

public interface Calculator<T> {
    T evaluate(OperationName operation, List<T> operands);
}
