package com.bookstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.util.ConnectionFactory;

public class BookDaoJdbcImpl implements BookDao{

	private Connection connection;
	
	public BookDaoJdbcImpl() {
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while(rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book addBook(Book book) {
		try {
			PreparedStatement psmt = connection.prepareStatement("insert into books(isbn, title, author, price) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());
			
			psmt.executeUpdate();
			ResultSet rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				book.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return book;
	}

}
