package com.conveylaw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conveylaw.model.Book;
import com.conveylaw.service.BooksService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class BooksController {
	
	@Autowired
	private BooksService booksService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return booksService.getBooks();
	}
	
	  @PostMapping("/books")
	  public void createBook(@RequestBody Book book)
	  {
		  booksService.saveBook(book);
	  }

}
