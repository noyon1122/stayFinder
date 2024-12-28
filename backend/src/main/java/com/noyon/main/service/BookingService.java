package com.noyon.main.service;

import com.noyon.main.dto.Response;
import com.noyon.main.entity.Booking;

public interface BookingService {

	  Response saveBooking(int rooId, int userId, Booking bookingRequest);
	    Response findBookingByConfirmationCode(String confirmationCode);
	    Response getAllBookings();
	    Response cancelBooking(int bookingId);
}
