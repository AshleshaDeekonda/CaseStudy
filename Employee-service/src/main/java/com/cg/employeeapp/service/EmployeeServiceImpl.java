package com.cg.employeeapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws NoProperDataException {
		
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
		return ResponseEntity.ok(employee);
		
	}

	@Override
	public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeNotFoundException {
		log.info("get all customers from here");
		return new  ResponseEntity<>(employeeRepo.findAll(),HttpStatus.OK);
		
	
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(long id) throws EmployeeNotFoundException{
		Employee employees=employeeRepo.findById(id).orElseThrow(()-> new  EmployeeNotFoundException("employee Not Found"+id));
		
		return ResponseEntity.ok().body(employees);
	}

//	@Override
//	public void deleteEmpById(Long empidL) {
//		crudRepo.deleteById(empidL);
//	}
//	
	@Override
	public ResponseEntity<Employee> updateEmployee(Employee employee, long empid) throws EmployeeNotFoundException {
		
        Employee employees=employeeRepo.findById(empid).orElseThrow(()-> new EmployeeNotFoundException("employee not "+empid));
		
		employees.setName(employee.getName());
		employees.setSalary(employee.getSalary());
		employees.setAddress(employee.getAddress());
		employees.setEmail(employee.getEmail());
		
		
		final Employee updatedEmployee = employeeRepo.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	
	
	}
	
	
}
