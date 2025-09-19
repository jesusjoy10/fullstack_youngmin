package com.company.java003;

import java.util.Scanner;

public class CastingCharEx {
	public static void main(String[] args) {
		
		//변수
		char upper = ' ';
		char lower = ' '; 
		Scanner scanner = new Scanner(System.in);
		
		//입력
		System.out.print("대문자를 입력해주세요>");
		upper = scanner.next().charAt(0); // next() 문자열입력 char(0)첫번째 문자
		
		//처리 대문자 'A' 65, 'B' 66 / 'a' 97 , 'b' 98,,,
		// 97 = 65  +32
		// char = char + int
		lower = (char) (upper +32);
		// 채우기....
		//출력
		System.out.println("입력하신 대문자 : " + upper +" 소문자 변환 : " + lower);
	}

}
