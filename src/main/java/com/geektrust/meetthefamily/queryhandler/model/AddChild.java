package com.geektrust.meetthefamily.queryhandler.model;

import com.geektrust.meetthefamily.FamilyTreeHandler.Constant;
import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.exception.NoSuchPersonException;

/**
 * @author E62H
 */
public class AddChild extends Command{

	AddQueryParameter addQueryParameter;
	
	public String execute(FamilyTree familyTree) {
		String response = Constant.CHILD_ADDED;
		String childName = addQueryParameter.getChildName();
		try {
			Person mother = findPerson(addQueryParameter.getMotherName());
			Person newChild = new Person(childName, addQueryParameter.getGender());
			mother.addChild(newChild);
			namePersonMap.put(childName, newChild);
		} catch (NullPointerException e) {
			response = Constant.CHILD_FAILED;
		} catch (NoSuchPersonException e) {
			response = Constant.NO_PERSON;
		}
		return response;		
	}

	@Override
	public String execute(Parameter parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
