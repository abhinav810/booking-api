package com.hotel.booking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.exception.ResourceNotFoundException;
import com.hotel.booking.model.Booking;
import com.hotel.booking.model.Room;
import com.hotel.booking.model.User;
import com.hotel.booking.service.BookingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	

	@GetMapping("/bookings")
	public List<Room> showBooking() {
		return bookingService.showBookings();
	}
	
	@GetMapping("/bookings/{id}") 
	public ResponseEntity<Room> getBookingById(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException { 
		Room room = bookingService.findById(roomId);
		return ResponseEntity.ok().body(room); 
	}
	
	@PostMapping("/bookings")
	public Map<String, String> createBooking(@Valid @RequestBody Booking booking) {
		String status = bookingService.createBooking(booking);
		Map<String, String> response = new HashMap<>();
		response.put("status", status);
		return response;
	}
	
	@PutMapping("/points")
	public List<Room> updatePoints(@Valid @RequestBody Booking booking) {
		return bookingService.updatePoints(booking);
	}
}
