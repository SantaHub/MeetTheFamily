package com.geektrust.meetthefamily.queryhandler;
/**
 * @author E62H
 */

import com.geektrust.meetthefamily.constant.Constant;
import com.geektrust.meetthefamily.constant.Gender;

public class AddQueryParameter implements Parameter {
	private String motherName;
	private String childName;
	private Gender gender;
	
	public AddQueryParameter(String stringParameter) {
		String[] splittedQuery = query.split(Constant.QUERY_SPLIT_REGEX,Constant.QUERY_SPLIT_SIZE);
		queryList.add(new Query(Command.valueOf(splittedQuery[Constant.COMMAND_INDEX]),splittedQuery[Constant.PARAMETER_INDEX]));
	}
	
	@Override
	public Parameter stringToParameter(String stringParameter) {
		
		return null;
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
