package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcomeMessage());
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public String[] getBooks() {
        String[] books = new String[] {"Life of Pi", "Dune", "The Hobbit", "Tom Sawyer", "To Kill a Mockingbird"};
        return books;
    }

    public String displayBooks(String[] books) {
        return null;
    }
}
