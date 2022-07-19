package com.cg.employeeapp.exception;

@SuppressWarnings("serial")
public class DetailsNotFoundException extends Exception{
	
	public DetailsNotFoundException(String msg)
	{
		super(msg);
	}

	public DetailsNotFoundException(Long id) {
		// TODO Auto-generated constructor stub
		super();
	}

	
	

}
