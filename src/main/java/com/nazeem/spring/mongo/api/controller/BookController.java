package com.nazeem.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import com.nazeem.spring.mongo.api.repository.BookRepository;
import com.nazeem.spring.mongo.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nazeem.spring.mongo.api.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("/add")
	public String saveBook(@RequestBody Book book) {
		String id  = bookService.save(book);
		return "Added book with id : " + id;
	}

	@GetMapping("/findAll")
	public List<Book> getBooks() {
		return bookService.findAll();
	}

	@GetMapping("/findByAuthor/{author}")
	public List<Book> findByAuthor( @PathVariable("author") String author) {
		return bookService.findByAuthor(author);
	}

	@GetMapping("/findAll/{id}")
	public Optional<Book> getBook(@PathVariable String id) {
		return bookService.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id) {
		bookService.deleteById(id);
		return "book deleted with id : " + id;
	}

}
