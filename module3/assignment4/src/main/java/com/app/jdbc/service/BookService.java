package com.app.jdbc.service;

import java.util.List;

import com.app.jdbc.dto.BookDto;
import com.app.jdbc.entities.Book;

public interface BookService{

    public Book addBook(BookDto dto);
    public Book updateBook(Integer id, BookDto dto);
    public Book getBook(Integer id);
    public List<Book> getAllBooks();
    public void deleteBook(Integer id);
    
    public List<Book> getByAuthor(String author);
    public List<Book> findByPriceRange(double min, double max);
}