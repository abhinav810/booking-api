package com.hotel.booking.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Booking {

	private long id;
	private long room;
	private long user;
	private double bonusPoints;
	
	public Booking() {
		
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
	
	public double getBonusPoints() {
		return bonusPoints;
	}
	public void setBonusPoints(double bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
}
