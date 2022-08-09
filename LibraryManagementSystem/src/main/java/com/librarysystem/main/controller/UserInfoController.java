package com.librarysystem.main.controller;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.main.dto.UserInfoDto;
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
	
	@PostMapping("/user/sign-up")
	public void signUpUser(@RequestBody UserInfoDto dto) {
		
		 String str = new String(Base64.getDecoder().decode(dto.getEncodedCredentials())); 
		 String[] sarr = str.split("@%");
		 
		 String username = sarr[0];
		 String password = sarr[1];
		 
//		 String username = str.split("@%")[0];
//		 String password = str.split("@%")[1]; //potter123
		
	// List<UserInfo> list =userInfoRepository.findAll();
	 
//	 list.stream().forEach(e->{
		 UserInfo info = new UserInfo();
		 info.setFirstName(dto.getFirstName());
		 info.setLastName(dto.getLastName());
		 info.setPhone(dto.getPhone());
		 info.setRegisterDate(LocalDate.now());
		 info.setRole(dto.getRole());
		 info.setUsername(username);
		 info.setPassword(passwordEncoder.encode(password));
		 info.setSecurityQuestion1(dto.getSecurityQuestion1());
		 info.setSecurityAnswer1(dto.getSecurityAnswer1());
		 info.setSecurityQuestion2(dto.getSecurityQuestion2());
		 info.setSecurityAnswer2(dto.getSecurityAnswer2());
		 //info.set
		 
		 userInfoRepository.save(info);
		 
	// });
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/user/{aId}")
	public void InsertUserInfo(@RequestBody UserInfo newUser, @PathVariable("aId") Long aId) {
		
//		Optional<Address> addressId = addressRepository.findById(aId);
//		if (!addressId.isPresent()) {
//			throw new RuntimeException("Address ID Invalid");
//		}
//		Address address = addressId.get();
//		
//		Optional<UserInfo> optUser = userInfoRepository.findByUsername(newUser.getUsername());
//		if (optUser.isPresent()) {
//			throw new RuntimeException("Username is Invalid");
//		}
//		//UserInfo userInfo = optUser.get();
//		
//		newUser.setAddress(address);
//		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
//		newUser.setRegisterDate(LocalDate.now());
//		
//		return userInfoRepository.save(newUser);
		
	}

}
