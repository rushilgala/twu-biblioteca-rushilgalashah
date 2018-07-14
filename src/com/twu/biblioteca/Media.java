package com.twu.biblioteca;

public class Media {

	protected String title;
	protected String writer;
	protected int yearPublished;
	protected boolean isLoaned;

	public Media(String title, String writer, int yearPublished, boolean isLoaned) {
		this.title = title;
		this.writer = writer;
		this.yearPublished = yearPublished;
		this.isLoaned = isLoaned;
	}

	public Media(String title, String writer, int yearPublished) {
		this.title = title;
		this.writer = writer;
		this.yearPublished = yearPublished;
		this.isLoaned = false;
	}

	public String getTitle() {
		return this.title;
	}

	public String getWriter() {
		return this.writer;
	}

	public int getYearPublished() {
		return this.yearPublished;
	}

	public boolean getLoanStatus() {
		return this.isLoaned;
	}

	public void setLoanStatus(boolean loanStatus) {
		this.isLoaned = loanStatus;
	}

	public boolean equals(Object obj) {
		Media media = (Media) obj;
		if (media.getTitle().equals(this.getTitle()) &&
				media.getWriter().equals(this.getWriter()) &&
				media.getYearPublished() == this.getYearPublished()) {
			return true;
		}
		return false;
	}
}
