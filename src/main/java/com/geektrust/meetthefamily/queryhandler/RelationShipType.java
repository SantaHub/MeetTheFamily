package com.geektrust.meetthefamily.queryhandler;

public enum RelationShipType {
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
	
	private RelationShipType(String value) {
		this.value = value;
	}
	
	private String getValue() {
		return this.value;
	}
	
	public static RelationShipType getTypeOfValue(String value) {
		for(RelationShipType relation : RelationShipType.values()) {
			if(relation.getValue().equalsIgnoreCase(value)) {
				return relation;
			}
		}
		
		return null;
	}
}
