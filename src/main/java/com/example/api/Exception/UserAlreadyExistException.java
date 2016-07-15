package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="User already exists...")
public class UserAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1231456408417806298L;

	public UserAlreadyExistException() {
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


}
