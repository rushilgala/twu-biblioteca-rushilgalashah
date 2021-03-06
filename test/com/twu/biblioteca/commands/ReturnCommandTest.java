package com.twu.biblioteca.commands;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReturnCommandTest {

	private ReturnCommand returnCommand;
	private ListCommand listCommand;
	private Book[] books;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	private final String errorMessage = "That is not a valid book to return.";
	@Before
	public void setUp() {
		returnCommand = new ReturnCommand("R","Return Book");
		listCommand = new ListCommand("L","List Books");
		System.setOut(new PrintStream(outputStream));
		books = new Book[]{
				new Book("Life of Pi", "Yann Martel", 2001, false),
				new Book("Dune", "Frank Herbert", 1965, true),
				new Book("The Hobbit", "J. R. R. Tolkien", 1937, false),
				new Book("Tom Sawyer", "Mark Twain", 1876, false),
				new Book("To Kill a Mockingbird", "Harper Lee", 1960, false)
		};
	}

	@After
	public void restore() {
		System.setOut(System.out);
	}

	@Test
	public void testShouldReturnFalseForReturnedBookOnExecute() {
		assertTrue(books[1].getLoanStatus());
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		returnCommand.execute(books);
		assertFalse(books[1].getLoanStatus());
	}

	@Test
	public void testShouldReturnTrueForReturnedBookOnListCommandExecute() {
		listCommand.execute(books);
		assertFalse(outputStream.toString().contains("Dune"));
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		returnCommand.execute(books);
		assertTrue(listCommand.execute(books).contains("Dune"));
	}

	@Test
	public void testShouldReturnSuccessMessageOnReturnExecute() {
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		assertEquals("Thank you for returning the book.",returnCommand.execute(books));
	}

	@Test
	public void testShouldReturnErrorMessageOnReturnExecute() {
		ByteArrayInputStream in = new ByteArrayInputStream("Dupe\n".getBytes());
		System.setIn(in);
		assertEquals(errorMessage,returnCommand.execute(books));
	}

	@Test
	public void testShouldReturnErrorMessageForBookNotLoanedOutOnReturnCommandExecute() {
		ByteArrayInputStream in = new ByteArrayInputStream("Life of Pi\n".getBytes());
		System.setIn(in);
		assertEquals(errorMessage,returnCommand.execute(books));
	}
}
