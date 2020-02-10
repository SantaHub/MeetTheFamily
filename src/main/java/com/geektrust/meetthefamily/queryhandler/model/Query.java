package com.geektrust.meetthefamily.queryhandler.model;

import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.queryhandler.CommandType;

public class Query {
	public static final String QUERY_SPLIT_REGEX=" ";
	public static final Integer QUERY_SPLIT_SIZE=2;
	public static final String PARAMTER_SPLIT_REGEX=" ";
	public static final Integer PARAMTER_SPLIT_SIZE=2;
	public static final Integer COMMAND_INDEX=0;
	public static final Integer PARAMETER_INDEX=1;
	
	private Command command;
	private String response;
	
	public Query(String stringQuery) {
		String[] splittedQuery = stringQuery.split(QUERY_SPLIT_REGEX,QUERY_SPLIT_SIZE);
		this.command= QueryFactory.getCommand(CommandType.valueOf(splittedQuery[COMMAND_INDEX]), splittedQuery[PARAMETER_INDEX]);
	}
	
	public void execute(FamilyTree familyTree) {
		this.setResponse(this.command.execute(familyTree));
	}
	
	public String getResponse() {
		return response;
	}

	private void setResponse(String response) {
		this.response = response;
	}
}
