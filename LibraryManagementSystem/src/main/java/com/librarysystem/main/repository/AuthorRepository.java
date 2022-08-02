package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
