package com.BSR.FinalProject.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.dto.TripScheduleDto;
import com.BSR.FinalProject.entity.Ticket;
import com.BSR.FinalProject.entity.Tripschedule;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.TicketRepository;
import com.BSR.FinalProject.repository.TripScheduleRepository;
import com.BSR.FinalProject.service.UserService;

@RestController
public class TripScheduleController {

	final private TripScheduleRepository tripScheduleRepository;

	public TripScheduleController(TripScheduleRepository tripScheduleRepository) {
		this.tripScheduleRepository = tripScheduleRepository;
	}

	@Autowired
	UserService userService;

	@Autowired
	TicketRepository ticketRepository;

//     @PostMapping("/schedule/search")
//     public List<Tripschedule> search(@RequestBody Map<String, String> body){
//    	 String serachTerm = body.get("text");
//    	 return tripScheduleRepository.findByTripDate(serachTerm);
//     }

//     @GetMapping("/schedule")
//     public ResponseEntity<List<TripScheduleDto>> getAllTripSchedule(){
//    	return ResponseEntity.ok(tripScheduleRepository.getAllTripSchedule());
//     }
	@PostMapping("/api/schedule/serach")
	public ResponseEntity<List<TripScheduleDto>> search(@RequestBody Map<String, String> body) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int idU = u.get_id();
		int idR = u.getRolesId();
		String searchTrem = body.get("text");
		if (idR == 1) {
			return ResponseEntity.ok(tripScheduleRepository.getAllTripSchedule(searchTrem));
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/api/v1/reservation/ticketSchedule")
	public String create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException{
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User u = userService.getUsername(userDetails.getUsername());
		int idR = u.getRolesId();
		int idU = u.get_id();
		String tripDate = body.get("tripDate");
		int avalableSeats = Integer.parseInt(body.get("avalableSeats"));
		int tripDetail = Integer.parseInt(body.get("tripDetail"));
		int ticketSold = Integer.parseInt(body.get("ticketSold"));
//		int seatNumber = Integer.parseInt(body.get("seatNumber"));
//		int cancellable = Integer.parseInt(body.get("cancellable"));
//		String journeyDate = body.get("journeyDate");
//		Ticket ticket = ticketRepository.findBypassenger(idU);
//		int idT = ticket.get_id();
		if (idR == 1) {
			tripScheduleRepository.save(new Tripschedule(tripDate, avalableSeats, tripDetail, ticketSold));
//			ticketRepository.save(new Ticket(seatNumber, cancellable, journeyDate, idU));
			return "Berhasil Tambah Data";
		}
		return "Silahkan Menghubungi Admin";
		
		
	
	}

}
