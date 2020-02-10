package com.geektrust.meetthefamily.test;

import org.junit.Test;

import com.geektrust.meetthefamily.queryhandler.Query;
import com.geektrust.meetthefamily.service.FamilyTreeService;

public class AddQueryTest {
	FamilyTreeService familyTreeService = new FamilyTreeService();
	
	@Test
	public void testAddChild() {
		Query query = new Query("ADD_CHILD Satya Ketu Male");
		
	}

}
