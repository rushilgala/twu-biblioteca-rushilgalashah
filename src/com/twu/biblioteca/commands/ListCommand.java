package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

public class ListCommand extends Command {

	@Override
	public String execute(Book[] books) {
		StringBuilder sb = new StringBuilder();
		for (Book book : books) {
			if (!book.getLoanStatus()) {
				sb.append(book.toString());
			}
		}
		return sb.toString();
	}
}
