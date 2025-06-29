//https://www.tutorialspoint.com/swingexamples/index.htm
package datingapp.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import datingapp.User;

import java.awt.Insets;
import javax.swing.BorderFactory;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;

public class RegistrationFrame extends JFrame {

    String[] allStates = {"AL", "AK", "AZ", "AR", "AS", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", 
    		"IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM",
    		"NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    JButton registerBtn;																									//FOLLOWUP
    private User newUser;
    public RegistrationFrame() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 90, 600, 400);
        //https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java
        setLocationRelativeTo(null); //center the window screen
        setResizable(false);

        // create the panel
        JPanel contentPane = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.yellow, 20);
        contentPane.setBorder(yellowBorder);
        setContentPane(contentPane);
        contentPane.setLayout(null); // we need to control the location to make things line up cleaner

        // Name
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setSize(75, 30);
        nameLbl.setLocation(50, 30);
        nameLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(nameLbl);
        
        // First
        JTextField firstTxtFld = new JTextField();
        firstTxtFld.setSize(100, 20);
        firstTxtFld.setLocation(50, 65);
        contentPane.add(firstTxtFld);

        JLabel firstLbl = new JLabel("First");
        firstLbl.setSize(100, 20);
        firstLbl.setLocation(50, 80);
        firstLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(firstLbl);
        
        // Middle
        JTextField middleTxtFld = new JTextField();
        middleTxtFld.setSize(30, 20);
        middleTxtFld.setLocation(160, 65);
        contentPane.add(middleTxtFld);

        JLabel middleLbl = new JLabel("MI");
        middleLbl.setSize(100, 20);
        middleLbl.setLocation(160, 80);
        middleLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(middleLbl);

        // Last
        JTextField lastTxtFld = new JTextField();
        lastTxtFld.setSize(100, 20);
        lastTxtFld.setLocation(200, 65);
        contentPane.add(lastTxtFld);

        JLabel lastLbl = new JLabel("Last");
        lastLbl.setSize(100, 20);
        lastLbl.setLocation(200, 80);
        lastLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(lastLbl);
        
        // Location
        JLabel locationLbl1 = new JLabel("Location");
        locationLbl1.setSize(75, 30);
        locationLbl1.setLocation(50, 110);
        locationLbl1.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(locationLbl1);
        
        // City
        JTextField cityTxtFld = new JTextField();
        cityTxtFld.setSize(100, 20);
        cityTxtFld.setLocation(50, 140);
        contentPane.add(cityTxtFld);

        JLabel cityLbl = new JLabel("City");
        cityLbl.setSize(100, 20);
        cityLbl.setLocation(50, 155);
        cityLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(cityLbl);
        
//        // State													CAN BE REMOVED AFTER TESTING
//        JTextField stateTxtFld = new JTextField();
//        stateTxtFld.setSize(30, 20);
//        stateTxtFld.setLocation(160, 140);
//        contentPane.add(stateTxtFld);
        
        //ComboBox for state
        JComboBox stateBox = new JComboBox(allStates);
        stateBox.setSelectedItem(stateBox);
        stateBox.setSize(45,  20);
        stateBox.setLocation(160,  140);
        contentPane.add(stateBox);
        stateBox.setVisible(true);
        
        JLabel stateLbl = new JLabel("State");
        stateLbl.setSize(100, 20);
        stateLbl.setLocation(160, 155);
        stateLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(stateLbl);
        
//        // Zip
//        JTextField zipTxtFld = new JTextField();						REMOVE AFTER TESTING
      //Zipcode formatting
        JFormattedTextField zipTxtFld = null;
        try {
        	MaskFormatter zformatter = new MaskFormatter("#####");
        	zipTxtFld = new JFormattedTextField(zformatter);
        	zipTxtFld.setColumns(5);
        } catch(ParseException e) {
        	e.printStackTrace();
        }
        zipTxtFld.setSize(100, 20);
        zipTxtFld.setLocation(50, 180);
        contentPane.add(zipTxtFld);
        
        JLabel zipLbl = new JLabel("Zip Code");
        zipLbl.setSize(100, 20);
        zipLbl.setLocation(50, 195);
        zipLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(zipLbl);
        
        // username
        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setSize(100, 20);
        usernameLbl.setLocation(50, 230);
        usernameLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(usernameLbl);
        
        JTextField usernameTxtFld = new JTextField();
        usernameTxtFld.setSize(100, 20);
        usernameTxtFld.setLocation(50, 255);
        contentPane.add(usernameTxtFld);
        
        // password
        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setSize(100, 20);
        passwordLbl.setLocation(50, 285);
        passwordLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(passwordLbl);
        
        //Password field
