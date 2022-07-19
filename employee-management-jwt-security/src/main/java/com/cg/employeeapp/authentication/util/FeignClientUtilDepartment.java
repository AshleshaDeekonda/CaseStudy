package com.cg.employeeapp.authentication.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.employeeapp.authentication.model.Department;



@FeignClient(name = "Department-service" ,url = "http://localhost:8085/department")
public interface FeignClientUtilDepartment {
	
	@PostMapping("/create")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department);
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Department>> getAllDepartments();
	
	@GetMapping("/get/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id);
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepartmentById(@PathVariable ("id") Long id);
	
	@PutMapping("/update/{id}")
	public Department updateDepartment(@PathVariable("id") Long id,@RequestBody Department department);
	

}
