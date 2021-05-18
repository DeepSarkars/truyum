package com.cognizant.truyum.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cognizant.truyum.dao.CartEmptyException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler(CartEmptyException.class)
	public ResponseEntity<Object> employeeNotFounHandler(CartEmptyException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("error", "Not Found");
		body.put("message",ex.getMessage());
		return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
