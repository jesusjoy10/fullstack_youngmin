package com.company.java100_Test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch;

      
        System.out.println("for 버전");
        for (;;) {
            System.out.println("+-*/ 중 하나를 입력하세요:");
            ch = scanner.next().charAt(0);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                break;
            }
        }
        System.out.println(ch);
        System.out.println();

      
     
        System.out.println("while 버전");
        char a = ' ';
        while (!(a == '+' || a == '-' || a == '*' || a == '/')) {
            System.out.println("+-*/ 중 하나를 입력하세요:");
            a = scanner.next().charAt(0);
        }

        System.out.println(a);
        System.out.println();

       
        System.out.println("dowhile 버전");
        do {
            System.out.println("+-*/ 중 하나를 입력하세요:");
            ch = scanner.next().charAt(0);
        } while (!(ch == '+' || ch == '-' || ch == '*' || ch == '/'));
        System.out.println(ch);
    } //end main 
}//end class
