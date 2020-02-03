package com.geektrust.meetthefamily.initializer;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.constant.Gender;
import com.geektrust.meetthefamily.model.Person;

public class Initializer {
	List<Person> family;
	public Initializer() {
		family = new ArrayList<Person>();
		
		Person King = new Person("King Shan",Gender.MALE);
		Person Queen = new Person("Queen Agna",Gender.FEMALE);
		Queen.setSpouse(King);
		family.add(Queen);
		Queen.setSiblings(addFirstGeneration());
	}
	public static List<Person> addFirstGeneration(){
		Person Chit = new Person("Chit", Gender.MALE);
		Person Amba = new Person("Amba", Gender.FEMALE);
		Chit.setSpouse(Amba);
		Amba.setSiblings(addSecondGeneration());
		
		Person Ish = new Person("Ish", Gender.MALE);
		
		Person Vich = new Person("Vich", Gender.MALE);
		Person Lika = new Person("Lika", Gender.FEMALE);
		Lika.setSpouse(Vich);
		
		
		return null;
	}
	
	public static List<Person> addSecondGeneration(){
		return null;
	}
}
