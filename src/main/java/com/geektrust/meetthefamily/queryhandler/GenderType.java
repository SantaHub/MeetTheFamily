package com.geektrust.meetthefamily.queryhandler;

public enum GenderType {
	MALE("Male"),
	FEMALE("Female");

	private String value;
	private GenderType(String value) {
		this.value = value;
	}

	private String getValue() {
		return this.value;
	}

	public static GenderType getGenderOfValue(String value) {
		GenderType genderType = null;
		for(GenderType gender : GenderType.values()) {
			if(gender.getValue().equalsIgnoreCase(value)) {
				genderType = gender;
			}
		}
		return genderType;
	}
}

