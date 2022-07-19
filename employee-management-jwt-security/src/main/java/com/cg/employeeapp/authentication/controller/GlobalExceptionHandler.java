package com.cg.employeeapp.authentication.controller;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cg.employeeapp.authentication.exception.EmployeeNotFoundException;
import com.cg.employeeapp.authentication.model.ErrorDetails;




@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourseNotFoundException
	(EmployeeNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails
				(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> GlobalExceptionHandler(Exception ex, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails
				(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}