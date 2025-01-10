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
                    removeOldestResult(calculator);
                    break;
                case "3":
                    editNumber(calculator);
                    break;
                case "4":
                    searchBigger(calculator);
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
        System.out.println("0. 계산하기  |  1. 모든 결과 조회  |  2. 오래된 결과 삭제  |  3. 결과 수정  |  4. 큰 값 조회  |  5.나가기(exit 입력)");
    }

    // 모든 결과 조회
    private static void printAllResult(ArithmeticCalculator<Double> calculator) {
        System.out.println(calculator.getResult());
    }

    // 오래된 결과 삭제
    private static void removeOldestResult(ArithmeticCalculator<Double> calculator) {
        if (calculator.getResult().isEmpty()) { // 결과 리스트가 비어있는지 확인
            System.out.println("삭제할 값이 없습니다.");
            return;
        }
        calculator.removeResult();
        printAllResult(calculator);
    }

    // 계산하기
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

    // 결과 수정
    private static void editNumber(ArithmeticCalculator<Double> calculator) {
        System.out.print("수정할 인덱스를 입력하세요: ");
        int index = sc.nextInt();
        sc.nextLine();
        System.out.print("수정 후 숫자를 입력하세요: ");
        double num = sc.nextDouble();
        sc.nextLine();

        if(calculator.getResult().size() <= index) { // 수정할 인덱스까지 결과가 존재하지 않을 경우
            System.out.println("수정할 인덱스가 존재하지 않습니다. 최대 인덱스는 " + (calculator.getResult().size() - 1) + "입니다.");
            return;
        }
        calculator.setResult(index, num);
        printAllResult(calculator);
    }

    private static void searchBigger(ArithmeticCalculator<Double> calculator) {
        System.out.print("비교할 값을 입력하세요: ");
        double num = sc.nextDouble();

        List<Double> filteredResults = calculator.getBigger(num);
        if (filteredResults.isEmpty()) { // 더 큰 값이 없을 경우
            System.out.println("입력한 값보다 더 큰 값이 없습니다.");
        } else  {
            System.out.println("입력한 값보다 큰 값 : " + filteredResults);
        }
    }
}
