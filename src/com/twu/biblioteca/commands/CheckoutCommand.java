package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

import java.util.Scanner;

public class CheckoutCommand extends Command {

	public CheckoutCommand(String command, String description) {
		super(command, description);
	}

	@Override
	public String execute(Book[] books) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		for (Book book : books) {
			if (book.getTitle().equals(title) && !book.getLoanStatus()) {
				book.setLoanStatus(true);
				return "Thank you! Enjoy the book";
			}
		}
		return "That book is not available.";
	}
}
