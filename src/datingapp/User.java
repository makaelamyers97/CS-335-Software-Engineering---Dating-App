package datingapp;

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
		}
    }
    
    //toString
    @Override
    public String toString() {
    	return this.firstName + "," + this.middleInitial + "," + this.lastName + "," + this.phoneNumber + "," + this.email + "," + 
    			this.city + "," + this.state + "," + this.zipCode + "," + this.dateOfBirth + "," +  this.userName + "," + this.password;
    	
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
