package com.BSR.FinalProject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BSR.FinalProject.entity.Ticket;
import com.BSR.FinalProject.entity.User;
import com.BSR.FinalProject.repository.TicketRepository;
import com.BSR.FinalProject.service.UserService;

@RestController
@RequestMapping("/api/v1/reservation")
public class TicketController {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	UserService userService;

	@PostMapping("/bookticket")
	public String create(@RequestBody Map<String, String> body) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User u = userService.getUsername(userDetails.getUsername());

		User u = userService.getUsername(userDetails.getUsername());
		int idU = u.get_id();
		int idA = u.getRolesId();
		int seatNumber = Integer.parseInt(body.get("seatNumber"));
		int cancellable = Integer.parseInt(body.get("cancellable"));
		String journeyDate = body.get("journeyDate");
		if (idA == 1) {
			ticketRepository.save(new Ticket(seatNumber, cancellable, journeyDate, idU));
			return "Berhasil Tambah Data";

		}
		return "Mohon Maaf ! Pemesanan Melalui Admin";

	}

}
