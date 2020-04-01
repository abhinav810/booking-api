package com.hotel.booking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.exception.ResourceNotFoundException;
import com.hotel.booking.model.Booking;
import com.hotel.booking.model.Room;
import com.hotel.booking.model.User;
import com.hotel.booking.repository.RoomRepository;
import com.hotel.booking.repository.UserRepository;;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String createBooking(@Valid Booking booking) {
		User user = userRepository.findById(booking.getUser()).get();
		Room room = roomRepository.findById(booking.getRoom()).get();
		
		if (!room.getStatus().equals("BOOKED")) {
			if (user.getBonusPoints() >= room.getPrice()) {
				room.setStatus("BOOKED");
				user.setBonusPoints(user.getBonusPoints() - room.getPrice());
			} else {
				room.setStatus("PENDING_APPROVAL");
				room.setRemainingAmount(room.getPrice() - user.getBonusPoints());
				user.setBonusPoints(0d);
			}
			userRepository.save(user);
			room.setUser(user);
			roomRepository.save(room);
		} else
			room.setStatus("CANNOT_BE_BOOKED");
		
		return room.getStatus();
	}

	@Override
	public List<Room> showBookings() {
		return roomRepository.findAll();
	}

	@Override
	public Room findById(Long roomId) throws ResourceNotFoundException {
		return roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + roomId));
	}

	@Override
	public List<Room> updatePoints(@Valid Booking booking) {
		User user = userRepository.findById(booking.getUser()).get();
		user.setBonusPoints(user.getBonusPoints() + booking.getBonusPoints());
		userRepository.save(user);
		
		List<Room> bookedRooms = roomRepository.findByUserAndStatus(user, "PENDING_APPROVAL");
		for (Room room : bookedRooms) {
			if (user.getBonusPoints() >= room.getPrice()) {
				room.setStatus("BOOKED");
				user.setBonusPoints(user.getBonusPoints() - room.getRemainingAmount());
				userRepository.save(user);
				room.setUser(user);
				room.setRemainingAmount(0d);
				roomRepository.save(room);
			}
		}
		return bookedRooms;
	}
	
	
}
