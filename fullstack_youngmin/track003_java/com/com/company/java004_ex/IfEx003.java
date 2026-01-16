package com.company.java004_ex;

import java.util.Scanner;

public class IfEx003 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자한개입력>");
		
		int num1 = scanner.nextInt();
		
		if (num1 == 1) {
			System.out.print("one");}
			
			else if (num1 == 2) {
			System.out.print("two");}	
				
			else if (num1 == 3) {
			System.out.print("three");}
			
			else {System.out.println("1,2,3,이 아니다");}		
					
		
	}

}

/*
 * 출력내용 : 숫자한개를 입력받아 만약 1을 입력했다면 one , 만약 2을 입력했다면 two , 만약 3을 입력했다면 three ,
 * 1,2,3이 아니라면 1,2,3이 아니다를 출력하는 프로그램을 작성하시오.
 */