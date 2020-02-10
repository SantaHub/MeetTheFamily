package com.geektrust.meetthefamily.FamilyTreeHandler.command;

import com.geektrust.meetthefamily.queryhandler.CommandType;
import com.geektrust.meetthefamily.queryhandler.model.AddQueryParameter;
import com.geektrust.meetthefamily.queryhandler.model.Parameter;
import com.geektrust.meetthefamily.queryhandler.model.RelationQueryParameter;

/**
 * @author E62H
 */
public class CommandFactory {
	
//	public static Set<Query> getCommandObject() 

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
