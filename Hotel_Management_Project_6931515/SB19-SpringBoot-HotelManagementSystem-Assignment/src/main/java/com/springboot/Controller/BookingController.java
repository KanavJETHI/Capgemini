package com.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Booking;
import com.springboot.Entity.Room;
import com.springboot.Service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bs;
	
	@PostMapping("/createbooking")
	public int createBooking(@RequestBody Booking booking) {
		return bs.createBooking(booking);
	}
	
	@GetMapping("/getallbookings")
	public List<Booking> getAllBookings(){
		return bs.getAllBookings();
	}
	
	@GetMapping("/findbookingbyid/{id}")
	public Booking getBookingById(@PathVariable int id) {
		return bs.getBookingById(id);
	}
	
	@PutMapping("/updatebooking/{id}")
	public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Booking booking){
		return bs.updateBooking(id, booking);
	}
	
	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<String> cancelBooking(@PathVariable int id){
		return bs.cancelBooking(id);
	}
}
