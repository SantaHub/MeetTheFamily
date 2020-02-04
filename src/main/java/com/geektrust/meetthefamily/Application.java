package com.geektrust.meetthefamily;


import com.geektrust.meetthefamily.controller.FamilyTreeController;
import com.geektrust.meetthefamily.exception.GeneralException;

public class Application {

	public static void main(String args[]) {

//		String filePath = "D:\\eclipseWorkspace\\MeetTheFamily-meetthefamily\\src\\main\\resources\\input.txt";
		FamilyTreeController familyTreeController = new FamilyTreeController();
		try {
			familyTreeController.runQueries(args[0]);
//			familyTreeController.runQueries(filePath);
		} catch (GeneralException e) {
			System.out.println("Error Code : "+e.getErrorCode()+"\nError Message : "+e.getErrorMessage());
		}
	}
}
