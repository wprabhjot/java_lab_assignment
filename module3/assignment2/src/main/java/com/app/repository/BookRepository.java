package com.app.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.app.entity.Book;

@Repository
public class BookRepository{

    private Map<Integer, Book> store = new HashMap<>();
    private AtomicInteger counter = new AtomicInteger(1);
    
    public Book save(Book book) {
    	if (book.getId() != null && store.containsKey(book.getId())) {
            store.put(book.getId(), book);
        } else {
            Integer key = counter.getAndIncrement();
            book.setId(key);
            store.put(key, book);
        }
        return book;
    }
    public Book findById(Integer id) {
    	Book book = store.get(id);
		return book;
    }
    public List<Book> findAll() {
    	List<Book> bookList = new ArrayList<>(store.values()) ;
    	return bookList;
    }
    public void deleteById(Integer id) {
    	store.remove(id);
    }

}