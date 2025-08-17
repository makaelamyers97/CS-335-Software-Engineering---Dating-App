//https://www.tutorialspoint.com/swingexamples/index.htm
package datingapp.gui;
import datingapp.csvDatabaseFileManager;
import datingapp.datingApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import datingapp.User;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@SuppressWarnings("serial")
public class RegistrationFrame extends AppFrame {
    //private JFormattedTextField phoneTxtFld = null;
   //private JFormattedTextField zipTxtFld = null;

    String[] allStates = {"AL", "AK", "AZ", "AR", "AS", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", 
    		"IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM",
    		"NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    String[] genders = {"Male", "Female", "Non-binary", "Trans Woman", "Trans Man", "Non-Conforming",};
	String[] edLevel = {"High School or less", "Some College/AA/AS", "BA/BS", "MA", "Phd", "JD", "MBA"};
    
    JButton registerBtn;
    JButton uploadPhotoBtn;
    //FOLLOWUP
    private User newUser;
    AppFrame RegistrationFrame = new AppFrame(); {
//    public RegistrationFrame() {
//        setTitle("User Registration");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(300, 90, 600, 400);
//        //https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java
//        setLocationRelativeTo(null); //center the window screen
//        setResizable(false);

        // create the panel
        JPanel contentPane = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
        contentPane.setBorder(yellowBorder);
        setContentPane(contentPane);
        contentPane.setLayout(null); // we need to control the location to make things line up cleaner

        // Name
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setSize(75, 30);
        nameLbl.setLocation(50, 30);
        nameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(nameLbl);
        
        // First
        JTextField firstTxtFld = new JTextField();
        firstTxtFld.setSize(100, 20);
        firstTxtFld.setLocation(50, 60);//65
        contentPane.add(firstTxtFld);

        JLabel firstLbl = new JLabel("First");
        firstLbl.setSize(100, 20);
        firstLbl.setLocation(50, 75);//80
        firstLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(firstLbl);
        
        // Middle
        JTextField middleTxtFld = new JTextField();
        middleTxtFld.setSize(30, 20);
        middleTxtFld.setLocation(160, 60);
        contentPane.add(middleTxtFld);

        JLabel middleLbl = new JLabel("MI");
        middleLbl.setSize(100, 20);
        middleLbl.setLocation(160, 75);
        middleLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(middleLbl);

        // Last
        JTextField lastTxtFld = new JTextField();
        lastTxtFld.setSize(100, 20);
        lastTxtFld.setLocation(200, 60);
        contentPane.add(lastTxtFld);

        JLabel lastLbl = new JLabel("Last");
        lastLbl.setSize(100, 20);
        lastLbl.setLocation(200, 75);
        lastLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(lastLbl);
        
        // Location
//        JLabel locationLbl1 = new JLabel("Location");
//        locationLbl1.setSize(75, 30);
//        locationLbl1.setLocation(50, 90);
//        locationLbl1.setFont(new Font("Arial", Font.PLAIN, 18));
//        contentPane.add(locationLbl1);
        
        // City
        JTextField cityTxtFld = new JTextField();
        cityTxtFld.setSize(115, 20);
        cityTxtFld.setLocation(50, 100);
        contentPane.add(cityTxtFld);

        JLabel cityLbl = new JLabel("City");
        cityLbl.setSize(100, 20);
        cityLbl.setLocation(50, 115);
        cityLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(cityLbl);
                
        //ComboBox for state
        JComboBox<String> stateBox = new JComboBox<String>(allStates);
        stateBox.setSelectedItem(stateBox);
        stateBox.setSize(45, 20);
        stateBox.setLocation(170, 100);
        contentPane.add(stateBox);
        stateBox.setVisible(true);
        
        JLabel stateLbl = new JLabel("State");
        stateLbl.setSize(100, 20);
        stateLbl.setLocation(170, 115);
        stateLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(stateLbl);
       
        MaskFormatter zformatter = null;								
        try {
        	zformatter = new MaskFormatter("#####");			
        	zformatter.setPlaceholder("#####") ;
        } catch(ParseException e) {
        	e.printStackTrace();
        }
        JFormattedTextField zipTxtFld = new JFormattedTextField(zformatter);				
    	zipTxtFld.setFocusLostBehavior(JFormattedTextField.PERSIST);	
    	zipTxtFld.setColumns(5);
        zipTxtFld.setSize(75, 20);
        zipTxtFld.setLocation(225, 100);
        contentPane.add(zipTxtFld);
        
        																
        zipTxtFld.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				zipTxtFld.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(zipTxtFld.getText().isEmpty()) {
				zipTxtFld.setText("#####");
				}
			}
        	
        });
        
        JLabel zipLbl = new JLabel("Zip Code");
        zipLbl.setSize(75, 20);
        zipLbl.setLocation(225, 115);
        zipLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(zipLbl);
        
        // username
        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setSize(100, 20);
        usernameLbl.setLocation(50, 155);
        usernameLbl.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(usernameLbl);
        
        JTextField usernameTxtFld = new JTextField();
        usernameTxtFld.setSize(150, 20);
        usernameTxtFld.setLocation(135, 155);
        contentPane.add(usernameTxtFld);

        
        // password
        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setSize(100, 20);
        passwordLbl.setLocation(50, 185);
        passwordLbl.setFont(new Font("Arial", Font.PLAIN, 18));
        contentPane.add(passwordLbl);
        
        //Password field
        JPasswordField passwordTxtFld = new JPasswordField();
        passwordTxtFld.setSize(150, 20);
        passwordTxtFld.setLocation(135, 185);
        contentPane.add(passwordTxtFld);
        
        // dob
        JLabel dobLbl = new JLabel("Date of Birth");
        dobLbl.setSize(200, 20);
        dobLbl.setLocation(50, 225);
        dobLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(dobLbl);
        
        JTextField dobTxtFld = new JTextField();
        //Temp solution until date picker is decided
        dobTxtFld.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				dobTxtFld.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(dobTxtFld.getText().isEmpty()) {
				dobTxtFld.setText("DD/MM/YYYY");
				}
			}
        	
        });
        dobTxtFld.setSize(100, 20);
        dobTxtFld.setLocation(150, 225);
        dobTxtFld.setText("DD/MM/YYYY");
        contentPane.add(dobTxtFld);
        
        // phone
        JLabel phoneLbl = new JLabel("Phone Number");
        phoneLbl.setSize(200, 20);
        phoneLbl.setLocation(50, 250);													
        phoneLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(phoneLbl);
        
        MaskFormatter pformatter = null;
        try {
        	
        	/*MaskFormatter */
        	pformatter = new MaskFormatter("###-###-####");	
        	pformatter.setPlaceholder("000-000-0000") ;


        } catch(ParseException e) {
        	e.printStackTrace();
        }
        JFormattedTextField phoneTxtFld= new JFormattedTextField(pformatter);
        phoneTxtFld.setFocusLostBehavior(JFormattedTextField.PERSIST);
        phoneTxtFld.setColumns(10);											 
        phoneTxtFld.setSize(100, 20);
        phoneTxtFld.setLocation(150, 250);			
        contentPane.add(phoneTxtFld);
        													

        phoneTxtFld.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				phoneTxtFld.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(phoneTxtFld.getText().isEmpty()) {
				phoneTxtFld.setText("000-000-0000");
				}
			}
        	
        });
