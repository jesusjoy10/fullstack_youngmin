package com.company.Bank005_Controller;

import java.util.List;
import java.util.Scanner;

public class Login implements BankController {

	@Override
	public int exec(List<UserInfo> users, int find) {// 유저번호
		//변수
		Scanner scanner =new Scanner(System.in);
		//입력
		System.out.println("[1] 아이디>"); String tempid = scanner.next();
		System.out.println("[2] 비밀번호>"); String temppass = scanner.next();
		  //내가 입력받은 아이디와 유저의 0번째 아이디가 같다면 번호는 0
		  //내가 입력받은 아이디와 유저의 1번째 아이디가 같다면 번호는 1
		  //처리 - users에서 아이디와 비밀번호가 맞는 유저번호 찾기 - 찾았으면 나오기 / 못찾았으면 -1
		for(int i=0; i<users.size(); i++) {
		 if(tempid.equals(users.get(0).getId()) && temppass.equals(users.get(0).getPass() ) ) {
			 return i; }	 	           
		}
		return -1;		
	  }
	}	