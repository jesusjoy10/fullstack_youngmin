package com.company.java016_Javaio;

public class Java006_StringBufferd {
	public static void main(String[] args) {
		//#1. String      문자열누적 - 새로운 주소 (변형X)
		String str="ABC"; //1번지 = 1번지["ABC"] heap
		System.out.println("1. str주소>" + str + ""+ System.identityHashCode(str));
		
		str += "D";      //2번지 = 2번지["ABCD"] heap
		System.out.println("1. str주소>" + str + ""+ System.identityHashCode(str));
		
		//#2. StringBuffer 문자열누적- 기존 주소 (변형o)
		StringBuffer sb = new StringBuffer();
		sb.append("ABC");
		System.out.println("3. str주소>" + str + ""+ System.identityHashCode(sb));
		
		sb.append("D");
		System.out.println("3. str주소>" + str + ""+ System.identityHashCode(sb));

	}

}
