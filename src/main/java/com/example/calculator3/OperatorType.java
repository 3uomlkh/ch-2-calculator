package com.example.calculator3;

import java.util.function.BiFunction;

public enum OperatorType {
    ADD('+', (a, b) -> a + b),
    SUBTRACT('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    });

    private final char symbol;
    private final BiFunction<Double, Double, Double> operation;

    OperatorType(char symbol,BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public char getSymbol() {
        return symbol;
    }

    public double apply(double a, double b) {
        return operation.apply(a, b);
    }
}
