package ru.otus.calculator.factory;

import ru.otus.calculator.operation.Operation;
import ru.otus.calculator.operation.OperationName;

public interface OperationFactory<T> {
    Operation<T> getOperation(OperationName operationName);
}
