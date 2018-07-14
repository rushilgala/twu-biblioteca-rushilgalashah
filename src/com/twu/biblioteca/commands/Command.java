package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

public abstract class Command {
	public abstract String execute(Book[] books);
}
