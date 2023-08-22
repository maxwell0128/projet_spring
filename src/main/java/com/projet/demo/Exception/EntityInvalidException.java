package com.projet.demo.Exception;

import java.util.List;

import lombok.Getter;

public class EntityInvalidException extends RuntimeException{

	@Getter
	private ErrorCodes errorCode;
	@Getter
	private List<String> errors;
	public EntityInvalidException(String message) {
		super(message);
	}
	
	public EntityInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EntityInvalidException(String message, Throwable cause ,ErrorCodes errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public EntityInvalidException(String message, ErrorCodes erroCode) {
		super(message);
		this.errorCode = erroCode;
	}

	public EntityInvalidException(String message, ErrorCodes erroCode, List<String>errors) {
	super(message);
	this.errorCode = erroCode;
	this.errors = errors;
	}
}
