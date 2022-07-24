package com.springboot.bookstore.controller;

import java.time.LocalDate;
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

import com.springboot.bookstore.model.Location;
import com.springboot.bookstore.model.User;
import com.springboot.bookstore.repository.LocationRepository;
import com.springboot.bookstore.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	// Show All users
	@GetMapping("/user")
	public List<User> showAllUser() {
		return userRepository.findAll();

	}

	// Show User info by ID

	@GetMapping("/user/{id}")
	public User showEachUserById(@PathVariable("id") Long id) {
		Optional<User> opt = userRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		User user = opt.get();

		return user;
	}

	// Insert Users
	@PostMapping("/user/{lId}")
	public User registerUser(@RequestBody User user, @PathVariable("lId") Long lId) {

		Optional<Location> opt = locationRepository.findById(lId);
		if (!opt.isPresent()) {
			throw new RuntimeException("Location Id Invalid");
		}
		Location location = opt.get();

		user.setLocation(location);
		user.setDate(LocalDate.now());

		return userRepository.save(user);

	}

	// Delete User by ID
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {

		Optional<User> opt = userRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		User user = opt.get();
		userRepository.delete(user);

	}

	// Update user by ID
	@PutMapping("/user/{id}/{lId}")
	public User updateUserById(@RequestBody User newUser, @PathVariable("id") Long id, @PathVariable("lId") Long lId) {
		// Checking if ID is present
		Optional<User> opt = userRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		Optional<Location> opt1 = locationRepository.findById(lId);
		if (!opt1.isPresent()) {
			throw new RuntimeException("Location ID Invalid");
		}
		Location location = opt1.get();

		User user = opt.get();
		user.setFirst_name(newUser.getFirst_name());
		user.setLast_name(newUser.getLast_name());
		user.setPassword(newUser.getPassword());
		user.setUsername(newUser.getUsername());
		user.setPhone(newUser.getPhone());
		user.setLocation(location);

		return userRepository.save(user);

	}
	
	//Get User By State
	

}
