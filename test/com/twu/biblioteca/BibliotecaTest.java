package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BibliotecaTest {

	private BibliotecaApp bibliotecaApp;
	private Media[] books;
	private Media[] movies;
	private User[] users;
	private UserState userState;
	private String displayedBooks;
	private String displayedMovies;
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@Before
	public void setUp() {
		bibliotecaApp = new BibliotecaApp();
		userState = new UserState();
		Menu.generateCommands();
		System.setOut(new PrintStream(outputStream));
		books = new Media[]{
				new Book("Life of Pi", "Yann Martel", 2001, false),
				new Book("Dune", "Frank Herbert", 1965, false),
				new Book("The Hobbit", "J. R. R. Tolkien", 1937, false),
				new Book("Tom Sawyer", "Mark Twain", 1876, false),
				new Book("To Kill a Mockingbird", "Harper Lee", 1960, false)
		};
		movies = new Media[]{
				new Movie("Life of Brian", 1979, "Terry Jones", 9, false),
				new Movie("Rush", 2013, "Ron Howard", 8, false),
				new Movie("The Thin Red Line", 1998, "Terrence Malick", 7, false),
				new Movie("Crouching Tiger, Hidden Dragon", 2001, "Ang Lee", 10, false),
				new Movie("Office Space", 1999, "Mike Judge", 7, false)
		};
		users = new User[]{
				new User("Rushil Gala-Shah",
						"rushil@example.com",
						"020 8000 0000",
						"135-2341",
						"test!Password")
		};
		displayedBooks = "               Life of Pi -          Yann Martel - 2001\n" +
				"                     Dune -        Frank Herbert - 1965\n" +
				"               The Hobbit -     J. R. R. Tolkien - 1937\n" +
				"               Tom Sawyer -           Mark Twain - 1876\n" +
				"    To Kill a Mockingbird -           Harper Lee - 1960\n\n";
		displayedMovies = "                 Life of Brian - 1979 -          Terry Jones - 9\n" +
				"                          Rush - 2013 -           Ron Howard - 8\n" +
				"             The Thin Red Line - 1998 -      Terrence Malick - 7\n" +
				"Crouching Tiger, Hidden Dragon - 2001 -              Ang Lee - 10\n" +
				"                  Office Space - 1999 -           Mike Judge - 7\n\n";
	}

	@After
	public void restore() {
		System.setOut(System.out);
	}

	@Test
	public void testShouldReturnMenuOnMainMethod() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
		System.setIn(in);
		bibliotecaApp.main(null);
		String menu = Menu.getMenu();
		String expected = "Welcome to Biblioteca!\n\nMenu\n" + menu + "\n";
		assertEquals(expected, outputStream.toString());
	}

	@Test
	public void testShouldListBooksOnGetBooks() {
		assertArrayEquals(bibliotecaApp.getBooks(), books);
	}

	@Test
	public void testShouldListMoviesOnGetMovies() {
		assertArrayEquals(bibliotecaApp.getMovies(), movies);
	}

	@Test
	public void testShouldReturnEmptyStringWhenInputIsQOnChooseOption() {
		ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
		System.setIn(in);
		bibliotecaApp.chooseOption();
		assertEquals("", outputStream.toString());
	}


	@Test
	public void testShouldReturnInvalidOptionMessageWhenIncorrectUserInputGivenOnAnalyseUserInput() {
		bibliotecaApp.analyseUserInput("B");
		assertEquals("Select a valid option!\n", outputStream.toString());
	}

	@Test
	public void testShouldReturnDisplayedBooksWhenInputIsLOnAnalysedUserInput() {
		bibliotecaApp.analyseUserInput("L");
		assertEquals(displayedBooks, outputStream.toString());

	}

	@Test
	public void testShouldReturnSuccessfulCheckoutMessageOnAnalyseUserInput() {
		userState.setLoggedInUser(users[0]);
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\nQ\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("C");
		assertTrue(outputStream.toString().contains("Thank you! Enjoy the book"));
	}

	@Test
	public void testShouldReturnSucessfulReturnMessageOnAnalyseUserInput() {
		userState.setLoggedInUser(users[0]);
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("C");
		in = new ByteArrayInputStream("Dune\nQ\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("R");
		assertTrue(outputStream.toString().contains("Thank you for returning the book."));
	}

	@Test
	public void testShouldReturnInvalidCheckoutErrorMessageOnAnalyseUserInput() {
		userState.setLoggedInUser(users[0]);
		ByteArrayInputStream in = new ByteArrayInputStream("Dupe\nQ\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("C");
		assertTrue(outputStream.toString().contains("That book is not available."));
	}

	@Test
	public void testShouldReturnInvalidReturnErrorMessageOnAnalyseUserInput() {
		userState.setLoggedInUser(users[0]);
		ByteArrayInputStream in = new ByteArrayInputStream("Dune\nQ\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("R");
		assertTrue(outputStream.toString().contains("That is not a valid book to return."));
	}

	@Test
	public void testShouldReturnDisplayedMoviesOnMatchCommand() {
		bibliotecaApp.matchCommand("M");
		assertEquals(displayedMovies, outputStream.toString());
	}

	@Test
	public void testShouldReturnSuccessfulSignInMessageOnAnalyseUserInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("135-2341\ntest!Password\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("S");
		assertTrue(outputStream.toString().contains("Welcome Rushil Gala-Shah, you are now signed in."));
	}

	@Test
	public void testShouldReturnErrorSignInMessageOnAnalyseUserInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("135-2341\ntest!password\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("S");
		assertTrue(outputStream.toString().contains("Invalid card number or password."));
	}

	@Test
	public void testShouldReturnSignInRequiredMessageOnCheckIfLoggedIn() {
		bibliotecaApp.checkLoggedInCommand("C");
		assertEquals("Error: You must sign in first!\n", outputStream.toString());
	}

	@Test
	public void testShouldReturnSuccessfulCheckoutMessageWithLoginOnAnalyseUserInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("135-2341\ntest!Password\nr".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("S");
		in = new ByteArrayInputStream("Dune\nQ\n".getBytes());
		System.setIn(in);
		bibliotecaApp.analyseUserInput("C");
		assertTrue(outputStream.toString().contains("Thank you! Enjoy the book"));
	}
}
