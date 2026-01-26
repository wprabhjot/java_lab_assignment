package com.bookstore.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;
import com.bookstore.util.ConnectionFactory;

public class BookDaoJdbcImpl implements BookDao {

//	private Connection connection;
//	
//	public BookDaoJdbcImpl() {
//		connection = ConnectionFactory.getConnection();
//	}

	@Override
	public List<Book> getAllBooks() throws DaoException {
		List<Book> books = new ArrayList<>();
		String sql = "select * from books";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery()) {
			while (rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("Record couldn't be fetched. Please try again.", e);
		}
		return books;
	}

	@Override
	public Book addBook(Book book) throws DaoException {
		String sql = "insert into books(isbn, title, author, price) values(?,?,?,?)";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());

			psmt.executeUpdate();
			try (ResultSet rs = psmt.getGeneratedKeys()) {
				if (rs.next()) {
					book.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO: handle exception
				throw new DaoException("Failed to add book", e);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be added. Please try again.", e);
		}
		return book;
	}

	@Override
	public void deleteBook(int id) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "delete from books WHERE id=?";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.setInt(1, id);
			int rowsAffected = psmt.executeUpdate();
			if (rowsAffected == 0) {
				throw new DaoException("No book found with id" + id, null);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be deleted. Please try again.", e);
		}
	}

	@Override
	public void updateBook(int id, Book book) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "update books SET isbn=?, title=?, author=?, price=? where id=?";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql)) {
			psmt.setString(1, book.getIsbn());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setDouble(4, book.getPrice());
			psmt.setInt(5, id);
			int rowsAffected = psmt.executeUpdate();
			if (rowsAffected == 0) {
				throw new DaoException("No book found with id" + id, null);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be updated. Please try again.", e);
		}
	}

	@Override
	public Book getBookById(int id) throws DaoException {
		// TODO Auto-generated method stub
		Book book = null;
		String sql = "select * from books where id=?";
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement psmt = connection.prepareStatement(sql);) {
			psmt.setInt(1, id);

			try (ResultSet rs = psmt.executeQuery()) {
				if (rs.next()) {
					book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
				} else {
					throw new DaoException("No book found with id" + id, null);
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DaoException("Record couldn't be found. Please try again.", e);
		}
		return book;
	}

}
