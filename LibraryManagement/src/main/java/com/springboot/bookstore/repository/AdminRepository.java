package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
