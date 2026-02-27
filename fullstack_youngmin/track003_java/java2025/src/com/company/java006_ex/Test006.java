package com.company.java006_ex;

import java.util.Scanner;

public class Test006 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를입력하세요>");
		int num1 = scanner.nextInt();
		
		switch (num1) {
		case 1 : System.out.println("mango"); break;
		case 2 : System.out.println("noodle"); break;
		case 3 : System.out.println("orange"); break;
		default : System.out.println("1,2,3이 아닙니다"); break;}
		
		
		

}
}