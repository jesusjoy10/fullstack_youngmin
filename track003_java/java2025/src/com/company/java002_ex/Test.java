package com.company.java002_ex;

import java.util.Scanner;

public class Test {
	public static void main(String [] args) {
		double d = 3.14;
		
	 Scanner scanner = new Scanner(System.in);
	 
	 System.out.print("파이값을 입력하시오>");
	 d= scanner.nextDouble();
	 System.out.println("파이값은"+d+"입니다");
	}
}

