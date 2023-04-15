package utils;

import exceptions.*;

public class ValidationRules {
	ValidationRules(){
		
	}
	public static boolean isDuplicate() throws VehicleHandlingException{
		
		throw new VehicleHandlingException("Cannot add vehicle! Duplicate vehicle detected");
	}
}
