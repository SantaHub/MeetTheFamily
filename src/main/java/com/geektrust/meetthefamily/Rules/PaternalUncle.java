package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class PaternalUncle {

	public static List<Person> execute(Person person){
		List<Person> paternalUncle =  Son.execute(person.getMother().getSpouse().getMother());
		paternalUncle.remove(person.getMother().getSpouse());
		return paternalUncle;
	}
}
