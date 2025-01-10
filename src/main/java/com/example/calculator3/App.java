package com.example.calculator3;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();
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
                case "4":
                    searchBigger(calculator);
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 골라주세요.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("0. 계산하기  |  1. 모든 결과 조회  |  2. 오래된 결과 삭제  |  3. 결과 수정  |  4. 큰 값 조회  |  5.나가기(exit 입력)");
    }

    private static void printAllResult(ArithmeticCalculator<Double> calculator) {
        System.out.println(calculator.getResult());
    }

    private static void calculate(ArithmeticCalculator<Double> calculator) {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        double num1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("두 번째 숫자를 입력하세요: ");
        double num2 = sc.nextDouble();
        sc.nextLine();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.nextLine().charAt(0);

        double result = calculator.calculate(num1, num2, operator);
        System.out.println("계산 결과: " + result);
    }

    private static void removeOldestResult(ArithmeticCalculator<Double> calculator) {
        System.out.print("수정할 인덱스를 입력하세요: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("수정 후 숫자를 입력하세요: ");
        double num = sc.nextDouble();
        sc.nextLine();

        calculator.setResult(index, num);
    }

    private static void searchBigger(ArithmeticCalculator<Double> calculator) {
        System.out.print("비교할 값을 입력하세요: ");
        double num = sc.nextDouble();

        List<Double> filteredResults = calculator.getBigger(num);
        if (filteredResults.isEmpty()) {
            System.out.println("입력한 값보다 더 큰 값이 없습니다.");
        } else  {
            System.out.println("입력한 값보다 큰 값 : " + filteredResults);
        }

    }
}
