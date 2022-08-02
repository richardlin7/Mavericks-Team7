package com.librarysystem.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.main.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
