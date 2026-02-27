package com.company.java013;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)
//3. 클래스( 설계도 )  → 장난감 조립 → 사용하는 방법   : 
//   Coffee  a1 = new Coffee("까페라떼" , 2 , 4000); 
//   3-0. 장난감 이름 :  Coffee  a1  
//   3-1. 장남감조립  :  new     → heap area 메모리빌리고 객체 생성
//   3-2. 장남감 만드는 방법 :  요청사항대로 Coffee("까페라떼" , 2 , 4000) , 아무말 안하면 - 아메리카노1잔, 2000원
//   3-3. 장남감 갖고놀수 있게 : a1 (어디에다가 만들었는지 번지)
/////////////////////////////////////// 1단계 설계도
class Coffee{
	//멤버변수
	public static final String Company="(주)스벅";//명시적
	public static final String Location;
	static {Location="africa java";}  //초기화블록
	String name;  int price, num;  // 인스턴스 변수- heap area - new 관련O - this 관련 - 각각
	//멤버함수
	void show() {    
		System.out.println("=====커피\r\n" + "커피명 : "+  this.name +"\r\n" + "커피잔수 :"
								          +  this.num +"\r\n" + "커피가격 : "+this.price+"\r\n");
	}
	public Coffee() { super(); this.name = "아메리카노"; this.price = 2000; this.num = 1; }
	public Coffee(String name, int num, int price) 
	{ super(); this.name = name; this.price = price; this.num = num; }
}
//class CafeMoca extends Coffee{}
///////////////////////////////////////////////////////////
public class Repeat001_oop {
	public static void main(String[] args) {
		Coffee  a1 = null;   // 2번지에 있는 클래스 자료형으로 a1이라는 장난감만들꺼야라고 했지..... 장난감만든적 없음.
				a1 = new Coffee("까페라떼" , 2 , 4000);   //2단계 장난감 조립
		     // 3. a1 (1000번지)     = 1. new 메모리빌리고(1000번지) 객체(장난감)생성 2.Coffee 생성자로 장난감 만드는 방법-초기화
		a1.show();   //3단계 갖고놀기 (1000번지).show()
		Coffee  a2 = new Coffee(); 
		// 3. a2 (2000번지)     = 1. new 메모리빌리고(2000번지) 객체(장난감)생성 2.Coffee 생성자로 장난감 만드는 방법-초기화
		a2.show();  //3단계 갖고놀기 (2000번지).show()
	}
}
/*  초기화순서  		
 1.	기본값	{name=null    , num= 0, price=0 / show()}	 		
 2. 명시적	{name=null    , num= 0, price=0 / show()}	 	
 3. 초기화블록 {name=null    , num= 0, price=0 / show()}	  		
 4. 생성자    {name="아메"    , num=1,price=2000 / show()}	
 */

/************** 
Repeat001_oop.java
Repeat001_oop.class   Coffee.class
[method : 정보보관] 
[1번지]  public Repeat001_oop.class  ★
[2번지]  Coffee.class  ( 설계도 )
------------------------------------------------------------
[heap:동적]                             			|  [stack:지역] 
												 ←  a2(2000번지).show()  @36번째줄 
2000번지	 																(a2 실제로 만든 장난감,객체,인스턴스)
{name="아메"    , num=1,price=2000 / show()}	     ←  a2(2000번지)         @34번째줄 	
___________________________________________________________________________________
												 ←  a1(1000번지).show()  @33번째줄 
1000번지	
{name="까페라떼", num=2,price=4000 / show()}	     ←  a1(1000번지)  @31번째줄(a1 실제로 만든 장난감,객체,인스턴스)
   										   			a1(null)     @30번째줄
									   			|   main 	  ★
------------------------------------------------------------
*/

/*
=====커피
커피명 : 까페라떼
커피잔수 : 2
커피가격 : 4000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000
*/