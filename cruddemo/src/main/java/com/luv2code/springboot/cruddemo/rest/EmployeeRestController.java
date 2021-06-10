package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theService) {
		this.employeeService = theService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAll();
	}
	
	@GetMapping("/employees/{theEmployeeId}")
	public Employee getEmployee(@PathVariable Integer theEmployeeId) {
		System.out.println(theEmployeeId);
		Employee employee = employeeService.findById(theEmployeeId);
		
		if(employee == null) {
			throw new NullPointerException();
		}
		return employee;
	}
	
	@DeleteMapping("/employees/{theId}")
	public void deleteEmployee(@PathVariable int theId) {
		System.out.println(theId);
		employeeService.delete(theId);

	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee putEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
}
