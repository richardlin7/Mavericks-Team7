package com.springboot.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookstore.model.Location;
import com.springboot.bookstore.repository.LocationRepository;

@RestController
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;
	
	//Insert new location to DB
	@PostMapping("/address")
	public void addNewAddress(@RequestBody Location address) {
		locationRepository.save(address);
	}
	
	//Display All the location
	@GetMapping("/address")
	public List<Location> showAllAddress() {
		return locationRepository.findAll();
	}
	
	//Delete Location by ID
	//Another way we can call the API
	@RequestMapping(value = ("/address/{id}"), method = RequestMethod.DELETE)
	public void deleteAddressById(@PathVariable("id") Long id) {
		
		Optional<Location> opt = locationRepository.findById(id);
		
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		Location location=opt.get();
		locationRepository.delete(location);
		
	}
	
	//Update Location
	//Another way we can call the API
	@RequestMapping(value = "/address/{id}",method = RequestMethod.PUT)
	public Location updateAddressById(@RequestBody Location newLocation, @PathVariable("id") Long id) {
		
		Optional<Location> opt = locationRepository.findById(id);
		
		if (!opt.isPresent()) {
			throw new RuntimeException("ID Invalid");
		}
		
		Location location = opt.get();
		
		location.setCity_name(newLocation.getCity_name());
		location.setStreet_name(newLocation.getStreet_name());
		location.setZip_code(newLocation.getZip_code());
		
		return locationRepository.save(location);
		
	}

}
