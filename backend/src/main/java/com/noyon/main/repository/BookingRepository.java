package com.noyon.main.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noyon.main.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Optional<Booking>findByCode(String confirmationCode);
}
