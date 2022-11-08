package com.BSR.FinalProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Role;
import com.BSR.FinalProject.repository.RoleRepository;
import com.BSR.FinalProject.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {
	@Autowired
	RoleService roleService;

	// Todo Add Role
	@PostMapping("/role")
	public ResponseEntity<Role> add(@RequestBody Role role) {
		roleService.saveRole(role);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

}
