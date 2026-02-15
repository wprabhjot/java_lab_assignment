package com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.springsecurity.entities.Book;

@Service
public class BookService {
	private List<Book> books = new ArrayList<>();

	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
	public List<Book> getAllBooks() {
		return books;
	}

	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
	public Book addBook(Book book) {
		books.add(book);
		return book;
	}

	@PreAuthorize("hasAnyRole('STUDENT','TEACHER')")
	public Book updateBook(Integer id, Book updatedBook) {
		for (Book book : books) {
			if (book.getId().equals(id)) {
				book.setTitle(updatedBook.getTitle());
				book.setAuthor(updatedBook.getAuthor());
				return book;
			}
		}
		return null;
	}

	@PreAuthorize("hasRole('TEACHER')")
	public String deleteBook(Integer id) {
		books.removeIf(book -> book.getId().equals(id));
		return "Book deleted successfully";
	}
}
