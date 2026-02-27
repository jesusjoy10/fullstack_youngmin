package com.company.movie_Controller;

public class Movie {
    private String title;
    private String genre;
    private double rating;

    public Movie() {}

    public Movie(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "영화제목: " + title + ", 장르: " + genre + ", 평점: " + rating;
    }
}
