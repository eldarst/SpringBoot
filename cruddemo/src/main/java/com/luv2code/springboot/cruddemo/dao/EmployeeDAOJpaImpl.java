package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getAll() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> result = query.getResultList();
		return result;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public Employee delete(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		entityManager.remove(theEmployee);
		return theEmployee;
	}

}
