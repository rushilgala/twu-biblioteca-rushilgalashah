package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

	Book book;

	@Before
	public void setUp() {
		book = new Book("Life of Pi","Yann Martel", 2001,false);
	}

	@Test
	public void testGetTitle() {
		assertEquals("Life of Pi", book.getTitle());
	}

	@Test
	public void testGetAuthor() {
		assertEquals("Yann Martel", book.getWriter());
	}

	@Test
	public void testGetYearPublished() {
		assertEquals(2001, book.getYearPublished());
	}

	@Test
	public void testStringOutput() {
		String displayedBook = "               Life of Pi -          Yann Martel - 2001\n";
		assertEquals(displayedBook, book.toString());
	}
}
