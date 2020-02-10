package com.geektrust.meetthefamily.queryhandler;

public class Query {
	public static final String QUERY_SPLIT_REGEX=" ";
	public static final Integer QUERY_SPLIT_SIZE=2;
	public static final String PARAMTER_SPLIT_REGEX=" ";
	public static final Integer PARAMTER_SPLIT_SIZE=2;
	public static final Integer COMMAND_INDEX=0;
	public static final Integer PARAMETER_INDEX=1;
	
	private Command command;
	private Parameter parameter;
	private String response;
	
	public Query(String stringQuery) {
		String[] splittedQuery = stringQuery.split(QUERY_SPLIT_REGEX,QUERY_SPLIT_SIZE);
		this.command = Command.valueOf(splittedQuery[COMMAND_INDEX]);
		this.parameter = ParameterFactory.getParameter(this.command, splittedQuery[PARAMETER_INDEX]);	
	}
	
	public Command getCommand() {
		return command;
	}

	public Parameter getParameter() {
		return parameter;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
