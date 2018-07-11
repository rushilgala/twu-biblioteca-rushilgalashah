package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
            new Book("Life of Pi", "Yann Martel", 2001),
            new Book("Dune", "Frank Herbert", 1965),
            new Book("The Hobbit", "J. R. R. Tolkien", 1937),
            new Book("Tom Sawyer", "Mark Twain", 1876),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960)
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
        assertEquals("L: List Books\n", bibliotecaApp.getMenu());
    }

    @Test
    public void testWelcomeMessageAndMenuAreInitiallyDisplayed() {
        bibliotecaApp.displayInitialScreen(bibliotecaApp);
        String expected = "Welcome to Biblioteca!\n\nMenu\nL: List Books\n\n";
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


}
