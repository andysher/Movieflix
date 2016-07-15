package com.example.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Review not found...")
public class ReviewNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7882373628414956794L;

	public ReviewNotFound() {
		// TODO Auto-generated constructor stub
	}

	public ReviewNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ReviewNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ReviewNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ReviewNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
