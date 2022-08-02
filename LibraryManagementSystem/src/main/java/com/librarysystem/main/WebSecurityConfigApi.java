package com.librarysystem.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.librarysystem.main.service.MyUserDetailService;



@Configuration
public class WebSecurityConfigApi extends WebSecurityConfigurerAdapter  {
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.anyRequest().permitAll()
		
//		.antMatchers(HttpMethod.GET,"/").authenticated()
//		.antMatchers("/user").hasAnyAuthority("ADMIN")
//		.antMatchers("/user/state/{state}").hasAnyAuthority("ADMIN")
//		
//		.antMatchers(HttpMethod.DELETE,"/").authenticated()
//		.antMatchers("/user/{lId}").hasAnyAuthority("ADMIN")
//		
//		.antMatchers(HttpMethod.POST,"/").authenticated()
//		.antMatchers("/user/{lId}").hasAnyAuthority("ADMIN")
		
		//.anyRequest().permitAll()
		.and().httpBasic()
		.and().csrf().disable();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getCustomProvider());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder;
	}
	
	public DaoAuthenticationProvider getCustomProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailService);
		return dao;
	}

}
