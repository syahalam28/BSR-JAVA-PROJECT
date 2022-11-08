package com.BSR.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private int fare;
	private String journeyTime;
	private int sourceStop;
	private int desStop;
	private int bus;
	private int agency;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getJourneyTime() {
		return journeyTime;
	}
	public void setJourneyTime(String journeyTime) {
		this.journeyTime = journeyTime;
	}
	public int getSourceStop() {
		return sourceStop;
	}
	public void setSourceStop(int sourceStop) {
		this.sourceStop = sourceStop;
	}
	public int getDesStop() {
		return desStop;
	}
	public void setDesStop(int desStop) {
		this.desStop = desStop;
	}
	public int getBus() {
		return bus;
	}
	public void setBus(int bus) {
		this.bus = bus;
	}
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}
	public Trip(int fare, String journeyTime, int sourceStop, int desStop, int bus, int agency) {
		super();
		this.fare = fare;
		this.journeyTime = journeyTime;
		this.sourceStop = sourceStop;
		this.desStop = desStop;
		this.bus = bus;
		this.agency = agency;
	}
	public Trip() {
		
	}
	
//	@OneToOne(mappedBy = "trip")
//	private Tripschedule tripschedule;
	
	
	
	
	
	
	
}
