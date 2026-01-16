package com.company.movie_Controller;

import java.util.List;
import java.util.Scanner;

public class SearchByGenre implements MovieController {

    @Override
    public int exec(List<Movie> movies, int find) {
        if (movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 장르 입력>");
        String genre = sc.nextLine();

        boolean found = false;
        System.out.println("===== '" + genre + "' 장르 영화 목록 =====");
        for (Movie m : movies) {
            if (m.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("해당 장르의 영화가 없습니다.");
        }
        return 0;
    }
}
