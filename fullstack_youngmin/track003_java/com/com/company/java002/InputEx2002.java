package com.company.java002;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		int kor; int math; int eng;
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수를 입력하시오");
		kor =scanner.nextInt();
		System.out.print("영어점수를 입력하시오");
		eng = scanner.nextInt();
		System.out.print("수학점수를 입력하시오");
		math = scanner.nextInt();
		
		int total = kor + eng + math;
		double average = total/3.0;
		System.out.println("총점:" + total);
		System.out.println("평균:" + average);
		
		
		
		
		
	}

}
