package com.app.entity;


import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@NotNull(message = "title shouldn't be empty")
	private String title;
	@NotNull(message = "title shouldn't be empty")
    private String author;
	@NotNull(message = "price shouldn't be empty")
	@Range(min = 1, message = "price should be greater than zero")
    private Double price;
	@NotNull(message = "isbn shouldn't be empty")
    private String isbn;
	@NotNull(message = "category shouldn't be empty")
    private String category;
    
	public Book(String title, String author, Double price, String isbn, String category) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.category = category;
	}
    
    
}