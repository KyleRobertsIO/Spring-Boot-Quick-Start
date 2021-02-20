package co.scuffdesign.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.scuffdesign.beans.exceptions.ApiRequestException;
import co.scuffdesign.beans.payloads.ApiErrorResponse;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ApiRequestException.class)
	public ResponseEntity<Object> handleApiRequestException(
		ApiRequestException exception
	) {
		ApiErrorResponse response = ApiErrorResponse.builder()
			.message(exception.getMessage())
			.timestamp(exception.getTimestamp())
			.httpStatus(exception.getHttpStatus())
			.build();
		return new ResponseEntity<>(response, exception.getHttpStatus());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<Object> handleApiRequestException(
		MethodArgumentNotValidException exception
	) {
		// Collect all the problematic fields that were in the request body
    	BindingResult result = exception.getBindingResult();
    	List<FieldError> errors = result.getFieldErrors();
    	// Create key value pair of the bad fields
    	HashMap<String, String> validationMessages = new HashMap<String, String>();
    	for (FieldError error : errors) 
    	{ 
            // Add errors to a hash map
    	    validationMessages.put(error.getField(), error.getDefaultMessage());
    	}
		
		ApiErrorResponse response = ApiErrorResponse.builder()
    	    .message("Payload validation failed")
    	    .httpStatus(HttpStatus.BAD_REQUEST)
    	    .validationMessages(validationMessages)
    	    .build();
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
