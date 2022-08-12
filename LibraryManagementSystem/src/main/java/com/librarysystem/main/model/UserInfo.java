package com.librarysystem.main.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.librarysystem.main.emuns.Role;
@Entity
@Table(name = "users")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String phone;
	private LocalDate passwordLastReset;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String securityQuestion1;
	@Column(nullable = false)
	private String securityQuestion2;
	@Column(nullable = false)
	private String securityAnswer1;
	@Column(nullable = false)
	private String securityAnswer2;
	@Column(nullable = false)
	private LocalDate registerDate;
	@Enumerated
	private Role role;
	@OneToOne
	private Address address;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Long id, String firstName, String lastName, String phone, String username, String password,
			String securityQuestion1, String securityQuestion2, String securityAnswer1, String securityAnswer2,
			LocalDate registerDate, Role role, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.securityQuestion1 = securityQuestion1;
		this.securityQuestion2 = securityQuestion2;
		this.securityAnswer1 = securityAnswer1;
		this.securityAnswer2 = securityAnswer2;
		this.registerDate = registerDate;
		this.role = role;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getPasswordLastReset() {
		return passwordLastReset;
	}
	public void setPasswordLastReset(LocalDate passwordLastReset) {
		this.passwordLastReset = passwordLastReset;
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
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + ", securityQuestion1=" + securityQuestion1
				+ ", securityQuestion2=" + securityQuestion2 + ", securityAnswer1=" + securityAnswer1
				+ ", securityAnswer2=" + securityAnswer2 + ", registerDate=" + registerDate + ", role=" + role
				+ ", address=" + address + "]";
	}
	
	
}
