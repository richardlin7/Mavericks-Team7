package com.librarysystem.main.repository;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.librarysystem.main.model.Address;
import com.librarysystem.main.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getUserInfoByUserName(String username);

	@Query("select u from UserInfo u where u.username=?1")
	Optional<UserInfo> findByUsername(String username);

	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);

	
	@Transactional
	@Modifying
	@Query("update UserInfo u SET u.password=?2,u.passwordLastReset=?3 where u.username=?1")
	void resetPassword(String username, String encodedPassword, LocalDate date);

//	
//	@Transactional
//	@Modifying
//	@Query("delete from UserInfo u where u.id?=1 and u.address?=2")
//	void deleteUserById(Long uId, Address address);

//	void deleteUserById(Long uId, Address address);

	
//	@Transactional
//	@Modifying
//	@Query("update UserInfo u SET u.firstName=?2,u.lastName=?3,u.phone=?4,u.securityQuestion1=?5,u.securityQuestion2=?6,"
//			+ "u.securityAnswer1=?7,u.securityAnswer2=?8,"
//			+ "u.address.streetName=?9,u.address.cityName=?10,u.address.state=?11,u.address.zipCode=?12"
//			+ " where u.username=?1")
//	void updateProfile(String username, String firstName, String lastName, String phone, String securityQuestion1,
//			String securityQuestion2, String securityAnswer1, String securityAnswer2, String streetName,
//			String cityName, String state, Integer zipCode);

//	@Transactional
//	@Modifying
//	@Query("update UserInfo u SET u.address=?2 where u.username=?1")
//	void insertAddId(String username, Long addressId);
	
	
	

}
