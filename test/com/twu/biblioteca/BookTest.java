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
	public void testShouldReturnTitleOnGetTitle() {
		assertEquals("Life of Pi", book.getTitle());
	}

	@Test
	public void testShouldReturnWriterOnGetWriter() {
		assertEquals("Yann Martel", book.getWriter());
	}

	@Test
	public void testShouldReturnYearOnGetYearPublished() {
		assertEquals(2001, book.getYearPublished());
	}

	@Test
	public void testShouldReturnStringOutputOnToString() {
		String displayedBook = "               Life of Pi -          Yann Martel - 2001\n";
		assertEquals(displayedBook, book.toString());
	}
}
