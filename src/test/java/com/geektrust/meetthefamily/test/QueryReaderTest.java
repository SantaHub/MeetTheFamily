package com.geektrust.meetthefamily.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.geektrust.meetthefamily.service.FamilyTreeService;

public class QueryReaderTest {
	
	@Test
	public void TestQueryReader() {
		String filePath =  "src\\main\\resources\\input.txt";
		assertNotNull(FamilyTreeService.getQueriesFromFile(filePath));
	}
	

}
