package com.BSR.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tripschedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private String tripDate;
	private int avalableSeats;
	private int tripDetail;
	private int ticketSold;
	
	public int getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(int tripDetail) {
		this.tripDetail = tripDetail;
	}





	

//	@OneToOne
//	@JoinColumn(name = "trip", referencedColumnName = "trip")
//	private Trip trip;
	

	public int getId() {
		return _id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvalableSeats() {
		return avalableSeats;
	}

	public void setAvalableSeats(int avalableSeats) {
		this.avalableSeats = avalableSeats;
	}

//	public Trip getTrip() {
//		return trip;
//	}
//
//	public void setTrip(Trip trip) {
//		this.trip = trip;
//	}

	public int getTicketSold() {
		return ticketSold;
	}

	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}

	
	

	public Tripschedule(String tripDate, int avalableSeats, int tripDetail, int ticketSold) {
		super();
		this.tripDate = tripDate;
		this.avalableSeats = avalableSeats;
		this.tripDetail = tripDetail;
		this.ticketSold = ticketSold;
	}

	public Tripschedule() {
		
	}
	
	


	
	

}
