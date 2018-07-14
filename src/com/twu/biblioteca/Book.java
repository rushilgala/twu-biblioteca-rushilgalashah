package com.twu.biblioteca;

public class Book extends Media {

	public Book(String title, String author, int yearPublished) {
		super(title,author,yearPublished);
	}

	public Book(String title, String author, int yearPublished, boolean isLoaned) {
		super(title,author,yearPublished,isLoaned);
	}

	public String toString() {
		return String.format("%25s - %20s - %4d\n",
				this.getTitle(), this.getWriter(), this.getYearPublished());
	}

}
