package com.company.java013;

/*
 1. 클래스는 부품객체
 2. 상태와 행위
 Q1. 상속? 재사용
 Q2. class 자식 extends 부모
 Q3. 상속도    >>      
Objecet      #4. Object(){                 #5 } 객체생성    	
   ↑
   A1  {a}   #3.A1() {                     #6.  a=0}  
   ↑
   B1  {b}   #2.B1() {                     #7.  b=0}
   ↑
   C1  {c}   #1 C1() {                     #8.   c=0}
   
   객체호출순서 : C1() B1()  A1()   Object()
   객체생성순서 : Object     A1     B1     C1
 */
/**************    C1  myc = new C1(); 
[method : 정보보관]   A1.class, B1.class, C1.class ,  public Repeat006.class  ★1) 설계도
------------------------------------------------------------
[heap:동적]                             |       [stack:지역] 
						 myc(1번지).a = 10; myc(1번지).b=20; myc(1번지).c=30;  @44번째줄
	 Object(){ }
	 A1() {    a=0}
	 B1() {    b=0}
1번지 C1() {    c=0}             ←        myc [1번지]    @43번째줄
									   | main
------------------------------------------------------------
> 생성자의 인스턴스변수를 초기화해서 사용가능하게 해준다.
*/
class A1 extends Object{  int a;  public A1() { super(); }  }
class B1 extends A1{      int b;  public B1() { super(); }  }
class C1 extends B1{      int c;  public C1() { super(); }  
	public void showC() {
		System.out.println("상속받은 A클래스의 a : " + a);
		System.out.println("상속받은 B클래스의 b : " + b);
		System.out.println("자신멤버의 C클래스의 c: " + c);
	}
}
public class Repeat006 {
	public static void main(String[] args) {
		C1  myc = new C1();   
		myc.a = 10; myc.b=20; myc.c=30;
		myc.showC();
	}
}

/*

*/