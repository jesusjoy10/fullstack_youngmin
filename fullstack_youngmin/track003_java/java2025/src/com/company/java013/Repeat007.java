package com.company.java013;



class Papa1 extends Object{  
	int money = 10000;     
	public Papa1() { super(); }
	public void sing() {  System.out.println("GOD-거짓말");  }
}// end class

class Son2 extends Papa1{ 
	int money = 1500;
	public Son2() { super(); }
	@Override public void sing() { System.out.println("빅뱅-거짓말"); }
} // end class

public class Repeat007 {
  public static void main(String[] args) {
	Papa1 mypapa = new Son2();    
	System.out.println(mypapa.money);   //10000
	mypapa.sing();     // 빅뱅 
	System.out.println(((Son2)mypapa).money); // 1500 출력되게 해주세요.
  }
}
/*
[method : 정보보관] Papa1, Son2 , Repeat007
------------------------------------------------------------
[heap:동적]            			 			| [stack:지역] 
> 생성자가 인스턴스변수를 초기화해서 사용가능하게 해준다.
       Papa1() {money = 10000 / -----   }
[1번지] Son2()  {money = 1500 / @sing 빅뱅}  ← Papa1 mypapa [1번지] {money = 10000 / @sing }  @19번째줄
					   						|  main
------------------------------------------------------------
*/

/*
Object
  ↑
Papa1 {money = 10000 / @sing GOD}
  ↑
 Son2 {money = 1500 / @sing 빅뱅}	  	  
*/







