package com.exterro.discussionRoomBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exterro.discussionRoomBookingApp.entity.Room;
import com.exterro.discussionRoomBookingApp.entity.Room;
import com.exterro.discussionRoomBookingApp.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping("addRoom")
	@ResponseBody
	public String addRoom(Room room) {
		Room room1=roomService.addRoom(room);
		return (room1 !=null)?"Room Successfully Added":"failed to add room";
	}
	@RequestMapping("viewRoom")
	@ResponseBody
	public Room viewRoom(String roomId) {
		return roomService.getRoom(roomId);
	}
	
	@RequestMapping("viewAllRoom")
	@ResponseBody
	public String viewAllRoom() {
	    String result = "<h2>Room List</h2>";
	    result += "<table style='border-collapse: collapse; width: 100%;'>";
	    result += "<tr style='background-color: #ddd;'><th style='padding: 8px; border: 1px solid #ddd;'>ID</th><th style='padding: 8px; border: 1px solid #ddd;'>Name</th><th style='padding: 8px; border: 1px solid #ddd;'>Seating</th></tr>";
	    List<Room> rooms = roomService.getAllRoom();		
	    for(Room room: rooms) {
	        result += "<tr style='border: 1px solid #ddd;'>";
	        result += "<td style='padding: 8px; border: 1px solid #ddd;'>"+room.getRoomId()+"</td>";
	        result += "<td style='padding: 8px; border: 1px solid #ddd;'>"+room.getRoomName()+"</td>";
	        result += "<td style='padding: 8px; border: 1px solid #ddd;'>"+room.getSeating()+"</td>";
	        result += "</tr>";
	    }			
	    result += "</table>";
	    return result;
	}

	
	@RequestMapping("updateRoom")
	@ResponseBody
	public String updateRoom(Room room) {
		return roomService.updateRoom(room).toString();
	}
	
	@RequestMapping("deleteRoom")
	@ResponseBody
	public String deleteRoom(String roomId) {
		return roomService.deleteRoom(roomId);
	}
	
}
