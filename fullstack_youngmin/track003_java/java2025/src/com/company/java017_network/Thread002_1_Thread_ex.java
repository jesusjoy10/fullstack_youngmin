package com.company.java017_network;

// 수행클래스 1) Thread 상속  2)run 실행해야하는 내용  3) start 실행

class Cow extends Thread{ //#1. 상속
	@Override public void run() {//#2. run
		for(int i=0; i<5; i++) {
			System.out.print("음메#" + (i+1) +" ");
			try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}
class Chicken  extends Thread{//#1. 상속
	@Override public void run() {//#2. run
		for(int i=0; i<5; i++) {
			System.out.print("꼬끼오#" + (i+1) +" ");
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
		}
	}
}

public class Thread002_1_Thread_ex {
	public static void main(String[] args) {
		Thread cow = new Cow();  cow.start(); //#3. 실행클래스 시작 start
		Thread chicken = new Chicken();  chicken.start();
	}
}



