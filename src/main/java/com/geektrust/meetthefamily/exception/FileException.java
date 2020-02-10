package com.geektrust.meetthefamily.exception;

import com.geektrust.meetthefamily.constant.ErrorCode;

public class FileException extends GeneralException {

	private static final long serialVersionUID = 1L;

	public FileException(ErrorCode errorCode){
		super(errorCode);
	}
}
