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
	public void testGetName() {
		assertEquals("Rushil Gala-Shah", user.getName());
	}

	@Test
	public void testGetEmail() {
		assertEquals("rushil@example.com",user.getEmail());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("020 8000 0000", user.getPhoneNumber());
	}

	@Test
	public void testGetLibraryNumber() {
		assertEquals("135-2341",user.getLibraryNumber());
	}

	@Test
	public void testGetPassword() {
		assertEquals("test!Password",user.getPassword());
	}
}
