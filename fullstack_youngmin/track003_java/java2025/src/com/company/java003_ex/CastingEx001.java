package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx001 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자입력1>");
		int num1 = scanner.nextInt();
		System.out.print("숫자입력2>");
		int num2 = scanner.nextInt();
		
		double result =(double)num1/num2;
		
		System.out.println(num1+"/"+num2 +"=" + result);
		
		
		
		
	}

}
