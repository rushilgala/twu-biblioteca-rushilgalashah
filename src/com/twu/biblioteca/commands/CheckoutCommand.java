package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

import java.util.Scanner;

public class CheckoutCommand extends Command {

	@Override
	public String execute(Book[] books) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				book.setLoanStatus(true);
				return "Thank you! Enjoy the book";
			}
		}
		return "That book is not available.";
	}
}
