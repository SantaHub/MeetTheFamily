package com.geektrust.meetthefamily.exception;

public class FileException extends GeneralException {

	private static final long serialVersionUID = 1L;

	public FileException(String errorCode, String errorMessage){
		super(errorCode, errorMessage);
	}
}
