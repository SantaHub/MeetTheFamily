package com.geektrust.meetthefamily.Rules;
/**
 * @author E62H
 */

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.constant.GenderType;

public class Brothers {
	public static List<Person> execute(Person person) {
		List<Person> brothers = new ArrayList<Person>();
		for(Person sib: Sibling.execute(person)) {
			if(GenderType.MALE.equals(sib.getGender())) {
				brothers.add(sib);
			}
		}
		return brothers;
	}
}
