package com.app.service;

import java.util.List;

import com.app.dto.BookDto;
import com.app.entity.Book;

public interface BookService{

    public Book addBook(BookDto dto);
    public Book updateBook(Integer id, BookDto dto);
    public Book getBook(Integer id);
    public List<Book> getAllBooks();
    public void deleteBook(Integer id);
    
    public List<Book> getByAuthor(String author);
    public List<Book> getByCategory(String category);
}