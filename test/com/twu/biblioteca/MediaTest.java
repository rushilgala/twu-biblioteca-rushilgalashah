package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MediaTest {

	Media book;
	Media movie;

	@Before
	public void setUp() {
		movie = new Movie("Life of Brian",1979, "Terry Jones",9,false);
		book = new Book("Life of Pi","Yann Martel", 2001,false);
	}

	@Test
	public void testGetTitle() {
		assertEquals("Life of Brian", movie.getTitle());
	}

	@Test
	public void testGetAuthor() {
		assertEquals("Terry Jones", movie.getWriter());
	}

	@Test
	public void testGetYearPublished() {
		assertEquals(1979, movie.getYearPublished());
	}

	@Test
	public void testMovieIsEqual() {
		Movie sameMovie = new Movie("Life of Brian",1979,"Terry Jones", 9,false);
		assertEquals(sameMovie,movie);
	}

	@Test
	public void testFakeMovieDifferentYearIsNotEqual() {
		Movie fakeMovie = new Movie("Life of Brian",1980,"Terry Jones", 9,false);
		assertNotEquals(fakeMovie, movie);
	}

	@Test
	public void testMovieIsNotOnLoanInitially() {
		assertFalse(movie.getLoanStatus());
	}

	@Test
	public void testMovieStatusIsChanged() {
		movie.setLoanStatus(true);
		assertTrue(movie.getLoanStatus());
	}

	@Test
	public void testMovieWithNoLoanStatusIsNotCheckedOut() {
		Movie noLoan = new Movie("Life of Brian",1979,"Terry Jones",9);
		assertFalse(noLoan.getLoanStatus());
	}

	@Test
	public void testMovieStringOutput() {
		String displayedMovie = "            Life of Brian - 1979 -          Terry Jones - 9\n";
		assertEquals(displayedMovie, movie.toString());
	}

	@Test
	public void testBookIsEqual() {
		Media sameBook = new Book("Life of Pi", "Yann Martel", 2001, false);
		assertEquals(sameBook, book);
	}

	@Test
	public void testFakeBookDifferentYearIsNotEqual() {
		Media fakeBook = new Book("Life of Pi","Yann Martel", 2018, false);
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
	public void testBookWithNoLoanStatusIsNotCheckedOut() {
		Media noLoan = new Book("Life of Pi","Yann Martel",2001);
		assertFalse(noLoan.getLoanStatus());
	}

	@Test
	public void testBookStringOutput() {
		String displayedBook = "               Life of Pi -          Yann Martel - 2001\n";
		assertEquals(displayedBook, book.toString());
	}
}
