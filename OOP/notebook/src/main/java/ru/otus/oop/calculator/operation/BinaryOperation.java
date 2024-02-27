package ru.otus.oop.calculator.operation;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;

public class BinaryOperation<T> implements Operation<T> {
    private final OperationName name;
    private final OperationType type;
    private final BiFunction<T, T, T> function;

    public BinaryOperation(OperationName name, BiFunction<T, T, T> function) {
        this.name = name;
        this.type = name.getType();
        this.function = function;
    }

    @Override
    public OperationName getName() {
        return name;
    }

    @Override
    public OperationType getType() {
        return type;
    }

    @Override
    public T evaluate(List<T> operands) {
        validateOperands(operands);
        return function.apply(operands.get(0), operands.get(1));
    }

    private void validateOperands(List<T> operands) {
        if (operands == null || operands.size() != 2) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryOperation<?> that = (BinaryOperation<?>) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
