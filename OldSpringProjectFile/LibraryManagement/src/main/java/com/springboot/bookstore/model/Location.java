package com.springboot.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String street_name;
	
	@Column(nullable = false)
	private String city_name;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private Integer zip_code;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(Long id, String street_name, String city_name, String state, Integer zip_code) {
		super();
		this.id = id;
		this.street_name = street_name;
		this.city_name = city_name;
		this.state = state;
		this.zip_code = zip_code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip_code() {
		return zip_code;
	}

	public void setZip_code(Integer zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", street_name=" + street_name + ", city_name=" + city_name + ", state=" + state
				+ ", zip_code=" + zip_code + "]";
	}
	
	
	
	

}
