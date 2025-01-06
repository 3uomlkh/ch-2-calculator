package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                result = divide(num1, num2);
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요.");
        }
        results.add(result);
        return result;
    }

    public List<Integer> getResult() {
        return results;
    }

    public void setResult(List<Integer> result) {
        results = result;
    }

    public void removeResult() {
        results.remove(0);
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        return num1 / num2;
    }
}
