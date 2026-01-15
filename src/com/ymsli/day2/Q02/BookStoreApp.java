package com.ymsli.day2.Q02;
/*
	Part C: BookStoreApp (main class)
	Demonstrate the following:
	
	Add sample books
	Order new & existing books
	Sell books
	Display inventory after each operation
 */

import java.util.List;
import java.util.ArrayList;


public class BookStoreApp{
	
	public static void main(String[] args) {
		Book book1  = new Book("Java Basics", "Alice", "ISBN001", 5);
		Book book2  = new Book("Python Fundamentals", "Bob", "ISBN002", 3);
		Book book3  = new Book("Data Structures", "Charlie", "ISBN003", 2);
		Book book4  = new Book("Algorithms", "David", "ISBN004", 4);
		Book book5  = new Book("Operating Systems", "Eve", "ISBN005", 6);
		Book book6  = new Book("Computer Networks", "Frank", "ISBN006", 5);
		Book book7  = new Book("Database Systems", "Grace", "ISBN007", 7);
		Book book8  = new Book("Software Engineering", "Helen", "ISBN008", 3);
		Book book9  = new Book("Machine Learning", "Ian", "ISBN009", 2);
//		Book book10 = new Book("Artificial Intelligence", "Jack", "ISBN010", 4);

	    
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		books.add(book9);
//		books.add(book10);
  
	    BookStore bookStore = new BookStore(books);
	    
	    System.out.println("Initial Inventory: \n");
	    bookStore.display();
	    
	    bookStore.sell("Java Basics", 3);
	    bookStore.order("ISBN003", 11);
	    bookStore.order("ISBN053", 11);
	    bookStore.sell("Python Fundamentals", 4);
	    
	    System.out.println("\nFinal Inventory: \n");
	    bookStore.display();
	}
}
