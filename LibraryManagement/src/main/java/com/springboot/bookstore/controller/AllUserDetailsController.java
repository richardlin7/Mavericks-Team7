package com.springboot.bookstore.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.AllUserDetails;
import com.springboot.bookstore.model.Location;
import com.springboot.bookstore.repository.AllUserDetailsRepository;
import com.springboot.bookstore.repository.LocationRepository;

@RestController
public class AllUserDetailsController {

	@Autowired
	private AllUserDetailsRepository allUserDetailsRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Show All users
	@GetMapping("/user")
	public List<AllUserDetails> showAllUser() {
		return allUserDetailsRepository.findAll();

	}

	// Show User info by ID

	@GetMapping("/user/{id}")
	public AllUserDetails showEachUserById(@PathVariable("id") Long id) {
		Optional<AllUserDetails> opt = allUserDetailsRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		AllUserDetails allUserDetails = opt.get();

		return allUserDetails;
	}

	// Insert Users
	@PostMapping("/user/{lId}")
	public AllUserDetails registerUser(@RequestBody AllUserDetails allUserDetails, @PathVariable("lId") Long lId) {

		
		
		Optional<Location> opt = locationRepository.findById(lId);
		if (!opt.isPresent()) {
			throw new RuntimeException("Location Id Invalid");
		}
		
		Location location = opt.get();
		
		Optional<AllUserDetails> allUser = allUserDetailsRepository.getUsersByUserName(allUserDetails.getUsername());
		if (allUser.isPresent()) {
			throw new RuntimeException("Username Is Already Used");
		}
		
		allUserDetails.setLocation(location);
		allUserDetails.setDate(LocalDate.now());
		allUserDetails.setRole(allUserDetails.getRole());
		allUserDetails.setPassword(passwordEncoder.encode(allUserDetails.getPassword()));
		

		return allUserDetailsRepository.save(allUserDetails);

	}

	// Delete User by ID
	@DeleteMapping("/user/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {

		Optional<AllUserDetails> opt = allUserDetailsRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		AllUserDetails allUserDetails = opt.get();
		allUserDetailsRepository.delete(allUserDetails);

	}

	// Update user by ID
	@PutMapping("/user/{id}/{lId}")
	public AllUserDetails updateUserById(@RequestBody AllUserDetails newUser, @PathVariable("id") Long id, @PathVariable("lId") Long lId) {
		// Checking if ID is present
		Optional<AllUserDetails> opt = allUserDetailsRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		Optional<Location> opt1 = locationRepository.findById(lId);
		if (!opt1.isPresent()) {
			throw new RuntimeException("Location ID Invalid");
		}
		Location location = opt1.get();

		AllUserDetails allUserDetails = opt.get();
		allUserDetails.setFirstName(newUser.getFirstName());
		allUserDetails.setLastName(newUser.getLastName());
		allUserDetails.setPassword(newUser.getPassword());
		allUserDetails.setUsername(newUser.getUsername());
		allUserDetails.setPhone(newUser.getPhone());
		allUserDetails.setLocation(location);
		allUserDetails.setRole(newUser.getRole());

		return allUserDetailsRepository.save(allUserDetails);

	}

	// Get User By State

	@GetMapping("/user/state/{state}")
	public List<AllUserDetails> getUserByState(@PathVariable("state") String state) {

		List<AllUserDetails> list = allUserDetailsRepository.getUserByState(state);

		return list;

	}

}
