package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibliotecaApp;
    private String[] books;
    private String displayedBooks;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        books = new String[] {"Life of Pi", "Dune", "The Hobbit", "Tom Sawyer", "To Kill a Mockingbird"};
        displayedBooks = "Life of Pi\nDune\nThe Hobbit\nTom Sawyer\nTo Kill a Mockingbird\n";
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
}