//        													

        // email
        JLabel emailLbl = new JLabel("Email");
        emailLbl.setSize(200, 20);
        emailLbl.setLocation(50, 275);
        emailLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        contentPane.add(emailLbl);
        
        //Email example label
        JTextField emailTxtFld = new JTextField();
        emailTxtFld.setSize(220, 20);
        emailTxtFld.setLocation(90, 275);
        emailTxtFld.setText("ex: myname@example.com");
        contentPane.add(emailTxtFld);
        emailTxtFld.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				emailTxtFld.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(emailTxtFld.getText().isEmpty()) {
				emailTxtFld.setText("ex: myname@example.com");
				}
			}
        	
        });
        
        //Occupation
        JLabel occupationLbl = new JLabel("Occupation:");
        occupationLbl.setSize(100, 30);
        occupationLbl.setLocation(50, 300);
        occupationLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(occupationLbl);
        
        JTextField occupationTxtFld = new JTextField();
        occupationTxtFld.setSize(175, 20);
        occupationTxtFld.setLocation(130, 305); 
        contentPane.add(occupationTxtFld);
        
        //Education Level
        JLabel educationLbl = new JLabel("Education Level");
        educationLbl.setSize(200, 30);
        educationLbl.setLocation(50, 325);   //x, y
        educationLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(educationLbl);
        
        //ComboBox for edLevel
        JComboBox<String> edLevelBox = new JComboBox<String>(edLevel);
        edLevelBox.setSelectedItem(edLevelBox);
        edLevelBox.setSize(150, 20);
        edLevelBox.setLocation(155, 330);
        contentPane.add(edLevelBox);
        edLevelBox.setVisible(true);
        
        //Hobbies and interests
        JLabel hobbiesLbl = new JLabel("Hobbies/Interests");
        hobbiesLbl.setSize(200, 30);
        hobbiesLbl.setLocation(50, 350);
        hobbiesLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(hobbiesLbl);
        
        JTextField hobbiesTxtFld = new JTextField();
        hobbiesTxtFld.setSize(280, 20);
        hobbiesTxtFld.setLocation(50, 375);//x,y 
        contentPane.add(hobbiesTxtFld);
        
        //Relationship Goals
        JLabel goalsLbl = new JLabel("Relationship Goals:");
        goalsLbl.setSize(280, 20);
        goalsLbl.setLocation(50, 400);   //x, y
        goalsLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(goalsLbl);
        																					
        JTextField relGoalsTxtFld = new JTextField();
        relGoalsTxtFld.setSize(280, 20);
        relGoalsTxtFld.setLocation(50, 420);
        contentPane.add(relGoalsTxtFld);
        
        //Gender
        JLabel genderLbl = new JLabel("Gender:");
        genderLbl.setSize(100, 30);
        genderLbl.setLocation(50, 440);   //x, y
        genderLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(genderLbl);
        																				
        //ComboBox for gender
        JComboBox<String> genderBox = new JComboBox<String>(genders);
        genderBox.setSelectedItem(genderBox);
        genderBox.setSize(120, 20);
        genderBox.setLocation(105, 445);
        contentPane.add(genderBox);
        genderBox.setVisible(true);
        
        //Interests
        JLabel gendInterestsLbl = new JLabel("Genders interested in:");
        gendInterestsLbl.setSize(150, 30);
        gendInterestsLbl.setLocation(50, 465);   //x, y
        gendInterestsLbl.setFont(new Font("Arial", Font.PLAIN,14));
        contentPane.add(gendInterestsLbl);
        
        //ComboBox for interests
        JComboBox<String> genderInterestsBox = new JComboBox<String>(genders);
        genderInterestsBox.setSelectedItem(genderInterestsBox);
        genderInterestsBox.setSize(120, 20);
        genderInterestsBox.setLocation(195, 470);
        contentPane.add(genderInterestsBox);
        genderInterestsBox.setVisible(true);
        
        // About me
        JLabel aboutMeLbl = new JLabel("Tell us a little more about yourself");
        aboutMeLbl.setSize(300, 30);
        aboutMeLbl.setLocation(30, 490);   //x, y
        aboutMeLbl.setFont(new Font("Arial", Font.PLAIN,18));
        contentPane.add(aboutMeLbl);   
        
        JTextArea aboutTxtFld = new JTextArea();
        aboutTxtFld.setBounds(30, 515, 300, 50);
        aboutTxtFld.setLineWrap(true);
        aboutTxtFld.setWrapStyleWord(true);
        contentPane.add(aboutTxtFld);
        //detailsTxtFld.setVisible(true);
