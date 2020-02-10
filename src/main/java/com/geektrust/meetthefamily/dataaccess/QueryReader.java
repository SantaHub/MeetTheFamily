package com.geektrust.meetthefamily.dataaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import com.geektrust.meetthefamily.exception.FileException;
import com.geektrust.meetthefamily.queryhandler.model.Query;

public class QueryReader {

	public static Set<Query> getQueryFromFile(String filePath){
		Set<String> stringQueriesSet = readFromFile(filePath);
		return stringToQueryConverter(stringQueriesSet);
	}
	
	private static Set<Query> stringToQueryConverter(Set<String> stringQuerySet){
		Set<Query> querySet = new HashSet<Query>();
		for(String stringQuery : stringQuerySet) {
			querySet.add(new Query(stringQuery));
		}
		return querySet;
	}
	
	private static Set<String> readFromFile(String filePath) {
		Set<String> queries = new HashSet<String>();
		try {
			File file = new File(filePath); 
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
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
