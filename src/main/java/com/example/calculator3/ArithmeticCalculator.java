package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

import static com.example.calculator3.OperatorType.*;

public class ArithmeticCalculator<T> {
    private List<T> results = new ArrayList<>();

    public T calculate(T num1, T num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = ADD.apply((Double) num1, (Double) num2);
                break;
            case '-':
                result = SUBTRACT.apply((Double) num1, (Double) num2);
                break;
            case '*':
                result = MULTIPLY.apply((Double) num1, (Double) num2);
                break;
            case '/':
                result = DIVIDE.apply((Double) num1, (Double) num2);
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요.");
        }

        if (num1 instanceof Integer && num2 instanceof Integer) {
            T castedResult = (T) Integer.valueOf((int) result);
            results.add(castedResult);
            return castedResult;
        } else {
            T castedResult = (T) Double.valueOf(result);
            results.add(castedResult);
            return castedResult;
        }
    }

    public List<T> getResult() {
        return results;
    }

    public void setResult(int index, T value) {
        results.set(index, value);
    }

    public void removeResult() {
        results.remove(0);
    }

    //저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력 -> 조회 메서드 추가

}