//        JTextField passwordTxtFld = new JTextField();				REMOVE AFTER TESTING
        JPasswordField passwordTxtFld = new JPasswordField();
        passwordTxtFld.setSize(100, 20);
        passwordTxtFld.setLocation(50, 310);
        contentPane.add(passwordTxtFld);
        
        // dob
        JLabel dobLbl = new JLabel("Date of Birth");
        dobLbl.setSize(200, 20);
        dobLbl.setLocation(350, 33);
        dobLbl.setFont(new Font("Arial", Font.BOLD, 18));
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
        dobTxtFld.setLocation(350, 65);
        dobTxtFld.setText("DD/MM/YYYY");
        contentPane.add(dobTxtFld);
        
        // phone
        JLabel phoneLbl = new JLabel("Phone Number");
        phoneLbl.setSize(200, 20);
        phoneLbl.setLocation(350, 110);
        phoneLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(phoneLbl);
    
//        JTextField phoneTxtFld = new JTextField();					REMOVE AFTER TESTING
        JFormattedTextField phoneTxtFld = null;
        try {
        	MaskFormatter pformatter = new MaskFormatter("###-###-####");		//FIX FOCUS
        	phoneTxtFld= new JFormattedTextField(pformatter);
        	phoneTxtFld.setColumns(10);
        } catch(ParseException e) {
        	e.printStackTrace();
        }
        phoneTxtFld.setSize(100, 20);
        phoneTxtFld.setLocation(350, 140);
        phoneTxtFld.setText("000-000-000");
        contentPane.add(phoneTxtFld);


        // email
        JLabel emailLbl = new JLabel("Email");
        emailLbl.setSize(200, 20);
        emailLbl.setLocation(350, 180);
        emailLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(emailLbl);
        
        //Email example label
        JTextField emailTxtFld = new JTextField();
        emailTxtFld.setSize(200, 20);
        emailTxtFld.setLocation(350,  210);
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
        
        
        registerBtn = new JButton("Register");
        registerBtn.setSize(120, 30);
        registerBtn.setLocation(365, 290);
        newUser = new User();
        registerBtn.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
            	//Get data to User when Register button is clicked
            	
            	String userNameData = usernameTxtFld.getText();
            	newUser.setUserName(userNameData);
            	
            	String firstNameData = firstTxtFld.getText();
            	newUser.setFirstName(firstNameData);
            	
            	String lastNameData = lastTxtFld.getText();
            	newUser.setLastName(lastNameData);
            	
            	String middleIData = middleTxtFld.getText();
            	newUser.setMiddleInitial(middleIData);
            	
//            	String phoneData = (String) phoneTxtFld.getText();;	 //NEED TO FIGURE OUT
//            	newUser.setPhoneNumber(phoneData);
            	
            	String emailData = emailTxtFld.getText();
            	newUser.setEmail(emailData);
            	
            	String cityData = cityTxtFld.getText();
            	newUser.setCity(cityData);
            	
            	String stateData = (String) stateBox.getSelectedItem();
            	newUser.setState(stateData);
            	
//            	String zipData = (String)zipTxtFld.getText();			//NEED TO FIGURE
//            	newUser.setZipCode(zipData);
            	
            	char[] passwordArr = passwordTxtFld.getPassword();
            	String passwordData = new String(passwordArr);
            	newUser.setPassword(passwordData);
            	
            	String dobData = dobTxtFld.getText();
            	newUser.setDateOfBirth(dobData);
            	
            	System.out.println(newUser);
            	
                dispose();
                new WelcomeFrame(newUser).setVisible(true);
            }
        });
        
        contentPane.add(registerBtn);
        registerBtn.setFocusable(false);
    }

}


//focusListener--https://www.youtube.com/watch?v=CzKXbkjgDBY
