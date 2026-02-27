package com.company.java012_ex;

/*Q1. 상속도를 그리시오. 
 *     Object
 *       ↑
 *     TestA3   (a=10, --------) 
 *       ↑
 *     TestB3   (b=10, @toString) 
 * 
 * */
class TestA3  extends Object{  
	   int a=10;
	   @Override public String toString() { return "TestA3 [a=" + a + "]"; }
	}
	class TestB3  extends TestA3{  
	   int b=10;
	   @Override public String toString() { return "TestB3 [b=" + b + "]"; }
	} 

public class PolyEx002 {
	public static void main(String[] args) {
		  //     자식 =   부모 /   다운캐스팅 / 타입캐스팅 필요 o
	      TestB3  tb =  (TestB3) new TestA3();
	      //Q2. 15번째줄에서   TestB3  tb는 클래스의 무엇을 사용할수 있을까요? 코드의 의미  A. (b=10, @toString) - (a=10, --------) 
	      //Q3. 15번째줄에서   T(TestB3) new TestA3() 클래스의 무엇을 사용할 수 있을까요? A.                    (a=10, toString()) 
	      //Q4. 코드상에서는 문제가 없는데 코드를 실행하면 오류가 나는 이유는?
	      // tb : (b=10, @toString) - (a=10, --------) =            1000번지{a=10, toString()}
	      //      {b=10,} 이부분을 객체생성한적이없음
	   }

}


/*//Q1. 상속도를 그리시오. 
class TestA3  extends Object{  
   int a=10;
   @Override public String toString() { return "TestA3 [a=" + a + "]"; }
}
class TestB3  extends TestA3{  
   int b=10;
   @Override public String toString() { return "TestB3 [b=" + b + "]"; }
} 
/////////////////////////////////////////////////
public class PolyEx002 {
   public static void main(String[] args) {
      TestB3  tb =  (TestB3) new TestA3();
      //Q2. 15번째줄에서   TestB3  tb는 클래스의 무엇을 사용할수 있을까요? 코드의 의미
      //Q3. 15번째줄에서   T(TestB3) new TestA3() 클래스의 무엇을 사용할 수 있을까요?
      //Q4. 코드상에서는 문제가 없는데 코드를 실행하면 오류가 나는 이유는?
   }
}
*/