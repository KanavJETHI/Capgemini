package com.springboot.Controller;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Room;
import com.springboot.Service.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	RoomService rs;
	
	@PostMapping("/createroom")
	public ResponseEntity<String> createRoom(@RequestBody Room room) {
		rs.createRoom(room);
		
		return new ResponseEntity<>("Room created", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getallrooms")
	public List<Room> getAllRooms(){
		return rs.getAllRooms();
	}
	
	@GetMapping("/findroombyid/{id}")
	public Room findRoomById(@PathVariable String id) {
		return rs.getRoombyId(id);
	}
	
	@PutMapping("/updateroom/{id}")
	public ResponseEntity<String> updateRoom(@PathVariable String id, @RequestBody Room room){
		return rs.updateRoom(id, room);
	}
	
	@DeleteMapping("/deleteroom/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable String id){
		return rs.deleteRoom(id);
	}
}
