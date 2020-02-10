package com.geektrust.meetthefamily.service;

import java.util.HashMap;
import java.util.Map;

import com.geektrust.meetthefamily.FamilyTreeHandler.Constant;
import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.constant.GenderType;
import com.geektrust.meetthefamily.queryhandler.model.AddQueryParameter;
import com.geektrust.meetthefamily.queryhandler.model.Query;

public class FamilyTree {
	Map<String, Person> namePersonMap = new HashMap<String, Person>();
	Person queen;
	
	public FamilyTree(String kingName, String queenName){
		queen=new Person(queenName, GenderType.FEMALE);
		queen.setSpouse(new Person(kingName, GenderType.MALE));
	}
	
	private Person findPerson(String name) {
		Person person = null;
		return person;
	}
	
	public String addChild(Query query) {
		String response = Constant.CHILD_ADDED;
		AddQueryParameter addQueryParameter = (AddQueryParameter)query.getParameter();
		Person mother = findPerson(addQueryParameter.getMotherName());
		Person newChild = new Person(addQueryParameter.getChildName(), addQueryParameter.getGender());
		try {
			mother.addChild(newChild);
		} catch (NullPointerException e) {
			response = Constant.CHILD_FAILED;
		}
		return response;
	}
	
	public String getRelationship(Query query) {
		String response = Constant.NONE;
	}
}
