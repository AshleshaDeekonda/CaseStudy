package com.cg.employeeapp.service;

import java.util.List;



import com.cg.employeeapp.exception.EmployeeNotFoundException;
import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee) throws NoProperDataException;

	public List<Employee> getAllEmployees() throws EmployeeNotFoundException;

	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException;

	
	public Employee updateEmployee(Employee employee ,long id) throws EmployeeNotFoundException;
	
	public String deleteEmpById(long id) throws EmployeeNotFoundException;

	
	
	

	


}
