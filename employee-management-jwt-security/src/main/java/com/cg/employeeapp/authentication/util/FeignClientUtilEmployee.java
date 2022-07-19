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

import com.cg.employeeapp.authentication.model.Employee;


@FeignClient(name = "Employee-service" ,url = "http://localhost:8082/employees")
public interface FeignClientUtilEmployee {
	
	@PostMapping("/employeedetails")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);
	
	@GetMapping("/emp/all")
	public ResponseEntity<List<Employee>> getAllEmployees();
	
	@GetMapping("/emp/{id}")
	public Employee getEmployeeById(@PathVariable ("id") long id);
	
	@PutMapping("/updateemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id);
	
	@DeleteMapping(path="/emp/delete/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable ("id") long id);
		
	

}
