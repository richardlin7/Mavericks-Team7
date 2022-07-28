package com.springboot.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.bookstore.model.AllUserDetails;

public interface AllUserDetailsRepository extends JpaRepository<AllUserDetails, Long> {

	@Query("select u from AllUserDetails u where u.location.state=?1")
	List<AllUserDetails> getUserByState(String state);

	@Query("select u from AllUserDetails u where u.username=?1")
	AllUserDetails getUserByUserName(String username);
	
	@Query("select u from AllUserDetails u where u.username=?1")
	Optional<AllUserDetails> getUsersByUserName(String username);

}
