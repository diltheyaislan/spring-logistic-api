package com.diltheyaislan.springlogistic.api.domain.exception;

public class NotFoundEntityBusinessException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public NotFoundEntityBusinessException(String message) {
		super(message);
	}

}
