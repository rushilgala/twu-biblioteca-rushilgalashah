package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        System.out.println(bibliotecaApp.welcomeMessage());
        System.out.println(bibliotecaApp.displayBooks(bibliotecaApp.getBooks()));
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Book[] getBooks() {
        Book[] books = new Book[] {
            new Book("Life of Pi", "Yann Martel", 2001),
            new Book("Dune", "Frank Herbert", 1965),
            new Book("The Hobbit", "J. R. R. Tolkien", 1937),
            new Book("Tom Sawyer", "Mark Twain", 1876),
            new Book("To Kill a Mockingbird", "Harper Lee", 1960)
        };
        return books;
    }

    public String displayBooks(Book[] books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString());
        }
        return sb.toString();
    }
}
