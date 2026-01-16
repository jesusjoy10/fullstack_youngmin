package com.company.java006;

import java.util.Scanner;

public class Exercise_Log_Array {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        final int MAX = 10; // 최대 사용자 수
	        int[] age = new int[MAX];
	        double[] height = new double[MAX];
	        double[] weight = new double[MAX];
	        double[] muscle = new double[MAX];
	        double[] fat = new double[MAX];

	        double[] goalWeight = new double[MAX];
	        double[] goalMuscle = new double[MAX];
	        double[] goalFat = new double[MAX];

	        double tolerance = 3.0; // 목표 허용 범위
	        int recordCount = 0;

	        System.out.println("🏋️‍♂️ 바디프로필 챌린지 시작 🏁");

	        // 사용자 등록
	        while (recordCount < MAX) {
	            System.out.print("나이: ");
	            int a = sc.nextInt();
	            if (a < 20) {
	                System.out.println("❌ 성인만 가능합니다!");
	                continue;
	            }
	            age[recordCount] = a;

	            System.out.print("키(cm): ");
	            height[recordCount] = sc.nextDouble();
	            System.out.print("몸무게(kg): ");
	            weight[recordCount] = sc.nextDouble();
	            System.out.print("근육량(kg): ");
	            muscle[recordCount] = sc.nextDouble();
	            System.out.print("체지방율(%): ");
	            fat[recordCount] = sc.nextDouble();

	            goalWeight[recordCount] = weight[recordCount] - 5;
	            goalMuscle[recordCount] = muscle[recordCount] + 5;
	            goalFat[recordCount] = fat[recordCount] - 5;
	            if (goalFat[recordCount] < 0) goalFat[recordCount] = 0;

	            System.out.println("사용자 등록 완료!");
	            recordCount++;

	            System.out.print("사용자를 더 등록하시겠습니까? (1.예 0.아니오): ");
	            int more = sc.nextInt();
	            if (more == 0) break;
	        }

	        int sel = -1;
	        while (true) {
	            System.out.println("\n== 💪 운동하자 💪 ==");
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

	            else if (sel == 1) { // 현재 상태 조회
	                for (int i = 0; i < recordCount; i++) {
	                    System.out.println("[" + age[i] + "세 사용자]");
	                    System.out.printf("키: %.1f cm, 몸무게: %.1f kg, 근육량: %.1f kg, 체지방: %.1f %%\n",
	                            height[i], weight[i], muscle[i], fat[i]);
	                }
	            }

	            else if (sel == 2) { // 운동 기록
	                if (recordCount == 0) {
	                    System.out.println("등록된 사용자가 없습니다.");
	                    continue;
	                }

	                System.out.print("운동 기록할 사용자 나이: ");
	                int userAge = sc.nextInt();
	                int idx = -1;
	                for (int i = 0; i < recordCount; i++) {
	                    if (age[i] == userAge) idx = i;
	                }
	                if (idx == -1) {
	                    System.out.println("❌ 등록되지 않은 나이입니다.");
	                    continue;
	                }

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
	                    muscle[idx] += gain;
	                    System.out.printf("근육량 +%.1f kg\n", gain);
	                }
	                else if (workout == 2) {
	                    System.out.print("턱걸이 횟수: ");
	                    int reps = sc.nextInt();
	                    double gain = reps / 30.0;
	                    muscle[idx] += gain;
	                    System.out.printf("근육량 +%.1f kg\n", gain);
	                }
	                else if (workout == 3) {
	                    System.out.print("스쿼트 횟수: ");
	                    int reps = sc.nextInt();
	                    double gain = reps / 50.0;
	                    muscle[idx] += gain;
	                    fat[idx] -= 0.3 * gain;
	                    if (fat[idx] < 0) fat[idx] = 0;
	                    System.out.printf("근육량 +%.1f kg, 체지방 -%.1f %%\n", gain, 0.3 * gain);
	                }
	                else if (workout == 4) {
	                    System.out.print("런닝머신 시간(분): ");
	                    int min = sc.nextInt();
	                    double fatLoss = (min / 10.0) * 0.5;
	                    double muscleLoss = (min / 10.0) * 0.2;
	                    double weightLoss = (min / 20.0) * 2.0;

	                    fat[idx] -= fatLoss;
	                    if (fat[idx] < 0) fat[idx] = 0;
	                    muscle[idx] -= muscleLoss;
	                    if (muscle[idx] < 0) muscle[idx] = 0;
	                    weight[idx] -= weightLoss;
	                    if (weight[idx] < 0) weight[idx] = 0;

	                    System.out.printf("체지방 -%.1f %%, 근육량 -%.1f kg, 몸무게 -%.1f kg\n", fatLoss, muscleLoss, weightLoss);
	                } 
	                else {
	                    System.out.println("❌ 잘못된 선택입니다.");
	                }
	            }

	            else if (sel == 3) { // 목표 현황 보기
	                for (int i = 0; i < recordCount; i++) {
	                    System.out.println("[" + age[i] + "세 사용자]");
	                    System.out.printf("근육량: %.1f kg / 목표: %.1f kg, 체지방: %.1f %% / 목표: %.1f %%, 몸무게: %.1f kg / 목표: %.1f kg\n",
	                            muscle[i], goalMuscle[i], fat[i], goalFat[i], weight[i], goalWeight[i]);

	                    if (Math.abs(muscle[i] - goalMuscle[i]) <= tolerance &&
	                        Math.abs(fat[i] - goalFat[i]) <= tolerance &&
	                        Math.abs(weight[i] - goalWeight[i]) <= tolerance) {
	                        System.out.println("🎉 목표 달성!");
	                    } else {
	                        System.out.println("🔥 목표 미달성");
	                    }
	                }
	            }

	            else if (sel == 4) { // 추천 운동
	                for (int i = 0; i < recordCount; i++) {
	                    System.out.println("[" + age[i] + "세 사용자 추천]");
	                    if (muscle[i] < goalMuscle[i] - tolerance)
	                        System.out.println("- 근육량 부족! 스쿼트나 벤치프레스 추천 💪");
	                    if (fat[i] > goalFat[i] + tolerance)
	                        System.out.println("- 체지방 많음! 런닝머신 추천 🏃‍♂️");
	                    if (weight[i] > goalWeight[i] + tolerance)
	                        System.out.println("- 체중 감량 필요! 런닝머신 추천 🏃‍♂️");
	                    if (Math.abs(muscle[i] - goalMuscle[i]) <= tolerance &&
	                        Math.abs(fat[i] - goalFat[i]) <= tolerance &&
	                        Math.abs(weight[i] - goalWeight[i]) <= tolerance) {
	                        System.out.println("👍 현재 상태가 목표 범위 안에 있습니다!");
	                    }
	                }
	            }

	            else {
	                System.out.println("❌ 잘못된 입력입니다.");
	            }
	        }

	        sc.close();
	    }
	}