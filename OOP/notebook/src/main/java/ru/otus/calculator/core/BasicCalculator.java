package ru.otus.calculator.core;

import ru.otus.calculator.exception.UnsupportedCalculatorOperationException;
import ru.otus.calculator.operation.Operation;
import ru.otus.calculator.operation.OperationName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicCalculator<T> implements Calculator<T> {
    private final Map<OperationName, Operation<T>> supportedOperations;

    public BasicCalculator(List<Operation<T>> operations) {
        supportedOperations = new HashMap<>();
        for (Operation<T> operation : operations) {
            supportedOperations.put(operation.getName(), operation);
        }
    }

    @Override
    public T evaluate(OperationName operationName, List<T> operands) {
        Operation<T> operation = supportedOperations.get(operationName);
        if (operation == null) {
            throw new UnsupportedCalculatorOperationException();
        }

        return operation.evaluate(operands);
    }
}
