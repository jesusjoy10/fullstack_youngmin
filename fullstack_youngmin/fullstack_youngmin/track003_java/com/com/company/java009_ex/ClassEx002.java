package com.company.java009_ex;

import java.util.Scanner;

class MyPrice001{
	 // 멤버변수
	String name;  int price;
	 // 멤버함수
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("상품이름 입력:"  ); this.name = scanner.next();
		System.out.println("상품가격 입력:"); this.price= scanner.nextInt();
	} 
	void show() {
		System.out.println("상품정보입니다");
		System.out.println("상품이름:"+this.name + "/상품가격:" + this.price);
		
	}
}
//////////////////////////////
public class ClassEx002 {
	  public static void main(String[] args) {
	        MyPrice001   p1 = new MyPrice001();
	        p1.name="apple"; p1.price=1500;
	        p1.input();
	        p1.show();
	   }
}
/////////////////////////////



/*클래스명 :  ClassEx002
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 입력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500
  
    Student001   s1 = new Student001();
   ----------------------------------[runtime data area]
 [method: 정보, static, final :공용정보]
 class MyPrice001,  class ClassEx002         
 ----------------------------------
[heap: 동적]                                        |[stack :잠깐빌리기]    
                                                   p1 show (){}
                                                   p1 input(){} 
 1번지 {name=null,  p1.input, p1.show }<- p1[1번지]                     
                                                  | main 2)
 ----------------------------------
  */


