package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;

public class Command {
	protected String command;
	protected String description;

	public Command(String command, String description) {
		this.command = command;
		this.description = description;
	}

	public String execute(Book[] books) {
		return null;
	}

	public String getCommand() {
		return this.command;
	}

	public String getDescription() {
		return this.description;
	}
}
