package com.company.java002_ex;

public class VarEx002 {
	public static void main(String[] args) {
		int a=10;
		int b=3;
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.println(a + "-" + b + "=" + (a-b));
		System.out.println(a + "*" + b + "=" + (a*b));
		System.out.println(a + "/" + b + "=" + (a/b));
		
		
		System.out.printf("%d+%d=%d\n",a,b, a+b); //대입 용도라 묶지 않아도 계산됨
		System.out.printf("%d-%d=%d\n",a,b, a-b);
		System.out.printf("%d*%d=%d\n",a,b, a*b);
		System.out.printf("%d/%d=%d\n",a,b, a/b);
		
		System.out.printf("%s  %d\n", a, b); //맞는 형식 선택해서 사용
		
		
		double a1=10;
		double b1=3;
		System.out.printf("%d/%d=%f\n",a,b,a1/b1); 
		
	}
	
//	연습문제2)  
//	패키지명 : com.company.java002_ex
//	클래스명 : VarEx002
//	출력내용 : 
//	   1-1.  정수형데이터를 담을수 있는 변수 a 만들고   
//	   1-2.  a에 10대입하시오
//	   1-3.  정수형데이터를 담을수 있는 변수 b 만들고   
//	   1-4.  b에 3대입하시오
//	   1-5.  System.out.println 을 4번사용해서 
//	     10 + 3 = 13
//	     10  - 3 = 7
//	     10  * 3 = 30
//	     10  / 3 = 3


}
