package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	
	EntityManager enityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager manager) {
		this.enityManager = manager;
	}
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		Session currentSession = enityManager.unwrap(Session.class);
		
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> result = query.getResultList();
		return result;
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Session currentSession = enityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		Session currentSession = enityManager.unwrap(Session.class);
		
		if(theEmployee != null) {
			currentSession.saveOrUpdate(theEmployee);
		}
		
	}

	@Override
	@Transactional
	public Employee delete(int theId) {
		Session currentSession = enityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, theId);
		if(theEmployee != null) {
			currentSession.delete(theEmployee);
		}
		return theEmployee;
	}

}
