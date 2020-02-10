package com.geektrust.meetthefamily;

import com.geektrust.meetthefamily.exception.GeneralException;

public class Application {

	public static void main(String args[]) {

		String filePath = "D:\\eclipseWorkspace\\MeetTheFamily-meetthefamily\\src\\main\\resources\\input.txt";
		try {
			
		} catch (GeneralException e) {
			System.out.println("Error Code : "+e.getErrorCode()+"\nError Message : "+e.getErrorMessage());
		}
	}
}
