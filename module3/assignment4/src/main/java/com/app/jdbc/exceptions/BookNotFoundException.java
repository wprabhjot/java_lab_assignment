package com.app.jdbc.exceptions;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5899295851837796450L;

	public BookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookNotFoundException(String message) {
		super(message);
	}
	
}
