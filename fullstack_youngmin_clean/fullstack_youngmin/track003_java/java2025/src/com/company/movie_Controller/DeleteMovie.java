package com.company.movie_Controller;

import java.util.List;
import java.util.Scanner;

public class DeleteMovie implements MovieController {
    @Override
    public int exec(List<Movie> movies, int find) {
        if(movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 영화 번호 입력>");
        int num = sc.nextInt() - 1;
        if(num < 0 || num >= movies.size()) {
            System.out.println("잘못된 번호입니다.");
            return 0;
        }
        movies.remove(num);
        System.out.println("영화가 삭제되었습니다.");
        return 0;
    }
}
