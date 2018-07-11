package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibliotecaApp;
    private String[] books;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        books = new String[] {"Life of Pi", "Dune", "The Hobbit", "Tom Sawyer", "To Kill a Mockingbird"};
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals("Welcome to Biblioteca!", bibliotecaApp.welcomeMessage());
    }

    @Test
    public void testListBooks() {
        assertEquals(bibliotecaApp.getBooks(), books);
    }
}
