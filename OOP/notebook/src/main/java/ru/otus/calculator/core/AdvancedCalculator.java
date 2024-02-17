package ru.otus.calculator.core;

import ru.otus.calculator.operation.OperationName;

import java.util.List;

public class AdvancedCalculator<T> implements Calculator<T> {
    private final Calculator<T> calculator;

    public AdvancedCalculator(Calculator<T> calculator) {
        this.calculator = calculator;
    }

    @Override
    public T evaluate(OperationName operation, List<T> operands) {
        System.out.printf("Called operation: %s with operands: %s%n", operation.name(), operands);
        return calculator.evaluate(operation, operands);
    }
}
