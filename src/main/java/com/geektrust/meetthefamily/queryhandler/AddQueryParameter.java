package com.geektrust.meetthefamily.queryhandler;
/**
 * @author E62H
 */

public class AddQueryParameter implements Parameter {
	public static final String ADD_SPLIT_REGEX=" ";
	public static final Integer ADD_SPLIT_SIZE=3;
	public static final Integer ADD_ROOT_NODE_INDEX=0;
	public static final Integer ADD_NEW_NODE_INDEX=1;
	public static final Integer ADD_GENDER_INDEX=2; 


	private String rootNode;
	private String newNode;
	private GenderType gender;
	
	public AddQueryParameter(String stringParameter) {
		String[] splittedParameter = stringParameter.split(ADD_SPLIT_REGEX,ADD_SPLIT_SIZE);
		this.rootNode = splittedParameter[ADD_ROOT_NODE_INDEX];
		this.newNode = splittedParameter[ADD_NEW_NODE_INDEX];
		this.gender = GenderType.getGenderOfValue(splittedParameter[ADD_GENDER_INDEX]);
	}
	
	public String getMotherName() {
		return rootNode;
	}

	public void setMotherName(String motherName) {
		this.rootNode = motherName;
	}

	public String getChildName() {
		return newNode;
	}

	public void setChildName(String childName) {
		this.newNode = childName;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}
}
