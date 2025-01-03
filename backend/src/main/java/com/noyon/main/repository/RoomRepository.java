package com.noyon.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.noyon.main.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	
	@Query(value="SELECT DISTINC r.roomType FROM Room r",nativeQuery = true)
	List<String> findDistinctRoomTypes();
	
	@Query(value="SELECT r FROM Room WHERE r.id NOT IN (SELECT b.room.id FROM Booking b)",nativeQuery=true)
	List<Room>findAllAvailableRooms();
	
	 @Query(value="SELECT r FROM Room r WHERE r.roomType LIKE %:roomType% AND r.id NOT IN (SELECT bk.room.id FROM Booking bk WHERE" +
	            "(bk.checkInDate <= :checkOutDate) AND (bk.checkOutDate >= :checkInDate))")
	List<Room> findAvailableRoomsByDateAndTypes(LocalDate checkInDate,LocalDate checkOutDate,String roomType);
	 
	 
}
