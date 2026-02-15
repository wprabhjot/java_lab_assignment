package com.springsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entities.Book;
import com.springsecurity.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable Integer id) {
		return bookService.deleteBook(id);
	}
}
