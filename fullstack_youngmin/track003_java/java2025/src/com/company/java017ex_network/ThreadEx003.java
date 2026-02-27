package com.company.java017ex_network;

import javax.swing.JOptionPane;

class Count31 extends Thread { // 
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;}     
        }
    }
}
public class ThreadEx003 {
    public static void main(String[] args) {
        Thread timer1 = new Count31(); // 
        timer1.start();

        String answer = JOptionPane.showInputDialog("count stop? y/n");
        if (answer.toLowerCase().equals("y")) {
            timer1.interrupt();
            System.out.println("count를 멈춥니다.");
        }

        System.out.println(">main end....");
    }
}
