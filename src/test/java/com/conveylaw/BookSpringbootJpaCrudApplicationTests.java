package com.conveylaw;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.conveylaw.model.Book;
import com.conveylaw.repository.BookRepository;
import com.conveylaw.service.BooksService;
import com.sun.el.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookSpringbootJpaCrudApplicationTests {

	@Autowired
	private BooksService service;

	@MockBean
	private BookRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Arrays.asList(
				new Book(376, "TestTitle1", "TestAuthor1", "TestGenre1", "TestIsbn1"), new Book(958, "TestTitle2", "TestAuthor2", "TestGenre2", "TestIsbn2")));
		assertEquals(2, service.getBooks().size());
	}

	@Test
	public void saveUserTest() {
		Book book = new Book(999, "TestTitle", "TestAuthor", "TestGenre", "TestIsbn");
		when(repository.save(book)).thenReturn(book);
		assertEquals(book, service.saveBook(book));
	}


}
