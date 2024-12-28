package com.noyon.main.entity;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "check in data is required")
	private LocalDate checkInDate;
	@Future(message = "check out date must be in future")
	private LocalDate checkOutDate;
	
	@Min(value = 1,message = "number of adults should not be less than one")
	private int numOfAdults;
	@Min(value = 0,message = "number of children should not be less than zero")
	private int numOfChildren;
	private int totalNumofGuests;
	
	private String code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "room_id")
	private Room room;

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
		calculateTotalNumberOfGuests();
	}

	public int getNumOfChildren() {
		return numOfChildren;
	}

	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumberOfGuests();
	}

	public int getTotalNumofGuests() {
		return totalNumofGuests;
	}

	public void setTotalNumofGuests(int totalNumofGuests) {
		this.totalNumofGuests = totalNumofGuests;
	}

	public String getCode() {
		return code;
	}

	public void setBookingConfirmationCode(String code) {
		this.code = code;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Booking(int id, LocalDate checkInDate, LocalDate checkOutDate, int numOfAdults, int numOfChildren,
			int totalNumofGuests, String code, User user, Room room) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfAdults = numOfAdults;
		this.numOfChildren = numOfChildren;
		this.totalNumofGuests = totalNumofGuests;
		this.code = code;
		this.user = user;
		this.room = room;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public void calculateTotalNumberOfGuests()
	{
		this.totalNumofGuests=this.numOfAdults+this.numOfChildren;
				
	
	}
}
