package com.exterro.discussionRoomBookingApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee getEmployee(String empId);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee Employee);
	public String deleteEmployee(String empId);
	
	String validateEmployee(String empEmail,String empPassword);
	public boolean employeeLogin(Employee employee);
}
