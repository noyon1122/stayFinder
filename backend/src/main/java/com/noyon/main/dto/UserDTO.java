package com.noyon.main.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private int id;
	private String email;
	private String name;
	private String phoneNumber;
	private String role;
	private List<BookingDTO> bookings=new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<BookingDTO> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}
	public UserDTO(int id, String email, String name, String phoneNumber, String role, List<BookingDTO> bookings) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.bookings = bookings;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
