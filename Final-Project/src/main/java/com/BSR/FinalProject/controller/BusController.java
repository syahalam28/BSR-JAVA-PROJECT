package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Agency;
import com.BSR.FinalProject.entity.Bus;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.BusRepository;
import com.BSR.FinalProject.service.AgencyService;
import com.BSR.FinalProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BusController {
	final private BusRepository busRepository;

	public BusController(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	@Autowired
	UserService userService;

	@Autowired
	AgencyService agencyService;

	@PostMapping("/api/bus")
	public String create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int idU = u.get_id();
		String code = body.get("code");
		String capasity = body.get("capasity");
		int ParseCap = Integer.parseInt(capasity);
		String make = body.get("make");
		int agency = Integer.parseInt(body.get("agency"));
		List<Agency> agencys = agencyService.getOwner(idU);
		Boolean result = agencys.stream().filter(o -> o.get_id() == agency).findFirst().isPresent();
		
		if (result == true) {
			busRepository.save(new Bus(code, ParseCap, make, agency));
			return "Berhasil Tambah Data";
			
		}
		else {
			return "Bus Tidak Sesuai Agensi";
		}

	}

}
