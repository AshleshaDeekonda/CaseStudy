package com.cg.employeeapp.authentication.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.employeeapp.authentication.models.ERole;
import com.cg.employeeapp.authentication.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
