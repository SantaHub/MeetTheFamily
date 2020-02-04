package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class Sibling {
	public static List<Person> execute(Person person) {
		List<Person> siblings = person.getMother().getChildren();
		siblings.remove(person);
		return siblings;
	}
}
