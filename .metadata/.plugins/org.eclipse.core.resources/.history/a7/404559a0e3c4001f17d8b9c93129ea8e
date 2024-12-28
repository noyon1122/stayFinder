package com.noyon.main.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.noyon.main.dto.Response;
import com.noyon.main.dto.RoomDTO;
import com.noyon.main.entity.Room;
import com.noyon.main.exception.CustomException;

import com.noyon.main.repository.RoomRepository;
import com.noyon.main.service.RoomService;
import com.noyon.main.utils.Utils;

@Service
public class RoomServiceImpl implements RoomService {

	
	    @Autowired
	    private RoomRepository roomRepository;
	  
//	    @Autowired
//	    private AwsS3Service awsS3Service;


	    @Override
	    public Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description) {
	        Response response = new Response();

	        try {

	           // String imageUrl = awsS3Service.saveImageToS3(photo);
	            Room room = new Room();

	           // room.setRoomPhotoUrl(imageUrl);
	            room.setRoomType(roomType);
	            room.setRoomPrice(roomPrice);
	            room.setRoomDescription(description);

	            Room savedRoom = roomRepository.save(room);
	            RoomDTO roomDTO = Utils.mapRoomEntityToRoomDTO(savedRoom);

	            response.setRoom(roomDTO);
	            response.setMessage("successful");
	            response.setStatusCode(200);

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error saving a room " + e.getMessage());

	        }
	        return response;
	    }


	    @Override
	    public List<String> getAllRoomTypes() {
	        return roomRepository.findDistinctRoomTypes();
	    }

	    @Override
	    public Response getAllRooms() {
	        Response response = new Response();

	        try {
	            List<Room> roomList = roomRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	            List<RoomDTO> roomDTOList = Utils.mapRoomListEntityToRoomListDTO(roomList);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setRoomList(roomDTOList);

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting all rooms " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response deleteRoom(int roomId) {
	        Response response = new Response();

	        try {
	            roomRepository.findById(roomId).orElseThrow(()-> new CustomException("Room Not Found"));
	            roomRepository.deleteById(roomId);

	            response.setMessage("successful");
	            response.setStatusCode(200);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error deleting a room " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response updateRoom(int roomId, String description, String roomType, BigDecimal roomPrice, MultipartFile photo) {
	        Response response = new Response();

	        try {
//	            String imageUrl = null;
//
//	            if (photo != null && !photo.isEmpty()){
//	                imageUrl = awsS3Service.saveImageToS3(photo);
//	            }

	            Room room = roomRepository.findById(roomId).orElseThrow(()-> new CustomException("Room Not Found"));
	            if(roomType != null) room.setRoomType(roomType);
	            if (roomPrice != null) room.setRoomPrice(roomPrice);
	            if (description != null) room.setRoomDescription(description);
	           // if (imageUrl != null) room.setRoomPhotoUrl(imageUrl);

	            Room updatedRoom = roomRepository.save(room);
	            RoomDTO roomDTO = Utils.mapRoomEntityToRoomDTO(updatedRoom);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setRoom(roomDTO);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error updating a room " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getRoomById(int roomId) {
	        Response response = new Response();

	        try {
	            Room room = roomRepository.findById(roomId).orElseThrow(()-> new CustomException("Room Not Found"));
	            RoomDTO roomDTO = Utils.mapRoomEntityToRoomDTOPlusBookings(room);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setRoom(roomDTO);

	        } catch (CustomException e) {
	            response.setStatusCode(404);
	            response.setMessage(e.getMessage());

	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error Getting a room By Id " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
	        Response response = new Response();

	        try {
	            List<Room> availableRooms = roomRepository.findAvailableRoomsByDateAndTypes(checkInDate, checkOutDate, roomType);
	            List<RoomDTO> roomDTOList = Utils.mapRoomListEntityToRoomListDTO(availableRooms);

	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setRoomList(roomDTOList);

	        }catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting available rooms " + e.getMessage());

	        }
	        return response;
	    }

	    @Override
	    public Response getAllAvailableRooms() {
	        Response response = new Response();

	        try {
	            List<Room> roomList = roomRepository.findAllAvailableRooms();
	            List<RoomDTO> roomDTOList = Utils.mapRoomListEntityToRoomListDTO(roomList);
	            response.setMessage("successful");
	            response.setStatusCode(200);
	            response.setRoomList(roomDTOList);

	        }catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error getting available rooms " + e.getMessage());

	        }
	        return response;
	    }
}
