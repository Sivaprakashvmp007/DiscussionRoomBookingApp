package com.exterro.discussionRoomBookingApp.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exterro.discussionRoomBookingApp.entity.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer> {
	@Query(nativeQuery=true,value="select * from booking where room_id=?1 and date=?2")
	List<Booking> findByRoomAndDate(String roomId,Date date);
}
