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
    private Book[] books;
    private String displayedBooks;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
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
    public void testMainMethod() {
        ByteArrayInputStream in = new ByteArrayInputStream("Q\n".getBytes());
        System.setIn(in);
        bibliotecaApp.main(null);
        String expected = "Welcome to Biblioteca!\n\nMenu\nL - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals("Welcome to Biblioteca!", bibliotecaApp.welcomeMessage());
    }

    @Test
    public void testListBooks() {
        assertArrayEquals(bibliotecaApp.getBooks(), books);
    }

    @Test
    public void testDisplayBooks() {
        assertEquals(displayedBooks, bibliotecaApp.displayBooks(books));
    }

    @Test
    public void testGetMenu() {
        assertEquals("L - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n", bibliotecaApp.getMenu());
    }

    @Test
    public void testWelcomeMessageAndMenuAreInitiallyDisplayed() {
        bibliotecaApp.displayInitialScreen(bibliotecaApp);
        String expected = "Welcome to Biblioteca!\n\nMenu\nL - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void testEnterUpperCaseLToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("L\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertEquals(displayedBooks, outputStream.toString());
    }

    @Test
    public void testEnterLowerCaseLToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("l\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertEquals(displayedBooks, outputStream.toString());
    }


    @Test
    public void testEnterListBooksToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("List books\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertEquals(displayedBooks, outputStream.toString());
    }

    @Test
    public void testEnterQToExit() {
        ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void testBookDoesNotAppearAfterCheckedOut() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDune\nL\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertFalse(outputStream.toString().contains("Dune"));
    }

    @Test
    public void testBookIsMisspelledReturnsNotAvailable() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDupe\nL\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertTrue(outputStream.toString().contains("That book is not available."));
    }


    @Test
    public void testCheckoutMessageOnSuccessfulCheckout() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDune\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertTrue(outputStream.toString().contains("Thank you! Enjoy the book"));
        assertFalse(outputStream.toString().contains("That book is not available."));
    }

    @Test
    public void testReturnedBookAppearsOnList() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDune\nR\nDune\nL\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertTrue(outputStream.toString().contains("Dune"));
    }


    @Test
    public void testReturnMessageOnSuccessfulReturn() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDune\nR\nDune\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertTrue(outputStream.toString().contains("Thank you for returning the book."));
        assertFalse(outputStream.toString().contains("That is not a valid book to return."));
    }

    @Test
    public void testReturnMessageOnUnsuccessfulReturn() {
        ByteArrayInputStream in = new ByteArrayInputStream("C\nDupe\nR\nDupe\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertTrue(outputStream.toString().contains("That is not a valid book to return."));
    }

    @Test
    public void testInvalidOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("B\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption(bibliotecaApp);
        assertEquals("Select a valid option!\n", outputStream.toString());
    }

}
