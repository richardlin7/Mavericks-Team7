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

import com.librarysystem.main.model.Library;
import com.librarysystem.main.repository.LibraryRepository;

@RestController
public class LibraryController {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@GetMapping("/library")
	public List<Library> getAllLibrary() {
		
		return libraryRepository.findAll();
		
	}
	
	@PostMapping("/library")
	public Library insertLibrary(@RequestBody Library library) {
		
		return libraryRepository.save(library);
		
	}
	@DeleteMapping("/library/{id}")
	public void deleteLibraryById(@PathVariable("id") Long id) {
		
		Optional<Library> opt = libraryRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("Id is Invalid");
		}
		Library library = opt.get();
		
		 libraryRepository.delete(library);
	}
	
	//get library by id rest api
	@GetMapping("/library/{id}")
	public ResponseEntity<Library> getLibraryById(@PathVariable Long id){
		Library library = libraryRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(library);
	}
	
	//update library rest api
	@PutMapping("/library/{id}")
	public ResponseEntity<Library> updateLibrary(@PathVariable Long id,@RequestBody Library libraryDetails){
		Library library = libraryRepository.findById(id).orElseThrow();
		
		library.setLibraryName(libraryDetails.getLibraryName());
		library.setPhone(libraryDetails.getPhone());

	
		Library updatedLibrary = libraryRepository.save(library);
		
		return ResponseEntity.ok(updatedLibrary);
	}

}
