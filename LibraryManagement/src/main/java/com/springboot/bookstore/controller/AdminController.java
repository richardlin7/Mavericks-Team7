package com.springboot.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.repository.AdminRepository;

@RestController
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;

}
