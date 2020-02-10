package com.geektrust.meetthefamily.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.geektrust.meetthefamily.FamilyTreeHandler.Constant;
import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.Rules.BrotherInLaw;
import com.geektrust.meetthefamily.Rules.Daughter;
import com.geektrust.meetthefamily.Rules.MaternalAunt;
import com.geektrust.meetthefamily.Rules.MaternalUncle;
import com.geektrust.meetthefamily.Rules.PaternalAunt;
import com.geektrust.meetthefamily.Rules.PaternalUncle;
import com.geektrust.meetthefamily.Rules.Sibling;
import com.geektrust.meetthefamily.Rules.SisterInLaw;
import com.geektrust.meetthefamily.Rules.Son;
import com.geektrust.meetthefamily.constant.GenderType;
import com.geektrust.meetthefamily.dataaccess.QueryReader;
import com.geektrust.meetthefamily.queryhandler.RelationShipType;
import com.geektrust.meetthefamily.queryhandler.model.Query;

public class FamilyTreeService {
	FamilyTree familyTree;

	public static Set<Query> getQueriesFromFile(String filePath){
		return QueryReader.getQueryFromFile(filePath);
	}
	
	public static FamilyTree initialize(String kingName, String queenName) {
		return new FamilyTree(kingName, queenName);
	}

	public String executeRelation(Person person, RelationShipType relation) {
		String response = null;
		switch(relation) {
		case PATERNAL_UNCLE :
			response = listToString(PaternalUncle.execute(person));
			break;
		case MATERNAL_UNCLE:
			response = listToString(MaternalUncle.execute(person));
			break;
		case PATERNAL_AUNT:
			response = listToString(PaternalAunt.execute(person));
			break;
		case MATERNAL_AUNT:
			response = listToString(MaternalAunt.execute(person));
			break;
		case SISTER_IN_LAW:
			response = listToString(SisterInLaw.execute(person));
			break;
		case BROTHER_IN_LAW:
			response = listToString(BrotherInLaw.execute(person));
			break;
		case SIBLINGS:
			response = listToString(Sibling.execute(person));
			break;
		case SON:
			response = listToString(Son.execute(person));
			break;
		case DAUGHTER:
			response = listToString(Daughter.execute(person));
		}
		return response;
	}
	
	
	public Person findPerson(Person person, String name) {
		Person foundPerson = null;
		if(GenderType.FEMALE.equals(person.getGender())) {
			if(person.getName().equals(name)) { // Name check
				foundPerson = person;
			} else {
				if(person.hasChildren()) { // Child check
					for(Person child: person.getChildren()) {
						foundPerson = findPerson(child, name);
						if(foundPerson != null) { // breaks if person found
							break;
						}
					}
				}
				if(person.hasSpouse() && person.getMother()!=null && foundPerson == null) { // Spouse check. Mother check to break infinite loop
					foundPerson = findPerson(person.getSpouse(),name);
				} 
			}
		}else if(GenderType.MALE.equals(person.getGender())) {
			if(person.getName().equals(name)) { //Name check
				foundPerson = person;
			} else if(person.getMother() != null) { //Move control to spouse if has mother.
				if(person.hasSpouse()) {
					foundPerson = findPerson(person.getSpouse(), name);
				}
			}
		}
		return foundPerson;
	}
	
	public static String listToString(List<Person> people) {
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
