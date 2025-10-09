package com.company.java012;

/*
 *       Object           
           ↑      
 *       Animal   {String name; int age;}
 *          ↑    
 *         cat    {String number; void show()}
 * 
 *   Object           
        ↑      
 *   Animal   {String name; int age;}
 *     ↑    
 *    cat     {String jumin; void show()}
 * 
 */
class Animal{ String name; int age;
public Animal() {super();} //object() 컴파일러가 자동생성 x → 오버로딩과 상속시 
public Animal(String name, int age) { super(); this.name = name; this.age = age; }
public void show() {System.out.println("Animal");}
}

class Cat extends Animal{
	String number;
	public void show () {System.out.println("Cat>" + super.name + "/"+ super.age);}
	}

class person extends Animal{
	String jumin;
	public void show() {System.out.println("person > " + super.name + "/" + super.age);}
}

public class Poly005 {

	
	public static void main(String[] args) {
		// 부모 = 자식 / 업캐스팅 / 타입캐스팅 필요 x 
		Animal  [] anis = {new Cat(), new Cat() , new person() ,new person() };
		// 1. 보장 : {String name ; int age;/ show()} 
		//                new Cat{number, @show()} - Animal{String name, int age; /  show() }
		// 1. 보장 : {String name ; int age;}
				//        new person{jumin, @show()} - Animal{String name, int age; /  show() }
		Animal controller = null; 
		controller = anis[0]; controller.show();
		controller = anis[1]; controller.show();
		controller = anis[2]; controller.show();
		controller = anis[3]; controller.show();
				
	}

}
