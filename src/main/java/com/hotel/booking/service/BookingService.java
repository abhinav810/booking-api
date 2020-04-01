package com.hotel.booking.service;

import java.util.List;

import javax.validation.Valid;

import com.hotel.booking.exception.ResourceNotFoundException;
import com.hotel.booking.model.Booking;
import com.hotel.booking.model.Room;

public interface BookingService {

	String createBooking(@Valid Booking booking);

	List<Room> showBookings();

	Room findById(Long roomId) throws ResourceNotFoundException;

	List<Room> updatePoints(@Valid Booking booking);
	
}
