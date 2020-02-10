package com.geektrust.meetthefamily.Rules;

import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.FamilyTreeHandler.Person;
import com.geektrust.meetthefamily.constant.GenderType;

/**
 * @author E62H
 */
public class Sisters {
	public static List<Person> execute(Person person) {
		List<Person> sisters = new ArrayList<Person>();
		for(Person sib: Sibling.execute(person)) {
			if(GenderType.FEMALE.equals(sib.getGender())) {
				sisters.add(sib);
			}
		}
		return sisters;
	}
}
