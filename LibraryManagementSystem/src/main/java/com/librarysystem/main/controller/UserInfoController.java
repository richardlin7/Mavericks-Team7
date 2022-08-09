package com.librarysystem.main.controller;

import java.security.Principal;
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

import com.librarysystem.main.dto.AdminLoginDto;
import com.librarysystem.main.dto.UserInfoDto;
import com.librarysystem.main.dto.UserLoginDto;
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
	
		 userInfoRepository.save(info);
	
	}
	@GetMapping("/user-login")
	public UserLoginDto userLogin(Principal principal) {
		
		String username = principal.getName();
		UserInfo info = userInfoRepository.getByUsername(username);
		if (!(info.getRole().toString() =="USER")) {
			throw new RuntimeException("Only User can login");
		}
		UserLoginDto dto = new UserLoginDto();
		dto.setId(info.getId());
		dto.setFirstName(info.getFirstName());
		dto.setLastName(info.getLastName());
		dto.setUsername(info.getUsername());
		dto.setRole(info.getRole().toString());
		return dto; 
		
	}
	
	
	@GetMapping("/admin-login")
	public AdminLoginDto adminLogin(Principal principal) {
		
		String username = principal.getName();
		UserInfo info = userInfoRepository.getByUsername(username);
		if (info.getRole().toString()=="ADMIN") {
			
		
		//System.out.println(info.getRole());
		
		AdminLoginDto dto = new AdminLoginDto();
		dto.setId(info.getId());
		dto.setFirstName(info.getFirstName());
		dto.setLastName(info.getLastName());
		dto.setUsername(info.getUsername());
		dto.setRole(info.getRole().toString());
		return dto; 
		
		}else {
			throw new RuntimeException("Only Admin can login");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	


}
