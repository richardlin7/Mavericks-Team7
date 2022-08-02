package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
