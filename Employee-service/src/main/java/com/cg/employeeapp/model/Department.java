package com.cg.employeeapp.model;

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
	 public static final String SEQUENCE_NAME = "user_sequence";
	
	 @Id
	 private long id;
	 private String department;
	 private String departmentcode;


}
