package com.ymsli.day2.Q02;

//	Part B: BookStore Class
//	BookStore manages an array of maximum 10 books.
//	
//	Required Methods
//	sell(String title, int count)
//	Search by bookTitle.
//	If found → decrease copies.
//	If not found → display “Book not found.”
//	If insufficient copies → display “Not enough stock.”
//	order(String isbn, int count)
//	Search by ISBN.
//	If book exists → increase quantity.
//	If not found → create a new Book object (ask user for title & author).
//	Add the new Book if space is available.
//	display()
//	Print all books using Book’s display() method.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {
	private List<Book> books = new ArrayList<>();
	
	BookStore(List<Book> books){
		this.books = books;
	}
	
	void sell(String title, int count) {
		boolean found = false;
		for(Book book: books) {
			
			if(book.getBookTitle().equals(title)) {
				found = true;
				
				if(book.getNumOfCopies()>=count) {
					book.setNumOfCopies(book.getNumOfCopies()-count);
					System.out.println("Book provided successfully");
				}
				else {
					System.out.println("Not enough stock.");
				}
			}
		}
		if(!found) {
			System.out.println("Book not found.");
		}
	}
	
	void order(String ISBN, int count) {
		boolean found = false;
		for(Book book: books) {
			
			if(book.getISBN().equals(ISBN)) {
				found = true;
				
				book.setNumOfCopies(book.getNumOfCopies()+count);
				System.out.println("Order processed successfully");
			}
		}
		if(!found) {
			System.out.print("Enter book title: ");
			Scanner sc = new Scanner(System.in);
			String title = sc.nextLine();
			System.out.print("Enter author: ");
			String author = sc.nextLine();
//			sc.close();
			
			Book book = new Book(title, author, ISBN, count);
			if(books.size() < 10) {
				books.add(book);
			}
			else {
				System.out.println("Total books can't be more than 10");
			}
		}
	}
	
	void display() {
		for(Book book: books) {	
			System.out.println("Author- "+ book.getAuthor()+ " Title- "+ book.getBookTitle()+ " ISBN- "+ book.getISBN()+ " Quantity- "+ book.getNumOfCopies());
		}
	}
}
