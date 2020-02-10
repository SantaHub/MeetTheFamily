package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.FamilyTreeHandler.Person;

public class MaternalUncle {

	public static List<Person> execute(Person person){
		return Son.execute(person.getMother().getMother());
	}
}
