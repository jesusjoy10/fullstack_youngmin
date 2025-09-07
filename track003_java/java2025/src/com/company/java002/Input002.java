package com.company.java002;

import java.util.Scanner;

public class Input002 {
	public static void main(String[] args) { 
		// 자료형의 분류 : 기본(값)/참조(주소)
		// 기본형 : 논리형(boolean), 정수형(byte-short-int-long), 실수형(float-double)
		// GIGO (입력 -> 처리 -> 출력) 
		// 변수
		float f = 3.14f;
		double d = 3.14;
		Scanner scanner = new Scanner(System.in);
		
		// 입력
		System.out.print("실수를 입력하세요 "); //f = scanner.nextFloat();
		d= scanner.nextDouble();
		
		// 처리
		
		// 출력
		System.out.println("입력하신 실수는 " + d);
		
		
		
	}

}
