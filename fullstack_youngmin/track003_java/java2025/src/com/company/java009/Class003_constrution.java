package com.company.java009;

//1. 클래스는 부품객체
//2. 클래스는 상태(멤버변수)와 행위 (멤버함수)

class Car31{} // 생성자 Car31() - 컴파일러가 기본생성자를 자동생성
class Car32{
     String color;
     // alt + shift + s ★ 밑에서 3번째 (2,3,4)
	 public Car32() {super(); } //##  object()
	 public Car32(String color) {super();this.color = color;}
	 @Override
	 public String toString() {return "Car32 [color=" + color + "]";}
	 
//class car33 extends car32{}   


//////////////////////////////////
public class Class003_constrution {
    public void main(String [] args) {
        Car31 ca1 = new Car31(); //1. new (메모리 빌리고, 객체생성)  2. Car31()초기화 3. ca1 번지
        System.out.println(ca1); //Car31@73a28541
        
        Car32 ca2 = new Car32(); //1. new (메모리 빌리고, 객체생성)  2. Car32()초기화 3. ca2 번지
        System.out.println(ca2); //Car32@4554617c
        
        Car32 car3 = new Car32("red");
        System.out.println(car3 + "\t" + car3.color);
    }
   
}}
//////////////////////////////////
/* Q1. 클래스란? [ 설계도   ]   예) [car31.class   , car32.class , class003.class]
   Q2. 객체?  [ 실제(new)로 만든 장난감   ] 예) [ car1 , car2   , car3   ]
   Q3. 인스턴스?  [ 각각의 장난감들   ] 예) [ car1(x), car2(null) ,car3(red) ]   
  
  
   */
 