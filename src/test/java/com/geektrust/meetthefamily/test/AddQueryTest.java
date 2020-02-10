package com.geektrust.meetthefamily.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.geektrust.meetthefamily.FamilyTreeHandler.FamilyTree;
import com.geektrust.meetthefamily.queryhandler.model.Query;

public class AddQueryTest {
	FamilyTree familyTree = new FamilyTree("King Shan", "Queen Anga");
	
	@Test
	public void testAddChild() {
		Set<Query> queries = new HashSet<Query>();
		queries.add(new Query("ADD_CHILD Satya Ketu Male"));
		queries = familyTree.processQueries(queries);
	}

}
