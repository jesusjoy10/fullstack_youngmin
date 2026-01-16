package com.company.java013;

//1. 클래스는 단일상속 
/*    Papa{brain}       Mama{brain}
 *          ↑           ↑
 *             son()
 * */

class Papa2{int brain;} // papa2 , Mama는 그냥 일반클래스이고, brain이라는 멤버변수(상태)를 갖고있음
 // 자바에서는 클래스 상속이 단일상속만 가능함. 즉, 한클래스만 extends 할 수 있음
//class son extends Papa, Mama{} // Syntax error on token ",", . expected

//2. 인터페이스는 다중상속     
//                                 {method()}             {method()}
/* <<interface>>Inter20    <<interface>>Inter21     <<interface>>Inter22
 *                                       ↑                 ↑
 *                                      <<interface>>Inter23 {method()}
 *                                      
 *       <<class>>Papa2
 *               ↑     
 *            Using1  extends Papa2       implements Inter23, Inter20
 *            -{@method()}
 *            -{@inter()}
 * */
interface Inter20{void inter();}
interface Inter21{void method();}
interface Inter22{void method();}
interface Inter23 extends Inter21, Inter22{ }

//3. 많이 쓰는 형식  주요메인클래스상속      추가설계1, 추가설계2
class Using1 extends Papa2 implements Inter23, Inter20{
	@Override public void method() {   }
	@Override public void inter() {   }
	
}
public class Interface002 {

	public static void main(String[] args) {
		//Inter23 my = new Inter23();
		Using1 my = new Using1();
		//instanceof 클래스확인, 상속확인 (내 부모? 족보확인)
		if(my instanceof Object) {System.out.println("1.Object");}
		if(my instanceof Papa2) {System.out.println("2.Papa");}
		//if(my instanceof Mama2) {System.out.println("3.Mama");}
		if(my instanceof Inter20) {System.out.println("4.Inter20");}
	}

}
