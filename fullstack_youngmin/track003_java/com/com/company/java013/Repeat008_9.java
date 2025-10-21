package com.company.java013;

//Q8. abstract vs interface의 공통점과 차이점
/*	둘다 설계가 가능한 클래스
 *  공통점 : 자식객체를통해서 코드를 구현
	차이점 : 추상화정도가 interface가 더 크다.
	abstract  - 인스턴스변수, 인스턴스메서드 사용가능
	interface - 상수(public static final) , abstract 메서드
 */

interface Vehicle{public void run();}
class MotorCycle implements Vehicle{
	@Override public void run()
	{System.out.println("오토바이가 달립니다.");}
	public void helmet() {System.out.println("헬멧을 착용합니다");}
}
class Car implements Vehicle{
	@Override public void run()
	{System.out.println("자동차가 달립니다.");}
}
class Driver{
	public void drive(Vehicle v){  //의존관계  - 다형성( 부모객체로 여러자식객체들을 관리 ) / 부모.메서드() 오버라이드되서 자식메서드
		//자동차일때는 자동차가 달립니다. /오토바이 헬멧,달린다 
		if(v instanceof MotorCycle) { ((MotorCycle) v).helmet();}  // helmet은 부모에게 없고 자식에게 있는 최신기술
		v.run();  // 오버라이드되서 자식메서드
	}   
}
public class Repeat008_9 {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		MotorCycle motorCycle = new MotorCycle();
		Car car = new Car();
		
		driver.drive(car);  //public void drive(Vehicle v){ 해야할일  }   
		System.out.println("\n\n>>자동차가 고장나서 교통수단을 바꿉니다");

		driver.drive(motorCycle);//public void drive(Vehicle v){  자동차일때는 자동차가 달립니다. /오토바이 헬멧,달린다 }   
	}
}
//Q9. interface - can do this
/*			 
Driver ......>	       Vehicle  {  run() }
			 	 ......△				......△
			 	MotorCycle				Car
			 	{ helmet() , @run() }	{ @run() }

*/