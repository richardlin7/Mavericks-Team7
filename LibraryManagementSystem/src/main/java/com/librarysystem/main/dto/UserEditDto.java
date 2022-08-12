package com.librarysystem.main.dto;

public class UserEditDto {
	
	private Long id; 
	private String firstName;
	private String lastName; 
	private String securityAnswer1;
	private String securityQuestion1;
	private String securityAnswer2;
	private String securityQuestion2;
	
	
	public UserEditDto(Long id, String firstName, String lastName, String securityAnswer1, String securityQuestion1,
			String securityAnswer2, String securityQuestion2) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.securityAnswer1 = securityAnswer1;
		this.securityQuestion1 = securityQuestion1;
		this.securityAnswer2 = securityAnswer2;
		this.securityQuestion2 = securityQuestion2;
	}
	public UserEditDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getSecurityAnswer1() {
		return securityAnswer1;
	}
	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}
	public String getSecurityQuestion1() {
		return securityQuestion1;
	}
	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}
	public String getSecurityAnswer2() {
		return securityAnswer2;
	}
	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}
	public String getSecurityQuestion2() {
		return securityQuestion2;
	}
	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}
	@Override
	public String toString() {
		return "UserEditDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", securityAnswer1="
				+ securityAnswer1 + ", securityQuestion1=" + securityQuestion1 + ", securityAnswer2=" + securityAnswer2
				+ ", securityQuestion2=" + securityQuestion2 + "]";
	}
	
	

}
