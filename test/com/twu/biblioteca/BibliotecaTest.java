package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibliotecaApp;
    private Book[] books;
    private String displayedBooks;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
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

}
