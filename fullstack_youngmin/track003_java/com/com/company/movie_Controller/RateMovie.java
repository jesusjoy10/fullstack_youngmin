package com.company.movie_Controller;

import java.util.List;
import java.util.Scanner;

public class RateMovie implements MovieController {
    @Override
    public int exec(List<Movie> movies, int find) {
        if(movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("평점 변경할 영화 번호 입력>");
        int num = sc.nextInt() - 1;
        if(num < 0 || num >= movies.size()) {
            System.out.println("잘못된 번호입니다.");
            return 0;
        }
        System.out.println("새 평점 입력>");
        double newRating = sc.nextDouble();
        movies.get(num).setRating(newRating);
        System.out.println("평점이 변경되었습니다.");
        return 0;
    }
}
