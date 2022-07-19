package com.springboot.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.User;
import com.springboot.bookstore.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// Show All users
	@GetMapping("/user")
	public List<User> showAllUser() {
		return userRepository.findAll();

	}

	// Insert Users
	@PostMapping("/user")
	public void registerUser(@RequestBody User user) {

		userRepository.save(user);

	}

	// Delete User by ID
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {

		Optional<User> opt = userRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		userRepository.deleteById(id);

	}
	
	//Update user by ID
	@PutMapping("/user/{id}")
	public User updateUserById(@RequestBody User newUser, @PathVariable("id") Long id) {
		//Checking if ID is present
		Optional<User> opt = userRepository.findById(id);
		if(!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		
		User user = opt.get();
		user.setFirst_name(newUser.getFirst_name());
		user.setLast_name(newUser.getLast_name());
		user.setPassword(newUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setPhone(newUser.getPhone());
		
		return userRepository.save(user);
		
	}
	

}
