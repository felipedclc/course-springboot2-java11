package com.felipedclc.course.services.exception;

public class ResourceNotFoundException extends RuntimeException {
	                                                   //(RunTimeException) O COPILADOR NÃO OBRIGA A TRATAR
	private static final long serialVersionUID = 1L; 
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id);
	}
}
