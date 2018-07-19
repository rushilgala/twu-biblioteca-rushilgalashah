package com.twu.biblioteca;

public class User {
	private String name;
	private String email;
	private String phoneNumber;
	private String libraryNumber;
	private String password;

	public User(String name, String email, String phoneNumber, String libraryNumber, String password) {
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
		return this.libraryNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public String toString() {
		return String.format("Name: %s\nEmail: %s\nPhone number: %s",
				getName(),
				getEmail(),
				getPhoneNumber());
	}

}
