package com.company.java013;

/*  
 * Abstract : 일반클래스 + 설계  
 * 
 * Object
 *   ↑
 * Robot {abstract charge(), move(), speak()} ← 추상클래스
 *   ↑         ↑             ↑  
 * CleaningRobot SecurityRobot CookingRobot
 * {@charge(),   {@charge(),    {@charge(),
 *  @move(),      @move(),      @move(), 
 *  @speak()}     @speak()}     @speak()}
 */

abstract class Robot {
    String model;
    int batteryLevel;

    abstract void charge(); // 충전방식
    abstract void move();   // 이동방식
    abstract void speak();  // 말하기방식

    public Robot() { super(); }
}

class CleaningRobot extends Robot {
    @Override void charge() {
        System.out.println(model + " 청소로봇 충전 중... 배터리 " + batteryLevel + "%");
    }
    @Override void move() {
        System.out.println(model + " 청소로봇: 먼지를 제거합니다!");
    }
    @Override void speak() {
        System.out.println(model + "청소로봇: 먼지를 제거합니다!");
    }
}

class SecurityRobot extends Robot {
    @Override void charge() {
        System.out.println(model + " 경비로봇 태양광 충전 중... 배터리 " + batteryLevel + "%");
    }
    @Override void move() {
        System.out.println(model + " 경비로봇: 경비 중");
    }
    @Override void speak() {
        System.out.println(model + " 경비로봇: 이상 없음. 안전 확보!");
    }
}

class CookingRobot extends Robot {
    @Override void charge() {
        System.out.println(model + " 요리로봇 인덕션 충전 중... 배터리 " + batteryLevel + "%");
    }
    @Override void move() {
        System.out.println(model + " 요리로봇: 요리 만드는 중");
    }
    @Override void speak() {
        System.out.println(model + " 요리로봇: 오늘의 메뉴는 파스타입니다!");
    }
}

public class Abstract001Ex {
    public static void main(String[] args) {
        // Robot robot = new Robot(); // Q1. 추상 클래스는 객체 생성 불가

        Robot[] bots = {
            new CleaningRobot(),
            new SecurityRobot(),
            new CookingRobot()
        };    
        int[] levels = {50, 70, 95};

        for (int i = 0; i < bots.length; i++) {
            bots[i].model = "Robo"+(i+1);
            bots[i].batteryLevel = levels[i];
            bots[i].charge();  
            bots[i].speak(); 
            
        }
    }
}
