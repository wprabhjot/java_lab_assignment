package com.app.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.jdbc.dao.BookDao;
import com.app.jdbc.dao.BookNamedDao;
import com.app.jdbc.dto.BookDto;
import com.app.jdbc.entities.Book;
import com.app.jdbc.exceptions.BookNotFoundException;
import com.app.jdbc.util.BookConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final BookDao bookDao;
    private final BookNamedDao namedDao;

    public BookServiceImpl(@Qualifier("bookJdbcDao") BookDao bookDao, BookNamedDao namedDao) {
        this.bookDao = bookDao;
        this.namedDao = namedDao;
    }

    @Override
    public Book getBook(Integer id) {
        Book book = bookDao.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book addBook(BookDto dto) {
        Book book = BookConverter.convertToBook(dto);
        bookDao.save(book);
        return book;
    }

    @Override
    public Book updateBook(Integer id, BookDto dto) {
        Book existingBook = bookDao.findById(id);
        if (existingBook == null) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        existingBook.setTitle(dto.getTitle());
        existingBook.setAuthor(dto.getAuthor());
        existingBook.setCategory(dto.getCategory());
        existingBook.setPrice(dto.getPrice());
        existingBook.setIsbn(dto.getIsbn());

        bookDao.update(existingBook);
        return existingBook;
    }

    @Override
    public void deleteBook(Integer id) {
        int rows = bookDao.delete(id);
        if (rows == 0) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return namedDao.findByAuthor(author);
    }

    @Override
    public List<Book> findByPriceRange(double min, double max) {
        return namedDao.findByPriceRange(min, max);
    }
}
