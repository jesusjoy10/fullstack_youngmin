package com.company.java017_network;

class Animal{String name;}
//class Dog extends Animal , Thread{}  //   Mentol extends Thread 사용하지 못함.
//1)Thread 상속 → Runnable 구현 2) run 수행내용 3) start 실행

class Dog extends Animal implements Runnable{ //1) extends Thread
 
	@Override public void run() {   //2) run 
		for(int i =0; i<5; i++) {
			System.out.println("멍");
			try { Thread.sleep(1000);} catch(InterruptedException e ) {e.printStackTrace();};
	     }
    }
}
public class Thread003_Runnable {
	public static void main(String[] args) {
		Thread sound = new Thread(new Dog()); sound.start(); //3) start
		for(int i=0; i<5; i++) {
			System.out.println("◖⚆ᴥ⚆◗");
			try { Thread.sleep(1000);} catch(InterruptedException e ) {e.printStackTrace();};
		}
		

	}

}
