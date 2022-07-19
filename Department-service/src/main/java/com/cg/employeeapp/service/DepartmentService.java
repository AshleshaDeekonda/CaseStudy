package com.cg.employeeapp.service;



import java.util.List;


import com.cg.employeeapp.exception.DetailsNotFoundException;
import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department) throws NoProperDataException;

	public List<Department> getAllDepartments() throws DetailsNotFoundException;

	public Department getDepartmentById(Long id) throws DetailsNotFoundException;

	public String deleteDepartment(Long id) throws DetailsNotFoundException;
	
	public Department updateDepartment(Long id, Department department) throws DetailsNotFoundException;


	
	

}




