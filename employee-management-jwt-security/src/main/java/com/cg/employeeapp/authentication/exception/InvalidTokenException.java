package com.cg.employeeapp.authentication.exception;

@SuppressWarnings("serial")
public class InvalidTokenException extends Exception{
	
	public InvalidTokenException(String message){
		super(message);
	}

}
