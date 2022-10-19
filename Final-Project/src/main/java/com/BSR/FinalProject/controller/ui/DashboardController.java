package com.BSR.FinalProject.controller.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BSR.FinalProject.dto.TripScheduleDto;
import com.BSR.FinalProject.dto.TripsStopDto;
import com.BSR.FinalProject.entity.Stop;
import com.BSR.FinalProject.repository.StopRepository;
import com.BSR.FinalProject.repository.TripRepository;
import com.BSR.FinalProject.repository.TripScheduleRepository;
import com.BSR.FinalProject.service.StopService;

@Controller
@RequestMapping("/book")
public class DashboardController {
	@Autowired
	TripRepository tripRepository;
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	@Autowired
	StopRepository stopRepository;

	@GetMapping("/list")
	public String GetAllStop(Model model) {
		List<TripsStopDto> stops = tripRepository.getAllTripStop();
		model.addAttribute("stops", stops);
		return "main_layout";

	}

	@GetMapping("/list/schedule")
	public String GetSchedule(Model model) {
		List<TripScheduleDto> schedule = tripScheduleRepository.getTripSchedule();
		model.addAttribute("schedule", schedule);
		return "second_layout";
	}
	
	@GetMapping("/list/stop")
	public String GetStop(Model model) {
		List<Stop> stops = stopRepository.findAll();
		model.addAttribute("stops",stops);
		return "stop";
	}

}
