package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuTest {

	private Menu menu;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private Book[] books;
	private String displayedBooks;

	@Before
	public void setUp() {
		menu = new Menu();
		System.setOut(new PrintStream(outputStream));
		books = new Book[] {
				new Book("Life of Pi", "Yann Martel", 2001,false),
				new Book("Dune", "Frank Herbert", 1965,false),
				new Book("The Hobbit", "J. R. R. Tolkien", 1937,false),
				new Book("Tom Sawyer", "Mark Twain", 1876,false),
				new Book("To Kill a Mockingbird", "Harper Lee", 1960,false)
		};
		displayedBooks = "               Life of Pi -          Yann Martel - 2001\n" +
				"                     Dune -        Frank Herbert - 1965\n" +
				"               The Hobbit -     J. R. R. Tolkien - 1937\n" +
				"               Tom Sawyer -           Mark Twain - 1876\n" +
				"    To Kill a Mockingbird -           Harper Lee - 1960\n";
	}

	@After
	public void restore() {
		System.setOut(System.out);
	}

	@Test
	public void testWelcomeMessage() {
		assertEquals("Welcome to Biblioteca!", menu.welcomeMessage());
	}

	@Test
	public void testGetMenu() {
		assertEquals("L - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n", menu.getMenu());
	}

	@Test
	public void testInvalidOption() {
		assertFalse(menu.checkIfValidOption("B"));
	}

	@Test
	public void testValidOption() {
		assertTrue(menu.checkIfValidOption("Q"));
	}

	@Test
	public void testValidListBookOption() {
		assertTrue(menu.checkIfValidOption("L"));
	}

	@Test
	public void testThatOnlyFirstLetterIsTaken() {
		ByteArrayInputStream in = new ByteArrayInputStream("List Books\n".getBytes());
		System.setIn(in);
		String output = menu.enterCommand();
		assertEquals("L",output);
	}

	@Test
	public void testThatLowerCaseGetsConvertedToUpperCase() {
		ByteArrayInputStream in = new ByteArrayInputStream("l\n".getBytes());
		System.setIn(in);
		String output = menu.enterCommand();
		assertEquals("L",output);
	}

	@Test
	public void testTakingUserInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		String output = menu.userInput();
		assertEquals("Q",output);
	}

	@Test
	public void testExecutingListBooks() {
		assertEquals(displayedBooks,menu.executeCommand("L", books));
	}

}
