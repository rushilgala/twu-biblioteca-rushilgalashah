package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

	private User user;

	@Before
	public void setUp() {
		user = new User("Rushil Gala-Shah",
				"rushil@example.com",
				"020 8000 0000",
				"135-2341",
				"test!Password");
	}

	@Test
	public void testShouldReturnNameOnGetName() {
		assertEquals("Rushil Gala-Shah", user.getName());
	}

	@Test
	public void testShouldReturnEmailOnGetEmail() {
		assertEquals("rushil@example.com",user.getEmail());
	}

	@Test
	public void testShouldReturnPhoneNumberOnGetPhoneNumber() {
		assertEquals("020 8000 0000", user.getPhoneNumber());
	}

	@Test
	public void testShouldReturnLibraryNumberOnGetLibraryNumber() {
		assertEquals("135-2341",user.getLibraryNumber());
	}

	@Test
	public void testShouldReturnPasswordOnGetPassword() {
		assertEquals("test!Password",user.getPassword());
	}
}
