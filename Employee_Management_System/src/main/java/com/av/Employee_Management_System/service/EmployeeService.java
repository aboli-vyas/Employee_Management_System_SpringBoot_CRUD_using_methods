package com.av.Employee_Management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av.Employee_Management_System.dao.EmployeeDao;
import com.av.Employee_Management_System.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	public String insertData(Employee e) {
		String msg = dao.insertData(e);
		return msg;
	}
	
	public String deleteData(int eId) {
		String msg = dao.deleteData(eId);
		return msg;
	}
	
	public String updateData(Employee e , int eId) {
		String msg = dao.updateData(e,eId);
		return msg;
	}
	
	public Employee getSingleRecord(int eId) {
		Employee e1 =dao.getSingleRecord(eId);
		return e1;
	}
	
	public List<Employee> getAllData(){
		List<Employee> list =dao.getAllData();
		return list;
	}
	

}
