package com.BSR.FinalProject.dto;

import lombok.Data;

@Data
public class TripsStopDto {
//	Trip
	private int fare;
	private String journeyTime;
//	Stop
	private String name;
	private String detail;
	
	public TripsStopDto(int fare, String journeyTime, String name, String detail) {
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.name = name;
		this.detail = detail;
	}
	
	public TripsStopDto() {
	
	}
	
	
	
	

	
}
