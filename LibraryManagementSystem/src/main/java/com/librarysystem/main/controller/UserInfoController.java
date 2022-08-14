package com.librarysystem.main.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.main.dto.AdminLoginDto;
import com.librarysystem.main.dto.AllUserDisplayDto;
import com.librarysystem.main.dto.UserEditDto;
import com.librarysystem.main.dto.UserInfoDto;
import com.librarysystem.main.dto.UserLoginDto;
import com.librarysystem.main.dto.UserProfileEditDto;
import com.librarysystem.main.dto.UsersDto;
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
	public List<AllUserDisplayDto> getAllUserInfo(
			@RequestParam(name="page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name="size",required=false,defaultValue = "1000") Integer size) 
	{
		
		if(page < 0)
			page=0;
		
		Pageable pageable = PageRequest.of(page, size);
		
		List<UserInfo> list =  userInfoRepository.findAll(pageable).getContent();
		List<AllUserDisplayDto> allUsers = new ArrayList<>();
		
		
		
		String streetName = "";
		String cityName = "";
		String state="";		
		Integer zipCode= 0000;
		
		for (UserInfo u : list) {
			
			AllUserDisplayDto allUser = new AllUserDisplayDto();
			if (u.getAddress()== null) {
				
				Address address = new Address();
				
				address.setCityName(cityName);
				address.setState(state);
				address.setStreetName(streetName);
				address.setZipCode(zipCode);
				addressRepository.save(address);
				
				u.setAddress(address);
				
			}
			
			allUser.setFirstName(u.getFirstName());
			allUser.setLastName(u.getLastName());
			allUser.setId(u.getId());
			allUser.setCityName(u.getAddress().getCityName());
			allUser.setPhone(u.getPhone());
			allUser.setState(u.getAddress().getState());
			allUser.setStreetName(u.getAddress().getStreetName());
			allUser.setUsername(u.getUsername());
			allUser.setZipCode(u.getAddress().getZipCode());
			allUsers.add(allUser);
			
		}
		return allUsers;
	
	}
	
	
	
	
	@PostMapping("/user/sign-up")
	public void signUpUser(@RequestBody UserInfoDto dto) {
		
		 String str = new String(Base64.getDecoder().decode(dto.getEncodedCredentials())); 
		 String[] sarr = str.split("@%");
		 
		 String username = sarr[0];
		 String password = sarr[1];
		 
		UserInfo uInfo = userInfoRepository.getByUsername(username);
		 
		System.out.println(uInfo);
		 
		 if (uInfo == null) {
			 
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
			
		} else {
			throw new RuntimeException("Username is already Present");
		}
		 
		
	
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
	
	
	@GetMapping("/user/security/info/{username}")
	public UserEditDto getUserInfo(@PathVariable("username") String username) {
		UserInfo info =userInfoRepository.getByUsername(username);
		UserEditDto dto = new UserEditDto(info.getId(), info.getFirstName(),info.getLastName()," ", 
				info.getSecurityQuestion1(), " ", info.getSecurityQuestion2());
		return dto; 
	}
	
	
	@GetMapping("/validate-security-answer/{encodedText}")
	public boolean verifySecurityAnswer(@PathVariable("encodedText") String encodedText) {
		boolean status=false;
		String str = new String(Base64.getDecoder().decode(encodedText)); 
		//username + '--'+answer
		String[] sarr =str.split("--");
		String username = sarr[0]; 
		String answer1=sarr[1];
		String answer2=sarr[2];
		
		//System.out.println(username+"--"+answer1+"--"+answer2);
		
		UserInfo info =userInfoRepository.getByUsername(username);
		if(info.getSecurityAnswer1().equalsIgnoreCase(answer1) && info.getSecurityAnswer2().equalsIgnoreCase(answer2)) {
			status=true; 
		}
		return status; 
	}
	
	
	@PutMapping("/user/reset-password/{encodedText}")
	public void resetPassword(@PathVariable("encodedText") String encodedText) {
		//boolean status=false;
		String str = new String(Base64.getDecoder().decode(encodedText)); 
		
		String[] sarr =str.split("--");
		String username = sarr[0]; 
		String password=sarr[1];
		
		String encodedPassword = this.passwordEncoder.encode(password);
		userInfoRepository.resetPassword(username,encodedPassword,LocalDate.now());
		
	}
	
	
	@GetMapping("/user/username")
	public UserProfileEditDto getUsersByUsername(Principal principal) {
		String username = principal.getName();
		
		System.out.println(username);
		
		UserInfo info = userInfoRepository.getByUsername(username);
		System.out.println(info);
		UserProfileEditDto dto = new UserProfileEditDto();
		dto.setId(info.getId());
		dto.setUsername(info.getUsername());
		dto.setFirstName(info.getFirstName());
		dto.setLastName(info.getLastName());
		dto.setPhone(info.getPhone());
		dto.setSecurityQuestion1(info.getSecurityQuestion1());
		dto.setSecurityQuestion2(info.getSecurityQuestion2());
		dto.setSecurityAnswer1(info.getSecurityAnswer1());
		dto.setSecurityAnswer2(info.getSecurityAnswer2());
		
		if (info.getAddress()==null) {
			return dto;
		}
		
		dto.setStreetName(info.getAddress().getStreetName());
		dto.setCityName(info.getAddress().getCityName());
		dto.setState(info.getAddress().getState());
		dto.setZipCode(info.getAddress().getZipCode());
		System.out.println(dto);
		return dto;
	}
	//http://localhost:8080/user/profile
	
	
	@PutMapping("/user/profile")
	public void profileEdit(Principal pricipal, @RequestBody UsersDto dto) {
		
	
		String streetName = dto.getStreetName();
		String cityName = dto.getCityName();
		String state=dto.getState();
		Integer zipCode=dto.getZipCode();
		
		
		String username = pricipal.getName();
		
		UserInfo info = userInfoRepository.getByUsername(username);
		
		if (info.getAddress()== null) {
								
			Address address = new Address();
					
			address.setCityName(cityName);
			address.setState(state);
			address.setStreetName(streetName);
			address.setZipCode(zipCode);
			addressRepository.save(address);
			
			info.setAddress(address);
		
		}
		
		info.setFirstName(dto.getFirstName());
		info.setLastName(dto.getLastName());
		info.setPhone(dto.getPhone());
		info.setSecurityAnswer1(dto.getSecurityAnswer1());
		info.setSecurityAnswer2(dto.getSecurityAnswer2());
		info.setSecurityQuestion1(dto.getSecurityQuestion1());
		info.setSecurityQuestion2(dto.getSecurityQuestion2());
		info.getAddress().setCityName(cityName);
		info.getAddress().setState(state);
		info.getAddress().setStreetName(streetName);
		info.getAddress().setZipCode(zipCode);
		
		userInfoRepository.save(info);

//		userInfoRepository.updateProfile(
//				username,
//				dto.getFirstName(),
//				dto.getLastName(),
//				dto.getPhone(),
//				dto.getSecurityQuestion1(),
//				dto.getSecurityQuestion2(),
//				dto.getSecurityAnswer1(),
//				dto.getSecurityAnswer2(),
//				dto.getStreetName(),
//				dto.getCityName(),
//				dto.getState(),
//				dto.getZipCode()
//				);
	}


}
