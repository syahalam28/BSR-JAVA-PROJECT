package com.BSR.FinalProject.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int _id;

	@Column(nullable = false)
	private String role;

	// Membuat Relasi One To Many
//	@OneToMany(mappedBy = "role")
//	private List<User> users;

//	Constructor Default
	public Role() {
	}

//	Constructor
	public Role(String role) {

		this.role = role;
	}

	// Constructor
//	public Role(String role, User... users) {
//		this.role = role;
//		this.users = Stream.of(users).collect(Collectors.toList());
//		this.users.forEach(x -> x.setRole(this));
//	}

//	Getter & Setter
	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public List<User> getUsers() {
//		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

}
