package com.projet.demo.Handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projet.demo.Exception.EntityInvalidException;
import com.projet.demo.Exception.EntityNotFoundException;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorDto> handlerException(EntityNotFoundException exception, WebRequest webRequest){
		
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		final ErrorDto errorDto = ErrorDto.builder()
			.code(exception.getErrorCode())
			.httpcode(notFound.value())
			.message(exception.getMessage())
			.build();
		return new ResponseEntity<>(errorDto,notFound);
		
	}
	
	@ExceptionHandler(EntityInvalidException.class)
	public ResponseEntity<ErrorDto> handlerException(EntityInvalidException exception, WebRequest webRequest){
		
		final HttpStatus badresquest = HttpStatus.BAD_REQUEST;
		final ErrorDto errorDto = ErrorDto.builder()
			.code(exception.getErrorCode())
			.httpcode(badresquest.value())
			.message(exception.getMessage())
			.errors(exception.getErrors())
			.build();
		return new ResponseEntity<>(errorDto,badresquest);
		
	}
}
