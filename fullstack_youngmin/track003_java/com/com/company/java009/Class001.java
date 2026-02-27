package com.company.java009;

class A1{}

public class Class001{
    public static void main(String []args){  //jvm - mian 구동시점
        int i =10;
        A1 a = new A1(); // 4-1 new (heap 1번지 공간빌리기, 객체생성) 인스턴스화
                          // 4-2 A1() 초기화
                          // 4-3 a 1번지라는 주소주기
        System.out.println(a); // A1@73a28541 
        A1 a2 = new A1();
        A1 a3 = new A1();                         
    }
}
/////////////////////////


/* [runtime data area] 
--------------------------------
[method: 클래스정보, static, final :공용] 1)
  A1.class, class001.class 2)      클래스 : 설계도
--------------------------------
[heap: 동적]         [stack: 잠깐빌리기]   객체(전체) : a, a2 ,a3
                                         인스턴스(각각) : a, a2, a3
  3번지 : A1{}    <-  a3[1번지] 
  2번지 : A1{}    <-  a2[2번지]     
  1번지 : A1{}    <-  a[1번지]                   
                    
                     i[10]
                   |main 3)

--------------------------------
*/