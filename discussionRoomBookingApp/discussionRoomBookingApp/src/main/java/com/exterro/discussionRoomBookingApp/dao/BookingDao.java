package com.exterro.discussionRoomBookingApp.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exterro.discussionRoomBookingApp.entity.Booking;

//creating interface to communicate with repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
	//adding sql custom query.
	@Query(nativeQuery=true,value="select * from booking where room_id=?1 and date=?2")
	List<Booking> findByRoomAndDate(String roomId,Date date);
	@Query(nativeQuery=true,value="select * from booking where room_id=?1 and date=?2 and slot=?3")
	List<Booking> findByRoomAndDateAndSlot(String roomId,Date date,String slot);
	

	
}
