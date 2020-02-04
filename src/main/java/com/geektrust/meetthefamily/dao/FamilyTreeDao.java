package com.geektrust.meetthefamily.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.geektrust.meetthefamily.exception.FileException;

public class FamilyTreeDao {
	
	public List<String> readQueriesFromFile(String filePath) {
		File file ;  
		FileReader reader;
		BufferedReader br;
		List<String> queries = new ArrayList<String>();
		try {
			
		    file = new File(filePath); 
  
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null) {
				queries.add(line);
			}
			br.close();
		} catch (Exception exception) {
			FileException fileException = new FileException("FILE001", "File not found.");
			throw fileException;
		} 
		return queries;
	}
	
	
}
