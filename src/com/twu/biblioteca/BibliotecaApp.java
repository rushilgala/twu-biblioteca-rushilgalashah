package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayInitialScreen(bibliotecaApp);
        bibliotecaApp.chooseOption(bibliotecaApp);
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

    public void displayInitialScreen(BibliotecaApp bibliotecaApp) {
        System.out.println(bibliotecaApp.welcomeMessage() + "\n");
        System.out.println("Menu");
        System.out.println(bibliotecaApp.getMenu());
    }

    public String displayBooks(Book[] books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.toString());
        }
        return sb.toString();
    }

    public String getMenu() {
        return "L: List Books\n";
    }

    public void chooseOption(BibliotecaApp bibliotecaApp) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().substring(0, 1).toUpperCase();
        if (input.equals("L")) {
            System.out.print(bibliotecaApp.displayBooks(bibliotecaApp.getBooks()));
        }
    }
}
