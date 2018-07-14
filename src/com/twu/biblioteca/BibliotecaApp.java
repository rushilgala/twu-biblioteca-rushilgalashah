package com.twu.biblioteca;


import java.util.Scanner;

public class BibliotecaApp {

    private Media[] books = new Media[] {
		    new Book("Life of Pi", "Yann Martel", 2001,false),
		    new Book("Dune", "Frank Herbert", 1965,false),
		    new Book("The Hobbit", "J. R. R. Tolkien", 1937,false),
		    new Book("Tom Sawyer", "Mark Twain", 1876,false),
		    new Book("To Kill a Mockingbird", "Harper Lee", 1960,false)
    };

    private Media[] movies = new Media[] {
		    new Movie("Life of Brian",1979, "Terry Jones",9,false),
				new Movie("Rush",2013,"Ron Howard",8,false),
		    new Movie("The Thin Red Line",1998,"Terrence Malick",7,false),
		    new Movie("Crouching Tiger, Hidden Dragon",2001,"Ang Lee",10,false),
		    new Movie("Office Space",1999,"Mike Judge",7,false)
    };

	public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.displayInitialScreen();
        bibliotecaApp.chooseOption();
    }

    public Media[] getBooks() {
        return books;
    }

    public Media[] getMovies() {
			return movies;
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
				matchCommand(input);
	    } else {
		    System.out.println("Select a valid option!");
	    }
    }

    public void matchCommand(String input) {
			if (Menu.requiresBooks(input)) {
				System.out.println(Menu.executeCommand(input,getBooks()));
			} else {
				System.out.println(Menu.executeCommand(input,getMovies()));
			}
    }

}
