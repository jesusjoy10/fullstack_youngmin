package com.company.java011;

/* 상속 : 클래스의 재사용
   Object (실선- 속이빈화살표)  ■3 Object{        }
     ↑
   Animal   ■2  Anilmal() {name=null,age=0 / eat(), sleep(), poo() ■5) }
   ↑   ↑    ■1) Cat(){animal_card / qukquk()}                      ■6) }
person cat  ■0) 1번지{}   
------------------------------------------------  
Cat dudals = new Cat();  
------------------------------------------------  
1) Cat은 Anilmal이다  ↑
2) 생성자호출 : Cat() → Animal() → object()
3) 객체생성  : object → Animal() → Cat
 
 * */

class Animal{
	String name;
	int age;
	void eat()    {System.out.println("먹고");}
	void sleep( ) {System.out.println("자고");}
	void poo()    {System.out.println("배변");}
}
class Cat extends Animal{
	String animal_card;
	void qukquk() {System.out.println(this.name+ "-꾹꾹이");}
	
}
class Person{	
}
public class Extends002 {

	public static void main(String[] args) {
		Cat dudals = new Cat();
		dudals.name="kitty"; dudals.age = 52;
		dudals.animal_card="ani-1234";
		dudals.eat(); dudals.sleep(); dudals.poo(); dudals.qukquk();
		

	}

}
