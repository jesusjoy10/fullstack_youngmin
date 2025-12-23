package com.company.java004;

public class IF001 {
    public static void main(String[] args) {  // ✅ main 시그니처 수정
        // 1. 1형식
        int axe = 1;
        System.out.println("1형식 - 조건을 무조건 읽음");
        if (axe == 1) { System.out.println("금도끼"); }
        if (axe == 2) { System.out.println("은도끼"); }
        if (axe == 3) { System.out.println("낡은도끼"); }

        // 2. 2형식
        System.out.println("2형식 - 맞다-틀리다");
        axe = 2;
        if (axe == 1) { 
            System.out.println("금도끼"); 
        } else { 
            System.out.println("금도끼가 아니다"); 
        }  // ✅ 블록 닫기

        // 3. 다형식
        System.out.println("다형식");
        axe = 3;
        if (axe == 1) { 
            System.out.println("금도끼"); 
        } else if (axe == 2) { 
            System.out.println("은도끼"); 
        } else if (axe == 3) { 
            System.out.println("낡은도끼"); 
        } else { 
            System.out.println("모두 도끼가 아니다"); 
        }
    }
}
