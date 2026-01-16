package com.company.java010_bank;

import java.util.Scanner;

public class Withdraw {
	   //상태 : 멤버변수
    UserInfo userinfo;
       //행위 : 멤버함수
 	public Withdraw() { super();  }

	public Withdraw(UserInfo userinfo) { super(); this.userinfo = userinfo; }
    
	//행위 : 멤버함수
	public void exec() {
		//입력- 사용자에게 입금할 금액입력받기
		Scanner scanner = new Scanner(System.in);
		System.out.println("출금할 금액 입력 > "); 
		//처리 - setter를 이용해서  사용자에게 입력받기
		double output =scanner.nextDouble(); 							     
	   this.userinfo.setBalance(this.userinfo.getBalance()-output);
	   //출력 - 출금이 완료되었습니다 출력 
		System.out.println("출금 완료되었습니다> "); 
		//setter / getter 이용해서 사용자에게 출금받기 ### 
	}
    
}
/* 기능: 사용자에게 출금받기 
*/