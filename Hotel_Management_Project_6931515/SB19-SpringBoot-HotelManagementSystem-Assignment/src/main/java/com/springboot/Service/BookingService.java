package com.springboot.Service;

import com.springboot.Entity.Booking;

import java.util.*;

import org.springframework.http.ResponseEntity;

public interface BookingService {
	public int createBooking(Booking booking);
	public List<Booking> getAllBookings();
	public Booking getBookingById(int id);
	public ResponseEntity<String> updateBooking(int id, Booking booking);
	public ResponseEntity<String> cancelBooking(int id);
}
