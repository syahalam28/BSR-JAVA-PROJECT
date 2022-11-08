package com.BSR.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private String code;
	private int capasity;
	private String make;
	private int agency;
	
	
	
	public Bus() {

	}

	public Bus(String code, int capasity, String make, int agency) {
		this.code = code;
		this.capasity = capasity;
		this.make = make;
		this.agency = agency;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCapasity() {
		return capasity;
	}
	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getAgency() {
		return agency;
	}
	public void setAgency(int agency) {
		this.agency = agency;
	}

	
	
}
