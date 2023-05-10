package com.exterro.discussionRoomBookingApp.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.dao.BookingDao;
import com.exterro.discussionRoomBookingApp.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Booking addBooking(Booking booking) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(booking.getEmpId().getEmpEmail());
		message.setSubject("Room booking confirmation");
		message.setText("Dear " + booking.getEmpId().getEmpName() + ", your room booking is confirmed on "+ booking.getDate()+" "+" in "+booking.getSlot()+" slot"+" for room number"+booking.getRoomId().getRoomId()+"..Thank you ..always welcome");
		mailSender.send(message);		
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
		if (booking1 != null) {
			bookingDao.delete(booking1);
		}
		return bookingDao.save(booking);
	}

	@Override
	public String deleteBooking(int bookingId) {
		Booking booking1 = bookingDao.findById(bookingId).orElse(null);
		if (booking1 != null) {
			bookingDao.delete(booking1);
			return "Booking Deleted Successfully";
		}
		return "Booking Unavailable";
	}

	@Override
	public String checkAvailability(String roomId, Date date, String slot) {
		List<Booking> bookingList = bookingDao.findByRoomAndDate(roomId, date);

		for (Booking booking : bookingList) {
			if (booking.getSlot().equalsIgnoreCase(slot)) {
				return "SLOT ALREADY BOOKED";
			}
		}
		return "SLOT AVAILABLE";
	}

}
