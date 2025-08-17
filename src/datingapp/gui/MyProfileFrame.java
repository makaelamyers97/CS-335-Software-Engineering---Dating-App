package datingapp.gui;
								 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import datingapp.HelperFunctions;
import datingapp.csvDatabaseFileManager;

	public class MyProfileFrame extends AppFrame{


	private static final long serialVersionUID = 1L;

	private List<List<String>> users = csvDatabaseFileManager.readCSVRows("dbSeeds.csv", true);
	private List<String> foundUser = new ArrayList<>();
	String userName;

	public MyProfileFrame(String userName ) {

	foundUser=findUserData(users,userName);

	// panel
	JPanel profilePane = new JPanel();
	Border pinkBorder = BorderFactory.createLineBorder(Color.pink, 20);
	profilePane.setBorder(pinkBorder);
	setContentPane(profilePane);							
	profilePane.setLayout(null); 

	//https://stackoverflow.com/questions/14117481/how-can-i-set-the-insets-of-a-jframe/14117630
	JLabel logoutLbl = Logout.createLabel(this);
	profilePane.add(logoutLbl);
	Dimension dimension = logoutLbl.getPreferredSize();
	Insets insets = profilePane.getInsets();
	int x = insets.left + 5;
	int y = insets.top + 5;
	logoutLbl.setBounds(x, y, dimension.width, dimension.height);
	
	JButton btnAllProfiles = new JButton("Go to Dashboard");	//? shouldn't this be a dashboard button instead of all profiles?
	btnAllProfiles.setBounds(100, 50, 160, 30);           
	btnAllProfiles.setFocusable(false);
	profilePane.add(btnAllProfiles);

	btnAllProfiles.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();									
			DashboardFrame dashboardFrame = new DashboardFrame(userName);
			dashboardFrame.setVisible(true);
		}
	});

	profilePane.add(btnAllProfiles);

// start show user profile photo

	String newPath = "assets/UserPics";
	File directory = new File(newPath);

	File[] files = directory.listFiles();

	String[] filePaths = new String[files.length];

	List<String> images = new ArrayList<>();

	for (int i = 0; i < files.length; i++) {
		filePaths[i] = files[i].getAbsolutePath(); 
		}

	for (String filePath: filePaths) {
	
		Path pathToAFile = Paths.get(filePath);
		images.add(pathToAFile.getFileName().toString());
	
	}

String newImageName = (foundUser.get(9).trim() + "_pic.jpg").toLowerCase();

for (String image1: images) {
	
	String oldImageName = image1.trim().toLowerCase();

    if (newImageName.equals(oldImageName)) {

    	String imagePath1 = new File("assets/UserPics/" + image1).getAbsolutePath();

    	ImageIcon photoIcon = new ImageIcon(imagePath1);
    	
		Image profileImage = photoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		photoIcon = new ImageIcon(profileImage);

		JLabel lblPhoto = new JLabel(photoIcon);
		lblPhoto.setBounds(80, 70, 200, 200);		
		profilePane.add(lblPhoto);
	}
}

