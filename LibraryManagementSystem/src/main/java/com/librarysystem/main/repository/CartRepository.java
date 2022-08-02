package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
