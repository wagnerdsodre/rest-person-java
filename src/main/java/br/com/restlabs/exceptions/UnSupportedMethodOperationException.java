package br.com.restlabs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnSupportedMethodOperationException 
extends RuntimeException {
	private static final long serialVersionUID = 1L;
	 
	public UnSupportedMethodOperationException (String ex) {
		super(ex);
	}
	
	}
