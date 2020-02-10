package com.geektrust.meetthefamily.test;

import static org.junit.Assert.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.geektrust.meetthefamily.FamilyTreeHandler.Constant;
import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.queryhandler.model.Query;
import com.geektrust.meetthefamily.service.FamilyTreeService;

public class AddQueryTest {
	FamilyTree familyTree = new FamilyTree("King Shan", "Queen Anga");
	
	@Test
	public void testAddChild() {
		Set<Query> queries = new HashSet<Query>();
		queries.add(new Query("ADD_CHILD Agna Ketu Male"));
		
		FamilyTree familyTree = FamilyTreeService.initialize("Shan", "Agna");
		for(Query query : queries ) {
			query.execute(familyTree);
			assertSame(query.getResponse(), Constant.CHILD_ADDED);
		}
	}

}
