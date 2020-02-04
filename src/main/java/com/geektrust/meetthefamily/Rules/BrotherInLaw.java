package com.geektrust.meetthefamily.Rules;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class BrotherInLaw {
	public static List<Person> execute(Person person) {	
		List<Person> brotherInLaw;
		if(person.hasMother()) {
			brotherInLaw = new ArrayList<Person>();
			for(Person sister : Sisters.execute(person)) {
				if(sister.hasSpouse()) {
					brotherInLaw.add(sister.getSpouse());
				}
			}
		} else {
			brotherInLaw = Brothers.execute(person.getSpouse());
		}
		if(brotherInLaw == null || brotherInLaw.isEmpty()) {
			throw new NullPointerException();
		}
		return brotherInLaw;
	}
}
