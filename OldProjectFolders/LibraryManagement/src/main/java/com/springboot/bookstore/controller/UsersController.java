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
import com.springboot.bookstore.model.LoginCredentials;
import com.springboot.bookstore.model.Users;
import com.springboot.bookstore.repository.LocationRepository;
import com.springboot.bookstore.repository.UsersRepository;

@RestController
public class UsersController {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private LocationRepository locationRepository;

	// Show All users
	@GetMapping("/user")
	public List<Users> showAllUser() {
		return usersRepository.findAll();

	}

	// Show User info by ID

//	@GetMapping("/user/{id}")
//	public Users showEachUserById(@PathVariable("id") Long id) {
//		Optional<Users> opt = usersRepository.findById(id);
//		if (!opt.isPresent()) {
//			throw new RuntimeException("ID Invalid");
//		}
//		Users users = opt.get();
//
//		return users;
//	}

	// Insert Users
	@PostMapping("/user/{lId}")
	public Users registerUser(@RequestBody Users users,@RequestBody LoginCredentials loginCredentials, @PathVariable("lId") Long lId) {

		Optional<Location> opt = locationRepository.findById(lId);
		if (!opt.isPresent()) {
			throw new RuntimeException("Location Id Invalid");
		}
		Location location = opt.get();

		users.setLocation(location);
		users.setDate(LocalDate.now());
		users.getLoginCredentials().setUsername(loginCredentials.getUsername());
		users.getLoginCredentials().setPassword(loginCredentials.getPassword());
		users.getLoginCredentials().setRoles(loginCredentials.getRoles());

		return usersRepository.save(users);

	}

	// Delete User by ID
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {

		Optional<Users> opt = usersRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		Users users = opt.get();
		usersRepository.delete(users);

	}

	// Update user by ID
	@PutMapping("/user/{id}/{lId}")
	public Users updateUserById(@RequestBody Users newUser, @PathVariable("id") Long id, @PathVariable("lId") Long lId) {
		// Checking if ID is present
		Optional<Users> opt = usersRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		Optional<Location> opt1 = locationRepository.findById(lId);
		if (!opt1.isPresent()) {
			throw new RuntimeException("Location ID Invalid");
		}
		Location location = opt1.get();

		Users users = opt.get();
		users.setFirstName(newUser.getFirstName());
		users.setLastName(newUser.getLastName());
		//users.setPassword(newUser.getPassword());
		//users.setUsername(newUser.getUsername());
		users.setPhone(newUser.getPhone());
		users.setLocation(location);

		return usersRepository.save(users);

	}

	// Get User By State

	@GetMapping("/user/state/{state}")
	public List<Users> getUserByState(@PathVariable("state") String state) {

		List<Users> list = usersRepository.getUserByState(state);

		return list;

	}

}
