package com.geektrust.meetthefamily.queryhandler.model;

import java.util.List;
import java.util.stream.Collectors;

import com.geektrust.meetthefamily.FamilyTreeHandler.Constant;
import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.FamilyTreeHandler.Person;

/**
 * @author E62H
 */
public abstract class Command {
	
	public abstract String execute(FamilyTree familyTree);
	
	public String listToString(List<Person> people) {
		String response;
		if(people.isEmpty()) {
			response = Constant.NONE;
		}else {
			response= people.stream()
					.map(uncle -> uncle.getName())
					.collect(Collectors.joining(" "));
		}
		return response;
	}
	
}
