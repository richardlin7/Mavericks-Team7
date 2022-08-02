package com.librarysystem.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.main.model.Address;
import com.librarysystem.main.repository.AddressRepository;

@RestController
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/address")
	public List<Address> getAllAddress() {
		
		return addressRepository.findAll();
		
	}
	
	@PostMapping("/address")
	public Address insertAddress(@RequestBody Address address) {
		
		return addressRepository.save(address);
		
	}
	@DeleteMapping("/address/{id}")
	public void deleteAddressById(@PathVariable("id") Long id) {
		
		Optional<Address> opt = addressRepository.findById(id);
		if (!opt.isPresent()) {
			throw new RuntimeException("Id is Invalid");
		}
		Address address = opt.get();
		
		 addressRepository.delete(address);
	}

}
