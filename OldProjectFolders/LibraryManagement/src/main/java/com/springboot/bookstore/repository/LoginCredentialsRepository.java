package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bookstore.model.LoginCredentials;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials, Long> {

	@Query("select u from LoginCredentials u where u.username =?1")
	LoginCredentials findByUsername(String username);

}
