package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[] args) {
		
		int kor, eng, mat, total;
		double avg, lev;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하시오 >");
		kor = scanner.nextInt();
		System.out.print("영어 점수를 입력하시오 >");
		eng = scanner.nextInt();
		System.out.print("수학 점수를 입력하시오 >");
		mat = scanner.nextInt();
		
		total = kor + eng + mat;
		avg = total/3.0;
		lev = (int)(avg/10);
		
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println(":: GOOD  IT SCORE ::");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.printf("%-5s\t%-5s\t%-5s\t%-5s\t%-5s\t%-5s\n", "국어", "영어", "수학", "총점", "평균", "레벨");
		//System.out.println(kor +" "+ eng +" "+ mat +" "+ total +" "+ String.format("%.2f", avg) +" "+ (int)lev);
		System.out.printf("%-5d\t%-5d\t%-5d\t%-5d\t%-5s\t%-5d\n", kor, eng, mat, total, String.format("%.2f", avg), (int)lev);
		
	}
}
