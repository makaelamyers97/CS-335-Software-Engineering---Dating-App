package datingapp.gui;
								 
										 
					  

//import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
//import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import datingapp.HelperFunctions;
import datingapp.User;
import datingapp.csvDatabaseFileManager;
import datingapp.datingApp;

public class MyProfileFrame extends AppFrame{


/**
* 
*/
private static final long serialVersionUID = 1L;
//	String[] genders = {"Male", "Female", "Non-binary", "Trans Woman", "Trans Man", "Non-Conforming",};
//	String[] edLevel = {"High School or less", "Some College/AA/AS", "BA/BS", "MA", "Phd", "JD", "MBA"};
//User u = new User();
private List<List<String>> users = csvDatabaseFileManager.readCSVRows("dbSeeds.csv", true);
private List<String> foundUser = new ArrayList<>();
String userName;
public MyProfileFrame(String userName /*, String first, String last, String city, String state*/) {
System.out.println("From myprofile " +userName);
foundUser=findUserData(users,userName);

// panel
JPanel profilePane = new JPanel();
Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
profilePane.setBorder(yellowBorder);
setContentPane(profilePane);							
profilePane.setLayout(null); 


//profilePane.add(Box.createRigidArea(new Dimension(0, 20))); 

JButton btnAllProfiles = new JButton("Go to Dashboard");		//? should this be a dashboard button instead of all profiles?
btnAllProfiles.setAlignmentX(Component.CENTER_ALIGNMENT);
btnAllProfiles.setBounds(105, 40, 150, 30); 
btnAllProfiles.setFocusable(false);
profilePane.add(btnAllProfiles);

btnAllProfiles.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
DashboardFrame dashboardFrame = new DashboardFrame(userName);
dashboardFrame.setVisible(true);
}
});

//image placeholder
String basePath1 = System.getProperty("user.dir");
String imagePath1 = Paths.get(basePath1, "assets", "swans_with_background.JPG").toString();
ImageIcon photoIcon = new ImageIcon(imagePath1);

Image profileImage = photoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
photoIcon = new ImageIcon(profileImage);

JLabel lblPhoto = new JLabel(photoIcon);
lblPhoto.setBounds(80, 70, 200, 200);		// x, y, w, h
profilePane.add(lblPhoto);
// lblPhoto.setVisible(true);

// Full Name
JLabel lblFullName = new JLabel();//first + " " + last  u.getFirstName().toString + " " + u.getLastName()
lblFullName.setSize(300, 30); //size w300, h30
lblFullName.setLocation(30, 250);
lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
lblFullName.setFont(new Font("Arial", Font.PLAIN,18));	//18
lblFullName.setText(foundUser.get(0) + " " + foundUser.get(2));//Error??
profilePane.add(lblFullName);

// User Name
JLabel lblUserName = new JLabel();	//u.getUserName()//userName
lblUserName.setSize(300, 20);	//300, 20
lblUserName.setLocation(30, 275);   //x(30), y(275)
lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
lblUserName.setFont(new Font("Arial", Font.PLAIN,16));	//16
lblUserName.setText(userName);	//imagePath1
profilePane.add(lblUserName);

// City, ST
JLabel lblCityState = new JLabel();//u.getCity()+ ", " + u.getState()
lblCityState.setSize(300, 30);
lblCityState.setLocation(30, 300);   //x, y
lblCityState.setHorizontalAlignment(SwingConstants.CENTER);
lblCityState.setFont(new Font("Arial", Font.PLAIN,14));	//14
lblCityState.setText(foundUser.get(5) + ", " + foundUser.get(6));
profilePane.add(lblCityState);

// About me
//        JLabel lblAboutMe = new JLabel("About Me");
//        lblAboutMe.setSize(300, 100);
//        lblAboutMe.setLocation(30, 325);   //x, y
//        lblAboutMe.setFont(new Font("Arial", Font.PLAIN,16));
//        lblAboutMe.setText(foundUser.get(17));
//        profilePane.add(lblAboutMe);        

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

										
												   
													 
						  
								
						   


//        JTextField ageTxtFld = new JTextField();
//        //int ageYears = HelperFunctions.calculateAge(dob);
//        //ageTxtFld.setText();		//String.valueOf(returnValue)
//        ageTxtFld.setSize(50, 20);
//        ageTxtFld.setLocation(155, 455);
//        profilePane.add(ageTxtFld);

