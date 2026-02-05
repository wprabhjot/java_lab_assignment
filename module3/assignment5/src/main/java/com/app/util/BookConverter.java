package com.app.util;

import com.app.dto.BookDto;
import com.app.entities.Book;

public class BookConverter {
	
	public static BookDto convertToBookDto(Book book) {
		if(book==null) return null;
		BookDto bookDto = new BookDto();
		bookDto.setTitle(book.getTitle());
		bookDto.setPrice(book.getPrice());
		bookDto.setAuthor(book.getAuthor());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setCategory(book.getCategory());
		return bookDto;
	}
	
	public static Book convertToBook(BookDto bookDto) {
	    if (bookDto==null) return null;
	    Book book = new Book();
	    book.setTitle(bookDto.getTitle());
	    book.setAuthor(bookDto.getAuthor());
	    book.setPrice(bookDto.getPrice());
	    book.setIsbn(bookDto.getIsbn());   
	    book.setCategory(bookDto.getCategory());
	    return book;
	}
}
