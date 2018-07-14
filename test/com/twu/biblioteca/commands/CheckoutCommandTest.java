package com.twu.biblioteca.commands;

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

public class CheckoutCommandTest {

	private CheckoutCommand checkoutCommand;
	private ListCommand listCommand;
	private Book[] books;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		checkoutCommand = new CheckoutCommand();
		listCommand = new ListCommand();
		System.setOut(new PrintStream(outputStream));
		books = new Book[]{
				new Book("Life of Pi", "Yann Martel", 2001, false),
				new Book("Dune", "Frank Herbert", 1965, false),
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
	public void testBookDoesNotAppearAfterCheckedOut() {
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		checkoutCommand.execute(books);
		listCommand.execute(books);
		assertFalse(outputStream.toString().contains("Dune"));
	}

	@Test
	public void testBookIsMisspelledReturnsNotAvailable() {
		ByteArrayInputStream in = new ByteArrayInputStream("Dupe\n".getBytes());
		System.setIn(in);
		assertEquals("That book is not available.",checkoutCommand.execute(books));
	}


	@Test
	public void testCheckoutMessageOnSuccessfulCheckout() {
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		assertEquals("Thank you! Enjoy the book",checkoutCommand.execute(books));
	}
}
