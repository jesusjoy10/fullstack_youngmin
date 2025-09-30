package com.company.java012_ex;

/*// Q1. 상속도 그리기
 * Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
      Object
        ↑
       Papa (money=10000, sing(god))
        ↑
       Son (money=1500, @sing(빅뱅) 오버라이딩) 
 */
	class Papa extends Object{  
		   int money = 10000;     
		   public Papa() { super(); }
		   public void sing() {  System.out.println("GOD-거짓말");  }
		}// end class
		class Son extends Papa{ 
		   int money = 1500;
		   public Son() { super(); }
		   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
		} // end class	
    public class PolyEx004 {
	public static void main(String[] args) { 
	      Papa mypapa = new Son();    
	      // Q3. Papa mypapa 의미?  A. Papa 자료형 쓸 수 있어! {money= 10000/sing}  부모 -> 자식 / 업캐스팅 -> 타입캐스팅x 
	      // Q4. 인스턴스화한 실제 메모리 빌려온그림
	      // mypapa = {money = 1500 / @sing - 빅뱅} -  {money= 10000/sing / -----}
	      System.out.println(mypapa.money); // Q5.  출력    A. 10000
	      mypapa.sing();  //Q6. 출력   A. 빅뱅 거짓말
	       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.  
	      System.out.println(((Son)mypapa).money);  // 출력: 1500
	   }
}
/*클래스명 : PolyEx004
다음과 같이 코드를 작성하시오.
// Q1. 상속도 그리기
// Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
class Papa extends Object{  
   int money = 10000;     
   public Papa() { super(); }
   public void sing() {  System.out.println("GOD-거짓말");  }
}// end class
class Son extends Papa{ 
   int money = 1500;
   public Son() { super(); }
   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
} // end class
public class PolyEx001 {
   public static void main(String[] args) { 
      Papa mypapa = new Son2();    
      // Q3. Papa mypapa 의미?
      // Q4. 인스턴스화한 실제 메모리 빌려온그림
      System.out.println(mypapa.money); // Q5.  출력   
      mypapa.sing();  //Q6. 출력 
       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.  
   }
}
*/