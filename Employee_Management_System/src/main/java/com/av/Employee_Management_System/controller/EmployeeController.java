package com.av.Employee_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.av.Employee_Management_System.entity.Employee;
import com.av.Employee_Management_System.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/save")
	public String insertData(@RequestBody Employee e) {
		String msg = service.insertData(e);
		return msg;
	}
	
	@DeleteMapping("/delete/{eId}")
	public String deleteData(@PathVariable int eId) {
		String msg = service.deleteData(eId);
		return msg;
	}
	
	@PutMapping("/update/{eId}")
	public String updateData(@RequestBody Employee e ,@PathVariable int eId) {
		String msg = service.updateData(e, eId);
		return msg;
	}
	
	@GetMapping("/getSingleRecord/{eId}")
	public Employee getSingleRecord(@PathVariable int eId) {
		Employee e1 = service.getSingleRecord(eId);
		return e1;
	}
	
	@GetMapping("/getAllData")
	public List<Employee> getAllData() {
		List<Employee> list = service.getAllData();
		return list;
	}
	

}
