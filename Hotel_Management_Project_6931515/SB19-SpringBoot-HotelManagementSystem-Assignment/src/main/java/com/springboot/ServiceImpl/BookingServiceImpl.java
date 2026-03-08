package com.springboot.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.Entity.Booking;
import com.springboot.Repository.BookingRepository;
import com.springboot.Service.BookingService;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository rr;
	
	@Override
	public int createBooking(Booking booking) {
		rr.save(booking);
		
		return booking.getBookingId();
	}
	
	@Override
	public List<Booking> getAllBookings(){
		List<Booking> Bookings = new ArrayList<Booking>();
		
		rr.findAll().forEach(r1 -> Bookings.add(r1));
		
		return Bookings;
	}
	@Override
	public Booking getBookingById(int id) {
		return rr.findById(id).get();
	}
	
	@Override
	public ResponseEntity<String> updateBooking(int id, Booking booking) {	
		Optional<Booking> opt = rr.findById(id);
		
		if(!opt.isPresent()) {
			return new ResponseEntity<>("Booking not found", HttpStatus.BAD_REQUEST);
		}
		
//	agar yaha dikkat aayi to theek kr lena
			Booking r = opt.get();
		 r.setCustomerName(booking.getCustomerName());
		 r.setCustomerPhone(booking.getCustomerPhone());
		 r.setCheckIn(booking.getCheckIn());
		 r.setCheckOut(booking.getCheckOut());
		 r.setRoom(booking.getRoom());
		rr.save(r);
		
		return new ResponseEntity<>("Booking Updated", HttpStatus.OK);
		
	}

	

	@Override
	public ResponseEntity<String> cancelBooking(int id) {
		// TODO Auto-generated method stub
		
Optional<Booking> opt = rr.findById(id);
		
		if(!opt.isPresent()) {
			return new ResponseEntity<>("Booking not found", HttpStatus.BAD_REQUEST);
		}
		
//	agar yaha dikkat aayi to theek kr lena
			Booking r = opt.get();
		
		rr.deleteById(id);
		
		return new ResponseEntity<>("Booking deleted", HttpStatus.OK);
		
		
		
	}
	
	

}
