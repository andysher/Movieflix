package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.FORBIDDEN, reason="User Authentication failed.")

public class UserAuthFailedException extends RuntimeException {

	private static final long serialVersionUID = 5111881455563000563L;
	
	public UserAuthFailedException() {
		// TODO Auto-generated constructor stub
	}

	public UserAuthFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAuthFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserAuthFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAuthFailedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



}
