package com.company.java002;

import java.util.Scanner;

public class InputEx003 {
	public static void main(String[] args) {
		int years = 0;
		System.out.println("태어난 년도를 입력하세요>");
		Scanner scanner = new Scanner(System.in);
		
		years = scanner.nextInt();
		years = 2025 - years; 
		System.out.println("당신의 나이는 "+years+"입니다.");
	}

}
