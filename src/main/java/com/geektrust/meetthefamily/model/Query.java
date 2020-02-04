package com.geektrust.meetthefamily.model;

import com.geektrust.meetthefamily.constant.Command;

public class Query {
	private Command command;
	private String parameter;
	private String response;
	
	public Query(Command command, String parameter) {
		this.command = command;
		this.parameter = parameter;
	}
	
	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
