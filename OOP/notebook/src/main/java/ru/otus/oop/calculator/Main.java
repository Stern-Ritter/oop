package ru.otus.oop.calculator;

import ru.otus.oop.calculator.core.AdvancedCalculator;
import ru.otus.oop.calculator.core.BasicCalculator;
import ru.otus.oop.calculator.core.Calculator;
import ru.otus.oop.calculator.factory.DoubleOperationFactory;
import ru.otus.oop.calculator.factory.OperationFactory;

import java.util.List;

import static ru.otus.oop.calculator.operation.OperationName.*;

public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        OperationFactory<Double> operations = new DoubleOperationFactory();
        Calculator<Double> calculator = new AdvancedCalculator<>(new BasicCalculator<>(
                List.of(operations.getOperation(ADDITION),
                        operations.getOperation(SUBTRACTION),
                        operations.getOperation(MULTIPLICATION),
                        operations.getOperation(DIVISION),
                        operations.getOperation(ROOT))
        ));

        System.out.println(calculator.evaluate(ADDITION, List.of(1.0, 2.0)));
        System.out.println(calculator.evaluate(SUBTRACTION, List.of(3.0, 5.0)));
        System.out.println(calculator.evaluate(MULTIPLICATION, List.of(3.0, 3.0)));
        System.out.println(calculator.evaluate(DIVISION, List.of(12.0, 3.0)));
        System.out.println(calculator.evaluate(ROOT, List.of(81.0)));
    }
}
