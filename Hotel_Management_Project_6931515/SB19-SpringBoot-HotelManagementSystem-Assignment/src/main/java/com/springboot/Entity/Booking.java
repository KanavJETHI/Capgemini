package com.springboot.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="BOOKING")
public class Booking {
	
	@Id
	private int bookingId;
	
	private String customerName;
	
	private String customerPhone;
	
	private String checkIn;
	private String checkOut;
	
	
	
	public int getBookingId() {
		return bookingId;
	}



	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerPhone() {
		return customerPhone;
	}



	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}



	public String getCheckIn() {
		return checkIn;
	}



	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}



	public String getCheckOut() {
		return checkOut;
	}



	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}



	public Room getRoom() {
		return room;
	}



	public void setRoom(Room room) {
		this.room = room;
	}


	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="roomId", nullable=false)
	private Room room;
	
}
