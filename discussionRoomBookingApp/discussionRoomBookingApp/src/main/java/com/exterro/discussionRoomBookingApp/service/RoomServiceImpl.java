package com.exterro.discussionRoomBookingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.dao.RoomDao;
import com.exterro.discussionRoomBookingApp.entity.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;

	@Override
	public Room addRoom(Room room) {

		return roomDao.save(room);
	}

	@Override
	public Room getRoom(String empId) {
		return roomDao.findById(empId).orElse(new Room());
	}

	@Override
	public List<Room> getAllRoom() {
		return roomDao.findAll();
	}

	@Override
	public Room updateRoom(Room room) {
		Room room1 = roomDao.findById(room.getRoomId()).orElse(null);
		if (room1 != null) {
			roomDao.delete(room1);
		}
		return roomDao.save(room);
	}

	@Override
	public String deleteRoom(String roomId) {
		Room room1 = roomDao.findById(roomId).orElse(null);
		if (room1 != null) {
			roomDao.delete(room1);
			return "Room Deleted Successfully";
		}
		return "Room Unavailable";
	}
}
