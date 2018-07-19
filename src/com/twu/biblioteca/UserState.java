package com.twu.biblioteca;

import java.util.Scanner;

public class UserState {

	private static User user;

	public UserState() {
		user = null;
	}

	public static String executeCommand(String input, User[] users) {
		if (input.equals("S")) {
			processSignIn(users);
			return generateMessage();
		} else {
			return viewUserInformation();
		}
	}

	public static void processSignIn(User[] users) {
		Scanner sc = new Scanner(System.in);
		String libraryNumber = getInput(sc,"Enter library number: ");
		String password = getInput(sc,"Enter password: ");
		setLoggedInUser(signIn(libraryNumber,password,users));
	}

	private static String generateMessage() {
		if (getLoggedInUser() != null) {
			return new StringBuilder().append("Welcome ")
					.append(getLoggedInUser().getName())
					.append(", you are now signed in.")
					.toString();
		} else {
			return "Invalid card number or password.";
		}
	}

	private static String getInput(Scanner sc,String prompt) {
		System.out.print(prompt);
		return sc.nextLine();
	}

	public static User signIn(String libraryNumber, String password, User[] users) {
		for (User user : users) {
			if (checkCredentials(libraryNumber, password, user)) {
				return user;
			}
		}
		return null;
	}

	public static User getLoggedInUser() {
		return user;
	}

	public static boolean isLoggedIn() {
		return user != null;
	}

	public static void setLoggedInUser(User newUser) {
		user = newUser;
	}

	public static boolean checkCredentials(String libraryNumber, String password, User user) {
		return user.getLibraryNumber().equals(libraryNumber) &&
				user.getPassword().equals(password);
	}

	public static String viewUserInformation() {
		if (isLoggedIn()) {
			return getLoggedInUser().toString();
		} else {
			return notLoggedInMessage();
		}
	}

	public static String notLoggedInMessage() {
		return "Error: You must sign in first!";
	}
}
