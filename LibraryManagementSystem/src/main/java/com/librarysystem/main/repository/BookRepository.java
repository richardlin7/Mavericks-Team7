package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
