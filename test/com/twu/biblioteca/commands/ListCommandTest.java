package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ListCommandTest {
	private ListCommand listCommand;
	private Book[] books;
	private String displayedBooks;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		listCommand = new ListCommand("L","List Books");
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
	public void testDisplayBooksFormat() {
		assertEquals(displayedBooks, listCommand.execute(books));
	}
}
