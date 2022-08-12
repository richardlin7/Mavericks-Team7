package com.librarysystem.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.main.model.Book;
import com.librarysystem.main.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/book")
	public List<Book> getAllBook() {
		
		return bookRepository.findAll();
		
	}
	
	@PostMapping("/book")
	public Book insertBook(@RequestBody Book book) {
		
		return bookRepository.save(book);
		
	}
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable("id") Long id) {
		
		Optional<Book> opt = bookRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("Id is Invalid");
		}
		Book book = opt.get();
		
		 bookRepository.delete(book);
	}

}
