package com.twu.biblioteca.commands;

import com.twu.biblioteca.Media;
import com.twu.biblioteca.Menu;

public class Command {
	protected String command;
	protected String description;
	private final String enterTitlePrompt = "Enter the title: ";
	public Command(String command, String description) {
		this.command = command;
		this.description = description;
	}

	public String execute(Media[] mediaObjects) {
		return null;
	}

	public String getCommand() {
		return this.command;
	}

	public String getDescription() {
		return this.description;
	}

	protected String getTitleFromUser() {
		System.out.print(enterTitlePrompt);
		return Menu.userInput();
	}
}
