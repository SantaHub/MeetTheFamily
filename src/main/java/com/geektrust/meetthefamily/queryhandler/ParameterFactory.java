package com.geektrust.meetthefamily.queryhandler;

import com.geektrust.meetthefamily.queryhandler.model.AddQueryParameter;
import com.geektrust.meetthefamily.queryhandler.model.Parameter;
import com.geektrust.meetthefamily.queryhandler.model.RelationQueryParameter;

//Maps to correct parameter classes based on the command
public class ParameterFactory {

	public static Parameter getParameter(Command command, String stringParameter) {
		Parameter parameter = null;
		switch(command) {
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
