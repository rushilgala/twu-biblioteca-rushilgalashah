package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MovieTest {

	Movie movie;

	@Before
	public void setUp() {
		movie = new Movie("Life of Brian",1979, "Terry Jones",9,false);
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
	public void testGetMovieRating() {
		assertEquals(9,movie.getMovieRating());
	}

	@Test
	public void testStringOutput() {
		String displayedMovie = "                 Life of Brian - 1979 -          Terry Jones - 9\n";
		assertEquals(displayedMovie, movie.toString());
	}
}
