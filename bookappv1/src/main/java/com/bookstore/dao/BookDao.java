package com.bookstore.dao;

import java.util.List;

import com.bookstore.dto.Book;

public interface BookDao {

    public List<Book> getAllBooks();

    public Book addBook(Book book);

}