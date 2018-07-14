package com.twu.biblioteca;

import com.twu.biblioteca.commands.CheckoutCommand;
import com.twu.biblioteca.commands.Command;
import com.twu.biblioteca.commands.ListCommand;
import com.twu.biblioteca.commands.ReturnCommand;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
	private static final String welcomeMessage = "Welcome to Biblioteca!";
	private static final LinkedHashMap<String, Command> commands = new LinkedHashMap<String, Command>();


	public static String welcomeMessage() {
		return welcomeMessage;
	}

	public static String getMenu() {
		Iterator it = commands.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			Command tempCommand = (Command)((Map.Entry)it.next()).getValue();
			sb.append(tempCommand.getCommand()).append(" - ").append(tempCommand.getDescription()).append("\n");
		}
		return sb.toString();
	}

	public static void initialise() {
		generateCommands();
		System.out.println(welcomeMessage() + "\n");
		System.out.println("Menu");
		System.out.println(getMenu());
	}

	public static void generateCommands() {
		commands.put("L",new ListCommand("L", "List Books"));
		commands.put("C",new CheckoutCommand("C", "Checkout Book"));
		commands.put("R",new ReturnCommand("R", "Return Book"));
		commands.put("M",new ReturnCommand("M", "List Movies"));
		commands.put("O",new ReturnCommand("O", "Checkout Movie"));
		commands.put("Q",new Command("Q", "Quit"));
	}

	public static boolean checkIfValidOption(String input) {
		return commands.get(input) != null;
	}

	public static String enterCommand() {
		return userInput().substring(0,1).toUpperCase();
	}

	public static String userInput() {
		return new Scanner(System.in).nextLine();
	}

	public static String executeCommand(String command, Media[] media) {
		Command executeCommand = commands.get(command);
		return executeCommand.execute(media);
	}
}
