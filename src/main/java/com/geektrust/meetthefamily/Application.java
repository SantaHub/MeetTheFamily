package com.geektrust.meetthefamily;

import com.geektrust.meetthefamily.dao.FamilyTreeDao;
import com.geektrust.meetthefamily.exception.FileException;
import com.geektrust.meetthefamily.service.FamilyTreeService;

public class Application {

	public static void main(String args[]) {
		FamilyTreeService familyTreeService = new FamilyTreeService();
		FamilyTreeDao familyTreeDao = new FamilyTreeDao();
		try {
			familyTreeDao.readQueriesFromFile();

			familyTreeService.getQueriesFromFile();
		} catch (FileException e) {
			System.out.println("Error Code : "+e.getErrorCode()+"\nError Message : "+e.getErrorMessage());
		}
	}
}
