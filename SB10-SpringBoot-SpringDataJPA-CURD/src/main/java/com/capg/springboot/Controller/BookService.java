package com.capg.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BooksRepository booksRepository;
	
	
	
	public void addBook(Books books) {
		booksRepository.save(books);
	}
	
	public List<Books> getAllBooks(){
		List<Books> books = new ArrayList<Books>();
		
		booksRepository.findAll().forEach(b1 -> books.add(b1));
		System.out.println(books);
		return books;
	}
	
	public Books findByID(int id) {
		return booksRepository.findById(id).get();
	}
	
	public void deleteBook(int id) {
		booksRepository.deleteById(id);
	}
	
	public void update(Books books) {
		booksRepository.save(books);
	}

}
