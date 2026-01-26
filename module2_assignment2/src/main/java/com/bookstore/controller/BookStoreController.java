package com.bookstore.controller;

import java.util.List;

import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoJdbcImpl;
import com.bookstore.dto.Book;
import com.bookstore.service.BookService;

public class BookStoreController {

    public static void main(String[] args) {
        BookDao dao = new BookDaoJdbcImpl();
        BookService service = new BookService(dao);

        try {
//            // Add books
//            Book book1 = new Book("978-013235088", "Effective Java", "Joshua Bloch", 450.0);
//            Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra", 350.0);
//
//            service.addBook(book1);
//            service.addBook(book2);
//
//            System.out.println("Books added successfully!");
//
//            // List all books
            System.out.println("\nAll Books:");
            List<Book> allBooks = service.getAllBooks();
            allBooks.forEach(System.out::println);
//
//            // Get book by ID
//            System.out.println("\nGet Book by ID 1:");
//            Book b = service.getBookById(1);
//            System.out.println(b);
//
//            // Update book
//            b.setPrice(500.0);
//            service.updateBook(b.getId(), b);
//            System.out.println("\nUpdated Book:");
//            System.out.println(service.getBookById(b.getId()));
//
//            // Delete book
//            service.deleteBook(book2.getId());
//            System.out.println("\nAfter deletion, all books:");
//            service.getAllBooks().forEach(System.out::println);

        } catch (RuntimeException e) {
            System.out.println("Operation failed: " + e.getMessage());
        }
    }
}
