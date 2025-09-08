package com.company.java005_ex;

public class ForEx004_2 {
	public static void main(String[]args) {
		int cnt = 0; String result="";
		// 1~10까지의 3의 배수의 갯수 카운트를 담을 변수
		
		
		for (int i=1; i<=10; i++ ) {if(i % 3 ==0){ cnt++; result += (i==3? "": ",")+i;}}
		
		//출력
		System.out.println("3의배수:"+ result);
		System.out.println("갯수:"+ cnt);
		
	}

}


/* 출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개
*/