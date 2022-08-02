package com.librarysystem.main.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.main.model.Address;
import com.librarysystem.main.model.UserInfo;
import com.librarysystem.main.repository.AddressRepository;
import com.librarysystem.main.repository.UserInfoRepository;

@RestController
public class UserInfoController {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/user")
	public List<UserInfo> getAllUserInfo() {
		return userInfoRepository.findAll();
		
	}
	
	@PostMapping("/user/{aId}")
	public UserInfo InsertUserInfo(@RequestBody UserInfo newUser, @PathVariable("aId") Long aId) {
		
		Optional<Address> addressId = addressRepository.findById(aId);
		if (!addressId.isPresent()) {
			throw new RuntimeException("Address ID Invalid");
		}
		Address address = addressId.get();
		
		Optional<UserInfo> optUser = userInfoRepository.findByUsername(newUser.getUsername());
		if (optUser.isPresent()) {
			throw new RuntimeException("Username is Invalid");
		}
		//UserInfo userInfo = optUser.get();
		
		newUser.setAddress(address);
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		newUser.setRegisterDate(LocalDate.now());
		
		return userInfoRepository.save(newUser);
		
	}

}
