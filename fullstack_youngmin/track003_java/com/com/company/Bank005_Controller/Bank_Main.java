package com.company.Bank005_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank_Main {

	
		//멤버변수
		private List<UserInfo> users;  // add, get , size , remove, contains
		private BankController [] controller;
		
		//생성자 - 멤버변수를 초기화해서 사용가능하게
		public Bank_Main() {
			users      = new ArrayList<>();
			controller = new BankController[]  {
					new Login(), new Add(),     new  Show(),   new Deposit() , new WithDraw(),  new Delete()
			}; //   0              1                    2             3               4               5 
		}
		//멤버함수 (메뉴판)
		public void menu() {
			//변수
			Scanner scanner = new Scanner(System.in);	
			int num = 0;
			
			//입력 + 처리
			//1. 메뉴판 무한반복 - 입력
			//2. 메누가 1- 사용자 추가 Add()   1번이니 ? 그럼 옆처럼 처리해줘 controller[1].exec(users); 
			//3. 메뉴가 2,3,4,5 - 로그인한 후에 Login()  각각의 기능  Login(),  Add(),  WithDraw(),  Deposit(),  Delete()
			//       각각의 기능 2 Show()                        3 WithDraw()
			//        controller[2].exec(users);   controller[3].exec(users); 
			 while (num != 9) {
			        System.out.println("\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟");
			        System.out.println("[1] ➕ 계좌 추가");
			        System.out.println("[2] 🔍 계좌 조회");
			        System.out.println("[3] 💵 입금하기");
			        System.out.println("[4] 💸 출금하기");
			        System.out.println("[5] 🗑️ 계좌 삭제");
			        System.out.println("[9] ❌ 종료");
			        System.out.print("번호를 선택하세요: ");
			        num = scanner.nextInt(); 
			        int find= 0;
			        if(num >=2 && num <=5 ) {find =controller[0].exec(users,0);}
			        controller[num].exec(users , find);			        			 						
				} // for end 
				
			}	
		// add, user.get(유저번호) , user.size() , user.remove(유저번호)
			/*
			 * 
		🌟💰 WELCOME TO BANK SYSTEM 💰🌟
					
		[1] ➕ 계좌 추가
		[2] 🔍 계좌 조회
		[3] 💵 입금하기
		[4] 💸 출금하기
		[5] 🗑️ 계좌 삭제  
					
				👉 번호를 선택하세요:*/
			//Q1. 무한반복 + 각번호 입력받으면 ~ 기능입니다 출력
			//Q2. 입력받은 번호가 1번이면 유저추가
			//Q3. 입력받은 번호가 2,3,4,5 이면
			      // 1) Login
			      // 2) 2,3,4,5 각각에서 처리해야할일 
			
			
			//start
			//1. 유저추가
			//2,3,4,5
			// 1) login 2) 2,3,4,5 각각에서 처리해야할일
				
		public static void main(String[] args) {
			new Bank_Main().menu(); //start
	}

}
