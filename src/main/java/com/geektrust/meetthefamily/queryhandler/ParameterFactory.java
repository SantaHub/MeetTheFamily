package com.geektrust.meetthefamily.queryhandler;

//Maps to correct parameter classes based on the command
public class ParameterFactory {

	public Parameter getParameter(Command command, String stringParameter) {
		Parameter parameter;
		switch(command) {
			case ADD_CHILD:
				parameter = new AddQueryParameter(stringParameter);
			case GET_RELATIONSHIP:
				parameter = new RelationQueryParameter(stringParameter);
				
		}
		return parameter;
	}
}
