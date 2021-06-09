package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		
		return employeeDAO.getAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}

	@Override
	public Employee delete(int theId) {
		return employeeDAO.delete(theId);
	}

}
