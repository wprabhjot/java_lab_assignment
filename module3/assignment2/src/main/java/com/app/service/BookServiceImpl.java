package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.exceptions.BookNotFoundException;
import com.app.repository.BookRepository;
import com.app.util.BookConverter;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

    public Book addBook(BookDto dto) {
    	return repo.save(BookConverter.convertToBook(dto));
    }
    public Book updateBook(Integer id, BookDto dto) throws BookNotFoundException {
    	Book existingBook = repo.findById(id);
    	if(existingBook==null) {
    		throw new BookNotFoundException("Unable to update. Book id: "+ id+ " not found.");
    	}
    	existingBook.setAuthor(dto.getAuthor());
    	existingBook.setPrice(dto.getPrice());
    	existingBook.setTitle(dto.getTitle());
    	return repo.save(existingBook);
    }
    public Book getBook(Integer id) {
        Book book = repo.findById(id);
        if(book == null) {
            throw new BookNotFoundException("Book id: " + id + " not found");
        }
        return book;
    }
    public List<Book> getAllBooks() {
    	return repo.findAll();
    }
    public void deleteBook(Integer id) {
        if(repo.findById(id) == null) {
            throw new BookNotFoundException("Book id: " + id + " not found");
        }
        repo.deleteById(id);
    }

}