package com.capstone.RentAPlaceAdmin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.RentAPlaceAdmin.dao.Booking;
import java.util.List;


public interface BookingRepo extends JpaRepository<Booking, Integer>  {

	List<Booking> findByUserId(int userId);
}
