package com.BSR.FinalProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BSR.FinalProject.entity.Agency;
import com.BSR.FinalProject.repository.AgencyRepository;

@Service
@Transactional
public class AgencyService {
	@Autowired
	AgencyRepository agencyRepository;
	public List<Agency> getOwner (int owner) {
		return agencyRepository.findByOwner(owner);
	}
	
//	public Agency getOwner(int owner) {
//		return agencyRepository.findByOwner(owner);
//	}

}
