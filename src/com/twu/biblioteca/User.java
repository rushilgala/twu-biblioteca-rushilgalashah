package com.twu.biblioteca;

public class User {
	private String name;
	private String email;
	private String phoneNumber;
	private int libraryNumber;
	private String password;

	public User(String name, String email, String phoneNumber, int libraryNumber, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.libraryNumber = libraryNumber;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public String getLibraryNumber() {
		String libNumber = new StringBuilder().append(this.libraryNumber).toString();
		return new StringBuilder()
				.append(libNumber.substring(0,3))
				.append("-")
				.append(libNumber.substring(3))
				.toString();
	}

	public String getPassword() {
		return this.password;
	}
}
