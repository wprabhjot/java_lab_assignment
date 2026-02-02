package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.BookDto;
import com.app.entity.Book;
import com.app.exceptions.BookNotFoundException;
import com.app.repository.BookRepository;
import com.app.util.BookConverter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repo;

    public BookServiceImpl(BookRepository repo) {
        this.repo = repo;
    }

	@Override
	public List<Book> getByAuthor(String author) {
		return repo.findByAuthor(author);
	}

	@Override
	public List<Book> getByCategory(String category) {
		return repo.findByCategory(category);
	}

	@Override
	public Book updateBook(Integer id, BookDto dto) {
	    Book existingBook = repo.findById(id)
	            .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

	    existingBook.setTitle(dto.getTitle());
	    existingBook.setAuthor(dto.getAuthor());
	    existingBook.setCategory(dto.getCategory());
	    existingBook.setPrice(dto.getPrice());
	    existingBook.setIsbn(dto.getIsbn());

	    return repo.save(existingBook);
	}


	@Override
	public Book getBook(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(()-> new BookNotFoundException("Book not found with id: "+ id));
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}


	@Override
	public Book addBook(BookDto dto) {
		return repo.save(BookConverter.convertToBook(dto));
	}

}