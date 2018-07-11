package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void testWelcomeMessage() {
        assertEquals("Welcome to Biblioteca!", bibliotecaApp.welcomeMessage());
    }
}
