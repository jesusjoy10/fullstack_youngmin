package com.company.java001;

public class A002 {
	public static void main(String[] args) {
		System.out.println("A");
		System.out.println("AB");
		System.out.println("ABC"); //여러 줄 사용
		
		//한 줄로 만드는 방법은?
		System.out.println("A\nAB\nABC"); // \n 사용한 줄바꿈
		
		//포맷 형식 printf 사용
		//%s(문자), %d(숫자) ->퍼센트 수만큼 , 필요
		System.out.printf("이름:%s	나이:%d","길동",12);
		
	}

}
