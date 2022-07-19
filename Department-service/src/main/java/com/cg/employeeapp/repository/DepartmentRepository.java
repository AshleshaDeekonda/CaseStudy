package com.cg.employeeapp.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.employeeapp.model.Department;

public interface DepartmentRepository extends MongoRepository<Department,Long>{

	

}
