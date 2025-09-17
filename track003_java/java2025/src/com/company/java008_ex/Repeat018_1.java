package com.company.java008_ex;

public class Repeat018_1 {
	public static void main(String[] args) {

		System.out.println("갱어지가 등장합니다!");
		dog();

		System.out.println("\n강아지가 시험을 봤습니다. 점수를 공개합니다!");
		disp(7, "*");
		
		System.out.println("평가 결과는?");
		System.out.println("당신의 평균은?"+stdAvg(88)); //
		
		public static void dog() 
			{System.out.println("멍멍");}
		
		public static void disp(int n,String ch) {
			for(int i=0; i<n; i++) {
				System.out.println(ch);
			}
		}
		public static void stdAvg(int score) 
		{return (score>=90)? "A" : 
		     	score>=80)? "B" :
				score>=70)? "C" :"D";}
		
		
		
		
		
	

}
}
