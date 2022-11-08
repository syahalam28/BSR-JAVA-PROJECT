package com.BSR.FinalProject.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSR.FinalProject.entity.Role;
import com.BSR.FinalProject.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

//CRUD Service
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}
}
