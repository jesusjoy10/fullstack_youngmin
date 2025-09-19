package com.company.java004_ex;

import java.util.Scanner;

public class IfEx008 {
	public static void main(String[] main) {
		
		
		//변수
		Scanner scanner = new Scanner(System.in);
		int kor; int math; int eng;  int total ;double avg; 
		String pass="불합격", lv="가", jang="-";
		String std;
			
		//입력
		System.out.println("학번 입력>");
		std = scanner.next();
		System.out.println("국어점수 입력>");
		kor = scanner.nextInt();
		System.out.println("수학점수 입력>");
		math = scanner.nextInt();
		System.out.println("영어점수 입력>");
		eng = scanner.nextInt();
		
		
		//처리
		total = kor + math + eng;
		avg = (double)total/3.0 ;
		//if (avg>=60 && kor>=40 && math>=40 && eng>=40) {pass="합격";} 밑에는 삼항연산자
		pass = avg<60? "불합격": kor>=40 && math>=40 && eng>=40 ? "합격":"";
		//if(avg>=95) {jang="장학생";} 밑에는 삼항연산자 
		jang = avg<95? "-" : "장학생";
		if(avg>=90) {lv="수";}
		else if(avg>=80) {lv="우";}
		else if(avg>=70) {lv="미";}
		else if(avg>=60) {lv="양";}
	
		//출력
		System.out.println("===================================================================================");
        System.out.println("학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생");
        System.out.println("===================================================================================");
        System.out.printf("%-s %5d %5d %5d %5d %5.2f   %-5s   %-5s   %-5s\n",
                std, kor, eng, math, total, avg, pass, lv, jang);


		
		
		
		
		
		
		
		
	}

}
