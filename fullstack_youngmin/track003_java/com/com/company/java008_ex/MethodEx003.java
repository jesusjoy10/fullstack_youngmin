package com.company.java008_ex;

public class MethodEx003 {
    
    
    public static void printProfile(String name, int age, String loc) {
        System.out.println("=== 사용자 프로필 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("지역: " + loc);
        System.out.println("===================");
    }

    
    public static void checkAge(int age) {
        if (age < 19) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }
    }

   
    public static void repeatMessage(String msg, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(msg);
        }
    }

   
    public static void drawBox(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(c);
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        printProfile("김영민", 26, "인천");
        checkAge(26);
        repeatMessage("안녕하세요!", 3);
        drawBox(5, '#');
    }
}
