package com.twu.biblioteca.commands;

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
		String type = "";
		for (Media media : mediaObjects) {
			type = Menu.checkType(media.getClass().getSimpleName());
			if (media.getTitle().equals(title) && media.getLoanStatus()) {
				media.setLoanStatus(false);
				return new StringBuilder()
						.append("Thank you for returning the ")
						.append(type)
						.append(".").toString();
			}
		}
		return new StringBuilder()
				.append("That is not a valid ")
				.append(type)
				.append(" to return.")
				.toString();
	}
}
