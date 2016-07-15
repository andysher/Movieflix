package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="User not found...")
public class UserNotFound extends RuntimeException {
	
	private static final long serialVersionUID = -1347068097210509112L;


	public UserNotFound(String message) {
		super(message);
	}
	public UserNotFound(String message, Throwable cause) {
		super(message,cause);
	}
}
