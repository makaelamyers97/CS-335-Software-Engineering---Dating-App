package datingapp;

import java.awt.Image;
import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
    
    public class Session {
        private static User currentUser;

        public static User getCurrentUser() {
            return currentUser;
        }

        public static void setCurrentUser(User user) {
            currentUser = user;
        }
    }
    
    public static ImageIcon getPicture (User user) {
    	
    	File profilePicFile = new File("assets/UserPics", User.getUserName() + "_pic.jpg");
        
    	ImageIcon photoIcon = new ImageIcon(profilePicFile.getAbsolutePath());
        Image profileImage = photoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

        return new ImageIcon(profileImage);


    }

//    this is what is causing an issue with photo showing on My Likes
	public static ImageIcon getPicture(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
