package com.bookstore.service;

import java.util.List;


import com.bookstore.dao.BookDao;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;

public class BookService {
    private BookDao bookDao;
    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    private void validateBook(Book book) {
    	if(book==null) throw new IllegalArgumentException("Book cannot be null");
    	if (book.getTitle() == null || book.getTitle().trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
    	if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) throw new IllegalArgumentException("Author cannot be empty");
    	if(book.getPrice()<=0) throw new IllegalArgumentException("Price can't be less than or equal to zero");
    }
    public List<Book> getAllBooks(){
    	try {
			return bookDao.getAllBooks();
		} catch (DaoException e) {
			// TODO: handle exception
			throw new RuntimeException("Some issue while fetching all books. Try again later", e);
		}
    }
    
    public Book addBook(Book book) {
    	try {
    		validateBook(book);
			return bookDao.addBook(book);
		} catch (DaoException e) {
			// TODO: handle exception
			throw new RuntimeException("Some issue while adding book. Try again later", e);
		}
    }
    
    public void deleteBook(int id) {
    	if(id<=0) {
    		throw new IllegalArgumentException("Invalid book ID");
    	}
    	try {
			bookDao.deleteBook(id);
		} catch (DaoException e) {
			// TODO: handle exception
			throw new RuntimeException("Some issue while deleting. Try again later", e);
		}
    }
    
    public void updateBook(int id, Book book) {
    	if(id<=0) {
    		throw new IllegalArgumentException("Invalid book ID");
    	}
    	validateBook(book);
    	try {
			bookDao.updateBook(id, book);
		} catch (DaoException e) {
			// TODO: handle exception
			throw new RuntimeException("Some issue while updating. Try again later", e);
		}
    }
    
    public Book getBookById(int id) {
    	if(id<=0) {
    		throw new IllegalArgumentException("Invalid book ID");
    	}
    	try {
			return bookDao.getBookById(id);	
		} catch (DaoException e) {
			// TODO: handle exception
			throw new RuntimeException("Some issue while fetching book. Try again later", e);
		}
    }
}