//        
        uploadPhotoBtn = new JButton("Upload Profile Photo");
        uploadPhotoBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        uploadPhotoBtn.setBounds(85, 575, 185, 30); 
	    uploadPhotoBtn.setFocusable(false);
	    
//	    https://www.youtube.com/watch?v=YZ_tQFTMYoQ
	    uploadPhotoBtn.addActionListener(new ActionListener() {
	    	
			public void actionPerformed (ActionEvent e) {
	    		
	    		if(e.getSource() == uploadPhotoBtn) {
	    			
	    			JFileChooser file_upload = new JFileChooser();

	    			int res_2 = file_upload.showSaveDialog(null);
	    			
	    			if(res_2 == JFileChooser.APPROVE_OPTION) {
	    				
	    				File file_path = new File(file_upload.getSelectedFile().getAbsolutePath());
	    				newUser.setUserFileName(file_path);

//	    				https://www.youtube.com/watch?v=n66gUbZ6WcQ
	    				String newPath = "assets/UserPics";
	    				File directory = new File(newPath);
	    				if (!directory.exists()) {
	    				    directory.mkdirs(); 
	    				}
	    				File sourceFile = file_path; 

	    				//String originalFileName = file_path.getName();
	    				//String extension = "";
	    				//int i = originalFileName.lastIndexOf('.');
	    				//if (i > 0) {
	    				    //extension = originalFileName.substring(i + 1); 
	    				//}

	    				String enteredUsername = usernameTxtFld.getText().trim();

	    				try {
	    				    BufferedImage image = ImageIO.read(sourceFile);
	    				    if (image == null) {
	    				        throw new IOException("Error.");
	    				    }

	    				    String finalFileFullName = enteredUsername + "_pic.jpg";
	    				    File finalFile = new File(directory, finalFileFullName);

	    				    ImageIO.write(image, "jpg", finalFile);

	    				    newUser.setUserFileName(finalFile); 

	    				} catch (IOException ex) {
	    				    ex.printStackTrace();
	    				    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    				
	    				}	    			
	    			}
	    		}    		
	    		
	    	}
			});
	    
	    contentPane.add(uploadPhotoBtn);
	    


        
        registerBtn = new JButton("Register");
        registerBtn.setSize(120, 30);
        registerBtn.setLocation(120, 610);												
        newUser = new User();
 	   	
        registerBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	//Validate required fields, then set data to Use-->when Register button is clicked
            	Boolean invalidUserName = validateUserName(usernameTxtFld.getText());        	
            	if(invalidUserName.equals(true)) {return;}
            	String userNameData = usernameTxtFld.getText();

            	for (List<String> row : datingApp.seedData) {

            		if(userNameData.trim().length() > 0 && row.toString().toLowerCase().contains(userNameData.toLowerCase())) {
            			Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
                    	JOptionPane.showMessageDialog((JFrame) activeWindow, "The username " + userNameData + " is in use.\nClick OK to exit the app.");
                    	System.exit(0);
            		}
            	}
          
            	newUser.setUserName(userNameData);
            	
            	Boolean invalidFirstName = validateFirstName(firstTxtFld.getText());
            	if(invalidFirstName.equals(true)) return;
            	String firstNameData = firstTxtFld.getText();
            	newUser.setFirstName(firstNameData);
            	
            	Boolean invalidLastName = validateLastName(lastTxtFld.getText());
            	if(invalidLastName.equals(true)) return;
            	String lastNameData = lastTxtFld.getText();
            	newUser.setLastName(lastNameData);
            	
            	String middleIData = middleTxtFld.getText();
            	newUser.setMiddleInitial(middleIData);
            	
            	Boolean invalidPhone = validatePhone(phoneTxtFld.getText());
            	if(invalidPhone.equals(true)) return;
            	String phoneData = (String) phoneTxtFld.getText();
            	newUser.setPhoneNumber(phoneData);
            	
            	
            	Boolean invalidEmail = validateEmail(emailTxtFld.getText());
            	if(invalidEmail.equals(true)) return;
            	String emailData = emailTxtFld.getText();
            	newUser.setEmail(emailData);
            	
            	Boolean invalidCity = validateCity(cityTxtFld.getText());
            	if(invalidCity.equals(true)) return;
            	String cityData = cityTxtFld.getText();
            	newUser.setCity(cityData);
            	
            	String stateData = (String) stateBox.getSelectedItem();
            	newUser.setState(stateData);
            	
            	Boolean invalidZipcode = validateZipcode(zipTxtFld.getText());
            	if(invalidZipcode.equals(true)) return;
				String zipData = (String)zipTxtFld.getText();
				newUser.setZipCode(zipData);
            	
				
				Boolean invalidPassword = validatePassword(passwordTxtFld.getPassword());
				if(invalidPassword.equals(true)) return;
            	char[] passwordArr = passwordTxtFld.getPassword();
            	String passwordData = new String(passwordArr);
            	newUser.setPassword(passwordData);
            	
            	Boolean invalidDOB = validateDOB(dobTxtFld.getText());
            	if(invalidDOB.equals(true)) return;
            	String dobData = dobTxtFld.getText();
            	newUser.setDateOfBirth(dobData);
            	
            	String occupationData = occupationTxtFld.getText();
            	newUser.setOccupation(occupationData);
            	
            	String edLevelData = edLevelBox.getSelectedItem().toString();
            	newUser.setEdLevel(edLevelData);
            	
            	String hobbiesData = hobbiesTxtFld.getText();
            	String hobbiesDataSemicolon = hobbiesData.replace(",", ";");
            	newUser.setHobbiesInterests(hobbiesDataSemicolon);
            	
            	String relGoalsData = relGoalsTxtFld.getText();
            	newUser.setRelationGoals(relGoalsData);
            	
            	String genderData = genderBox.getSelectedItem().toString();
            	newUser.setGender(genderData);
            	
            	String genderIntData = genderInterestsBox.getSelectedItem().toString();
            	newUser.setGenderInterest(genderIntData);
            	
            	String aboutData = aboutTxtFld.getText();
            	newUser.setAboutMe(aboutData);
            	
