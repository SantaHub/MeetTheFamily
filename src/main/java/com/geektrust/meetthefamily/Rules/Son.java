package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.queryhandler.GenderType;

public class Son {
	public static List<Person> execute(Person person) {
			return person.getChildren(GenderType.MALE);
	}
}
