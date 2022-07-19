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

import com.springboot.bookstore.model.Admin;
import com.springboot.bookstore.repository.AdminRepository;

@RestController
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;

	// Inserting Admin
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

	// Delete admin by ID
	@DeleteMapping("/admin/{id}")
	public void deleteAdminById(@PathVariable("id") Long id) {
		Optional<Admin> opt = adminRepository.findById(id);

		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}

		adminRepository.deleteById(id);
	}

	// Update Admin by adminID
	@PutMapping("/admin/{id}")
	public Admin updateAdminById(@RequestBody Admin newAdmin, @PathVariable("id") Long id) {

		Optional<Admin> opt = adminRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		Admin admin = opt.get();

		admin.setFirst_name(newAdmin.getFirst_name());
		admin.setLast_name(newAdmin.getLast_name());
		admin.setPassword(newAdmin.getPassword());
		admin.setUsername(newAdmin.getUsername());
		admin.setPhone(newAdmin.getPhone());

		return adminRepository.save(admin);
	}

}
