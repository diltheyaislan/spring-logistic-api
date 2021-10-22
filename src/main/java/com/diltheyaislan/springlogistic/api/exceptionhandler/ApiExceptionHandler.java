package com.diltheyaislan.springlogistic.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.diltheyaislan.springlogistic.api.domain.exception.BusinessException;
import com.diltheyaislan.springlogistic.api.domain.exception.NotFoundEntityBusinessException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error.Field> fields = ex.getBindingResult().getAllErrors().stream().map(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			return new Error.Field(fieldName, message);
		}).collect(Collectors.toList());
		
		Error error = new Error();
		error.setStatus(status.value());
		error.setDateTime(OffsetDateTime.now());
		error.setTitle("There are one or more field(s) with invalid data.");
		error.setFields(fields);
		
		return handleExceptionInternal(ex, error, headers, status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Error error = new Error();
		error.setStatus(status.value());
		error.setDateTime(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(NotFoundEntityBusinessException.class)
	public ResponseEntity<Object> handleBusinessException(NotFoundEntityBusinessException ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Error error = new Error();
		error.setStatus(status.value());
		error.setDateTime(OffsetDateTime.now());
		error.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
	}
}
