package com.springboot.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.Admin;
import com.springboot.bookstore.repository.AdminRepository;

@RestController
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	@PostMapping("/admin")
	public void registerAdmin(@RequestBody Admin admin) {

		adminRepository.save(admin);

	}

	// Showing all Admin info
	@GetMapping("/admin")
	public List<Admin> showAllAdmin() {
		List<Admin> list = adminRepository.findAll();

		return list;
	}

	
	//Delete admin by ID
	@DeleteMapping("/admin/{id}")
	public void deleteAdminById(@PathVariable("id") Long id) {
		adminRepository.deleteById(id);
	}

}
