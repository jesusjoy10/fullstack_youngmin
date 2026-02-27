package com.company.movie_Controller;

import java.util.List;
import java.util.Scanner;

public class AddMovie implements MovieController {
    @Override
    public int exec(List<Movie> movies, int find) {
        Scanner sc = new Scanner(System.in);
        System.out.println("영화 제목 입력>"); 
        String title = sc.nextLine();
        System.out.println("장르 입력>"); 
        String genre = sc.nextLine();
        System.out.println("평점 입력>"); 
        double rating = sc.nextDouble();
        movies.add(new Movie(title, genre, rating));
        System.out.println("영화가 추가되었습니다.");
        return 0;
    }
}
