package com.company.java005_ex;

public class ForEx005 {
	public static void main(String[]args) {
		int cnt=0;
		
		for (char ch= 'a';ch <= 'z'; ch++ ) {if (ch=='a'|| ch=='e' ||
				ch=='i'|| ch=='o' || ch=='u') {cnt++;}}
		System.out.println("소문자 a~z까지 모음의 갯수 >" + cnt);
	}

}



/* 출력내용 :   for 이용
소문자 a~z까지 모음의 갯수를 출력하시오.  */