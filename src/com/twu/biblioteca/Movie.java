package com.twu.biblioteca;

public class Movie extends Media {

	private int movieRating;

	public Movie(String title, int yearPublished, String director, int movieRating, boolean isLoaned) {
		super(title,director,yearPublished,isLoaned);
		this.movieRating = validateMovieRating(movieRating);
	}

	public Movie(String title, int yearPublished, String director, int movieRating) {
		super(title,director,yearPublished);
		this.movieRating = validateMovieRating(movieRating);
	}

	public int validateMovieRating(int movieRating) {
		return (movieRating > 0 && movieRating <= 10) ? movieRating : -1;
	}

	public int getMovieRating() {
		return this.movieRating;
	}

	public String toString() {
		return String.format("%25s - %4d - %20s - %1d\n",
				this.getTitle(), this.getYearPublished(), this.getWriter(), this.getMovieRating());
	}
}
