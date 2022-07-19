package com.cg.employeeapp.authentication.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeeapp.authentication.exception.EmployeeNotFoundException;
import com.cg.employeeapp.authentication.exception.NoProperDataException;
import com.cg.employeeapp.authentication.model.Employee;
import com.cg.employeeapp.authentication.security.services.SequenceGeneratorService;
import com.cg.employeeapp.authentication.util.FeignClientUtilEmployee;



@RestController
@RequestMapping("/employees")
public class FeignControllerEmployee {
	
	@Autowired
	private FeignClientUtilEmployee feignclientutilemployee;
	
	@Autowired
	private SequenceGeneratorService service;
	
	//only user
	@PostMapping("/employeedetails")
	@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) throws NoProperDataException {
        employee.setEmployeeId(service.getSequenceNumber(Employee.SEQUENCE_NAME));
        return feignclientutilemployee.addEmployee(employee);
    }
	
	@GetMapping("/emp/all")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException{
		
		return feignclientutilemployee.getAllEmployees();
	}
	
	@GetMapping("/emp/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException{
		
		//return feignclientutilemployee.getEmployeeById(empid);
		Employee employeeRetrieved = feignclientutilemployee.getEmployeeById(id);
		return new ResponseEntity<Employee>(employeeRetrieved, HttpStatus.OK);
	}
	
	@PutMapping("/updateemployee/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long id) throws EmployeeNotFoundException{
		
		Employee employeeSaved=feignclientutilemployee.updateEmployee(employee,id);
		return new ResponseEntity<Employee> (employeeSaved, HttpStatus.CREATED);
		
		
		//return feignclientutilemployee.updateEmployee(employee, id);
		
	}
	
	@DeleteMapping(path="/emp/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteEmpById(@Valid @PathVariable long id) throws EmployeeNotFoundException{
		
		return feignclientutilemployee.deleteEmpById(id);
	}

}


