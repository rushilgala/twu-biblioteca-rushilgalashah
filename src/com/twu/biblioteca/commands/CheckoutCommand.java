package com.twu.biblioteca.commands;

import com.twu.biblioteca.Media;
import com.twu.biblioteca.Menu;

public class CheckoutCommand extends Command {

	public CheckoutCommand(String command, String description) {
		super(command, description);
	}

	public String execute(Media[] mediaObjects) {
		String title = getTitleFromUser();
		String type = "";
		for (Media media : mediaObjects) {
			type = Menu.checkType(media.getClass().getSimpleName());
			if (media.getTitle().equals(title) && !media.getLoanStatus()) {
				media.setLoanStatus(true);
				return new StringBuilder()
						.append("Thank you! Enjoy the ")
						.append(type)
						.toString();
			}
		}
		return new StringBuilder()
				.append("That ")
				.append(type)
				.append(" is not available.")
				.toString();
	}
}
