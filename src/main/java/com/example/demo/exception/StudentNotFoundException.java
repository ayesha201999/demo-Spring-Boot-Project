package com.example.demo.exception;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String exception) {
	    super(exception);

	

}
}
