package com.exterro.discussionRoomBookingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exterro.discussionRoomBookingApp.entity.Room;

public interface RoomDao extends JpaRepository<Room, String>{

}
