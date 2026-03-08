package com.springboot.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.Entity.Room;
import com.springboot.Repository.RoomRepository;
import com.springboot.Service.RoomService;
import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomRepository rr;
	
	@Override
	public ResponseEntity<String> createRoom(Room room) {
		rr.save(room);
		
		return new ResponseEntity<>("Room created", HttpStatus.CREATED);
	}
	
	@Override
	public List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<Room>();
		
		rr.findAll().forEach(r1 -> rooms.add(r1));
		
		return rooms;
	}
	@Override
	public Room getRoombyId(String id) {
		return rr.findById(id).get();
	}
	
	@Override
	public ResponseEntity<String> updateRoom(String id, Room room) {
		
		Optional<Room> opt = rr.findById(id);

		if(!opt.isPresent()) {
		    return new ResponseEntity<>("Room Not Found", HttpStatus.BAD_REQUEST);
		}

		Room r = opt.get();
		
//	agar yaha dikkat aayi to theek kr lena
		 r.setRoomType(room.getRoomType());
		 r.setPrice(room.getPrice());
		 r.setStatus(room.getStatus());
		rr.save(r);
		
		return new ResponseEntity<>("Room Updated", HttpStatus.OK);
		
	}

	

	@Override
	public ResponseEntity<String> deleteRoom(String id) {
		// TODO Auto-generated method stub
		Optional<Room> opt = rr.findById(id);

		if(!opt.isPresent()) {
		    return new ResponseEntity<>("Room Not Found", HttpStatus.BAD_REQUEST);
		}

		Room r = opt.get();
		
		rr.deleteById(id);
		
		return new ResponseEntity<>("Room deleted", HttpStatus.OK);
		
		
		
	}
	
	

}
