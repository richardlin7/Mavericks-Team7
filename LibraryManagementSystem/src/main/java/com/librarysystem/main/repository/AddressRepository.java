package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
