package com.company.movie_Controller;

import java.util.List;

public class ShowMovies implements MovieController {
    @Override
    public int exec(List<Movie> movies, int find) {
        if(movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return 0;
        }
        System.out.println("===== 영화 목록 =====");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i));
        }
        return 0;
    }
}
