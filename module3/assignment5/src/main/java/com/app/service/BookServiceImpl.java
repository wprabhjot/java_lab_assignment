package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entities.Book;
import com.app.exceptions.BookNotFoundException;
import com.app.repo.BookNamedRepo;
import com.app.repo.BookRepo;
import com.app.util.BookConverter;
			
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final BookRepo bookRepo;
    private final BookNamedRepo namedRepo;

    public BookServiceImpl(@Qualifier("bookJdbcDao") BookRepo bookRepo, BookNamedRepo namedRepo) {
        this.bookRepo = bookRepo;
        this.namedRepo = namedRepo;
    }

    @Override
    public Book getBook(Integer id) {
        Book book = bookRepo.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book addBook(BookDto dto) {
        Book book = BookConverter.convertToBook(dto);
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book updateBook(Integer id, BookDto dto) {
        Book existingBook = bookRepo.findById(id);
        if (existingBook == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        existingBook.setTitle(dto.getTitle());
        existingBook.setAuthor(dto.getAuthor());
        existingBook.setCategory(dto.getCategory());
        existingBook.setPrice(dto.getPrice());
        existingBook.setIsbn(dto.getIsbn());

        bookRepo.update(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(Integer id) {
        int rows = bookRepo.delete(id);
        if (rows == 0) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return namedRepo.findByAuthor(author);
    }

    @Override
    public List<Book> findByPriceRange(double min, double max) {
        return namedRepo.findByPriceRange(min, max);
    }
}
