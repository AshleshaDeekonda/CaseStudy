package com.cg.employeeapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.employeeapp.exception.EmployeeNotFoundException;
import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Employee;

public interface EmployeeService {
	
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws NoProperDataException;

	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException;

	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException;

//	public void deleteEmpById(Long empidL) throws EmployeeNotFoundException;
	
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable long id) throws EmployeeNotFoundException;
	

	


}
