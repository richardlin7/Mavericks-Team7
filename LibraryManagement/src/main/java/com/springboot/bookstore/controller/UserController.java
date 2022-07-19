package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.User;
import com.springboot.bookstore.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//Show All users
	@GetMapping("/user")
	public List<User> showAllUser(){
		return userRepository.findAll();
		
	}
	
	
	//Save Users
	@PostMapping("/user")
	public void registerUser(@RequestBody User user) {
		
		 userRepository.save(user);
		
	}
	
	//Delete User by ID
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		
		userRepository.deleteById(id);
		
	}
	
	

}
