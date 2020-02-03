package com.geektrust.meetthefamily.service;

import java.util.List;

import com.geektrust.meetthefamily.constant.Constant;
import com.geektrust.meetthefamily.dao.FamilyTreeDao;

public class FamilyTreeService {
	FamilyTreeDao familyTreeDao;
	
	public FamilyTreeService() {
		this.familyTreeDao = new FamilyTreeDao();
	}
	
	public List<String> getQueriesFromFile(){
		 executeQueries(familyTreeDao.readQueriesFromFile());
		 return null;
	}

	public String executeQueries(List<String> queries) {
		for(String query : queries) {
			System.out.println(query);
			System.out.println(query.split(Constant.QUERY_SPLIT_REGEX)[Constant.COMMAND_INDEX]);
		}
		return null;
	}
}
