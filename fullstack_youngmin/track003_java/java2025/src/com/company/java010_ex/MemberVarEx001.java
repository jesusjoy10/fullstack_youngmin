package com.company.java010_ex;

class Sawon3{ 
    int pay  =10000;    // 인스턴스 변수 - heap area - new o - 생성자 o
    static int su=10;       // 클래스변수 , method  , new x  - 생성자 x > 바로사용 가능
    static int basicpay; // 클래스변수 , method  , new x  - 생성자 x > 바로사용 가능 클래스명.basicpay
                             // ! static은 this 사용 불가 / 당장사용해야하는데 this를 쓰려면 new 하고 난다음에
    static int basicpay2;    // 클래스변수 , method ,new x  - 생성자 x >  바로사용
    
    //클래스메서드 - method  , new x  - 생성자 x   sawon3.showSu () >바로사용
    public static void showSu() {   System.out.println(su);  }    
  //클래스메서드 - method  , new x  - 생성자 x   sawon3.showPay () >바로사용
  //! static은 this 사용 불가 / 당장사용해야하는데 this를 쓰려면 new 하고 난다음에 사용
  //public static void showPay() {   System.out.println(this.pay);  }    
  
    // 인스턴스메서드 - heap area -new o - 생성자
    public  void  showAll001() {   
       System.out.println(su);  // static 사용 가능 - new 전에 메모리상에 static 올라가있어서
       System.out.println(this.pay);  // this 사용가능
    } 
  //클래스메서드 - method  , new x  - 생성자 x   sawon3.showPay () >바로사용
    public static  void  showAll002() {  
       // showAll001();    // ! static은 this(인스턴스) 사용 불가
      // System.out.println(this.pay);
    } 
} 
public class MemberVarEx001{
  public static void main(String[] args) { //args 지역변수
   Sawon3   sola = new Sawon3();  //1)new 번지, 객체생성 2) 생성자초기화 3)sola 번지
   sola.showAll001();
  }
  }


/*/*
------------------------[ runtime data area]
[method: 정보, static, final : 공용정보]
> Sawon3.class   / MemberVarEx001. class
> Static : Sawon3.su , sawon3.basicpay2 , sawon3.showSu () , sawon3.showAll002()  
------------------------------------
[heap: 동적]            | [stack : 잠깐빌리기]
                         showAll001();
1번지{pay=0, showAll001() } <- sola[1번지] 29번째줄
                       | main
------------------------------------
*/