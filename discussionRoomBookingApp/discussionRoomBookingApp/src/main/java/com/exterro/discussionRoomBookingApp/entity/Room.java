package com.exterro.discussionRoomBookingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Room {
	@Id
	private String roomId;
	private String roomName;
	private String seating;
	public Room() {
		super();
	}
	public Room(String roomId, String roomName, String seating) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.seating = seating;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getSeating() {
		return seating;
	}
	public void setSeating(String seating) {
		this.seating = seating;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", seating=" + seating + "]";
	}
	
	
	
	
	
}
