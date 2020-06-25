package com.felipedclc.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipedclc.course.services.exception.ResourceNotFoundException;

@ControllerAdvice // INTERCEPTA AS EXCESSOES PARA O TRATAMENTO 
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // INTERCEPTA A REQUISIÇÃO DA EXCESSAO
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err); 
	}
}
