package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

import java.util.Scanner;

public class ReturnCommand extends Command {

	@Override
	public String execute(Book[] books) {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				book.setLoanStatus(false);
				return "Thank you for returning the book.";
			}
		}
		return "That is not a valid book to return.";
	}
}
