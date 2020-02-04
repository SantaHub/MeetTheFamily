package com.geektrust.meetthefamily.controller;

import java.util.List;

import com.geektrust.meetthefamily.model.Query;
import com.geektrust.meetthefamily.service.FamilyTreeService;

public class FamilyTreeController {
	FamilyTreeService familyTreeService =  new FamilyTreeService();
	
	/**
	 * To use file to create the base family
	 * @param baseFamilyFilePath
	 */
	public void runQueries(String filePath) {
		
		List<String> queries = familyTreeService.getQueriesFromFile(filePath);
		List<Query> responses = familyTreeService.executeQuery(queries);
		for(Query query : responses) {
			System.out.println(query.getResponse());
		}
	}

}
