package com.app.repo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entities.Book;
import com.app.rowmapper.BookRowMapper;

@Repository
public class BookJdbcRepo implements BookRepo {

	private JdbcTemplate jdbcTemplate;

	public BookJdbcRepo(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Book b) {
		String sql = "INSERT INTO book (title, author, price, isbn, category) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, b.getTitle(), b.getAuthor(), b.getPrice(), b.getIsbn(),
				b.getCategory());
	}

	@Override
	public Book findById(int id) {
		String sql = "SELECT * FROM book WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BookRowMapper(), id);
	}

	@Override
	public List<Book> findAll() {
		String sql = "SELECT * FROM book";
		return jdbcTemplate.query(sql, new BookRowMapper());
	}

	@Override
	public int update(Book b) {
		String sql = "UPDATE book SET title = ?, author = ?, price = ?, isbn = ?, category = ? WHERE id = ?";
		return jdbcTemplate.update(sql, b.getTitle(), b.getAuthor(), b.getPrice(), b.getIsbn(), b.getCategory(),
				b.getId());
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM book WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}



}
