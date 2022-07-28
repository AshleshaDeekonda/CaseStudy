package com.cg.employeeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeeapp.exception.EmployeeNotFoundException;

import com.cg.employeeapp.exception.NoProperDataException;
import com.cg.employeeapp.model.Employee;
import com.cg.employeeapp.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee addEmployee(Employee employee) throws NoProperDataException {
		
		log.info("start");
		if(employee!=null) 
		{
			employeeRepo.save(employee);
			System.out.println("employee added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return employee;
		
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeNotFoundException {
		log.info("get all customers from here");
		return employeeRepo.findAll();
		
	
	}

	@Override	
	public Employee getEmployeeById(Long id) throws EmployeeNotFoundException{
		Employee employees=employeeRepo.findById(id).orElseThrow(()-> new  EmployeeNotFoundException("employee Not Found"+id));
		
		return employees;
	}

	
	@Override
	public Employee updateEmployee(Employee employee, long empid) throws EmployeeNotFoundException {
	    log.info("started");
        Employee employees=employeeRepo.findById(empid).orElseThrow(()-> new EmployeeNotFoundException("employee not "+empid));
		employees.setId(employee.getId());
		employees.setName(employee.getName());
		employees.setSalary(employee.getSalary());
		employees.setAddress(employee.getAddress());
		employees.setEmail(employee.getEmail());
		
		
		employeeRepo.save(employees);
		
		log.info("Employee Details are updated.."+employees);
		
		
		return employees;
		
	}
	
	@Override
	public String deleteEmpById(long id) throws EmployeeNotFoundException {
		log.info("Start delete");
		var isRemoved =employeeRepo.findById(id);
		if(isRemoved.isPresent())
		{
			employeeRepo.deleteById(id);
			log.debug("deleted successfully {}",isRemoved.get());
		}
		else
		{
			throw new EmployeeNotFoundException("Id Not Available");
		}
		log.info(" deleted End");
		return "Employee deleted successfully";
	}

	
//	@Override
//	public Employee deleteEmployee(long id) throws EmployeeNotFoundException{
//		Employee employees=employeeRepo.deleteEmployee(id).orElseThrow(()-> new  EmployeeNotFoundException("employee Not Found"+id));
//		
//		return employees;
//	}
//	
}
