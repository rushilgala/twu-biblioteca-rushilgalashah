package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

	Movie movie;

	@Before
	public void setUp() {
		movie = new Movie("Life of Brian",1979, "Terry Jones",9,false);
	}

	@Test
	public void testShouldReturnTitleOnGetTitle() {
		assertEquals("Life of Brian", movie.getTitle());
	}

	@Test
	public void testShouldReturnTitleOnGetWriter() {
		assertEquals("Terry Jones", movie.getWriter());
	}

	@Test
	public void testShouldReturnYearOnGetYearPublished() {
		assertEquals(1979, movie.getYearPublished());
	}

	@Test
	public void testShouldReturnMovieRatingOnGetMovieRating() {
		assertEquals(9,movie.getMovieRating());
	}

	@Test
	public void testShouldReturnFormattedOutputOnToString() {
		String displayedMovie = "                 Life of Brian - 1979 -          Terry Jones - 9\n";
		assertEquals(displayedMovie, movie.toString());
	}

	@Test
	public void testShouldReturnNoRatingForNewMovieWithNoRating() {
		Movie noRatingMovie = new Movie("Life of Brian",1979,"Terry Jones",-1,false);
		assertEquals(-1, noRatingMovie.getMovieRating());
	}

}
