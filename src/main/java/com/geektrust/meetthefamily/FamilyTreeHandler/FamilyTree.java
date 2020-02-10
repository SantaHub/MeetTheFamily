package com.geektrust.meetthefamily.FamilyTreeHandler;

import java.util.HashMap;
import java.util.Map;

import com.geektrust.meetthefamily.constant.ErrorCode;
import com.geektrust.meetthefamily.constant.GenderType;
import com.geektrust.meetthefamily.exception.NoSuchPersonException;
import com.geektrust.meetthefamily.queryhandler.model.AddQueryParameter;
import com.geektrust.meetthefamily.queryhandler.model.RelationQueryParameter;

public class FamilyTree {
	Map<String, Person> namePersonMap = new HashMap<String, Person>();
	Person queen;
	
	public FamilyTree(String kingName, String queenName){
		queen=new Person(queenName, GenderType.FEMALE);
		Person king = new Person(kingName, GenderType.MALE);
		queen.setSpouse(king);
		namePersonMap.put(queenName, queen);
		namePersonMap.put(kingName, king);
	}
	
	public Person getQueen() {
		return this.queen;
	}
	
	private Person findPerson(String name) throws NoSuchPersonException {
		Person person = this.namePersonMap.get(name);
		if(person == null)
			throw new NoSuchPersonException(ErrorCode.PERSON_NOT_FOUND);
		return person;
	}
	
	public String addChild(AddQueryParameter addQueryParameter) {
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
	
	public String getRelationship(RelationQueryParameter relationQueryParameter ) {
		String response = Constant.NONE;
		
		return response;
	}
}
