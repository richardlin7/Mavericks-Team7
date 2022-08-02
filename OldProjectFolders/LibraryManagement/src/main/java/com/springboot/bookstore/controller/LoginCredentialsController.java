package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.LoginCredentials;
import com.springboot.bookstore.repository.LoginCredentialsRepository;

@RestController
public class LoginCredentialsController {
	
	@Autowired
	private LoginCredentialsRepository loginCredentialsRepository;
	
	
	@GetMapping("/login")
	public List<LoginCredentials> getAllLoginInfo() {
		List<LoginCredentials> list = loginCredentialsRepository.findAll();
		return list;
	}
	
	@PostMapping("/login")
	public LoginCredentials addNewLoginCredential(@RequestBody LoginCredentials newLoginCredentials){
		
		LoginCredentials opt = loginCredentialsRepository.findByUsername(newLoginCredentials.getUsername());
		
		if (opt!=null) {
			throw new RuntimeException("Username already present");
		}
		
		return loginCredentialsRepository.save(newLoginCredentials);
		
	}
	

}
