package com.geektrust.meetthefamily.model;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.constant.Gender;

public class Person {
	private String name;
	private Person mother;
	private Person spouse;
	private List<Person> children;
	private Gender gender;
	
	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public Person(Person mother, String name, Gender gender) {
		this.setName(name);
		this.setGender(gender);
		this.setMother(mother);
		mother.addChild(this);
		
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
	public Boolean hasMother() {
		return this.mother!=null;
	}
	public Person getSpouse() {
		return spouse;
	}
	public void setSpouse(Person spouse) {
		if(Gender.FEMALE.equals(this.getGender())) {
				this.spouse = spouse;
				this.getSpouse().setSpouse(this);
				if(this.children == null) {
					this.children = new ArrayList<Person>();
				}
		} else {
			this.spouse = spouse;
		}
		
	}
	public Boolean hasSpouse() {
		Boolean hasSpouse = false;
		if(null != this.getSpouse()) {
			hasSpouse = true;
		}
		return hasSpouse;
	}
	public List<Person> getChildren() {
		if(Gender.FEMALE.equals(this.gender)) {
			return this.children;
		} else {
			return this.getSpouse().getChildren();
		}
	}
	/**
	 * 
	 * @param gender
	 * @return
	 * @throws NullPointerException
	 */
	public List<Person> getChildren(Gender gender) {
		List<Person> children = new ArrayList<Person>();
		if(Gender.FEMALE.equals(this.gender)) {
			if(this.hasChildren()) {
				for(Person child :this.getChildren()) {
					if( child.getGender().equals(gender))
						children.add(child);
				}
			}
		} else {
			if(this.hasSpouse()) {
				children = this.getSpouse().getChildren(gender);
			}
		}
		return children;
	}
	
	public void setChildren(List<Person> children) {
		if(Gender.FEMALE.equals(this.gender)) {
			for(Person child : children) {
				child.setMother(this);
			}
			this.children = children;
		} else {
			this.getSpouse().setChildren(children);
		}
	}
	public void addChild(Person child) {
		if(Gender.FEMALE.equals(this.gender)) {
			child.setMother(this);
			this.children.add(child);
		}
	}
	
	public Boolean hasChildren() {
		Boolean hasChildren = false;
		if(null!=this.getChildren()) {
			hasChildren=true;
		}
		return hasChildren;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}		
}
