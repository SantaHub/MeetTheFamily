package com.geektrust.meetthefamily.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.geektrust.meetthefamily.Rules.BrotherInLaw;
import com.geektrust.meetthefamily.Rules.Daughter;
import com.geektrust.meetthefamily.Rules.MaternalAunt;
import com.geektrust.meetthefamily.Rules.MaternalUncle;
import com.geektrust.meetthefamily.Rules.PaternalAunt;
import com.geektrust.meetthefamily.Rules.PaternalUncle;
import com.geektrust.meetthefamily.Rules.Sibling;
import com.geektrust.meetthefamily.Rules.SisterInLaw;
import com.geektrust.meetthefamily.Rules.Son;
import com.geektrust.meetthefamily.constant.Command;
import com.geektrust.meetthefamily.constant.Constant;
import com.geektrust.meetthefamily.constant.Gender;
import com.geektrust.meetthefamily.constant.Relation;
import com.geektrust.meetthefamily.dao.FamilyTreeDao;
import com.geektrust.meetthefamily.initializer.Initializer;
import com.geektrust.meetthefamily.model.AddQuery;
import com.geektrust.meetthefamily.model.Person;
import com.geektrust.meetthefamily.model.Query;
import com.geektrust.meetthefamily.model.RelationQuery;

public class FamilyTreeService {
	Person queen;
	FamilyTreeDao familyTreeDao;
	
	public FamilyTreeService() {
		this.queen = Initializer.getQueen();
		this.familyTreeDao = new FamilyTreeDao();
	}
	
	public List<String> getQueriesFromFile(String filePath){
		return familyTreeDao.readQueriesFromFile(filePath);
	}

	public List<Query> processQueries(List<String> queries) {
		List<Query> queryList = new ArrayList<Query>();
		for(String query : queries) {
			String[] splittedQuery = query.split(Constant.QUERY_SPLIT_REGEX,Constant.QUERY_SPLIT_SIZE);
			queryList.add(new Query(Command.valueOf(splittedQuery[Constant.COMMAND_INDEX]),splittedQuery[Constant.PARAMETER_INDEX]));
		}
		return queryList;
	}
	public List<Query> executeQuery(List<String> queriesStrings){
		RelationQuery relationQuery;
		AddQuery addQuery;
		Person person;
		
		List<Query> queries= processQueries(queriesStrings);
		
		for(Query query : queries) {
			switch(query.getCommand()) {
			case ADD_CHILD :
				addQuery = processAdd(query.getParameter());
				person = findPerson(this.queen, addQuery.getMotherName());
				Person child = new Person(addQuery.getChildName(), addQuery.getGender());
				person.addChild(child);
				query.setResponse(Constant.CHILD_DONE);
				break;
			case GET_RELATIONSHIP:
				relationQuery = processRelation(query.getParameter());
				person = findPerson(this.queen, relationQuery.getName());
				if(person == null) {
					query.setResponse(Constant.NO_PERSON);
				} else{
					query.setResponse(executeRelation(person, relationQuery.getRelation()));
				}
				break;
			}
		}
		return queries;
	}
	
	public String executeRelation(Person person, Relation relation) {
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
	
	public RelationQuery processRelation(String parameter) {
		String[] splitterParameter = parameter.split(Constant.PARAMTER_SPLIT_REGEX, Constant.PARAMTER_SPLIT_SIZE);
		return new RelationQuery(splitterParameter[Constant.RELATION_NAME_INDEX], Relation.valueEquals(splitterParameter[Constant.RELATION_TYPE_INDEX].toUpperCase()));
	}
	
	public AddQuery processAdd(String parameter) {
		String[] splitterParameter = parameter.split(Constant.RELATIONSHIP_SPLIT_REGEX,Constant.RELATIONSHIP_SPLIT_SIZE);
		return new AddQuery(splitterParameter[Constant.ADD_MOTHER_INDEX], splitterParameter[Constant.ADD_CHILD_INDEX], Gender.valueOf(splitterParameter[Constant.ADD_GENDER_INDEX].toUpperCase()));
	}
	
	public Person findPerson(Person person, String name) {
		Person foundPerson = null;
		if(Gender.FEMALE.equals(person.getGender())) {
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
		}else if(Gender.MALE.equals(person.getGender())) {
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
