package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/findbyid/{id}")
	public Books findBookById(@PathVariable int id) {
		return bookService.findByID(id);
	}
	
	@PutMapping("/updatebook")
	public Books update(@RequestBody Books books) {
		bookService.update(books);
		return books;
	}
	
	@DeleteMapping("/deletebook/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
	
	
}
