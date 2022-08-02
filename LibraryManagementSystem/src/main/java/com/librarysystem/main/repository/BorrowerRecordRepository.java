package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.BorrowerRecord;

public interface BorrowerRecordRepository extends JpaRepository<BorrowerRecord, Long> {

}
