package com.librarysystem.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String streetName;
	
	@Column(nullable = false)
	private String cityName;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private Integer zipCode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Long id, String streetName, String cityName, String state, Integer zipCode) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.cityName = cityName;
		this.state = state;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName + ", cityName=" + cityName + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}
	
	

}
