package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.UserRepository;
import com.BSR.FinalProject.service.UserService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	UserService userService;
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	// Todo Add New User (SignUp)
	@PostMapping("/signup")
	public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException, ValidationException {
		String email = body.get("email");
		if (userRepository.existsByemail(email)) {
			throw new ValidationException("Email Alredy Existed");
		}
		String password = body.get("password");
		String encodepassword = new BCryptPasswordEncoder(BCryptVersion.$2B).encode(password);
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");
		String mobileNumber = body.get("mobileNumber");
		int rolesId = 2;
		userRepository.save(new User(email, encodepassword, firstName, lastName, mobileNumber, rolesId));
		return true;

	}
	
	@PostMapping("/signup/admin")
	public Boolean createAdmin(@RequestBody Map<String, String> body)
			throws NoSuchAlgorithmException, ValidationException {
		String email = body.get("email");
		if (userRepository.existsByemail(email)) {
			throw new ValidationException("Email Alredy Existed");
		}
		String password = body.get("password");
		String encodepassword = new BCryptPasswordEncoder(BCryptVersion.$2B).encode(password);
		String firstName = body.get("firstName");
		String lastName = body.get("lastName");
		String mobileNumber = body.get("mobileNumber");
		int rolesId = 1;
		userRepository.save(new User(email, encodepassword, firstName, lastName, mobileNumber, rolesId));
		return true;

	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int Roles = u.getRolesId();
		//log.info("Test : "+Roles);
		if (Roles == 2) {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				User _user = userOptional.get();
				_user.setEmail(user.getEmail());
				_user.setFirstName(user.getFirstName());
				_user.setLastName(user.getLastName());
				_user.setMobileNumber(user.getMobileNumber());
				_user.setRolesId(2);
//				_user.setPassword(user.getPassword());
				_user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				return new ResponseEntity<User>(userRepository.save(_user), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		}
		if (Roles == 3) {
			Optional<User> userOptional = userRepository.findById(id);
			if (userOptional.isPresent()) {
				User _user = userOptional.get();
				_user.setEmail(user.getEmail());
				_user.setFirstName(user.getFirstName());
				_user.setLastName(user.getLastName());
				_user.setMobileNumber(user.getMobileNumber());
				_user.setRolesId(3);
//				_user.setPassword(user.getPassword());
				_user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
				return new ResponseEntity<User>(userRepository.save(_user), HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		return null;
		

	}



}
