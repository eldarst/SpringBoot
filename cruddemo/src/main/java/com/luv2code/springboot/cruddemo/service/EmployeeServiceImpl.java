package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeDAO employeeDAO;
	
	// @Qualifier bean ID is class name with first letter with lower case
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	@Override
	@Transactional
	public List<Employee> getAll() {
		
		return employeeDAO.getAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);

	}

	@Override
	@Transactional
	public Employee delete(int theId) {
		return employeeDAO.delete(theId);
	}

}
