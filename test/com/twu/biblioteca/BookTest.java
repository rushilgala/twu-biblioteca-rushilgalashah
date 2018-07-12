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
		assertEquals("Yann Martel", book.getAuthor());
	}

	@Test
	public void testGetYearPublished() {
		assertEquals(2001, book.getYearPublished());
	}

	@Test
	public void testBookIsEqual() {
		Book sameBook = new Book("Life of Pi", "Yann Martel", 2001, false);
		assertEquals(sameBook, book);
	}

	@Test
	public void testFakeBookDifferentYearIsNotEqual() {
		Book fakeBook = new Book("Life of Pi","Yann Martel", 2018, false);
		assertNotEquals(fakeBook, book);
	}

	@Test
	public void testBookIsNotOnLoanInitially() {
		assertFalse(book.getLoanStatus());
	}

	@Test
	public void testBookStatusIsChanged() {
		book.setLoanStatus(true);
		assertTrue(book.getLoanStatus());
	}

	@Test
	public void testStringOutput() {
		String displayedBook = "               Life of Pi -          Yann Martel - 2001\n";
		assertEquals(displayedBook, book.toString());
	}
}
