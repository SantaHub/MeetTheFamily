package com.geektrust.meetthefamily.dataaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import com.geektrust.meetthefamily.constant.Constant;
import com.geektrust.meetthefamily.exception.FileException;
import com.geektrust.meetthefamily.queryhandler.Command;
import com.geektrust.meetthefamily.queryhandler.Parameter;
import com.geektrust.meetthefamily.queryhandler.Query;

public class QueryReader {

	public Set<Query> getQueryFromFile(String filePath){
		Set<String> stringQueriesSet = readFromFile(filePath);
		return stringToQueryConverter(stringQueries);
	}
	
	 private Set<Query> stringToQueryConverter(Set<String> stringQueriesSet){
		 Set<Query> querySet = new HashSet<Query>();
		 for(String stringQuery : stringQueriesSet) {
			String[] splittedQuery = stringQuery.split(Constant.QUERY_SPLIT_REGEX,Constant.QUERY_SPLIT_SIZE);
			Command command = Command.valueOf(splittedQuery[Constant.COMMAND_INDEX]);
			
			querySet.add(new Query(Command.valueOf(splittedQuery[Constant.COMMAND_INDEX]),splittedQuery[Constant.PARAMETER_INDEX]));
		 }
		 Query q = new Query(Command.ADD_CHILD, new Parameter());
		 q.get
		 return null;
	 }
	
	
	private Set<String> readFromFile(String filePath) {
		File file ;  
		FileReader reader;
		BufferedReader br;
		Set<String> queries = new HashSet<String>();
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
