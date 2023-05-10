package com.exterro.discussionRoomBookingApp.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee empId;
	
	@ManyToOne
	@JoinColumn(name = "roomId")
	private Room roomId;
	
	private Date date;
	
	private String slot;

	public Booking() {
		super();
	}

	public Booking( Employee empId, Room roomId, Date date, String slot) {
		super();
		
		
		this.empId = empId;
		this.roomId = roomId;
		this.date = date;
		this.slot = slot;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Employee getEmpId() {
		return empId;
	}

	public void setEmpId(Employee empId) {
		this.empId = empId;
	}

	public Room getRoomId() {
		return roomId;
	}

	public void setRoomId(Room roomId) {
		this.roomId = roomId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", employee=" + empId + ", room=" + roomId + ", date=" + date
				+ ", slot=" + slot + "]";
	}
}
