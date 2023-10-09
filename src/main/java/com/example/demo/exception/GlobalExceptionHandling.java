package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandling {
	
	@ExceptionHandler(value = UserCandidateException.class)
	public ResponseEntity<String> findException(UserCandidateException exception) {
		return new ResponseEntity<>(exception.message,HttpStatus.valueOf(exception.getStatusCode()));
	}

}
