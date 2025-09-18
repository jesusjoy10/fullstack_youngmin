package com.company.java006;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Exercise_Log {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // 사용자 신체 상태
	        double height = 0, weight = 0, muscle = 0, fat = 0;

	        // 목표 수치
	        double goalWeight = 0, goalMuscle = 0, goalFat = 0;
	        double tolerance = 3.0; // 목표 ±3 허용 범위

	        // 초기 설정
	        System.out.println("🏋️‍♂️ 바디프로필 챌린지 시작 🏁");
	        System.out.print("키(cm): ");
	        height = sc.nextDouble();
	        System.out.print("몸무게(kg): ");
	        weight = sc.nextDouble();
	        System.out.print("근육량(kg): ");
	        muscle = sc.nextDouble();
	        System.out.print("체지방율(%): ");
	        fat = sc.nextDouble();

	        // 목표 자동 설정
	        goalWeight = weight - 3;
	        goalMuscle = muscle + 5;
	        goalFat = fat - 3;
	        if (goalFat < 0) goalFat = 0; // 체지방 음수 방지

	        int sel = -1;

	        for (;;) {
	            System.out.println("\n== 💪 BODYPRO_100 ==");
	            System.out.println("1. 현재 상태 조회");
	            System.out.println("2. 운동 기록하기");
	            System.out.println("3. 목표 현황 보기");
	            System.out.println("4. 추천 운동 보기");
	            System.out.println("9. 종료");
	            System.out.print("> ");
	            sel = sc.nextInt();

	            if (sel == 9) {
	                System.out.println("🏁 프로그램을 종료합니다.");
	                break;
	            }

	            if (sel == 1) {
	                System.out.println("[현재 상태]");
	                System.out.printf("키: %.1f cm\n", height);
	                System.out.printf("몸무게: %.1f kg\n", weight);
	                System.out.printf("근육량: %.1f kg\n", muscle);
	                System.out.printf("체지방: %.1f %%\n", fat);
	            }

	            else if (sel == 2) {
	                System.out.println("운동 종류를 선택하세요.");
	                System.out.println("1. 벤치프레스 (50회당 근육 +1kg)");
	                System.out.println("2. 턱걸이 (30회당 근육 +1kg)");
	                System.out.println("3. 스쿼트 (50회당 근육 +1kg, 체지방 -0.3%)");
	                System.out.println("4. 런닝머신 (20분당 체중 -2kg, 체지방 -0.5%, 근육 -0.2kg)");
	                System.out.print("> ");
	                int workout = sc.nextInt();

	                if (workout == 1) {
	                    System.out.print("벤치프레스 횟수: ");
	                    int reps = sc.nextInt();
	                    double gain = reps / 50.0;
	                    muscle += gain;
	                    System.out.printf("근육량 +%.1f kg\n", gain);
	                } 
	                else if (workout == 2) {
	                    System.out.print("턱걸이 횟수: ");
	                    int reps = sc.nextInt();
	                    double gain = reps / 30.0;
	                    muscle += gain;
	                    System.out.printf("근육량 +%.1f kg\n", gain);
	                } 
	                else if (workout == 3) {
	                    System.out.print("스쿼트 횟수: ");
	                    int reps = sc.nextInt();
	                    double gain = reps / 50.0;
	                    muscle += gain;
	                    fat -= 0.3 * gain;
	                    if (fat < 0) fat = 0;
	                    System.out.printf("근육량 +%.1f kg, 체지방 -%.1f %%\n", gain, 0.3 * gain);
	                } 
	                else if (workout == 4) {
	                    System.out.print("런닝머신 시간(분): ");
	                    int min = sc.nextInt();
	                    double fatLoss = (min / 10.0) * 0.5;
	                    double muscleLoss = (min / 10.0) * 0.2;
	                    double weightLoss = (min / 20.0) * 2.0;

	                    fat -= fatLoss; if (fat < 0) fat = 0;
	                    muscle -= muscleLoss; if (muscle < 0) muscle = 0;
	                    weight -= weightLoss; if (weight < 0) weight = 0;

	                    System.out.printf("체지방 -%.1f %%, 근육량 -%.1f kg, 몸무게 -%.1f kg\n", fatLoss, muscleLoss, weightLoss);
	                } 
	                else {
	                    System.out.println("❌ 잘못된 선택입니다.");
	                }
	            }

	            else if (sel == 3) {
	                System.out.println("[목표 현황]");
	                System.out.printf("근육량: %.1f kg / 목표: %.1f kg\n", muscle, goalMuscle);
	                System.out.printf("체지방: %.1f %% / 목표: %.1f %%\n", fat, goalFat);
	                System.out.printf("몸무게: %.1f kg / 목표: %.1f kg\n", weight, goalWeight);

	                if (muscle >= goalMuscle - tolerance &&
	                    fat <= goalFat + tolerance &&
	                    weight <= goalWeight + tolerance) {
	                    System.out.println("🎉 목표 달성! 바디프로필 찍으러 갑시다!");
	                    break;
	                } else {
	                    System.out.println("🔥 아직 목표에 도달하지 못했습니다. 화이팅!");
	                }
	            }

	            else if (sel == 4) { // 추천 운동
	                System.out.println("[추천 운동]");
	                if (muscle < goalMuscle - tolerance) {
	                    System.out.println("- 근육량 부족! 스쿼트나 벤치프레스 추천 💪");
	                }
	                if (fat > goalFat + tolerance) {
	                    System.out.println("- 체지방 많음! 런닝머신 추천 🏃‍♂️");
	                }
	                if (weight > goalWeight + tolerance) {
	                    System.out.println("- 체중 감량 필요! 런닝머신 추천 🏃‍♂️");
	                }
	                if (muscle >= goalMuscle - tolerance && fat <= goalFat + tolerance && weight <= goalWeight + tolerance) {
	                    System.out.println("👍 현재 상태가 목표 범위 안에 있습니다!");
	                }
	            }

	            else {
	                System.out.println("❌ 잘못된 입력입니다.");
	            }
	        }

	        sc.close();
	    }
	}