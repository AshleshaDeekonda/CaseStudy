package com.cg.employeeapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="hrdata")
public class Department {
	
	 @Transient
	 public static final String SEQUENCE_NAME = "department_sequence";
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	
	 private String department;
	 private String departmentcode;


}
