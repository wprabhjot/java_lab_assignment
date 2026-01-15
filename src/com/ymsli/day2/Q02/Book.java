package com.ymsli.day2.Q02;

/*
	Part A: Book Class
	Create a class Book with:
	
	Attribute	Type
	bookTitle	String
	author	String
	ISBN	String
	numOfCopies	int
	Requirements
	Parameterized constructor
	Method display() to print:
	Title – Author – ISBN – Quantity
	Validate quantity must be non-negative.
 */
public class Book {
	private String bookTitle;
	private String author;
	private String ISBN;
	private int numOfCopies;
	
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
	
	Book(String bookTitle, String author, String ISBN, int numOfCopies){
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		this.numOfCopies = numOfCopies;
	}
	
	void display() {
		System.out.println("Title- "+ bookTitle+ " Author- "+ author+ " ISBN- "+ ISBN+ " Quantity- "+ numOfCopies);
	}
}
