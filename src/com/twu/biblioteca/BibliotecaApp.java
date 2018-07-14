package com.twu.biblioteca;

import com.twu.biblioteca.commands.CheckoutCommand;
import com.twu.biblioteca.commands.ListCommand;
import com.twu.biblioteca.commands.ReturnCommand;

import java.util.Scanner;

public class BibliotecaApp {

    private Book[] books = new Book[] {
		    new Book("Life of Pi", "Yann Martel", 2001,false),
		    new Book("Dune", "Frank Herbert", 1965,false),
		    new Book("The Hobbit", "J. R. R. Tolkien", 1937,false),
		    new Book("Tom Sawyer", "Mark Twain", 1876,false),
		    new Book("To Kill a Mockingbird", "Harper Lee", 1960,false)
    };

	public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayInitialScreen();
        bibliotecaApp.chooseOption();
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Book[] getBooks() {
        return books;
    }

    public void displayInitialScreen() {
        System.out.println(welcomeMessage() + "\n");
        System.out.println("Menu");
        System.out.println(getMenu());
    }

    public String getMenu() {
        return "L - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n";
    }

    public void chooseOption() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().substring(0, 1).toUpperCase();
        while (!input.equals("Q")) {
            if (input.equals("L")) {
                System.out.print(new ListCommand().execute(getBooks()));
            } else if (input.equals("C")) {
	            System.out.println(new CheckoutCommand().execute(getBooks()));
            } else if (input.equals("R")) {
	            System.out.println(new ReturnCommand().execute(getBooks()));
            } else {
            	System.out.println("Select a valid option!");
            }
            input = sc.nextLine().substring(0, 1).toUpperCase();
        }
    }


}
