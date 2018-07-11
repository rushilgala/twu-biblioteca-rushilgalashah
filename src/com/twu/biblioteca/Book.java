package com.twu.biblioteca;

public class Book {

	private String title;
	private String author;
	private int yearPublished;

	public Book(String title, String author, int yearPublished) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
	}


	@Override
	public boolean equals(Object obj) {
		Book book = (Book) obj;
		if (book.getTitle().equals(this.getTitle()) &&
				book.getAuthor().equals(this.getAuthor()) &&
				book.getYearPublished() == this.getYearPublished()) {
			return true;
		}
		return false;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public int getYearPublished() {
		return this.yearPublished;
	}

	public String toString() {
		return String.format("%25s - %20s - %4d\n",
				this.getTitle(), this.getAuthor(), this.getYearPublished());
	}
}
