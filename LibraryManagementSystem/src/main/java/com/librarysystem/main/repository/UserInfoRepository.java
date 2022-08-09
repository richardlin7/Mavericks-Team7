package com.librarysystem.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.librarysystem.main.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getUserInfoByUserName(String username);

	@Query("select u from UserInfo u where u.username=?1")
	Optional<UserInfo> findByUsername(String username);

	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);

}
