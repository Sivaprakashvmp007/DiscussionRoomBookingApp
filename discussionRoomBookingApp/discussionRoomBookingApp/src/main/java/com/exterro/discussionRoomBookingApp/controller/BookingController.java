package com.exterro.discussionRoomBookingApp.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exterro.discussionRoomBookingApp.entity.Booking;
import com.exterro.discussionRoomBookingApp.entity.Employee;
import com.exterro.discussionRoomBookingApp.entity.Room;
import com.exterro.discussionRoomBookingApp.service.BookingService;
import com.exterro.discussionRoomBookingApp.service.EmployeeService;
import com.exterro.discussionRoomBookingApp.service.RoomService;

//adding controller annotation 
@Controller
public class BookingController {

	// adding autowired annotation to create required beans
	@Autowired
	private BookingService bookingService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoomService roomService;

	@RequestMapping("addBooking")
	@ResponseBody
	public String addBooking(String empId, String roomId, Date date, String slot) {
	    Booking booking1 = null;
	    if (bookingService.checkAvailability(roomId, date, slot).equalsIgnoreCase("SLOT AVAILABLE")) {
	        Employee employee = employeeService.getEmployee(empId);
	        Room room = roomService.getRoom(roomId);
	        Booking booking = new Booking(employee, room, date, slot);
	        booking1 = bookingService.addBooking(booking);
	    }

	    if (booking1 != null) {
	        return "<body>\r\n"
	                + "<p>Booking Successful..Confirmation Mail has Sent..Thank you!!! </p><br>\r\n"
	                + "<p>Do u want to cancel booking...</p>\r\n"
	                + "<br>\r\n"
	                + "<form action=\"deleteBooking\">\r\n"
	                + "Delete<input type=\"hidden\" name=\"bookingId\" value='" + booking1.getBookingId()
	                + "'><input type=\"submit\" value=\"Cancel Booking\">\r\n"
	                + "</form>"
	                + "</body>";
	    } else {
	        return "Slot already booked";
	    }
	}

	
	@RequestMapping("viewBooking") 
	@ResponseBody
	public Booking viewBooking(int bookingId) {
		return bookingService.getBooking(bookingId);
	}

	@RequestMapping("viewAllBooking")
	@ResponseBody
	public String viewAllBooking() {
		String result = "<h2>Booking List</h2><table><tr><th>Booking ID</th><th>Employee Name</th><th>Room Id</th><th>Date</th><th>Slot</th></tr>";
		List<Booking> bookings = bookingService.getAllBooking();
		System.out.println(bookings);
		for (Booking booking : bookings) {
			result += "<tr><td>" + booking.getBookingId() + "</td><td>" + booking.getEmpId().getEmpName() + "</td><td>"
					+ booking.getRoomId().getRoomId() + "</td><td>" + booking.getDate() + "<td><td>" + booking.getSlot()
					+ "</td></tr>";
		}
		result += "</table>";
		return result;
	}

	@RequestMapping("updateBooking")
	@ResponseBody
	public String updateBooking(Booking booking) {
		return bookingService.updateBooking(booking).toString();
	}

	@RequestMapping("deleteBooking")
	@ResponseBody
	public String deleteBooking(int bookingId) {
		return bookingService.deleteBooking(bookingId);
	}

}
