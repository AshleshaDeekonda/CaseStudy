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

import com.cg.employeeapp.authentication.exception.DetailsNotFoundException;
import com.cg.employeeapp.authentication.exception.NoProperDataException;
import com.cg.employeeapp.authentication.model.Department;
import com.cg.employeeapp.authentication.security.services.SequenceGeneratorService;
import com.cg.employeeapp.authentication.util.FeignClientUtilDepartment;


@RestController
@RequestMapping("/department")
public class FeignControllerDepartment {
	
	@Autowired
	private FeignClientUtilDepartment feignclientutildepartment;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	 public ResponseEntity<Department> addDepartment(@RequestBody Department department) throws NoProperDataException {
		  department.setId(service.getSequenceNumber(Department.SEQUENCE_NAME));
		  return feignclientutildepartment.addDepartment(department); 
		  }
	
	@GetMapping("/get/all")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") 
	public ResponseEntity<List<Department>> getAllDepartments() throws DetailsNotFoundException { 
		  return feignclientutildepartment.getAllDepartments(); 
	  }
	
	@GetMapping("/get/{id}")
	@PreAuthorize("hasRole('USER')") 
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) throws  DetailsNotFoundException { 
		  //return feignclientutildepartment.getDepartmentById(id);
		Department departmentRetrieved = feignclientutildepartment.getDepartmentById(id);
		return new ResponseEntity<Department>(departmentRetrieved, HttpStatus.OK);
	  }
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@RequestBody Department department) throws  DetailsNotFoundException{
		Department departmentSaved=feignclientutildepartment.updateDepartment(id,department);
		  return new ResponseEntity<Department> (departmentSaved, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteDepartmentById(@Valid @PathVariable Long id) throws DetailsNotFoundException { 
		  return feignclientutildepartment.deleteDepartmentById(id); 
		  } 
	
	
	

}
