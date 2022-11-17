package com.example.springbackend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouraceNotFoundException extends RuntimeException {

	/**
	 * Ravi Chanamala 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResouraceNotFoundException(String message) {
		super(message);
	}

}
