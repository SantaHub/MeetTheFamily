package com.geektrust.meetthefamily.exception;

import com.geektrust.meetthefamily.constant.ErrorCode;

public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String errorMessage;
	
	public GeneralException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getErrorMessage();
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
