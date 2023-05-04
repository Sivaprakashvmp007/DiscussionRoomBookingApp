package com.exterro.discussionRoomBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exterro.discussionRoomBookingApp.entity.Employee;
import com.exterro.discussionRoomBookingApp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String getLogin() {
		return "employeeLogin.html";
	}
	/*
	 * @RequestMapping("index") public String getHome() { return "index.html"; }
	 */
	
	@RequestMapping("addEmployee")
	@ResponseBody
	public String addEmployee(Employee employee) {
		Employee employee1=employeeService.addEmployee(employee);
		return (employee1 !=null)?"<h1>Registration Successfull</h1><br><a href=\"employeeLogin.html\">Login</a>":"Registration Failed";
	}
	
	@RequestMapping("viewEmployee")
	@ResponseBody
	public Employee viewEmployee(String empId) {
		return employeeService.getEmployee(empId);
	}
	
	
	@RequestMapping("viewAllEmployee")
	@ResponseBody
	public String viewAllEmployee() {
	    String result = "<h2>Employee List</h2><table><tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>";
	    List<Employee> employees = employeeService.getAllEmployee();
	    for (Employee employee : employees) {
	        result += "<tr><td>" + employee.getEmpId() + "</td><td>" + employee.getEmpName() + "</td><td>" + employee.getEmpEmail() + "</td><td>" + employee.getEmpPassword() + "</td></tr>";
	    }
	    result += "</table>";
	    return result;
	}

	@RequestMapping("updateEmployee")
	@ResponseBody
	public String updateEmployee(Employee employee) {
		return employeeService.updateEmployee(employee).toString();
	}
	
	@RequestMapping("deleteEmployee")
	@ResponseBody
	public String deleteEmployee(String empId) {
		return employeeService.deleteEmployee(empId);
	}
	
	
	  @RequestMapping("validateEmployee")
	 
	  public String employeeLogin(String empEmail,String empPassword) {

		  boolean employee=true;
		  if(employeeService.validateEmployee(empEmail,empPassword).equalsIgnoreCase("Login")) {
			
			  Employee employee1=new Employee();
			  employee = employeeService.employeeLogin(employee1);
		  }
		  	  return (employee !=true)?"employeeAction.html":"failure.html";
		  }
		  
	  }
	
	 
	

