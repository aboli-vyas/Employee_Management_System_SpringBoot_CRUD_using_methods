package com.av.Employee_Management_System.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.av.Employee_Management_System.entity.Employee;

import jakarta.persistence.Query;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Employee e) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(e);
		// String hqlQuery ="insert into
		// Employee(empId,name,dept,salary)values(:empId,:name,:dept,:salary)";
		// Query<Employee> query = ss.createNativeQuery(hqlQuery);
		// query.executeUpdate();

		tr.commit();
		ss.close();
		return "Data is inserted";
	}

	public String deleteData(int eId) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e = ss.get(Employee.class, eId);
		ss.remove(e);
		tr.commit();
		ss.close();
		return "Data is deleted";
	}

	public String updateData(Employee e, int eId) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 = ss.get(Employee.class, eId);

		// e1.setEmpId(e.getEmpId());
		e1.setName(e.getName());
		e1.setDept(e.getDept());
		e1.setSalary(e.getSalary());

		ss.merge(e1);
		tr.commit();
		ss.close();

		return "Data is updated";

	}
	
	public Employee getSingleRecord(int eId) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		Employee e1 =ss.get(Employee.class, eId);
		
		tr.commit();
		ss.close();
		
		return e1;
	}
	
	public List<Employee> getAllData() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		/*
		 * String getAllQuery="from Employee"; 
		 * //using org.hibernate.query.Query;
		 * Query<Employee> query =ss.createQuery(getAllQuery,Employee.class);
		 * List<Employee> list = query.list();
		 */
		
		String getAllQuery="from Employee";
		Query query = ss.createQuery(getAllQuery,Employee.class);
	    List<Employee> list =query.getResultList();
		
		tr.commit();
		ss.close();
		
		return list;
		
	}

}
