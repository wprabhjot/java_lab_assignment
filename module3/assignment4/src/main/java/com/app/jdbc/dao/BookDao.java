package com.app.jdbc.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.jdbc.entities.Book;

@Repository
public interface BookDao {

	public int save(Book b);

    public Book findById(int id);

    public List<Book> findAll();

    public int update(Book b);

    public int delete(int id);
    
    public List<Book> findByAuthor(String author);
    
    public List<Book> findByPriceRange(double min, double max);
}