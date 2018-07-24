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
	public void testShouldReturnTitleOnGetTitle() {
		assertEquals("Life of Brian", movie.getTitle());
	}

	@Test
	public void testShouldReturnWriterOnGetWriter() {
		assertEquals("Terry Jones", movie.getWriter());
	}

	@Test
	public void testShouldReturnYearOnGetYearPublished() {
		assertEquals(1979, movie.getYearPublished());
	}

	@Test
	public void testShouldReturnEqualToTwoMovieObjects() {
		Movie sameMovie = new Movie("Life of Brian",1979,"Terry Jones", 9,false);
		assertEquals(sameMovie,movie);
	}

	@Test
	public void testShouldReturnNotEqualWithMovieHasDifferentYear() {
		Movie fakeMovie = new Movie("Life of Brian",1980,"Terry Jones", 9,false);
		assertNotEquals(fakeMovie, movie);
	}

	@Test
	public void testShouldReturnFalseForMovieNotOnLoanInitially() {
		assertFalse(movie.getLoanStatus());
	}

	@Test
	public void testShouldReturnTrueOnMovieStatusIsSetToTrue() {
		movie.setLoanStatus(true);
		assertTrue(movie.getLoanStatus());
	}

	@Test
	public void testShouldReturnFalseForMovieNotCheckedOutLoanStatus() {
		Movie noLoan = new Movie("Life of Brian",1979,"Terry Jones",9);
		assertFalse(noLoan.getLoanStatus());
	}

	@Test
	public void testShouldReturnEqualForTwoBookObjects() {
		Media sameBook = new Book("Life of Pi", "Yann Martel", 2001, false);
		assertEquals(sameBook, book);
	}

	@Test
	public void testShouldReturnFalseForBookWithDifferentYear() {
		Media fakeBook = new Book("Life of Pi","Yann Martel", 2018, false);
		assertNotEquals(fakeBook, book);
	}

	@Test
	public void testShouldReturnFalseForBookNotOnLoan() {
		assertFalse(book.getLoanStatus());
	}

	@Test
	public void testShouldReturnTrueWhenBookIsLoanedOut() {
		book.setLoanStatus(true);
		assertTrue(book.getLoanStatus());
	}

	@Test
	public void testShouldReturnFalseWhenBookIsNotCheckedOut() {
		Media noLoan = new Book("Life of Pi","Yann Martel",2001);
		assertFalse(noLoan.getLoanStatus());
	}

}
