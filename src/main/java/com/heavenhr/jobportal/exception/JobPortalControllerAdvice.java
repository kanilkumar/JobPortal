package com.heavenhr.jobportal.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author AnilKumar
 *
 */
@ControllerAdvice
public class JobPortalControllerAdvice {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<JobPortalError> handleRuntimeException(Exception ex) {
		return new ResponseEntity<JobPortalError>(getPortalException("500", ex.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<JobPortalError> handleConstraintViolationException(Exception ex) {
		return new ResponseEntity<JobPortalError>(getPortalException("500", "Please Verify Your Data"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<JobPortalError> handleEmptyResultDataException(Exception ex) {
		return new ResponseEntity<JobPortalError>(getPortalException("500","No records found for the request"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private JobPortalError getPortalException(String code, String message) {
		JobPortalError exp = new JobPortalError();
		exp.setCode(code);
		exp.setMessage(message);
		return exp;
	}

}
