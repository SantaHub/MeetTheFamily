package com.geektrust.meetthefamily.queryhandler.model;

import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;

/**
 * @author E62H
 */
public class AddChild extends Command{

	AddQueryParameter addQueryParameter;
	
	public AddChild(String stringparameter) {
		this.addQueryParameter = new AddQueryParameter(stringparameter);
	}
	
	public String execute(FamilyTree familyTree) {
		return familyTree.addChild(addQueryParameter);		
	}
	
}
