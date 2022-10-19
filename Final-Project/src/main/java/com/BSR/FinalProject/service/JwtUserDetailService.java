package com.BSR.FinalProject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.UserRepository;

@Component
public class JwtUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userInfo = userInfoRepository.findByemail(username);
		 if (userInfo == null) {
	            throw new UsernameNotFoundException("User not found with email: " + username);
	        }
		return new org.springframework.security.core.userdetails
				.User(userInfo.getEmail(), userInfo.getPassword(), new ArrayList<>());
		
//		Cara Return 2
//		User user = new User(userInfo.getUsername(), userInfo.getPassword(), new ArrayList<>());
//		return user;

		
	}






}
