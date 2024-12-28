package com.noyon.main.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BookingDTO {

	private int id;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	
	private int numOfAdults;
	private int numOfChildren;
	private int totalNumOfGuest;
	private String code;
	
	private UserDTO user;
	private RoomDTO room;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public int getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public int getTotalNumOfGuest() {
		return totalNumOfGuest;
	}
	public void setTotalNumOfGuest(int totalNumOfGuest) {
		this.totalNumOfGuest = totalNumOfGuest;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public RoomDTO getRoom() {
		return room;
	}
	public void setRoom(RoomDTO room) {
		this.room = room;
	}
	public BookingDTO(int id, LocalDate checkInDate, LocalDate checkOutDate, int numOfAdults, int numOfChildren,
			int totalNumOfGuest, String code, UserDTO user, RoomDTO room) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfAdults = numOfAdults;
		this.numOfChildren = numOfChildren;
		this.totalNumOfGuest = totalNumOfGuest;
		this.code = code;
		this.user = user;
		this.room = room;
	}
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
