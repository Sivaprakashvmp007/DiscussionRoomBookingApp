package com.exterro.discussionRoomBookingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exterro.discussionRoomBookingApp.dao.EmployeeDao;
import com.exterro.discussionRoomBookingApp.entity.Booking;
import com.exterro.discussionRoomBookingApp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeDao.save(employee);
	}
	@Override
	public Employee getEmployee(String empId) {
		return employeeDao.findById(empId).orElse(new Employee());
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employee1 = employeeDao.findById(employee.getEmpId()).orElse(null);
		if(employee1 != null) {
			employeeDao.delete(employee1);
		}
		return employeeDao.save(employee);
	}

	@Override
	public String deleteEmployee(String empId) {
		Employee employee1 = employeeDao.findById(empId).orElse(null);
		if(employee1 != null) {
			employeeDao.delete(employee1);
			return "Employee Deleted Successfully";
		}
		return "Employee Unavailable";
	}

	@Override
	public String sendMail(String empEmail) {
		List<Employee> employeeList =employeeDao.findByEmail(empEmail);
		for(Employee employee:employeeList ) {
			if(employee.getEmpEmail().equals(empEmail)){
				return "SendEmail";
			}
		}
		return "Invalid";
		
	}
	@Override
	public String validateEmployee(String empEmail, String empPassword) {
		
		List<Employee> employeeList = employeeDao.findByEmailAndPassword(empEmail, empPassword);
		
		for(Employee employee:employeeList ) {
			if(employee.getEmpEmail().equals(empEmail)){
				return "Login";
			}
		}
		return "Invalid Login credientials";
	}
	@Override
	public boolean employeeLogin(Employee employee) {
		return employeeDao.equals(employee);
	}
	
	@Override
	public List<Employee> findByEmail(String empEmail) {
		
		return employeeDao.findByEmail(empEmail);
	}
	


}
