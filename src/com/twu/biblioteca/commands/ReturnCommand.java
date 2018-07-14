package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Media;
import com.twu.biblioteca.Menu;


public class ReturnCommand extends Command {

	public ReturnCommand(String command, String description) {
		super(command, description);
	}

	@Override
	public String execute(Media[] mediaObjects) {
		System.out.print("Enter the title: ");
		String title = Menu.userInput();
		for (Media media : mediaObjects) {
			if (media.getTitle().equals(title) && media.getLoanStatus()) {
				media.setLoanStatus(false);
				return "Thank you for returning the book.";
			}
		}
		return "That is not a valid book to return.";
	}
}
