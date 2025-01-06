package com.example.calculator2;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            System.out.println("0. 계산하기  |  1. 모든 결과 보기  |  2. 오래된 결과 삭제  |  3. 결과 수정  |  4. 나가기(exit 입력)");
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println(calculator.getResult());
            } else if (input.equals("2")) {
                calculator.removeResult();
                System.out.println(calculator.getResult());
            } else if (input.equals("3")) {
                int index = sc.nextInt();
                int num = sc.nextInt();
                calculator.setResult(index, num);
                System.out.println(calculator.getResult());
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                sc.nextLine();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                sc.nextLine();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.nextLine().charAt(0);

                int result = calculator.calculate(num1, num2, operator);
                System.out.println("결과: " + result);
            }
        }
    }
}
