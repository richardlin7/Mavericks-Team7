package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}
