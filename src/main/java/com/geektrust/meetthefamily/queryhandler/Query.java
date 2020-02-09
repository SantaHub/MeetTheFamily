package com.geektrust.meetthefamily.queryhandler;

public class Query {
	private Command command;
	private Parameter parameter;
	private String response;
	
	public Query(Command command, Parameter parameter) {
		this.command = command;
		this.parameter = parameter;
	}
	
	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
