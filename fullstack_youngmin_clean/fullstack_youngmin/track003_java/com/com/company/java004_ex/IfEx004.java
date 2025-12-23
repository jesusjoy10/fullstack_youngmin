package com.company.java004_ex;

import java.util.Scanner;

public class IfEx004 {
	public static void main(String[] args) {
		// 변수
		char ch= '\u0000';
				
     	Scanner scanner = new Scanner(System.in);
     	//입력
     	System.out.print("영문 소문자 또는 대문자를 입력해주세요>");
     	ch = scanner.next().charAt(0); 
     	
     	//처리 + 출력 - 대문자인지, 소문자인지 판별하는 프로그램
     	if(ch>='A' && ch<='Z') {
     		System.out.println("대문자");
     	}else if(ch >= 97 && ch<= 122) {// ch>= 'a' && ch<= 'z'
     		System.out.println("소문자");
     	}else { System.out.println(" 영문,소문자,대문자가 아닙니다.");
     	}
     	
	}

}
/*출력내용 : 문자한개를 입력받아 
대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  */