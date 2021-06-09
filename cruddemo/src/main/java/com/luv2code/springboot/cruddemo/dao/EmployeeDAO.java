package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public Employee delete(int theId);

}
