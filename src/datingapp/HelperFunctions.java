package datingapp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HelperFunctions {
	
	protected static final String Session = null;

	//calculate age
    public static int calculateAge(String dateOfBirth) {
    	try {  	
    		
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    		LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
    		
    				
    	    LocalDate currentDate = LocalDate.now();
    	    Period period = Period.between(dob, currentDate);
//    	    System.out.println(dob);
//    	    System.out.println(period.getYears());
    	    return period.getYears();
    	    
  
    	} catch (Exception e) {
    		System.err.println("Error");
    		return -1;
    		
    	}

    }

}

	
