package com.BSR.FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BSR.FinalProject.entity.Stop;
import com.BSR.FinalProject.repository.StopRepository;

public class StopService {
@Autowired
private StopRepository stopRepository;

public List<Stop> listAllList(){
	return stopRepository.findAll();
	
}
}
