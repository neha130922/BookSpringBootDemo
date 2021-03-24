package com.conveylaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conveylaw.model.Book;
import com.conveylaw.repository.BookRepository;


@Service
public class BooksService {
	@Autowired
    private BookRepository repository;

    public Book saveBook(Book book) {
        return repository.save(book);
    }
    
    public List<Book> getBooks() {
        return repository.findAll();
    }

}
