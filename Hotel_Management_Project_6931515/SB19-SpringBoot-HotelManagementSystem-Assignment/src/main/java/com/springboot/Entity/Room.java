package com.springboot.Entity;

import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;
@Entity
@Table(name="ROOM")
public class Room {
	
	@Id
	@Column
	private String roomId;
	
	@Column(name="roomType", length=20)
	private String roomType;
	
	@Column(name="price")
	private int price;
	
	@Column(name="status")
	private String status;
	
	@JsonManagedReference
	@OneToMany(mappedBy="room", cascade = CascadeType.ALL)
	private List<Booking> bookings;
	
	
	

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomNumber) {
		this.roomId = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
