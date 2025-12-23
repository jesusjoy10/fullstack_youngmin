package com.company.java005_ex;

public class RepeatEx010 {
    public static void main(String[] args) {

        // for 버전
        int count = 0;
        System.out.println("for");
        for (char a = 'A'; a <= 'Z'; a++) {
            System.out.print(a + "\t");
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }
        System.out.println("\n");

        // while 버전
        int cw = 0;
        char b = 'A';
        System.out.println("while");
        while (b <= 'Z') {
            System.out.print(b + "\t");
            cw++;
            if (cw == 5) {
                System.out.println();
                cw = 0;
            }
            b++;
        }
        System.out.println("\n");

        // do-while 버전
        int cd = 0;
        char c = 'A';
        System.out.println("do while");
        do {
            System.out.print(c + "\t");
            cd++;
            if (cd == 5) {
                System.out.println();
                cd = 0;
            }
            c++;
        } while (c <= 'Z');
        System.out.println();
    }
}
