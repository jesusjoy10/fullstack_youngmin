package com.company.java004_ex;

import java.util.Scanner;

public class Repeat011 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//변수
		int num1, num2; char ch; String result= "";
		
		//입력
		System.out.println("정수를 하나 입력해주세요");
		num1= scanner.nextInt();
		System.out.println("정수를 하나 입력해주세요");
		num2= scanner.nextInt();
		System.out.println("연산자를 입력해주세요(+,-,*,/)");
		ch= scanner.next().charAt(0);
		
		//처리
		result= (""+num1+ch+num2+"=");
		
		
		//결과
		if(ch=='+') {System.out.println(num1+"+"+num2+"="+(num1+num2));}
		else if(ch=='-') {System.out.println(num1+"+"+num2+"="+(num1-num2));}
		else if(ch=='*') {System.out.println(num1+"+"+num2+"="+(num1*num2));}
		else if(ch=='/') {System.out.println(num1+"+"+num2+"="+((double)num1/num2));}
		
		System.out.println(result);
		
		
	}
}
