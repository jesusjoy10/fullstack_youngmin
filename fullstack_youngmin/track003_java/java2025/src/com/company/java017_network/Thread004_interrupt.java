package com.company.java017_network;

class Candy{  
	   String name; 
	   public void sell() { System.out.println(name + "가 1개 팔렸습니다."); }
	}
	class MentolSeller extends Candy  implements Runnable{  //##1) Runnable
	   
	   @Override public void run() { //##2) 실행내용
	      for(int i=0; i<10; i++){
	         if(  Thread.currentThread().isInterrupted()  ){  //방법2
	               System.out.println("판매중단됨!");
	               break;   
	         }
	         sell();
	         
	         try { Thread.sleep(1000); } 
	         catch (InterruptedException e) { 
	             System.out.println("판매 중 인터럽트(방해) 발생");
	            // 인터럽트상태를 상태복수 →  isInterrupted()  true 로 감지체크 
	            Thread.currentThread().interrupt();
	         }
	      }
	      
	      ////////////////////////////////// 방법1
	      /*
	      for(int i=0; i<10; i++){
	         sell();
	         try { Thread.sleep(1000); } 
	         catch (InterruptedException e) { 
	            System.out.println("판매 중단 요청됨.");
	            break;  // 반복종료  = 방법1)
	         }
	      }*/
	      ////////////////////////////////////////////
	   }
	}   
	//문제점 확인 : 손님이 없는데....   가 1개 팔렸습니다.  계속처리됨. 끄는 방법은?
	public class Thread004_interrupt {
	   public static void main(String[] args) {
	      //4. MentolSeller  start 실행해주기
	      //Thread       seller = new Thread(new MentolSeller()); // name을 설정한적이 없음. seller.name="멘톨캔디";
	      MentolSeller seller = new MentolSeller(); seller.name="멘톨캔디";
	      Thread       t      = new Thread(seller); t.start();
	      for(int i=0; i<5; i++) {
	         System.out.print("  손님 기다리는 중.....");
	         try { Thread.sleep(1000); } 
	         catch (InterruptedException e) { e.printStackTrace(); } 
	      }
	      System.out.println("..... 손님이 없어서 판매를 중단합니다.");
	      t.interrupt();  //##### 스레드중단요청1)
	   }
	}