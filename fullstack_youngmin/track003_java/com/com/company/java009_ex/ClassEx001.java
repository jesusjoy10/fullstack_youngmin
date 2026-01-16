package com.company.java009_ex;

class Student001{
	//멤버변수
	  String name;  int no, kor, eng, math;  
	//멤버함수
	  void info() {
		  System.out.println("이름: " + this.name);
		  System.out.println("총점: " + (this.kor+ this.eng +this.math));
		  System.out.println("평균: " + (this.kor+ this.eng +this.math)/3.0);
		  
	  }
	}


public class ClassEx001 {
	 public static void main(String[] args) {
		//1. new(1번지, 객체생성) 2. Student001() 초기화 3. s1 주소 =1번
	      Student001   s1 = new Student001();
	     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
	     s1.info();
	     
	   }

}

/*클래스명 :  ClassEx001
class Student001{
  멤버변수 : String name;  int no, kor, eng, math;
  멤버함수 : void info()
}

public class ClassEx001{
   public static void main(String[] args) {
      Student001   s1 = new Student003();
     s1.name="first";  s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
     s1.info();
   }
}
출력내용 : 
  이름: first
  총점 : 299
  평균 : 99.67
  
  Student001   s1 = new Student001();
   ----------------------------------[runtime data area]
 [method: 정보, static, final :공용정보]
 class Student001,  class ClassEx001         클래스는(설계도) → (인스턴스화) 객체(object/ a1,a2)
                                                                      -> 인스턴스(siu,nayong)
 ----------------------------------
[heap: 동적]                                        |[stack :잠깐빌리기]    
                                                     s1. info (){}
 1번지 {name=first, no=11 , kor=100 , eng=100 , math=99} <- s1[1번지]                     
                                                  | main 2)
 ----------------------------------
  
  
*/