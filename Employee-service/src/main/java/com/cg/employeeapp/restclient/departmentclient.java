package com.cg.employeeapp.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.cg.employeeapp.model.Department;

@FeignClient(name = "Department",url = "http://localhost:8082/department")
public interface departmentclient {
	
	@GetMapping(value= "/message")
	public  ResponseEntity<List<Department>> getAllDepartments();
	
	

}
