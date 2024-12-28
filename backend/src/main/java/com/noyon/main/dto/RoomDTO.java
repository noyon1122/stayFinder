package com.noyon.main.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {
	
	private int id;
	private String roomType;
	private BigDecimal roomPrice;
	private String roomDescription;
	private String roomPhotoUrl;
	private List<BookingDTO> bookings=new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public BigDecimal getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public List<BookingDTO> getBookings() {
		return bookings;
	}
	
	public String getRoomPhotoUrl() {
		return roomPhotoUrl;
	}
	public void setRoomPhotoUrl(String roomPhotoUrl) {
		this.roomPhotoUrl = roomPhotoUrl;
	}
	public void setBookings(List<BookingDTO> bookings) {
		this.bookings = bookings;
	}
	public RoomDTO(int id, String roomType, BigDecimal roomPrice, String roomDescription, List<BookingDTO> bookings) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomDescription = roomDescription;
		this.bookings = bookings;
	}
	public RoomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
