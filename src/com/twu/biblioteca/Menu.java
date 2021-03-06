package com.twu.biblioteca;

import com.twu.biblioteca.commands.CheckoutCommand;
import com.twu.biblioteca.commands.Command;
import com.twu.biblioteca.commands.ListCommand;
import com.twu.biblioteca.commands.ReturnCommand;

import java.util.*;

public class Menu {
	private static final String welcomeMessage = "Welcome to Biblioteca!";
	private static final LinkedHashMap<String, Command> commands = new LinkedHashMap<String, Command>();
	private static final String[] bookCommands = new String[]{
			"L", "C", "R"
	};
	private static final String[] movieCommands = new String[]{
			"M", "O"
	};
	private static final String[] userCommands = new String[]{
		"S", "V"
	};
	private static final String[] requiresUserLogin = new String[] {
		"C", "R", "V"
	};

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
		commands.put("M",new ListCommand("M", "List Movies"));
		commands.put("O",new CheckoutCommand("O", "Checkout Movie"));
		commands.put("S",new Command("S","Sign in"));
		commands.put("V",new Command("V","View User Information (Must be signed in!)"));
		commands.put("Q",new Command("Q", "Quit"));
	}

	public static boolean checkIfValidOption(String input) {
		return commands.get(input) != null;
	}

	public static String enterCommand() {
		String input = userInput();
		return (input.length() > 0)
				? input.substring(0,1).toUpperCase()
				: "";
	}

	public static String userInput() {
		Scanner sc = new Scanner(System.in);
		return (sc.hasNextLine()) ? sc.nextLine() : "";
	}

	public static String executeCommand(String command, Media[] media) {
		Command executeCommand = commands.get(command);
		return executeCommand.execute(media);
	}

	public static String checkType(String type) {
		return (type.equals("Book")) ? "book" : "movie";
	}

	public static boolean requiresBooks(String input) {
		return Arrays.asList(bookCommands).contains(input);
	}

	public static boolean requiresMovies(String input) {
		return Arrays.asList(movieCommands).contains(input);
	}

	public static boolean requireUsers(String input) {
		return Arrays.asList(userCommands).contains(input);
	}

	public static boolean requiresLogin(String input) {
		return Arrays.asList(requiresUserLogin).contains(input);
	}
}
