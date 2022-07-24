package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.location.state =?1")
	List<User> getUserByState(String state);

}
