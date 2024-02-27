package ru.otus.oop.calculator.factory;

import ru.otus.oop.calculator.operation.Operation;
import ru.otus.oop.calculator.operation.OperationName;

public interface OperationFactory<T> {
    Operation<T> getOperation(OperationName operationName);
}
