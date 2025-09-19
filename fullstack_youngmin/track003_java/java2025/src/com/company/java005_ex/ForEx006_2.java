package com.company.java005_ex;

import java.util.Scanner;

public class ForEx006_2 {
    public static void main(String[] args) {
        // 변수
        Scanner scanner = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        char ch;
        double result = 0;

        // 입력: 무한 반복 → 조건 만족 시 break
        for (;;) {
            // 숫자1 입력
            System.out.print("숫자1을 입력하시오 (0~100): ");
            num1 = scanner.nextInt();
            if (num1 < 0 || num1 > 100) {
                System.out.println("⚠️ 숫자1은 0~100 사이만 입력 가능합니다.");
                continue;
            }

            // 숫자2 입력
            System.out.print("숫자2를 입력하시오 (0~100): ");
            num2 = scanner.nextInt();
            if (num2 < 0 || num2 > 100) {
                System.out.println("⚠️ 숫자2는 0~100 사이만 입력 가능합니다.");
                continue;
            }

            // 연산자 입력
            System.out.print("연산자를 입력하시오 (+, -, *, /): ");
            ch = scanner.next().charAt(0);
            if (!(ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                System.out.println("⚠️ 연산자는 +, -, *, / 중 하나만 입력해주세요.");
                continue;
            }

            // 모든 조건이 만족되었으므로 반복 종료
            break;
        }

        // 계산 처리
        switch (ch) {
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
                if (num2 == 0) {
                    System.out.println("❌ 0으로 나눌 수 없습니다.");
                    return;
                }
                result = (double) num1 / num2;
                break;
        }

        // 결과 출력
        System.out.println(num1 + " " + ch + " " + num2 + " = " + result);
        scanner.close();
    }
}
