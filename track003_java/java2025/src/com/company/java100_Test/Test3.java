package com.company.java100_Test;

public class Test3 {
	public static void dog(){ System.out.println("멍멍");}
	public static void disp(int a, char ch){  for(int i=0; i<a; i++) { System.out.print(ch); } }
	public static String stdId(int a){   return  "G" + a;   } 
	 
	public static void main(String[] args) {
	
		dog();  	
		disp(7, '*');  
		System.out.println();
		System.out.println("당신의 학번은? " + stdId(1111));
	} //end main
} // end class




