package com.company.java002; //저장 위치(폴더)

public class Print001 { //어디든 접근 가능 - 부품 객체 - 이름
	public static void main(String[] args) {
		//1.System.out.println()
		System.out.println("1. 줄바꿈");
		
		//2.Syetem.out.print();
		System.out.print("줄바꿈 안됨.");
		System.out.print("줄바꿈 특수 문자 \n 이용"); 
							// \\사용 시 줄바꿈 취소하고 \n 출력
		
		//3.System.out.printf() 
		//	%s "a"(문자) %d 1(정수) %f 0.123(소수)
		System.out.printf("\n3. 정수 %d, 실수 %f, 문자열 %s", 42, 1.2, "abc");
		
		System.out.println("\n");
		
		//4. +의 의미
		System.out.println(10+3); //연산
		System.out.println(10+3 + "+" + 1+2);
		//			   숫자+숫자 + "문자열" + 문자열 뒤 숫자는 문자열처럼 순차 출력
		System.out.println(10+3 + "+" + (1+2));
		//								묶어서 해결 가능!
		
		
		//Q. System.out.println(1+2=3);
		//		1+2=3으로 출력
		System.out.println("1+2=3");
		System.out.println(1 + "+" + 2 + "=" + 3);
		System.out.printf("%d + %d = %d", 1, 2, 3);
	}
	

}
