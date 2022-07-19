package com.cg.employeeapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "db_sequence_department")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DbSequenceDepartment {
	
	@Id
    private String  id;
    private int seq;
	
	

}
