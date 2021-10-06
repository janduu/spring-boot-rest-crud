package com.example.springbootrest.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserRestControllerAdvice {
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(RuntimeException exc) {
		UserErrorResponse resp = new UserErrorResponse(
				HttpStatus.BAD_REQUEST.value(), 
				exc.getMessage(), 
				LocalDateTime.now()
		);
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
