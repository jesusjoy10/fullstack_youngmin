package com.company.java003_ex;

import java.util.Scanner;

public class CastingEx002 {
	public static void main(String[] args) {
		
		//변수
		int kor; int eng; int math; int total;
		int level;
		double average;
	
	
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("국어점수 입력>");
		kor = scanner.nextInt();
		
		System.out.print("영어점수 입력>");
		eng = scanner.nextInt();
		
		System.out.print("수학점수 입력>");
		math = scanner.nextInt();
		
		//처리
		total = kor + eng + math;
        average = total / 3.0;
		
        level = (int) average / 10;
		
	
		
		//출력
        System.out.println();
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":: GOOD  IT SCORE ::");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("국어   영어   수학   총점   평균   레벨");
        System.out.printf("%3d   %3d   %3d   %3d   %.2f %d\n", kor, eng, math, total, average,level);
    }
	}


