package com.exterro.discussionRoomBookingApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.entity.Room;

@Service
public interface RoomService {

	public Room addRoom(Room room);
	public Room getRoom(String roomId);
	public List<Room> getAllRoom();
	public Room updateRoom(Room Room);
	public String deleteRoom(String roomId);
}
