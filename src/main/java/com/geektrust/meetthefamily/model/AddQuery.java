package com.geektrust.meetthefamily.model;
/**
 * @author E62H
 */

import com.geektrust.meetthefamily.constant.Gender;

public class AddQuery {
	private String motherName;
	private String childName;
	private Gender gender;

	public AddQuery(String motherName, String childName, Gender gender) {
		this.motherName = motherName;
		this.childName = childName;
		this.gender = gender;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
