package com.librarysystem.main.dto;

import java.time.LocalDate;

import com.librarysystem.main.emuns.Role;


public class UserInfoDto {
	private Long id;
	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private String username;
	
	private Role role;
	private String securityQuestion1;
	
	private String securityQuestion2;
	
	private String securityAnswer1;
	
	private String securityAnswer2;
	
	public Role getRole() {
		return role;
	}

	private String encodedCredentials;
	
	public String getEncodedCredentials() {
		return encodedCredentials;
	}


	public void setEncodedCredentials(String encodedCredentials) {
		this.encodedCredentials = encodedCredentials;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	private String password;
	
	private LocalDate registerDate;

//	private String streetName;
//	
//	
//	private String cityName;
//	
//	
//	private String state;
//	
//	
//	private Integer zipCode;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}


	public String getSecurityQuestion1() {
		return securityQuestion1;
	}


	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}


	public String getSecurityQuestion2() {
		return securityQuestion2;
	}


	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}


	public String getSecurityAnswer1() {
		return securityAnswer1;
	}


	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}


	public String getSecurityAnswer2() {
		return securityAnswer2;
	}


	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}


	
	
	

}
