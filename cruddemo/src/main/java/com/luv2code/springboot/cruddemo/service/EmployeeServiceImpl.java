package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

/**
 * @author GOSH
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeRepository employeeRepository;
	
	// @Qualifier bean ID is class name with first letter with lower case
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	@Override
	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee with id:= " + theId);
		}
			
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void delete(int theId) {
		Employee employee = employeeRepository.getById(theId);
		employeeRepository.delete(employee);
		
	}

}
