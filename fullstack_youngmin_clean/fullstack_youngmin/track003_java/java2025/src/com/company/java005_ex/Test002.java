package com.company.java005_ex;

import java.util.Scanner;

public class Test002 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자 하나 입력하시오");
		
		char ch = scanner.next().charAt(0);
		
		switch(ch) {
		case 'x': System.out.println("x-ray"); break;
		case 'y': System.out.println("yogurt"); break;
		case 'z': System.out.println("zebra"); break;
		default : System.out.println("x,y,z가 아닙니다");break;
		}
		
		
	}
}
