package com.company.java010_ex;

import com.company.java010.UserInfo;

class UserSon1 extends UserInfo{
	public void show() {
		System.out.println("홍길동 아버지 이름 > " + super.name );     //자식 - public 
		System.out.println("홍길동 아버지 금고번호 > " + super.safeCode ); //자식 - protected
		//System.out.println("홍길동 아버지 집 > " + super.house );  //자식 - package (같은폴더에서)  
		//System.out.println("부 IQ > " + super.iQ );
		System.out.println("홍길동 아버지 IQ > " + super.getiQ() );
		//Q super.house를 못 쓰는 이유는 UserInfo 클래스의 house는 접근자가 package
		//  UserSon2클래스는 (java010_ex 폴더 안에 있음)
}
///////////////////////////////////////////
public class Modifier002_public_private {
	public static void main(String[] args) {
		System.out.println("\n\n1.홍길동 아버지 정보"); //본인 : public > protected > default > private (x)
		UserInfo user = new UserInfo();
		user.name="홍상직";  //public 아무데서나 접근 (홍길동씨 아버지)
		//user.safeCode = "1234"; //protected 본인꺼 접근가능  Q2. 오류이유 extends 상속 받은적이 없음
		//user.house = "전라남도장성군";  Q3. 오류이유 ? 같은폴더 아님 - java010_ex 폴더안에 있음.
		user.setiQ(148);  //The field UserInfo.iQ is not visible
		System.out.println(user.getiQ());
	}

}}
///////////////////////////////////////////