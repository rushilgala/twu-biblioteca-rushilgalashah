package com.twu.biblioteca.commands;

import com.twu.biblioteca.Media;

public class ListCommand extends Command {

	public ListCommand(String command, String description) {
		super(command, description);
	}

	@Override
	public String execute(Media[] mediaObjects) {
		StringBuilder sb = new StringBuilder();
		for (Media media : mediaObjects) {
			if (!media.getLoanStatus()) {
				sb.append(media.toString());
			}
		}
		return sb.toString();
	}
}
