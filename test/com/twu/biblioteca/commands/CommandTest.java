package com.twu.biblioteca.commands;

import com.twu.biblioteca.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandTest {
	private Command command;
	private Book[] books;

	@Before
	public void setUp() {
		command = new Command("Q","Quit");
		books = new Book[] {
				new Book("Life of Pi", "Yann Martel", 2001,false),
				new Book("Dune", "Frank Herbert", 1965,false),
				new Book("The Hobbit", "J. R. R. Tolkien", 1937,false),
				new Book("Tom Sawyer", "Mark Twain", 1876,false),
				new Book("To Kill a Mockingbird", "Harper Lee", 1960,false)
		};
	}



	@Test
	public void testShouldReturnNullOnExecute() {
		assertEquals(null,command.execute(books));
	}

	@Test
	public void testShouldReturnLetterOnGetCommand() {
		assertEquals("Q",command.getCommand());
	}

	@Test
	public void testShouldReturnDescriptionOnGetDescription() {
		assertEquals("Quit",command.getDescription());
	}
}
