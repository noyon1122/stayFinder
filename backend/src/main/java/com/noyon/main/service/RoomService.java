package com.noyon.main.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.noyon.main.dto.Response;

public interface RoomService {

	    Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description);
	    List<String> getAllRoomTypes();
	    Response getAllRooms();
	    Response deleteRoom(int roomId);
	    Response updateRoom(int roomId, String description, String roomType, BigDecimal roomPrice, MultipartFile photo);
	    Response getRoomById(int roomId);
	    Response getAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType);
	    Response getAllAvailableRooms();
}
