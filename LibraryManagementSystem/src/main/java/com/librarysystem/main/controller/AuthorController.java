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

import com.librarysystem.main.model.Author;
import com.librarysystem.main.repository.AuthorRepository;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/author")
	public List<Author> getAllAuthor() {
		
		return authorRepository.findAll();
		
	}
	
	@PostMapping("/author")
	public Author insertAuthor(@RequestBody Author author) {
		
		return authorRepository.save(author);
		
	}
	@DeleteMapping("/author/{id}")
	public void deleteAuthorById(@PathVariable("id") Long id) {
		
		Optional<Author> opt = authorRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("Id is Invalid");
		}
		Author author = opt.get();
		
		 authorRepository.delete(author);
	}
	

}
