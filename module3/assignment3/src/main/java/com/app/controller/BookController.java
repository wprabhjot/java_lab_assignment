package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody BookDto dto) {
        return bookService.addBook(dto);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody BookDto dto) {
        return bookService.updateBook(id, dto);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author) {
        return bookService.getByAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Book> getByCategory(@PathVariable String category) {
        return bookService.getByCategory(category);
    }
}
