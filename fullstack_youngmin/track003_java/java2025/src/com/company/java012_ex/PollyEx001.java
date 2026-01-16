package com.company.java012_ex;

//Q1. 상속도를 그리시오.
/*
 *     Object
 *       ↑
 *     TestA2   (a=10, toString) 
 *       ↑
 *     TestB2   (b=10, toString) 
 */

class TestA2 extends Object{int a=10;
	@Override public String toString() { return "TestA2 [a=" + a + "]"; }
}

class TestB2 extends TestA2{int b=10;
@Override public String toString() { return "TestB2 [b=" + b + "]";}
}
	

//////////////////////////////////////////////
public class PollyEx001 {
	public static void main(String[] args) {
		//부모     = 자식    //업캐스팅 / 타입캐스팅 x 
		TestA2 ta = new TestB2();
		//Q2. 24번째줄에서 TestA2 ta는 클래스의 무엇을 사용할 수 있는 지 코드의 의미  A. TestA2(a=10, toString)
		//Q3. 24번째줄에서 TestB2() 는 클래스의 무엇을 사용할 수 있을까요?
		// A. TestB (b=10, @toString) - TestA (a=10/-----)
		// A. ta[1000번지] = 1000번지 TestB2 {b=10/@toSring}  - TestA2 (a=10/-----)		 
		System.out.println(ta); // Q4. 출력내용과 이유? A. TestB2 why? 오버라이딩 돼서?
		System.out.println(ta.a); // Q5. 사용가능? A. 10
		//System.out.println(ta.b); // Q6. 사용가능? 
		// A. ㄴㄴ - ta는 TestA2 타입이기때문에 TestB2의 멤버인 b에는 직접 접근할 수 없음 but 타입캐스팅 사용 시 가능
	

	}

}
//////////////////////////////////////////////