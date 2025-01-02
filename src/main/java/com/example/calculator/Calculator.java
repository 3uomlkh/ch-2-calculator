package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            calculate();
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
        }
    }

    private static void calculate() {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.nextLine().charAt(0);

        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("올바른 연산자를 입력하세요.");
        }

        System.out.println("결과: " + result);
    }
}
