package br.com.cielo.cielo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class Exception extends RuntimeException {

	public Exception(String message) {
		super(message);
	}
	
}
