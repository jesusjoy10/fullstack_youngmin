package com.company.java002;

public class Var {
	public static void main(String[] args) {
		//1. 변수? 자료형 변수명;
		int a = 0; //%d 정수(1,2,3...) a[공간 생성]
		System.out.println("1:" + a);		
		
		a = 1000000; //A=B (=대입해 주세요) a[1000000] <-변수는 변경 가능
		System.out.println("2:"+a);
		
		a = a-90000; //a[1000000-90000]
		System.out.println("3:"+a);
		
		
		//2. 변수의 범위
		{int b=20; System.out.println(b);}
		//b=1000; cannot be resolved to a variable 
		//<-{적용 범위} 벗어남
		
		
		//3. 변수명 '$' or '_' or '소문자'
		//오픈 박스(변수)
		int $1=1; int _2=2; int a3bc=3; 
		//밀봉 박스(상수)
		int HOME = 4;
		//int static; <-Syntax error on token "static"
		//int package;
		//int void;
		int main; //<-단순 이름이라 가능
		
		
	}
}
