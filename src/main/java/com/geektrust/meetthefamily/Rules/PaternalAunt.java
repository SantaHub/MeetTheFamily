package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class PaternalAunt {

	public static List<Person> execute(Person person){
		return Daughter.execute(person.getMother().getSpouse().getMother());
	}
}
