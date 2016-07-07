package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Movie already exists.")
public class MovieAlreadyExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieAlreadyExistException() {
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MovieAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
