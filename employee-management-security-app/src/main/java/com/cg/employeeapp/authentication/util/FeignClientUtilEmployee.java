package com.cg.employeeapp.authentication.util;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.employeeapp.model.Employee;

@FeignClient(value = "Employee-service" ,url = "http://localhost:8082/Employee-service")
public class FeignClientUtilEmployee {
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees()
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable long employeeid)
	
	@DeleteMapping(path="/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id)

}
