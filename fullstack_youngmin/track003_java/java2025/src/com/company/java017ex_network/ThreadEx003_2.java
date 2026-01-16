package com.company.java017ex_network;

import javax.swing.JOptionPane;

class Count32 implements Runnable{ 
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
          if(Thread.currentThread().isInterrupted()) {
        	  System.out.println("....stop");
        	  break;
          }
          System.out.println(i);
          try {Thread.sleep(1000);}
          catch (InterruptedException e) { 
        	  System.out.println();
        	  Thread.currentThread().interrupt();
          }
        }
    }
}
public class ThreadEx003_2 {
    public static void main(String[] args) {
    	String info = "계속 카운터합니다";
        Thread timer1 = new Thread(Count32());  
        timer1.start();

        String answer = JOptionPane.showInputDialog("count stop? y/n");
        if (answer.toLowerCase().equals("y")) {
            timer1.interrupt();
            info="count를 멈춥니다."; }

        System.out.println(">main end....");
    }

	private static Runnable Count32() {
		return null;
	}
}
