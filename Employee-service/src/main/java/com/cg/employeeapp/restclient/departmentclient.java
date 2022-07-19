package com.cg.employeeapp.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



import com.cg.employeeapp.model.Department;
import com.cg.employeeapp.model.Employee;

@FeignClient(name = "Department",url = "http://localhost:8085/department")
public interface departmentclient {
	
	@GetMapping("/get/all")
	public  ResponseEntity<List<Department>> getAllDepartments();
	
	
	@PostMapping(value = "/create")
	public ResponseEntity<Department>  addDepartment(@RequestBody Department department) ;
	

	/**
	 * 
	 * @param token
	 * @param subscriptionId
	 * @return
	 * @throws InvalidTokenException
	 */
	@GetMapping("/get/{id}")
	  public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id);
	
	@PutMapping("/update/{id}")
	  public ResponseEntity<Department> updateDepartment(@PathVariable("id") String id, @RequestBody Department department);
	    
	   
	/**
	 * 		
	 * @param token
	 * @param subscriptionId
	 * @throws InvalidTokenException
	 */
	@DeleteMapping(path = "/delete/{id}" )
	public void deleteDepartment(@PathVariable ("id") String id);


//	public Asset getEmpByAssetId(String assetId);
//
//	@GetMapping("/get/{assetId}")
//	public ResponseEntity<List<Asset>> getAllAssetsById();
			
	//throws InvalidTokenException;
	
	
	
	
	
	
}




