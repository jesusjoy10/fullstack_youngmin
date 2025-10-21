package com.company.movie_Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie_Main {
    private List<Movie> movies;
    private MovieController[] controller;

    public Movie_Main() {
        movies = new ArrayList<>();
        controller = new MovieController[] {
            new AddMovie(),      // 0
            new ShowMovies(),    // 1
            new RateMovie(),     // 2
            new DeleteMovie(),   // 3
            new SearchByGenre(), // 4
            new SortByRating()   // 5
        };
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        while(num != 9) {
            System.out.println("\n🎬 영화 관리 시스템 🎬");
            System.out.println("[1] ➕ 영화 추가");
            System.out.println("[2] 🔍 영화 목록 조회");
            System.out.println("[3] ⭐ 영화 평점 변경");
            System.out.println("[4] 🗑️ 영화 삭제");
            System.out.println("[5] 🔍 장르별 검색");
            System.out.println("[6] 📊 평점 높은 순 정렬");
            System.out.println("[9] ❌ 종료");
            System.out.print("번호 선택> ");
            num = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 비우기

            switch(num) {
                case 1: controller[0].exec(movies, 0); break;
                case 2: controller[1].exec(movies, 0); break;
                case 3: controller[2].exec(movies, 0); break;
                case 4: controller[3].exec(movies, 0); break;
                case 5: controller[4].exec(movies, 0); break;
                case 6: controller[5].exec(movies, 0); break;
                case 9: System.out.println("시스템 종료"); break;
                default: System.out.println("잘못된 번호입니다."); break;
            }
        }
    }

    public static void main(String[] args) {
        new Movie_Main().menu();
    }
}
