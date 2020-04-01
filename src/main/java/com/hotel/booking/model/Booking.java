package com.hotel.booking.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Booking {

	private long id;
	private long room;
	private long user;
	
	public Booking() {	
		
	}
	
	public Booking(long room, long user) {
		this.room = room;
		this.user = user;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getRoom() {
		return room;
	}
	public void setRoom(long room) {
		this.room = room;
	}
	
	public long getUser() {
		return user;
	}
	public void setUser(long user) {
		this.user = user;
	}
	
}
