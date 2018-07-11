package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcomeMessage());
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
