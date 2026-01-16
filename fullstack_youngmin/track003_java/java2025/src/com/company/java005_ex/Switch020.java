package com.company.java005_ex;

import java.util.Scanner;

public class Switch020 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자 하나 입력하시오");
		char ch = scanner.next().charAt(0);
		
		switch (ch) {
		case 'a' : System.out.println("apple"); break;
		case 'b' : System.out.println("banana"); break;
		case 'c' : System.out.println("coconut"); break;
	    default : System.out.println("a,b,c가 아니다");break;
		} 
	
	

}
}