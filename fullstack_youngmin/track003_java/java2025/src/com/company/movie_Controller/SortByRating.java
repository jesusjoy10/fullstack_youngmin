package com.company.movie_Controller;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SortByRating implements MovieController {

    @Override
    public int exec(List<Movie> movies, int find) {
        if (movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        }

        Collections.sort(movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m2.getRating(), m1.getRating());
            }
        });

        System.out.println("===== 평점 높은 순 영화 목록 =====");
        for (Movie m : movies) {
            System.out.println(m);
        }

        return 0;
    }
}
