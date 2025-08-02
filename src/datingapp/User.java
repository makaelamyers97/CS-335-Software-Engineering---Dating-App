package datingapp;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

public class User {
	
	//vars
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
    //private int age;				//
    private String occupation;
    private String edLevel;
    private String hobbiesInterest;
    private String relationGoals;
    private String gender;
    private String genderInterest;
    private String aboutMe;
    
    //Constructor default
  
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
    public String getOccupation() {
    	return occupation;
    }
    
    public String getEdLevel() {
    	return edLevel;
    }
    
    public String getHobbiesInterest() {
    	return hobbiesInterest;
    }
    
    public String getRelationGoals() {
    	return relationGoals;
    }
    
    public String getGender() {
    	return gender;
    }
    
    public String getGenderInterest() {
    	return genderInterest;
    }
    
    public String getAboutMe() {
    	return aboutMe;
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
    
    public void setUserName(String uzName) {
    	this.userName = uzName;
    }

    
    public void setPhoneNumber(String phone) {
    	this.phoneNumber = phone;
    }
    
    public void setEmail(String email) {
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
    
    public void setDateOfBirth(String dob) {
    	this.dateOfBirth = dob;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    public void setOccupation(String occupation) {
    	this.occupation = occupation;
    }
    
    public void setEdLevel(String edLevel) {
    	this.edLevel = edLevel;
    }
    
    public void setHobbiesInterests(String hobbiesInt) {
    	this.hobbiesInterest = hobbiesInt;
    }
    
    public void setRelationGoals(String relGoals) {
    	this.relationGoals = relGoals;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public void setGenderInterest(String genderInt) {
    	this.genderInterest = genderInt;
    }
    
    public void setAboutMe(String aboutme) {
    	this.aboutMe = aboutme;
    }
    
    public void batchSetUser(User u, List<List<String>> list) {
    	
    	for (List<String> row : list) {
    		
			u.setFirstName(row.get(0));
            u.setFirstName(row.get(0).trim());
            u.setMiddleInitial(row.get(1).trim());
            u.setLastName(row.get(2).trim());
            u.setPhoneNumber(row.get(3).trim());
            u.setEmail(row.get(4).trim());
            u.setCity(row.get(5).trim());
            u.setState(row.get(6).trim());
            u.setZipCode(row.get(7).trim());
            u.setDateOfBirth(row.get(8).trim());
            u.setUserName(row.get(9).trim());
            u.setPassword(row.get(10).trim());
            u.setOccupation(row.get(11).trim());
            u.setEdLevel(row.get(12).trim());
            u.setHobbiesInterests(row.get(13).trim());
            u.setRelationGoals(row.get(14).trim());
            u.setGender(row.get(15).trim());
            u.setGenderInterest(row.get(16).trim());
            u.setAboutMe(row.get(17)/*.trim()*/);
            
		}
    }
    
    
    //toString
    @Override
    public String toString() {
    	return this.firstName + "," + this.middleInitial + "," + this.lastName + "," + this.phoneNumber + "," + this.email + "," + 
    			this.city + "," + this.state + "," + this.zipCode + "," + this.dateOfBirth + "," +  this.userName + "," + this.password + "," +
    			this.occupation + "," + this.edLevel + "," + this.hobbiesInterest + "," + this.relationGoals + "," + this.gender + "," + 
    			this.genderInterest + "," + this.aboutMe;
    	
    }
    
    //getValidInput method
 	private static String getValidInput(/*Scanner */String s, boolean isRequired, String regexPattern, String msg, int checkType, String errorMsg) {
	        
	        while (true) {
	        	
	        	
	            System.out.print(msg);
	            String input = s/*.nextLine()*/;
	
	            if (isRequired && input.isEmpty() == true) { 
	            	JOptionPane.showMessageDialog(null, errorMsg, "Error", 
                            JOptionPane.INFORMATION_MESSAGE);
//	                System.out.println("Error: Required field.");
//	                continue;
	            }
	
	            if (input.isEmpty() == true && input.matches(regexPattern) == false) {
	            	JOptionPane.showMessageDialog(null, errorMsg, "Error", 
                            JOptionPane.INFORMATION_MESSAGE);
	            	
//	                System.out.println(errorMsg);
//	                continue;
	            }
	
//	            if (checkType == 1 && isValidState(input) == false) {
//	                System.out.println(errorMsg);
//	                continue;
//	            }
	
	            return input;
	        }
	    } 

}
