package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Trip;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.TripRepository;
import com.BSR.FinalProject.service.UserService;

@RestController
public class TripController {
	@Autowired
	UserService userService;
	final private TripRepository tripRepository;

	public TripController(TripRepository tripRepository) {
		this.tripRepository = tripRepository;
	}

	@PostMapping("/api/trip/search")
	public ResponseEntity<List<Trip>> search(@RequestBody Map<String, String> body) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int idU = u.get_id();
		int idR = u.getRolesId();
		int searchTerm = Integer.parseInt(body.get("text"));
		int searchTerm2 = Integer.parseInt(body.get("text2"));
		if (idR == 1) {
			return ResponseEntity.ok(tripRepository.findBySourceStopAndDesStop(searchTerm, searchTerm2));
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/api/trip")
	public String addTrip(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException, ParseException {
		int fare = Integer.parseInt(body.get("fare"));
		String journeryTime = body.get("journeyTime");
		int sourceStrop = Integer.parseInt(body.get("sourceStop"));
		int desStop = Integer.parseInt(body.get("desStop"));
		int bus = Integer.parseInt(body.get("bus"));
		int agency = Integer.parseInt(body.get("agency"));

		tripRepository.save(new Trip(fare, journeryTime, sourceStrop, desStop, bus, agency));

		return "Data Berhasil Ditambahkan";

	}

}
