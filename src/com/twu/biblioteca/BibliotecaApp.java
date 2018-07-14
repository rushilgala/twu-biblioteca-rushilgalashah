package com.twu.biblioteca;


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

    public Book[] getBooks() {
        return books;
    }

    public void displayInitialScreen() {
			Menu.initialise();
    }


    public void chooseOption() {
				String input =  Menu.enterCommand();
        while (!input.equals("Q")) {
	        analyseUserInput(input);
          input = Menu.enterCommand();
        }
    }

    public void analyseUserInput(String input) {
	    if (Menu.checkIfValidOption(input)) {
		    System.out.println(Menu.executeCommand(input,getBooks()));
	    } else {
		    System.out.println("Select a valid option!");
	    }
    }


}
