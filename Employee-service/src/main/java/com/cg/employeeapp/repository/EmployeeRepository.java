package com.cg.employeeapp.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.employeeapp.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{

	

	

	

}
