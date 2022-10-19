package com.BSR.FinalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TripScheduleDto {
	private int fare;
	private String journeyTime;
	private String tripDate;
	private int avalableSeats;
//	Stop
	private String detail;
//	Bus
	private String code;
	private int capasity;
	private String make;
	
	public TripScheduleDto(int fare, String journeyTime, String tripDate, int avalableSeats, String detail, String code,
			int capasity, String make) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.tripDate = tripDate;
		this.avalableSeats = avalableSeats;
		this.detail = detail;
		this.code = code;
		this.capasity = capasity;
		this.make = make;
	}
	
	

	
	
	
	
	

	
	
	
	
}
