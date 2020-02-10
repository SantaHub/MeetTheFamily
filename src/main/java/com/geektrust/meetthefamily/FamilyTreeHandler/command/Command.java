package com.geektrust.meetthefamily.FamilyTreeHandler.command;

import com.geektrust.meetthefamily.queryhandler.model.Parameter;

/**
 * @author E62H
 */
public interface Command {

	public String execute(Parameter parameter);
}
