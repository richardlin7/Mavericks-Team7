package com.springboot.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.bookstore.model.AllUserDetails;
import com.springboot.bookstore.repository.AllUserDetailsRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	private AllUserDetailsRepository allUserDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AllUserDetails uInfo = allUserDetailsRepository.getUserByUserName(username);
		
		   if (uInfo==null){
	            throw  new RuntimeException("Username did not found!");
	        }
		
		List<GrantedAuthority> list = new ArrayList<>();
		
		SimpleGrantedAuthority gAuth =  new SimpleGrantedAuthority(uInfo.getRole().toString());
		list.add(gAuth);
		User user = new User(uInfo.getUsername(), uInfo.getPassword(), list);
		
		return user;
	}

}
