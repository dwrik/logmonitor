package org.dwrik.logmonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LogmonitorControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		var errors = new HashMap<String, String>();
		for (var error : ex.getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		return errors;
	}

}
