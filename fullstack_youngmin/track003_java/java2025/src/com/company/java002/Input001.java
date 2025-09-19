package com.company.java002;

import java.util.Scanner;

public class Input001 {
	public static void main(String[] args) {
		
		//자료형의 분류 : 기본(값)/참조(주소)
		// 기본형 : 논리형(boolean), 정수형(byte-short-int-long), 실수형(float-double)
		
		//OOP : 클래스(부품객체) 조립해서 완성해가는 프로그램 
		//변수
		int 	like	=0; //기본 : like[0]
		Scanner scanner = new Scanner(System.in); //참조 : ctrl + shift + o ->(import java.util.Scanner; 자동 생성)
		//1. new(공간 빌리기)	heap 1000 번지 [	]
		//2. Scanner(System.in) : Scanner() =사용할 수 있게 초기화 - System.in =키보드로 입력 의미
		//3. 사용법 :  scanner. (변수명.)
		
		//입력
		System.out.println("정수를 입력하세요>");
		like = scanner.nextInt(); //입력받기 커서가 깜빡임
		//처리x
		//출력
		System.out.println("입력하신 정수는 " + like + "입니다.");
		
		
		
		
		
		//처리
		
		
		
		//출력
		
	}

}
