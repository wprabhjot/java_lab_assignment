package com.ymsli.assignment3.Q04;

public class Book {
	private int id;
	private String ISBN;
	private String bookTitle;
	private String author;
	private int numOfCopies;
	
	public int getId() {
		return id;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getNumOfCopies() {
		return numOfCopies;
	}

	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	
	Book(int id, String ISBN, String bookTitle, String author,  int numOfCopies){
		this.id = id;
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		this.numOfCopies = numOfCopies;
	}
	
	void display() {
		System.out.println("ID- "+ id+ " , ISBN- "+ ISBN+ " , Title- "+ bookTitle+ " , Author- "+ author+ " , Quantity- "+ numOfCopies);
	}
}
