package com.geektrust.meetthefamily.Rules;

import java.util.List;

import com.geektrust.meetthefamily.model.Person;

public class MaternalAunt {

	/**
	 *  
	 * @param person
	 * @return
	 */
	public static List<Person> execute(Person person){
		
		List<Person> maternalAunt = Daughter.execute(person.getMother().getMother());
		maternalAunt.remove(person.getMother());
		return maternalAunt;
	}
}
