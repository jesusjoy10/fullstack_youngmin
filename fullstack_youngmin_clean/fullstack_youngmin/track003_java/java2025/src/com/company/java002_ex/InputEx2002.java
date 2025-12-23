package com.company.java002_ex;

import java.util.Scanner;

public class InputEx2002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k, e, m;
		
		System.out.print("국어 점수를 입력하시오 _");
		k = scanner.nextInt();
		System.out.print("영어 점수를 입력하시오 _");
		e = scanner.nextInt();
		System.out.print("수학 점수를 입력하시오 _");
		m = scanner.nextInt();
		
		int total = k + e + m;
		double average = total/3.0; // 정수/정수=정수 -> 정수/실수 or 실수/정수로 바꿔야됨
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);	
		
		
//		
//		연습문제2)
//		패키지명 : com.company.java002_ex
//		클래스명 : InputEx2002
//		출력내용 :  Scanner이용해서  성적처리를 입력받고 출력하시오.
//		   국어점수를 입력하시오.  _입력받기    100 
//		   영어점수를 입력하시오.  _입력받기    100 
//		   수학점수를 입력하시오.  _입력받기    99
//
//		   총점 :  299
//		   평균 :  99
		
		
		
	}

}