//            	HelperFunctions.Session.setCurrentUser(newUser);
            	
            	//Write the user to the assets/dbSeeds file to simulate database
            	csvDatabaseFileManager.writeUserToCSV(newUser);
            	
            	
                dispose();
                new WelcomeFrame(newUser.getUserName(), newUser.getFirstName()).setVisible(true);
            }
            
        });
        
        
        contentPane.add(registerBtn, uploadPhotoBtn);
        registerBtn.setFocusable(false);
        uploadPhotoBtn.setFocusable(false);

        
        
		//Modifies the AppFrame for this page
		this.setTitle("User Registration");
    
	};
    public static boolean validateUserName(String usernameTxt) {
    	String userNameData = usernameTxt.trim();
    	String regexPatternUn = ".{6,}"; 	
    	if(userNameData.isEmpty() || !userNameData.matches(regexPatternUn)) {
    		JOptionPane.showMessageDialog(null,"The username \"" + userNameData + "\" must be 6 or more characters.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		//System.exit(0);
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validatePassword(char[] passwordArr) {
    	String pstr = new String(passwordArr);
    	//char[] passwordArrData = passwordArr;
    	String regexPatternPw = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{12,}$";
    	if(pstr.isEmpty() || !pstr.matches(regexPatternPw)) {
    		JOptionPane.showMessageDialog(null,"The password \"" + pstr + "\" must be 12+ characters and include upper/lowercase, a digit, and special character.\"", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateFirstName(String firstNameTxt) {
    	String firstNameData = firstNameTxt.trim();
    	String regexPatternFN = "[A-Za-z]{2,}";
    	if(firstNameData.isEmpty() || !firstNameData.matches(regexPatternFN)) {
    		JOptionPane.showMessageDialog(null,"The first name \"" + firstNameData + "\" must be 2 or more characters.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateLastName(String lastNameTxt) {
    	String lastNameData = lastNameTxt.trim();
    	String regexPatternLN = "[A-Za-z]{2,}";	
    	if(lastNameData.isEmpty() || !lastNameData.matches(regexPatternLN)) {
    		JOptionPane.showMessageDialog(null,"The last name " + lastNameData + " must be 2 or more characters.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateDOB(String dobTxt) {
    	String dobData = dobTxt.trim();
    	String regexPatternDOB = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";  	
    	if(dobData.isEmpty() || !dobData.matches(regexPatternDOB)) {
    		JOptionPane.showMessageDialog(null,"The date of birth \"" + dobData + "\" must be in the format dd/mm/yyyy.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateEmail(String emailTxt) {
    	String emailData = emailTxt.trim();
    	String regexPatternE = ".+@.{2,}\\..{2,}";	
    	if(emailData.isEmpty()|| !emailData.matches(regexPatternE)) {
    		JOptionPane.showMessageDialog(null,"The email address\"" + emailData + "\" is invalid.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validatePhone(String phoneTxt) {
    	String phoneData = phoneTxt.trim();
    	String regexPatternP = "\\d{3}-\\d{3}-\\d{4}";   	
    	if(phoneData.isEmpty() || !phoneData.matches(regexPatternP)) {
    		JOptionPane.showMessageDialog(null,"The phone number \"" + phoneData + "\" must be in the format ###-###-####.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateCity(String cityTxt) {
    	String cityData = cityTxt.trim();
    	String regexPatternC = "[A-Za-z\\s]{2,}";    	
    	if(cityData.isEmpty() || !cityData.matches(regexPatternC)) {
    		JOptionPane.showMessageDialog(null,"The city \"" + cityData + "\" must be at least 2 characters.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    public static boolean validateZipcode(String zipCodeTxt) {
    	String zipcodeData = zipCodeTxt.trim();
    	String regexPatternz = "\\d{5}";   	    	
    	if(zipcodeData.isEmpty() || !zipcodeData.matches(regexPatternz)) {
    		JOptionPane.showMessageDialog(null,"The zip code \"" + zipcodeData + "\" must be at least 5 numbers.", "InValid Entry!", JOptionPane.INFORMATION_MESSAGE);
    		
    		return true;
    	} 	
    		return false;
    }
    
    
}




//focusListener--https://www.youtube.com/watch?v=CzKXbkjgDBY