package com.company.java008_ex;

import java.util.Arrays;

public class Methodex008_3 {
	public static void main(String[]args) {
		String[] toybox = {"레고, 컴퓨터, 키보드, 마우스, 모니터"};
		System.out.println("main 처음 toybox>" + Arrays.toString(toybox));
		lend(toybox);
		
		System.out.println("main 친구가 빌려간 후 toybox>" + Arrays.toString(toybox));
		
	}
  ////////////////////////////////////////////
	 public static void lend(String[] toybox) {toybox[0]="x";}
}
/* [method area]  1) MethodEx008Ex_3 정보
 * 
 * [heap area]               [stack area]
 *                          <- lend[1000번지]
 * 3) 1000번지                <- toybox[1000번지] 8번쨰줄
 *  {레고, 컴퓨터,,,,}
 *                           2)main
 */