//        //Occupation
JLabel lblOccupation = new JLabel();
lblOccupation.setSize(300, 30);
lblOccupation.setLocation(30, 475);
lblOccupation.setFont(new Font("Arial", Font.PLAIN,14));
lblOccupation.setText("Occupation:  " + foundUser.get(11));
profilePane.add(lblOccupation);

//        JTextField occupationTxtFld = new JTextField();
//        occupationTxtFld.setSize(175, 20);
//        occupationTxtFld.setLocation(155, 480); 
//        profilePane.add(occupationTxtFld);

//        //Education Level
JLabel lblEducation = new JLabel();
lblEducation.setSize(300, 30);
lblEducation.setLocation(30, 500);   //x, y
lblEducation.setFont(new Font("Arial", Font.PLAIN,14));
lblEducation.setText("Education Level:  " + foundUser.get(12));
profilePane.add(lblEducation);

//        //ComboBox for edLevel
//        JComboBox<String> edLevelBox = new JComboBox<String>(edLevel);
//        edLevelBox.setSelectedItem(edLevelBox);
//        edLevelBox.setSize(175, 20);
//        edLevelBox.setLocation(155, 505);
//        profilePane.add(edLevelBox);
//        edLevelBox.setVisible(true);

//Hobbies
JLabel lblHobbies = new JLabel();
lblHobbies.setSize(300, 30);
lblHobbies.setLocation(30, 525);
lblHobbies.setFont(new Font("Arial", Font.PLAIN,14));
lblHobbies.setText("Hobbies/Interests:  " + foundUser.get(13));
profilePane.add(lblHobbies);

//        JTextField hobbiesTxtFld = new JTextField();
//        hobbiesTxtFld.setSize(175, 20);
//        hobbiesTxtFld.setLocation(155, 530);//x,y 
//        profilePane.add(hobbiesTxtFld);

//Relationship Goals
JLabel lblGoals = new JLabel();
lblGoals.setSize(300, 30);
lblGoals.setLocation(30, 550);   //x, y
lblGoals.setFont(new Font("Arial", Font.PLAIN,14));
lblGoals.setText("Relationship Goals:  " + foundUser.get(14));
profilePane.add(lblGoals);

//        JTextField relGoalsTxtFld = new JTextField();
//        relGoalsTxtFld.setSize(175, 20);
//        relGoalsTxtFld.setLocation(155, 555);
//        profilePane.add(relGoalsTxtFld);

//Gender
JLabel lblGender = new JLabel();
lblGender.setSize(300, 30);
lblGender.setLocation(30, 575);   //x, y
lblGender.setFont(new Font("Arial", Font.PLAIN,14));
lblGender.setText("Gender:  " + foundUser.get(15));
profilePane.add(lblGender);

//        //ComboBox for gender
//        JComboBox<String> genderBox = new JComboBox<String>(genders);
//        genderBox.setSelectedItem(genderBox);
//        genderBox.setSize(125, 20);
//        genderBox.setLocation(155, 580);
//        profilePane.add(genderBox);
//        genderBox.setVisible(true);

//Interests
JLabel lblInterests = new JLabel();
lblInterests.setSize(200, 30);
lblInterests.setLocation(30, 600);   //x, y
lblInterests.setFont(new Font("Arial", Font.PLAIN,14));
lblInterests.setText("Interested In:  " + foundUser.get(16));
profilePane.add(lblInterests);

//ComboBox for interests
//        JComboBox<String> interestsBox = new JComboBox<String>(genders);
//        interestsBox.setSelectedItem(interestsBox);
//        interestsBox.setSize(125, 20);
//        interestsBox.setLocation(155, 605);
//        profilePane.add(interestsBox);
//        interestsBox.setVisible(true);


//Modified the AppFrame for this page
this.setTitle("MyProfile");
this.setResizable(true);

}//ends inner Profile frame

public List<String> findUserData(List<List<String>> users, String userName) {
for (List<String> user : users) {

String uName = user.get(9).toLowerCase();
//String match = "match found";
//List<String> foundUser;
System.out.println(uName);
if (uName.equals(userName.toLowerCase())) {

foundUser = user;
System.out.println(foundUser.toString());

//lblFullName.setText(row.get(0) + " " + row.get(2));
//lblCityState.setText(row.get(5) + " " + row.get(6));

return foundUser;
}
  
				
										   
}
return null;						
								  
			
}

}//ends outter Profile frame
