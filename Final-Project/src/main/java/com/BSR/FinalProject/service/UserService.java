package com.BSR.FinalProject.service;

import java.lang.StackWalker.Option;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.attoparser.config.ParseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Role;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.RoleRepository;
import com.BSR.FinalProject.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

//CRUD
//Todo Select All User
	
	public User getUsername(String username) {
		return userRepository.findByemail(username);
	}
	
	public List<User> listAllUser() {
		return userRepository.findAll();
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	
	public User getRole (int rolesId) {
		return userRepository.findByrolesId(rolesId);
	}
	
//	Todo Get User By Id
public User getUser(Integer id) {
	Optional<User> userOptional = userRepository.findById(id);
	if (userOptional.isPresent()) {
		
		return userOptional.get();
		
	}
	
	return null;
}













}
