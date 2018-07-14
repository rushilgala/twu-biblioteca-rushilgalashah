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
    public void testGetMenu() {
        assertEquals("L - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n", bibliotecaApp.getMenu());
    }

    @Test
    public void testWelcomeMessageAndMenuAreInitiallyDisplayed() {
        bibliotecaApp.displayInitialScreen();
        String expected = "Welcome to Biblioteca!\n\nMenu\nL - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n\n";
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void testEnterUpperCaseLToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("L\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption();
        assertEquals(displayedBooks, outputStream.toString());
    }

    @Test
    public void testEnterLowerCaseLToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("l\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption();
        assertEquals(displayedBooks, outputStream.toString());
    }


    @Test
    public void testEnterListBooksToDisplayBooks() {
        ByteArrayInputStream in = new ByteArrayInputStream("List books\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption();
        assertEquals(displayedBooks, outputStream.toString());
    }

    @Test
    public void testEnterQToExit() {
        ByteArrayInputStream in = new ByteArrayInputStream("Q".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption();
        assertEquals("", outputStream.toString());
    }


    @Test
    public void testInvalidOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("B\nQ\n".getBytes());
        System.setIn(in);
        bibliotecaApp.chooseOption();
        assertEquals("Select a valid option!\n", outputStream.toString());
    }

}
