package com.geektrust.meetthefamily.model;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.constant.Gender;

public class Person {
	private String name;
	private Person mother;
	private Person spouse;
	private List<Person> siblings;
	private Gender gender;
	
	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
		spouse.setSpouse(this);
	}
	public List<Person> getSiblings() {
		if(Gender.FEMALE.equals(this.gender)) {
			return this.siblings;
		} else {
			return this.getSpouse().getSiblings();
		}
	}
	/**
	 * 
	 * @param gender
	 * @return
	 * @throws NullPointerException
	 */
	public List<Person> getSiblings(Gender gender) {
		List<Person> children = new ArrayList<Person>();
		if(Gender.FEMALE.equals(this.gender)) {
			for(Person child :this.getSiblings()) {
				if( child.getGender().equals(gender))
					children.add(child);
			}
		} else {
			children = this.getSpouse().getSiblings(gender);
		}
		return children;
	}
	
	public void setSiblings(List<Person> siblings) {
		if(Gender.FEMALE.equals(this.gender)) {
			for(Person child : siblings) {
				child.setMother(this);
			}
			this.siblings = siblings;
		} else {
			this.getSpouse().setSiblings(siblings);
		}
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
		
}
