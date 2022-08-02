package com.springboot.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookstore.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
