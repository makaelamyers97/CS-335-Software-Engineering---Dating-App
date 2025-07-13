package datingapp.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ProfileFrame extends JFrame{
	
	public ProfileFrame(String first, String last, String userName, String city, String state) {
		
		JLabel lblNameArea = new JLabel();
		lblNameArea.setOpaque(true);
		lblNameArea.setBackground(Color.BLUE);
		lblNameArea.setBounds(70, 250, 200, 200);
		
		JLabel lblAboutArea = new JLabel("About Me");
		lblAboutArea.setOpaque(true);
		lblAboutArea.setBackground(Color.LIGHT_GRAY);
		lblAboutArea.setBounds(360, 150, 200, 200);
		
		JLabel lblPersonalArea = new JLabel();
		lblPersonalArea.setOpaque(true);
		lblPersonalArea.setBackground(Color.lightGray);
		lblPersonalArea.setBounds(50, 50, 200, 200);
		
		JLayeredPane namePane = new JLayeredPane();
        namePane.setBounds(0, 0, 500, 500);
        namePane.add(lblNameArea);
        namePane.add(lblAboutArea);
        namePane.add(lblPersonalArea);
        
        this.add(namePane);
        this.setTitle("Profile");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setLocationRelativeTo(null); //center the window screen
        this.setResizable(true);
        this.setVisible(true);
        
       
        // panel
        JPanel profilePane = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.yellow, 20);
        profilePane.setBorder(yellowBorder);
        setContentPane(profilePane);
        profilePane.setLayout(null); // we need to control the location to make things line up cleaner
        
//        //image placeholder
//        ImageIcon photoIcon = new ImageIcon("profile_pic_placeholder.svg");
//        
//        JLabel lblPhoto = new JLabel(photoIcon);
//        lblPhoto.setIcon(photoIcon);
//        lblPhoto.setBounds(100, 100, 100, 100);		// x, y, w, h
//        lblPhoto.setVisible(true);
//        
//        profilePane.add(lblPhoto);
        
        
        // Full Name
        JLabel lblFullName = new JLabel(first + " " + last);
        lblFullName.setSize(300, 30); //size w, h
        lblFullName.setLocation(60, 250);
        lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFullName.setFont(new Font("Fredoka", Font.PLAIN,18));
        profilePane.add(lblFullName);
        
        // User Name
        JLabel lblUserName = new JLabel(userName);
        lblUserName.setSize(300, 20);
        lblUserName.setLocation(60, 275);   //x, y
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setFont(new Font("Fredoka", Font.PLAIN,16));
        
        profilePane.add(lblUserName);
        
        // City, ST
        JLabel lblCityState = new JLabel(city + ", " + state);
        lblCityState.setSize(300, 30);
        lblCityState.setLocation(60, 300);   //x, y
        lblCityState.setHorizontalAlignment(SwingConstants.CENTER);
        lblCityState.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblCityState);
        
        // About me
        JLabel lblAboutMe = new JLabel("About Me");
        lblAboutMe.setSize(100, 30);
        lblAboutMe.setLocation(380, 150);   //x, y
        lblAboutMe.setFont(new Font("Fredoka", Font.PLAIN,18));
        profilePane.add(lblAboutMe);
        
        // About Details
        JLabel lblDetails = new JLabel("Provide some general details about yourself. ");
        lblDetails.setSize(400, 30);
        lblDetails.setLocation(380, 200);   //x, y
        lblDetails.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblDetails);
        
        //Age
        JLabel lblAge = new JLabel("Age:");
        lblAge.setSize(50, 30);	//w, h
        lblAge.setLocation(60, 350);   //x, y
        lblAge.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblAge);
        
        //Occupation
        JLabel lblOccupation = new JLabel("Occupation:");
        lblOccupation.setSize(100, 30);
        lblOccupation.setLocation(60, 375);   //x, y
        lblOccupation.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblOccupation);
        
        //Education Level
        JLabel lblEducation = new JLabel("Education Level:");
        lblEducation.setSize(200, 30);
        lblEducation.setLocation(60, 400);   //x, y
        lblEducation.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblEducation);
        
        //Hobbies
        JLabel lblHobbies = new JLabel("Hobbies/Interests:");
        lblHobbies.setSize(200, 30);
        lblHobbies.setLocation(60, 425);   //x, y
        lblHobbies.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblHobbies);
        
        //Relationship Goals
        JLabel lblGoals = new JLabel("Relationship Goals:");
        lblGoals.setSize(200, 30);
        lblGoals.setLocation(60, 450);   //x, y
        lblGoals.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblGoals);
        
        //Gender
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setSize(100, 30);
        lblGender.setLocation(60, 475);   //x, y
        lblGender.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblGender);
        
        //Interests
        JLabel lblInterests = new JLabel("Interested In:");
        lblInterests.setSize(200, 30);
        lblInterests.setLocation(60, 500);   //x, y
        lblInterests.setFont(new Font("Fredoka", Font.PLAIN,14));
        profilePane.add(lblInterests);
        
        
        
	}//ends inner Profile frame

}//ends outter Profile frame
