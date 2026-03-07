package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping("/addbook")
	public int addBook(@RequestBody Books books) {
		bookService.addBook(books);
		return books.getBookId();
	}
	
	@GetMapping("/allBooks")
	public List<Books> getAllBooks(){
		return bookService.getAllBooks();
	}
	
}
