package ru.otus.calculator.factory;

import ru.otus.calculator.exception.UnsupportedCalculatorOperationException;
import ru.otus.calculator.operation.BinaryOperation;
import ru.otus.calculator.operation.Operation;
import ru.otus.calculator.operation.OperationName;
import ru.otus.calculator.operation.UnaryOperation;

import java.util.HashMap;
import java.util.Map;

public class DoubleOperationFactory implements OperationFactory<Double> {
    private final Map<OperationName, Operation<Double>> operations;

    public DoubleOperationFactory() {
        operations = new HashMap<>();
    }

    @Override
    public Operation<Double> getOperation(OperationName operationName) {
        switch (operationName) {
            case ADDITION -> {
                Operation<Double> addition = operations.get(operationName);
                if (addition == null) {
                    addition = new BinaryOperation<>(OperationName.ADDITION, Double::sum);
                    operations.put(OperationName.ADDITION, addition);
                }
                return addition;
            }
            case SUBTRACTION -> {
                Operation<Double> subtraction = operations.get(operationName);
                if (subtraction == null) {
                    subtraction = new BinaryOperation<>(OperationName.SUBTRACTION, (a, b) -> a - b);
                    operations.put(OperationName.SUBTRACTION, subtraction);
                }
                return subtraction;
            }
            case MULTIPLICATION -> {
                Operation<Double> multiplication = operations.get(operationName);
                if (multiplication == null) {
                    multiplication = new BinaryOperation<>(OperationName.MULTIPLICATION, (a, b) -> a * b);
                    operations.put(OperationName.MULTIPLICATION, multiplication);
                }
                return multiplication;
            }
            case DIVISION -> {
                Operation<Double> division = operations.get(operationName);
                if (division == null) {
                    division = new BinaryOperation<>(OperationName.DIVISION, (a, b) -> a / b);
                    operations.put(OperationName.DIVISION, division);
                }
                return division;
            }
            case ROOT -> {
                Operation<Double> root = operations.get(operationName);
                if (root == null) {
                    root = new UnaryOperation<>(OperationName.ROOT, Math::sqrt);
                    operations.put(OperationName.ROOT, root);
                }
                return root;
            }
            default -> {
                throw new UnsupportedCalculatorOperationException();
            }
        }
    }
}
