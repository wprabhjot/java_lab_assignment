package com.app.jdbc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.app.jdbc.dto.BookDto;
import com.app.jdbc.entities.Book;
import com.app.jdbc.service.BookService;

@RestController
@RequestMapping("/api/jdbc/books")
public class BookJdbcController {

    private final BookService bookService;

    public BookJdbcController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public Book addBook(@RequestBody BookDto dto) {
        return bookService.addBook(dto);
    }

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable Integer id,
            @RequestBody BookDto dto) {
        return bookService.updateBook(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }
}
