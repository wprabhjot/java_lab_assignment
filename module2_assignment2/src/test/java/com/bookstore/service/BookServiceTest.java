package com.bookstore.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bookstore.dao.BookDao;
import com.bookstore.dto.Book;
import com.bookstore.exceptions.DaoException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceTest.class);
	
	@Mock
	private BookDao bookDao;
	
	@InjectMocks
	private BookService bookService;
	
	@BeforeAll
	static void setupAll() {
		logger.info("Starting BookService tests");
	}
	
	@BeforeEach
	void beforeEachTest() {
	    logger.info("Running new test...");
	}
	
	@Test
	void addBookPositiveTest() throws DaoException {
		logger.info("Starting addBook positive test...");
		
		Book book = new Book("testisbn123" ,"Test book", "Author", 100.0);
		
		when(bookDao.addBook(book)).thenReturn(book);
		Book addedBook = bookService.addBook(book);
		
		assertNotNull(addedBook, "Added book should not be null");
		assertEquals("Test book",  addedBook.getTitle());
		
		
		verify(bookDao).addBook(book);
		
		logger.info("addBook positive test passed");
	}
	
	@Test
	void addBookNegativeTestInvalidPrice() {
		logger.info("Starting addBook negative invalid price test...");
		Book book = new Book("testisbn123" ,"Test book", "Author", -100.0);
//		Book addedBook = bookService.addBook(book);
		assertThrows(IllegalArgumentException.class, ()-> bookService.addBook(book), "negative price");
		
		verifyNoMoreInteractions(bookDao);
	}
	
	@Test
	void addBookNegativeTestEmptyTitle() {
		logger.info("Starting addBook negative empty title test...");
		Book book = new Book("testisbn123" ," ", "Author", 100.0);
//		Book addedBook = bookService.addBook(book);
		assertThrows(IllegalArgumentException.class, ()-> bookService.addBook(book), "empty title");
		
		verifyNoMoreInteractions(bookDao);
	}
	
	@Test
	void getBookByIdValidIdTest() throws DaoException {
	    logger.info("Starting getBookById valid ID test...");

	    int bookId = 1;
	    Book book = new Book("isbn123", "Clean Code", "Robert Martin", 500.0);

	    when(bookDao.getBookById(bookId)).thenReturn(book);

	    Book result = bookService.getBookById(bookId);

	    assertNotNull(result);
	    assertEquals("Clean Code", result.getTitle());

	    verify(bookDao).getBookById(bookId);

	    logger.info("getBookById valid ID test passed");
	}

	
	@Test
	void getBookByIdInvalidIdTest() {
	    logger.info("Starting getBookById invalid ID test...");

	    int invalidId = 0;
	    assertThrows(IllegalArgumentException.class, () -> bookService.getBookById(invalidId), "invalid book ID");
	    verifyNoMoreInteractions(bookDao);

	    logger.info("getBookById invalid ID test passed");
	}

	@Test
	void updateBookValidDataTest() throws DaoException {
	    logger.info("Starting updateBook valid data test...");

	    int bookId = 1;

	    Book updatedBook = new Book("isbn123", "Effective Java", "Joshua Bloch", 650.0);

	    assertDoesNotThrow(() -> bookService.updateBook(bookId, updatedBook));

	    verify(bookDao).updateBook(bookId, updatedBook);

	    assertEquals("Effective Java", updatedBook.getTitle());
	    assertEquals(650.0, updatedBook.getPrice());
	    assertNotEquals("Old Title", updatedBook.getTitle());

	    logger.info("updateBook valid data test passed");
	}

	@Test
	void updateBookNullTitleTest() {
	    logger.info("Starting updateBook null title test...");

	    int bookId = 1;
	    Book invalidBook = new Book("isbn123", null, "Author", 300.0);

	    IllegalArgumentException ex = assertThrows(
	            IllegalArgumentException.class,
	            () -> bookService.updateBook(bookId, invalidBook)
	    );

	    assertEquals("Title cannot be empty", ex.getMessage());

	    verifyNoMoreInteractions(bookDao);

	    logger.info("updateBook null title test passed");
	}


	@Test
	void deleteBookValidIdTest() throws DaoException {
	    logger.info("Starting deleteBook valid ID test...");

	    int bookId = 1;

	    assertDoesNotThrow(() -> bookService.deleteBook(bookId));

	    verify(bookDao, times(1)).deleteBook(bookId);

	    logger.info("deleteBook valid ID test passed");
	}
	
	@Test
	void deleteBookInvalidIdTest() {
	    logger.info("Starting deleteBook invalid ID test...");

	    int invalidId = 0;

	    IllegalArgumentException ex = assertThrows(
	            IllegalArgumentException.class,
	            () -> bookService.deleteBook(invalidId)
	    );

	    assertEquals("Invalid book ID", ex.getMessage());

	    verifyNoMoreInteractions(bookDao);

	    logger.error("Book not found for deletion");
	}

	@Test
	void getAllBooksTest() throws DaoException {
	    logger.info("Starting getAllBooks test...");

	    Book book1 = new Book("isbn1", "Java Basics", "Author A", 300.0);
	    Book book2 = new Book("isbn2", "Spring Boot", "Author B", 500.0);
	    Book book3 = new Book("isbn3", "Microservices", "Author C", 700.0);

	    List<Book> mockBookList = List.of(book1, book2, book3);

	    when(bookDao.getAllBooks()).thenReturn(mockBookList);

	    List<Book> result = bookService.getAllBooks();

	    assertNotNull(result);
	    assertEquals(3, result.size());

	    assertEquals("Java Basics", result.get(0).getTitle());
	    assertEquals("Spring Boot", result.get(1).getTitle());
	    assertEquals("Microservices", result.get(2).getTitle());

	    verify(bookDao).getAllBooks();

	    logger.info("getAllBooks test passed");
	}

	
	@AfterEach
    void tearDown() {
        logger.info("Test completed.\n");
    }

    @AfterAll
    static void tearDownAll() {
        logger.info("All BookService tests completed!");
    }
}