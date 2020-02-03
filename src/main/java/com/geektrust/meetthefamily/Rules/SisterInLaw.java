package com.geektrust.meetthefamily.Rules;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.constant.Gender;
import com.geektrust.meetthefamily.model.Person;

public class SisterInLaw {

	/**
	 * returns the female siblings recorded in the family
	 * @param person
	 * @return
	 * @throws NullPointerException
	 */
	public static List<Person> execute(Person person){
		List<Person> sisterInLaw;
		if(person.getMother()==null) {
			sisterInLaw = person.getSpouse().getMother().getSiblings(Gender.FEMALE);
		} else {
			sisterInLaw = new ArrayList<Person>();
			for(Person brother : person.getMother().getSiblings(Gender.MALE)) {
				if(brother.getSpouse() != null) {
					sisterInLaw.add(brother.getSpouse());
				}
			}
		}
		if(sisterInLaw.size() == 0 ) {
			throw new NullPointerException();
		}
		return sisterInLaw;
	}
}
