package com.ymsli.assignment3.Q04;

import java.util.LinkedList;
import java.util.List;

public class BookStore {
	private List<Book> books = new LinkedList<>();
	
	BookStore(List<Book> books){
		this.books = books;
	}
	
	public Book searchBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println("Book (id:)"+book.getId()+ "found sucessfully");
                return book;
            }
        }
        System.out.println("Book Not found");
        return null;
    }
	
	private Book findBookByIsbn(String isbn) {
	    for (Book book : books) {
	        if (book.getISBN().equals(isbn)) {
	            return book;
	        }
	    }
	    return null;
	}
	
	void sellBook(String isbn, int count) throws NotSufficientBookException {
		Book book = findBookByIsbn(isbn);
		
		if(book==null) {
			System.out.println("Book not found.");
			return;
		}
		if (book.getNumOfCopies() < count) {
	        throw new NotSufficientBookException("Insufficient books");
	    }
		book.setNumOfCopies(book.getNumOfCopies() - count);
	    System.out.println("Book sold successfully");
	}
	
	void purchaseBook(String isbn, int count) {
		Book book = findBookByIsbn(isbn);
		
		if(book==null) {
			System.out.println("Book not found.");
			return;
		}
			
		book.setNumOfCopies(book.getNumOfCopies()+count);
		System.out.println("Book purchased successfully");
		return;
	}
	
	void display() {
		for(Book book: books) {	
			book.display();
		}
	}
}
