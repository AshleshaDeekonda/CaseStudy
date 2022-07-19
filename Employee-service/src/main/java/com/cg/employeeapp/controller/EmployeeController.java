package com.cg.employeeapp.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
//	@Autowired
//	private departmentclient departmentClient;
	
	@PostMapping("/employeedetails")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws NoProperDataException{
		log.info("start");
		employee.setEmployeeId(service.getSequenceNumber(Employee.SEQUENCE_NAME));
		return new ResponseEntity<>(employeeServiceimpl.addEmployee(employee),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/emp/all")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException{
		
		log.info("starting of get mapping");
		return  new  ResponseEntity<>(employeeServiceimpl.getAllEmployees(),HttpStatus.OK);
		
		
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException{
		
		Employee employees=employeeServiceimpl.getEmployeeById(id);
		return ResponseEntity.ok().body(employees);
		
		
	}
	
	@DeleteMapping(path="/emp/delete/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable Long id) throws EmployeeNotFoundException {
		
//		Employee remove=employeeServiceimpl.deleteEmployee(id);
//		return new ResponseEntity<Employee>(remove,HttpStatus.ACCEPTED);
		
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				employeeServiceimpl.deleteEmpById(id);
			} catch (EmployeeNotFoundException e) {
				log.error(e.getMessage());
			}
			}
			else
			{
				log.info("id not found");
			}
		}
			return ResponseEntity.ok(" deleted operation done ");

	}
	
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) throws EmployeeNotFoundException{
		
		Employee employeeSaved=employeeServiceimpl.updateEmployee(employee,id);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		//return ResponseEntity.ok().body(employee);
//		return employeeServiceimpl.updateEmployee(employee, id);
	}
	
//	@GetMapping("/get/all")
//    public  ResponseEntity<List<Department>> getAllDepartments(){
//        return departmentClient.getAllDepartments();
//    }

	
	
	
	
}