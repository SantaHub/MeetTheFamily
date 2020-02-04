package com.geektrust.meetthefamily.model;

import com.geektrust.meetthefamily.constant.Relation;

public class RelationQuery {
	String name;
	Relation relation;
	
	public RelationQuery(String name, Relation relation){
		this.relation = relation;
		this.name = name;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
