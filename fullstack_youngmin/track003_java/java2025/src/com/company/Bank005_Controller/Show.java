package com.company.Bank005_Controller;

import java.util.List;

public class Show implements BankController {

	@Override
	public int exec(List<UserInfo> users, int find) {//user.get(유저번호)
		//출력
		UserInfo info = users.get(find);
		System.out.println("ID >" + info.getId());
		System.out.println("PASS >" + info.getPass());
		System.out.println("BALANCE >" + info.getBalance());
		//System.out.println(users.get(find));
		return find;
		
	}

}