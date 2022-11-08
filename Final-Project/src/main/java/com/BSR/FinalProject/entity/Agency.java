package com.BSR.FinalProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;
	private String code;
	private String name;
	private String details;
	private int owner;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public Agency(String code, String name, String details, int owner) {
		this.code = code;
		this.name = name;
		this.details = details;
		this.owner = owner;
	}

	public Agency() {

	}
	
	@Override
	public String toString() {
		return "Agency [_id=" + _id + ", code=" + code + ", name=" + name + ", details=" + details + ", owner=" + owner
				+ "]";
	}

	
	

}
