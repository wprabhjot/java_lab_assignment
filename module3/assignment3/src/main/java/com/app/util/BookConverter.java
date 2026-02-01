package com.app.util;

import com.app.dto.BookDto;
import com.app.entity.Book;

public class BookConverter {
	
	public static BookDto convertToBookDto(Book book) {
		if(book==null) return null;
		BookDto bookDto = new BookDto();
		bookDto.setTitle(book.getTitle());
		bookDto.setPrice(book.getPrice());
		bookDto.setAuthor(book.getAuthor());
		return bookDto;
	}
	
	public static Book convertToBook(BookDto bookDto) {
	    if (bookDto==null) return null;
	    Book book = new Book();
	    book.setTitle(bookDto.getTitle());
	    book.setAuthor(bookDto.getAuthor());
	    book.setPrice(bookDto.getPrice());

	    return book;
	}
}
