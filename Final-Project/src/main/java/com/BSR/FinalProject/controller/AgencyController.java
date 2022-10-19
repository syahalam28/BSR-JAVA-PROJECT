package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Agency;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.AgencyRepository;
import com.BSR.FinalProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AgencyController {

	@Autowired
	UserService userService;
	
	final private AgencyRepository agencyRepository;

	public AgencyController(AgencyRepository agencyRepository) {
		this.agencyRepository = agencyRepository;
	}
	
	
	@PostMapping("/api/agency")
	public Boolean create(HttpServletRequest request, @RequestBody Map<String, String> body)
			throws NoSuchAlgorithmException {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int idU = u.get_id();
		int idR = u.getRolesId();
		String code = body.get("code");
		String name = body.get("name");
		String details = body.get("details");
		agencyRepository.save(new Agency(code, name, details, idU));

//		log.info("he" + idU);
		return true;
	}

}
