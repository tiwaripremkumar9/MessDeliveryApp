package com.techviz.app.exception;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techviz.app.response.ErrorResponse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

//@ControllerAdvice + @ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ErrorResponse handleConstraintViolationException(ConstraintViolationException ex) {
		/*
		 * getConstraintViolations() - predefined framework method of ConstraintViolationException
		 * returns the set consisting of all the constraint violation.
		 */
		String errorMessage = null;
		Set<ConstraintViolation<?>> constraintViolationSet = ex.getConstraintViolations();
		for(ConstraintViolation<?> eachViolation : constraintViolationSet) {
			errorMessage = eachViolation.getMessage();
			
		}
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
		
	}

}
