package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { BusinessException.class })
	public ResponseEntity<Object> handleAnyExceptionEntity(BusinessException e) {

		Map<String, Object> map = new HashMap<>();
		map.put("message", e.getMessage());
		map.put("errorCode", e.getErrorCode());

		return new ResponseEntity<>(map, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
