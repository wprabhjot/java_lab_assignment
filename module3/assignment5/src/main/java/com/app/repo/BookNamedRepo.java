package com.app.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.entities.Book;
import com.app.rowmapper.BookRowMapper;

@Repository
public class BookNamedRepo implements BookRepo{

    private final NamedParameterJdbcTemplate named;
    private final BookRowMapper rowMapper = new BookRowMapper();

    public BookNamedRepo(NamedParameterJdbcTemplate named) {
        this.named = named;
    }

    public List<Book> findByAuthor(String author) {
        String sql = "SELECT * FROM books_jdbc WHERE author = :author";

        Map<String, Object> params = new HashMap<>();
        params.put("author", author);

        return named.query(sql, params, rowMapper);
    }

    public List<Book> findByPriceRange(double min, double max) {
        String sql =
        "SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max";

        Map<String, Object> params = new HashMap<>();
        params.put("min", min);
        params.put("max", max);

        return named.query(sql, params, rowMapper);
    }

	@Override
	public int save(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Book b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
