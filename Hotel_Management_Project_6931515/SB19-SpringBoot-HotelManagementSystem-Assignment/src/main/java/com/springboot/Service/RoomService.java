package com.springboot.Service;

import com.springboot.Entity.Room;


import java.util.*;

import org.springframework.http.ResponseEntity;

public interface RoomService {
	public ResponseEntity<String> createRoom(Room room);
	public List<Room> getAllRooms();
	public Room getRoombyId(String id);
	public ResponseEntity<String> updateRoom(String id, Room room);
	public ResponseEntity<String> deleteRoom(String id);
	
	
}
