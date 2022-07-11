package com.cg.employeeapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeeapp.exception.EmployeeNotFoundException;
import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Employee;
import com.cg.employeeapp.service.EmployeeService;
import com.cg.employeeapp.service.EmployeeServiceImpl;
import com.cg.employeeapp.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceimpl;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws NoProperDataException{
		log.info("start");
		employee.setEmployeeId(service.getSequenceNumber(Employee.SEQUENCE_NAME));
		return employeeServiceimpl.addEmployee(employee);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException{
		
		log.info("starting of get mapping");
		return employeeServiceimpl.getAllEmployees();
		
		
	}
	
	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long empid) throws EmployeeNotFoundException{
		
		return employeeServiceimpl.getEmployeeById(empid);
		
		
	}
	
//	@DeleteMapping("/delete/{empid}")
//	public ResponseEntity<Void> deleteEmpById(@PathVariable("empid") Long empidL){
//		
//		employeeServiceInterface.deleteEmpById(empidL);
//		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//	}
//	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long empid) throws EmployeeNotFoundException{
		
		return employeeServiceimpl.updateEmployee(employee, empid);
	
	}

	
	
	
	
}