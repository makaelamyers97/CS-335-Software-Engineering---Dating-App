package datingapp;

import javax.swing.JTextField;

//import java.util.Scanner;

public class User {
	
	private String firstName;
    private String lastName;
    private String middleInitial;
    private String userName;
    private String phoneNumber;
    private String email;
    private String city;
    private String state;
    private String zipCode;
    private String dateOfBirth;
    private String password;
    
    //Construction
    
    //Getters
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return firstName;
    }
           
    public String getMiddleInitial() {
    	return middleInitial;
    }
    
    public String getUserName() {
    	return userName;
    }
    
    public String getPhoneNumber() {
    	return phoneNumber;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public String getCity() {
    	return city;
    }
    
    public String getState() {
    	return state;
    }
    
    public String getZipCode() {
    	return zipCode;
    }
    
    public String getDateOfBirth() {
    	return dateOfBirth;
    }
    
    public String getPassword() {
    	return password;
    }
    
    //Setters
    public void setFirstName(String fName) {
    	this.firstName = fName;
    }
    
    public void setLastName(String lName) {
    	this.lastName = lName;
    }
           
    public void setMiddleInitial(String mInitial) {
    	this.middleInitial = mInitial;
    }
    
    public void setUserName(String uName) {
    	this.userName = uName;
    }
    
    public void setPhoneNumber(String phone) {
    	this.phoneNumber = phone;
    }
    
    public void getEmail(String email) {
    	this.email = email;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    public void setZipCode(String zip) {
    	this.zipCode = zip;
    }
    
    public void getDateOfBirth(String dob) {
    	this.dateOfBirth = dob;
    }
    
    public void getPassword(String password) {
    	this.password = password;
    }
    
    //toString
    @Override
    public String toString() {
    	return "User: " + this.firstName + " " + this.lastName + " " + this.middleInitial + " " + this.userName + " " + this.phoneNumber + " " + this.email + " " + 
    			this.city + " " + this.state + " " + this.zipCode + " " + this.dateOfBirth + " " + this.password;
    	
    }
    
    //getValidInput method
	private static String getValidInput(/*Scanner */String s, boolean isRequired, String regexPattern, String msg, int checkType, String errorMsg) {
	        
	        while (true) {
	
	            System.out.print(msg);
	            String input = s/*.nextLine()*/;
	
	            if (isRequired /*&& input.isEmpty()*/) {
	                System.out.println("Error: Required field.");
	                //continue;
	            }
	
	            if (input.isEmpty() == false && input.matches(regexPattern) == false) {
	                System.out.println(errorMsg);
	                continue;
	            }
	
//	            if (checkType == 1 && isValidState(input) == false) {
//	                System.out.println(errorMsg);
//	                continue;
//	            }
	
	            return input;
	        }
	    }
    

}
