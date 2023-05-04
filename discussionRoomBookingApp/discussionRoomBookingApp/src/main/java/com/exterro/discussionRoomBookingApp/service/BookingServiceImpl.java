package com.exterro.discussionRoomBookingApp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.dao.BookingDao;
import com.exterro.discussionRoomBookingApp.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService  {

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public Booking addBooking(Booking booking) {
		
		return bookingDao.save(booking);
	}
	
	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.findById(bookingId).orElse(new Booking());
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingDao.findAll();
	}

	@Override
	public Booking updateBooking(Booking booking) {
		Booking booking1 = bookingDao.findById(booking.getBookingId()).orElse(null);
		if(booking1 != null) {
			bookingDao.delete(booking1);
		}
		return bookingDao.save(booking);
	}

	@Override
	public String deleteBooking(int bookingId) {
		Booking booking1 = bookingDao.findById(bookingId).orElse(null);
		if(booking1 != null) {
			bookingDao.delete(booking1);
			return "Booking Deleted Successfully";
		}
		return "Booking Unavailable";
	}
	
	@Override
	public String checkAvailability(String roomId, Date date, String slot){
		List<Booking> bookingList = bookingDao.findByRoomAndDate(roomId,date);
		System.out.println(bookingList);
		for(Booking booking:bookingList ) {
			if(booking.getSlot().equalsIgnoreCase(slot)) {
				return "SLOT ALREADY BOOKED";
			}
		}
		return "SLOT AVAILABLE";
	}

	

}
