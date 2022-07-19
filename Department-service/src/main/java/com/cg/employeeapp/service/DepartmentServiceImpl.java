package com.cg.employeeapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.employeeapp.exception.DetailsNotFoundException;

import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Department;

import com.cg.employeeapp.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentrepository;
	
	@Override
	public Department addDepartment(Department department)  throws NoProperDataException{
		log.info("start");
		if(department!=null) 
		{
			departmentrepository.save(department);
			System.out.println("orders added");
		}
		else
		{
			throw new NoProperDataException("Name can't be duplicate");
		}
		return department;
		
	}
	
	@Override
	public List<Department> getAllDepartments() throws DetailsNotFoundException{
		log.info("get all departments  from here");
		if(departmentrepository.findAll().isEmpty())
		{
			throw new DetailsNotFoundException("No Departments Found"); 
		}
		else
		{
		
		return departmentrepository.findAll();
	}
	}

	@Override
	public Department getDepartmentById(Long id) throws DetailsNotFoundException{
		Department department=departmentrepository.findById(id).orElseThrow(()-> new DetailsNotFoundException("User Not Found with id "+id));
		return department;
	}

	@Override
	public String deleteDepartment(Long id) throws DetailsNotFoundException{
		log.info("delete By Id");
		var isRemoved = departmentrepository.findById(id);
		if(isRemoved.isPresent())
		{
			departmentrepository.deleteById(id);
			log.debug("deleted succesfully {}",isRemoved.get());
		}
		else
		{
			throw new DetailsNotFoundException("Department not available to delete on given id");
		}
		log.info("end");
		return "deleted successfully";
	}

	
//	@Override
//	public Department updateDepartment(String id, Department department) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Department updateDepartment(Long id, Department department) throws DetailsNotFoundException {
	   
        Department departments=departmentrepository.findById(id).orElseThrow(()-> new DetailsNotFoundException("department not "+department));
        departments.setId(department.getId());
        departments.setDepartment(department.getDepartment());
        departments.setDepartmentcode(department.getDepartmentcode());
     
		departmentrepository.save(departments);
		
		log.info("Department Details are updated.."+departments);
	
		return departments;
		
	}



}


