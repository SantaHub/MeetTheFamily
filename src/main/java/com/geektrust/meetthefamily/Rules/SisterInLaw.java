package com.geektrust.meetthefamily.Rules;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class SisterInLaw {

	/**
	 * returns the female siblings recorded in the family
	 * @param person
	 * @return
	 * @throws NullPointerException
	 */
	public static List<Person> execute(Person person){
		List<Person> sisterInLaw = new ArrayList<Person>();
		if(person.hasMother()) {
			for(Person brother : Brothers.execute(person)) {
				if(brother.getSpouse() != null) {
					sisterInLaw.add(brother.getSpouse());
				}
			}
		} else {
			sisterInLaw = Sisters.execute(person.getSpouse());
		}
		return sisterInLaw;
	}
}
