package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.constant.Gender;
import com.geektrust.meetthefamily.model.Person;

public class Daughter {
	public static List<Person> execute(Person person) {	
		return person.getSiblings(Gender.FEMALE);
	}
}
