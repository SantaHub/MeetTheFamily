package com.geektrust.meetthefamily.exception;

import com.geektrust.meetthefamily.constant.ErrorCode;

/**
 * @author E62H
 */
public class NoSuchPersonException extends GeneralException {

	private static final long serialVersionUID = 1L;

	public NoSuchPersonException(ErrorCode errorCode) {
		super(errorCode);
	}
}
