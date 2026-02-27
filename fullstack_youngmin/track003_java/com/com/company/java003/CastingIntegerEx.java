package com.company.java003;

public class CastingIntegerEx {
	public static void main(String[] args) {
		// 1) 기본형 / 참조형
		// 2) boolean, 정수형(byte<short , char <int <long), 실수형 (float<double>
		
		short sh1 = 1; // sh1 [ 1 ] 2byte
		short sh2 = 2; // sh2 [ 2 ] 2byte
		
		// 산술연산시(+) 자동으로 int 변환
 		short result1 = (short) (sh1 + sh2); // 1 (int)+2(int)
 		int result2 = sh1 +sh2; 
	}

}
