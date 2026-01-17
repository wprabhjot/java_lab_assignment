package com.ymsli.assignment3.Q04;

import java.io.IOException;
import java.util.LinkedList;


public class BookStoreApp{
	
	public static void main(String[] args) throws IOException {
	
		LinkedList<Book> books = BookFileReader.bookFileReader("books.txt");
  
	    BookStore bookStore = new BookStore(books);
	    
	    System.out.println("Initial Inventory: \n");
	    bookStore.display();
	    
	    
	    Book b = bookStore.searchBook(121);
        if (b != null) b.display();
        
        try {
        	bookStore.sellBook("A234", 2000);
		} catch (NotSufficientBookException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
        
        bookStore.purchaseBook("A234", 5);
	    
	    System.out.println("\nFinal Inventory: \n");
	    bookStore.display();
	}
}
