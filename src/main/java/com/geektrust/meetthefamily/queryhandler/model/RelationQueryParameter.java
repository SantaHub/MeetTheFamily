package com.geektrust.meetthefamily.queryhandler.model;

import com.geektrust.meetthefamily.queryhandler.RelationShipType;

public class RelationQueryParameter implements Parameter {
	public static final String RELATIONSHIP_SPLIT_REGEX=" ";
	public static final Integer RELATIONSHIP_SPLIT_SIZE=3;
	public static final Integer RELATION_NAME_INDEX=0;
	public static final Integer RELATION_TYPE_INDEX=1;
	
	String name;
	RelationShipType relation;
	
	public RelationQueryParameter(String stringParameter) {
		String[] splittedParameter = stringParameter.split(RELATIONSHIP_SPLIT_REGEX,RELATIONSHIP_SPLIT_SIZE);
		this.name = splittedParameter[RELATION_NAME_INDEX];
		this.relation =  RelationShipType.getTypeOfValue(splittedParameter[RELATION_TYPE_INDEX]);
	}
	
	public RelationShipType getRelation() {
		return relation;
	}

	public void setRelation(RelationShipType relation) {
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
