package com.librarysystem.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//get book by id rest api
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id){
		Book book = bookRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(book);
	}
	
	//update book rest api
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book bookDetails){
		Book book = bookRepository.findById(id).orElseThrow();
		
		book.setBookName(bookDetails.getBookName());
		book.setBookStatus(bookDetails.getBookStatus());
		book.setBookCopies(bookDetails.getBookCopies());
		book.setBookDescription(bookDetails.getBookDescription());
		book.setListedDate(bookDetails.getListedDate());
		book.setAuthor(bookDetails.getAuthor());
		book.setCategory(bookDetails.getCategory());
		book.setLibrary(bookDetails.getLibrary());
		


		Book updatedBook = bookRepository.save(book);
		
		return ResponseEntity.ok(updatedBook);
	}
	 
	

}
