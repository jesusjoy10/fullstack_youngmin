package com.company.java010_bank;

import java.util.Scanner;

//1. 클래스는 부품객체
//2. 상태와 행위
public class Deposit {
       //상태 : 멤버변수
	    UserInfo userinfo;

		public Deposit() { super();  }

		public Deposit(UserInfo userinfo) { super(); this.userinfo = userinfo; }
	    
		//행위 : 멤버함수
		public void exec() {
			//입력- 사용자에게 입금할 금액입력받기
			Scanner scanner = new Scanner(System.in);
			System.out.println("입급할 금액 입력 > "); 
			//처리 - setter를 이용해서  사용자에게 입력받기
			double balance =scanner.nextDouble(); 							     
		   this.userinfo.setBalance(this.userinfo.getBalance()+balance);
		 //출력 - 입금이 완료되었습니다 출력 
			System.out.println("입금 완료되었습니다> "); 
			
			//setter  이용해서 사용자에게 입금받기
			
			
			
			
		}
}
/* 기능: 사용자에게 입금받기 
*/