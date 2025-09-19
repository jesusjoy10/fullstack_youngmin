package com.company.java003;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		
		// 변수
		int num1; int num2;
		double result; 
		Scanner scanner = new Scanner(System.in);
		// 입력
		System.out.print("숫자입력1>");
		num1 = scanner.nextInt();
		System.out.print("숫자입력2>");
		num2 = scanner.nextInt();
		
		// 처리
		

		result = (double)num1/num2; //실수 = 실수/정수
		
		//출력
		
		
		System.out.println(num1+"/" + num2 + "=" + result);
		System.out.printf("%d/%d=%.2f",num1,num2,result);
		
		
	
		
		
		
		
		
		// 출력
	}

}
