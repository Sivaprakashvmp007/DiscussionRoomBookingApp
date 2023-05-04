package com.exterro.discussionRoomBookingApp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.entity.Booking;

@Service
public interface BookingService {

	public Booking addBooking(Booking booking);
	public Booking getBooking(int bookingId);
	public List<Booking> getAllBooking();
	public Booking updateBooking(Booking Booking);
	public String deleteBooking(int bookingId);
	
	
	String checkAvailability(String roomId, Date date, String slot);
	
}
