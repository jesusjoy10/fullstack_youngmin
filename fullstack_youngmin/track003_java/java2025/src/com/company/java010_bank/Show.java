package com.company.java010_bank;

//1. 부품객체
//2. 상태와 행위
public class Show {
	// 상태 : 멤버변수
	private UserInfo userinfo;

	public Show() { super();  }

	public Show(UserInfo userinfo) { super(); this.userinfo = userinfo; } 
	// 행위: 멤버함수
	public void exec() {
		System.out.println("\nID>" + this.userinfo.getId()
		                   + "\nPASS" + this.userinfo.getPass()
		                   + "\nBALANCE" + this.userinfo.getBalance() );
	}

}

/* 기능: 유저정보보여주기*/