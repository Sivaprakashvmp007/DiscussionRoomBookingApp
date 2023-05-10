package com.exterro.discussionRoomBookingApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exterro.discussionRoomBookingApp.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, String> {
	@Query(nativeQuery=true,value="select * from employee where emp_email=?1 and emp_password=?2")
	
	//creating method
	List<Employee> findByEmailAndPassword(String empEmail,String empPassword);

	 @Query(nativeQuery = true, value = "select * from employee where emp_email=?1")
	 List<Employee> findByEmail(String empEmail);
}
