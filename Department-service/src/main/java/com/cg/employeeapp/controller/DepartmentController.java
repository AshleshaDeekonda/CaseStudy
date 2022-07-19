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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeeapp.exception.DetailsNotFoundException;

import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Department;
import com.cg.employeeapp.service.DepartmentServiceImpl;

import com.cg.employeeapp.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentserviceimpl;

	@Autowired
	private SequenceGeneratorService service;
	
	
	@PostMapping("/create")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) throws NoProperDataException{
		
		log.info("start");
		department.setId(service.getSequenceNumberForDepartment(Department.SEQUENCE_NAME));
		 //productserviceimpl.addProduct(product);
		 return new ResponseEntity<>(departmentserviceimpl.addDepartment(department),HttpStatus.CREATED);
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Department>> getAllDepartments() throws DetailsNotFoundException{
		
		log.info("starting  of get mapping");
		return new  ResponseEntity<>(departmentserviceimpl.getAllDepartments(),HttpStatus.OK);
		
	}
	
	
//
//    if (listOfAllEmps.is Present()) {
//      return new ResponseEntity<>(listOfAllEmps.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) throws DetailsNotFoundException{
		
		Department departmentRetrieved = departmentserviceimpl.getDepartmentById(id);
		return ResponseEntity.ok().body(departmentRetrieved);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long id) throws DetailsNotFoundException{
		int count=1;
		for(int i=1;i>=count;count++)
		{
			if(count==1)
			{
			try {
				departmentserviceimpl.deleteDepartment(id);
			} catch (DetailsNotFoundException e) {
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
		
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id,@RequestBody Department department) throws DetailsNotFoundException{
		Department departmentSaved = departmentserviceimpl.updateDepartment(id,department);
		return new ResponseEntity<Department>(departmentSaved, HttpStatus.CREATED);
		
		//return departmentserviceimpl.updateDepartment(id, department);
	}

}