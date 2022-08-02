package com.springboot.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookstore.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("select u from Users u where u.location.state =?1")
	List<Users> getUserByState(String state);

}
