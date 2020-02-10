package com.geektrust.meetthefamily.queryhandler.model;

import com.geektrust.meetthefamily.queryhandler.CommandType;

//Maps to correct parameter classes based on the command
public class QueryFactory {

	public static Command getCommand(CommandType commandType) {
		Command command = null;
		switch(commandType) {
		case ADD_CHILD:
//			command = new AddChild();
		}
		return command;
	}
	
	public static Parameter getParameter(CommandType commandType, String stringParameter) {
		Parameter parameter = null;
		switch(commandType) {
			case ADD_CHILD:
				parameter = new AddQueryParameter(stringParameter);
				break;
			case ADD_SPOUSE:
				parameter = new AddQueryParameter(stringParameter);
				break;
			case GET_RELATIONSHIP:
				parameter = new RelationQueryParameter(stringParameter);
				break;
		}
		return parameter;
	}
}
