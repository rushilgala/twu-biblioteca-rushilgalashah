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
	public void testShouldReturnWelcomeMessageOnWelcomeMessage() {
		assertEquals("Welcome to Biblioteca!", menu.welcomeMessage());
	}

	@Test
	public void testShouldReturnMenuOnGetMenu() {
		assertEquals("L - List Books\nC - Checkout Book\nR - Return Book\nM - List Movies\nO - Checkout Movie\nS - Sign in\nV - View User Information (Must be signed in!)\nQ - Quit\n", menu.getMenu());
	}

	@Test
	public void testShouldReturnFalseOnCheckInvalidOption() {
		assertFalse(menu.checkIfValidOption("B"));
	}

	@Test
	public void testShouldReturnTrueOnCheckValidOption() {
		assertTrue(menu.checkIfValidOption("Q"));
	}

	@Test
	public void testShouldReturnTrueOnCheckValidListBookOption() {
		assertTrue(menu.checkIfValidOption("L"));
	}

	@Test
	public void testShouldReturnOnlyFirstLetterOnEnterCommand() {
		ByteArrayInputStream in = new ByteArrayInputStream("List Books\n".getBytes());
		System.setIn(in);
		String output = menu.enterCommand();
		assertEquals("L",output);
	}

	@Test
	public void testShouldConvertLowerCaseToUpperCaseOnEnterCommand() {
		ByteArrayInputStream in = new ByteArrayInputStream("l\n".getBytes());
		System.setIn(in);
		String output = menu.enterCommand();
		assertEquals("L",output);
	}

	@Test
	public void testShouldReturnInputOnUserInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		String output = menu.userInput();
		assertEquals("Q",output);
	}

	@Test
	public void testShouldReturnTrueOnRequiresMoviesFromInput() {
		assertTrue(menu.requiresMovies("M"));
	}

	@Test
	public void testShouldDisplayBooksOnExecuteListBooks() {
		assertEquals(displayedBooks,menu.executeCommand("L", books));
	}

	@Test
	public void testShouldReturnTrueOnCheckThatSignInCommandIsValid() {
		assertTrue(menu.checkIfValidOption("S"));
	}
}
