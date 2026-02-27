package com.company.java010_bank;

public class UserInfo {
	//변수 만들기 private -> 외부접근 x
	// 입력값=문자=String=id ,pass
	// 
	private String id;
	private String pass;
	private double balance;
	
	public UserInfo() { super();  }
	public UserInfo(String id, String pass, double balance) { super();		this.id = id;		this.pass = pass;		this.balance = balance;	}
	
	@Override
	public String toString()
	{return "UserInfo [id=" + id + ", pass=" + pass + ", balance=" + balance + "]";}
	
	public String getId() {return id;}  public void setId(String id) {	this.id = id;}
	public String getPass() {return pass;}	public void setPass(String pass) {this.pass = pass;}
	public double getBalance() {return balance;	} 
	public void setBalance(double balance) {this.balance = balance;	} 
	

} // end class

/*1명분의 유저정보보관
 *  [ -id :String, -pass:String, -balance:String]
 *  */
