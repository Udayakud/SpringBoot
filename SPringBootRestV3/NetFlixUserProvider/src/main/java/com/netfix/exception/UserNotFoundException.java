package com.netfix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//To write custom exception use below annotation 
//@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

}
