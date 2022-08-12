package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librarysystem.main.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

//	@Query("insert into Address a (a.streetName, a.cityName, a.state,a.zipCode) values(a.streetName=?1, a.cityName=?2, a.state=?3,a.zipCode=?4)")
//	void insertAddress(String streetName, String cityName, String state, Integer zipCode);

}
