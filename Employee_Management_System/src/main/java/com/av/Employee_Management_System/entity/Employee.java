package com.av.Employee_Management_System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private int empId;
	private String name;
	private String dept;
	private String salary;
	public Employee() {
		
	}
	public Employee(int empId, String name, String dept, String salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	

}
