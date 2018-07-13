package com.twu.biblioteca;

import java.util.Arrays;
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
        bibliotecaApp.displayInitialScreen(bibliotecaApp);
        bibliotecaApp.chooseOption(bibliotecaApp);
    }

    public String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public Book[] getBooks() {
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
        	if (!book.getLoanStatus()) {
		        sb.append(book.toString());
	        }
        }
        return sb.toString();
    }

    public String getMenu() {
        return "L - List Books\nC - Checkout Book\nR - Return Book\nQ - Quit\n";
    }

    public void chooseOption(BibliotecaApp bibliotecaApp) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().substring(0, 1).toUpperCase();
        while (!input.equals("Q")) {
            if (input.equals("L")) {
                System.out.print(bibliotecaApp.displayBooks(bibliotecaApp.getBooks()));
            } else if (input.equals("C")) {
	            checkoutBook(sc);
            } else if (input.equals("R")) {
            	returnBook(sc);
            } else {
            	System.out.println("Select a valid option!");
            }
            input = sc.nextLine().substring(0, 1).toUpperCase();
        }
    }

	private void returnBook(Scanner sc) {
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		for (Book book : getBooks()) {
			if (book.getTitle().equals(title)) {
				book.setLoanStatus(false);
				System.out.println("Thank you for returning the book.");
				return;
			}
		}
		System.out.println("That is not a valid book to return.");
	}

	public void checkoutBook(Scanner sc) {
			System.out.print("Enter the title: ");
	    String title = sc.nextLine();
	    for (Book book : getBooks()) {
		    if (book.getTitle().equals(title)) {
			    book.setLoanStatus(true);
			    System.out.println("Thank you! Enjoy the book");
			    return;
		    }
	    }
	    System.out.println("That book is not available.");
    }
}
