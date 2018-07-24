package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserStateTest {

	private UserState userState;
	private User user;
	private User[] users;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		userState = new UserState();
		user = new User("Rushil Gala-Shah",
				"rushil@example.com",
				"020 8000 0000",
				"135-2341",
				"test!Password");
		users = new User[]{
				user
		};
		System.setOut(new PrintStream(outputStream));
	}

	@Test
	public void testShouldReturnCorrectUserObjectOnSuccessfulSignIn() {
		assertEquals(user, userState.signIn("135-2341", "test!Password", users));
	}

	@Test
	public void testShouldReturnUserOnGetLoggedInUser() {
		userState.setLoggedInUser(user);
		assertEquals(user, userState.getLoggedInUser());
	}

	@Test
	public void testUserIsNullOnUserStateCreation() {
		assertTrue(userState.getLoggedInUser() == null);
	}

	@Test
	public void testShouldReturnTrueWhenCorrectCredentialsEntered() {
		assertTrue(userState.checkCredentials("135-2341", "test!Password", user));
	}

	@Test
	public void testShouldReturnFalseWhenInvalidCredentialsEntered() {
		assertFalse(userState.checkCredentials("135-2341", "test!password", user));
	}

	@Test
	public void testShouldReturnFalseWhenUserNotLoggedIn() {
		assertFalse(userState.isLoggedIn());
	}

	@Test
	public void testShouldReturnTrueWhenUserLoggedIn() {
		ByteArrayInputStream in = new ByteArrayInputStream("135-2341\ntest!Password\n".getBytes());
		System.setIn(in);
		userState.processSignIn(users);
		assertTrue(userState.isLoggedIn());
	}

	@Test
	public void testShouldReturnInformationIfLoggedInOnViewInformation() {
		userState.setLoggedInUser(user);
		assertEquals("Name: Rushil Gala-Shah\nEmail: rushil@example.com\nPhone number: 020 8000 0000", userState.viewUserInformation());
	}

	@Test
	public void testShouldReturnErrorMessageIfNotLoggedInOnViewInformation() {
		assertEquals("Error: You must sign in first!", userState.viewUserInformation());
	}
}