// end show user profile photo

	// Full Name
	JLabel lblFullName = new JLabel();
	lblFullName.setSize(300, 30); //size w300, h30
	lblFullName.setLocation(30, 250);
	lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
	lblFullName.setFont(new Font("Arial", Font.PLAIN,18));	
	lblFullName.setText(foundUser.get(0) + " " + foundUser.get(2));
	profilePane.add(lblFullName);
	
	// User Name
	JLabel lblUserName = new JLabel();	
	lblUserName.setSize(300, 20);
	lblUserName.setLocation(30, 275); 
	lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
	lblUserName.setFont(new Font("Arial", Font.PLAIN,16));
	lblUserName.setText(userName);
	profilePane.add(lblUserName);
	
	// City, ST
	JLabel lblCityState = new JLabel();
	lblCityState.setSize(300, 30);
	lblCityState.setLocation(30, 300);   //x, y
	lblCityState.setHorizontalAlignment(SwingConstants.CENTER);
	lblCityState.setFont(new Font("Arial", Font.PLAIN,14));	
	lblCityState.setText(foundUser.get(5) + ", " + foundUser.get(6));
	profilePane.add(lblCityState);
	       
	
	JTextArea detailsTxtArea = new JTextArea(5, 20);
	detailsTxtArea.setBounds(30, 350, 300, 90);
	detailsTxtArea.setLineWrap(true);
	detailsTxtArea.setWrapStyleWord(true);
	detailsTxtArea.setEditable(false);
	detailsTxtArea.setOpaque(false);
	detailsTxtArea.setFont(new Font("Arial", Font.PLAIN, 16));
	detailsTxtArea.setText(foundUser.get(17));
	profilePane.add(detailsTxtArea);
	//detailsTxtArea.setVisible(true);
	
	//Age
	JLabel lblAge = new JLabel("Age:  ");
	lblAge.setSize(50, 30);	//w, h
	lblAge.setLocation(30, 450);   //x, y
	lblAge.setFont(new Font("Arial", Font.PLAIN,14));
	String dob = foundUser.get(8);
	int ageYears = HelperFunctions.calculateAge(dob);
	lblAge.setText("Age: "+ Integer.toString(ageYears));
	
	profilePane.add(lblAge);
	
	//        //Occupation
	JLabel lblOccupation = new JLabel();
	lblOccupation.setSize(300, 30);
	lblOccupation.setLocation(30, 475);
	lblOccupation.setFont(new Font("Arial", Font.PLAIN,14));
	lblOccupation.setText("Occupation:  " + foundUser.get(11));
	profilePane.add(lblOccupation);
	
	//        //Education Level
	JLabel lblEducation = new JLabel();
	lblEducation.setSize(300, 30);
	lblEducation.setLocation(30, 500);   //x, y
	lblEducation.setFont(new Font("Arial", Font.PLAIN,14));
	lblEducation.setText("Education Level:  " + foundUser.get(12));
	profilePane.add(lblEducation);
	
	//Hobbies
	JLabel lblHobbies = new JLabel();
	lblHobbies.setSize(300, 30);
	lblHobbies.setLocation(30, 525);
	lblHobbies.setFont(new Font("Arial", Font.PLAIN,14));
	lblHobbies.setText("Hobbies/Interests:  " + foundUser.get(13));
	profilePane.add(lblHobbies);
	
	//Relationship Goals
	JLabel lblGoals = new JLabel();
	lblGoals.setSize(300, 30);
	lblGoals.setLocation(30, 550);   //x, y
	lblGoals.setFont(new Font("Arial", Font.PLAIN,14));
	lblGoals.setText("Relationship Goals:  " + foundUser.get(14));
	profilePane.add(lblGoals);
	
	//Gender
	JLabel lblGender = new JLabel();
	lblGender.setSize(300, 30);
	lblGender.setLocation(30, 575);   //x, y
	lblGender.setFont(new Font("Arial", Font.PLAIN,14));
	lblGender.setText("Gender:  " + foundUser.get(15));
	profilePane.add(lblGender);
	
	//Interests
	JLabel lblInterests = new JLabel();
	lblInterests.setSize(200, 30);
	lblInterests.setLocation(30, 600);   //x, y
	lblInterests.setFont(new Font("Arial", Font.PLAIN,14));
	lblInterests.setText("Interested In:  " + foundUser.get(16));
	profilePane.add(lblInterests);
	
	//Modified the AppFrame for this page
	this.setTitle("MyProfile");
	this.setResizable(true);
	
	}//ends

	public List<String> findUserData(List<List<String>> users, String userName) {
		for (List<String> user : users) {
	
		String uName = user.get(9).toLowerCase();
		//String match = "match found";
		//List<String> foundUser;
		//System.out.println(uName);
			if (uName.equals(userName.toLowerCase())) {
		
				foundUser = user;
			//System.out.println(foundUser.toString());
			
			//lblFullName.setText(row.get(0) + " " + row.get(2));
			//lblCityState.setText(row.get(5) + " " + row.get(6));
		
				return foundUser;
			}
	  
					
											   
			}
				return null;						
								  
			
	}

}//ends out
