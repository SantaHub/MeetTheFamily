package com.geektrust.meetthefamily.constant;
/**
 * @author E62H
 */
public enum ErrorCode {
	ERR0000("Something is wrong"),
	NULL("Your Query has mistakes"),
	PERSON_NOT_FOUND("No person with name "),
	FILE000("The given file cannot be found");
	
	private String errorMessage;
	
	private ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
}
