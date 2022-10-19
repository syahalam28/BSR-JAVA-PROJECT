package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.dto.TripScheduleDto;
import com.BSR.FinalProject.dto.TripsStopDto;
import com.BSR.FinalProject.entity.Stop;
import com.BSR.FinalProject.entity.Tripschedule;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.StopRepository;
import com.BSR.FinalProject.repository.TripRepository;
import com.BSR.FinalProject.repository.TripScheduleRepository;
import com.BSR.FinalProject.service.StopService;
import com.BSR.FinalProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/reservation")
public class StopController {
	@Autowired
	UserService userService;
	@Autowired
	private TripRepository tripRepository;
	@Autowired
	private TripScheduleRepository tripScheduleRepository;
	final private StopRepository stopRepository;

	public StopController(StopRepository stopRepository) {
		this.stopRepository = stopRepository;
	}

	@GetMapping("/tripschedules")
	public ResponseEntity<List<TripScheduleDto>> getTripSchedule() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int Roles = u.getRolesId();
		if (Roles == 1) {
			return ResponseEntity.ok(tripScheduleRepository.getTripSchedule());
		}

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/stop")
	public ResponseEntity<List<Stop>> list() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int Roles = u.getRolesId();
		if (Roles == 1) {
			return ResponseEntity.ok(stopRepository.findAll());
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@GetMapping("/tripsbystops")
	public ResponseEntity<List<TripsStopDto>> getAllTripStop() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int Roles = u.getRolesId();
		if (Roles == 1) {
			return ResponseEntity.ok(tripRepository.getAllTripStop());
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/stop")
	public String create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
		String code = body.get("code");
		String name = body.get("name");
		String detail = body.get("detail");

		stopRepository.save(new Stop(code, name, detail));

		return "Berhasil Tambah Data";

	}

}
