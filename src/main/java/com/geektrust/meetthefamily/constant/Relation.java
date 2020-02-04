package com.geektrust.meetthefamily.constant;

public enum Relation {
	PATERNAL_UNCLE("Paternal-Uncle"),
	MATERNAL_UNCLE("Maternal-Uncle"),
	PATERNAL_AUNT("Paternal-Aunt"),
	MATERNAL_AUNT("Maternal-Aunt"),
	SISTER_IN_LAW("Sister-In-Law"),
	BROTHER_IN_LAW("Brother-In-Law"),
	SON("Son"),
	DAUGHTER("Daughter"),
	SIBLINGS("Siblings");
	
	public final String value;
	
	private Relation(String value) {
		this.value = value;
	}
	
	public String getValue(Relation relation) {
		return relation.value;
	}
	public static Relation valueEquals(String value) {
		for(Relation relation : Relation.values()) {
			if(relation.getValue(relation).equalsIgnoreCase(value)) {
				return relation;
			}
		}
		
		return null;
	}
}
