package ru.otus.oop.calculator.operation;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class UnaryOperation<T> implements Operation<T> {
    private final OperationName name;
    private final OperationType type;
    private final Function<T, T> function;

    public UnaryOperation(OperationName name, Function<T, T> function) {
        this.name = name;
        this.type = name.getType();
        this.function = function;
    }

    public OperationName getName() {
        return name;
    }

    public OperationType getType() {
        return type;
    }

    public T evaluate(List<T> operands) {
        validateOperands(operands);
        return function.apply(operands.get(0));
    }

    private void validateOperands(List<T> operands) {
        if (operands == null || operands.size() != 1) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryOperation<?> that = (UnaryOperation<?>) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
