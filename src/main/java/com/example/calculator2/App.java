package com.example.calculator2;

import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            printMenu();
            String input = sc.nextLine();
            switch (input) {
                case "0":
                    calculate(calculator);
                    break;
                case "1":
                    printAllResult(calculator);
                    break;
                case "2":
                    calculator.removeResult();
                    printAllResult(calculator);
                    break;
                case "3":
                    removeOldestResult(calculator);
                    printAllResult(calculator);
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 골라주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("0. 계산하기  |  1. 모든 결과 보기  |  2. 오래된 결과 삭제  |  3. 결과 수정  |  4. 나가기(exit 입력)");
    }

    private static void printAllResult(Calculator calculator) {
        System.out.println(calculator.getResult());
    }

    private static void calculate(Calculator calculator) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        sc.nextLine();
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.nextLine().charAt(0);

        int result = calculator.calculate(num1, num2, operator);
        System.out.println("계산 결과: " + result);
    }

    private static void removeOldestResult(Calculator calculator) {
        System.out.print("수정할 인덱스를 입력하세요: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("수정 후 숫자를 입력하세요: ");
        int num = sc.nextInt();
        sc.nextLine();
        calculator.setResult(index, num);
    }
}
