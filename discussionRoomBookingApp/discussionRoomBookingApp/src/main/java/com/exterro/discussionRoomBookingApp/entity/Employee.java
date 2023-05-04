package com.exterro.discussionRoomBookingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity

public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private String empEmail;
	private String empPassword;
	
	public Employee() {
		super();
	}

	public Employee(String empId, String empName, String empEmail, String empPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empPassword="
				+ empPassword + "]";
	}
	
	
}
