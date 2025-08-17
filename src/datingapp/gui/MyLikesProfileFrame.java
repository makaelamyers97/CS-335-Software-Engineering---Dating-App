package datingapp.gui;

import datingapp.csvDatabaseFileManager;
import datingapp.datingApp;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datingapp.HelperFunctions;
@SuppressWarnings("serial")
public class MyLikesProfileFrame extends AppFrame {
	
	private List<List<String>> userList = csvDatabaseFileManager.readCSVRows("dbSeeds.csv", true);
    private List<String> foundUser = new ArrayList<>();
    String userName;
	
    private JLabel likesPhoto;
	private String curUserName;
	private Set<String> likedUsers = new HashSet<>();
	private List<List<String>> users = datingApp.seedData;
	private List<List<String>> filteredUsers = new ArrayList<>();
	
    int index = 0;
    JLabel namelbl, locationlbl, aboutmelbl, agelbl, ocupationlbl, edulbl, hobieslb, relationshiplbl, genderlbl, interestlb;
    JButton nxtBtn, prevBtn, dashBtn;

    public MyLikesProfileFrame(String curUserName) {

    	this.curUserName = curUserName.toLowerCase();
    	getLikes();
    	//System.out.println(likedUsers);
    	filterUsers();
    	//System.out.println(filteredUsers);
    	
        JPanel LikesProfilesPanel = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
        LikesProfilesPanel.setBorder(yellowBorder);
        setContentPane(LikesProfilesPanel);
        LikesProfilesPanel.setLayout(null);
        
    	JLabel logoutLbl = Logout.createLabel(this);
    	LikesProfilesPanel.add(logoutLbl);
    	Dimension dimension = logoutLbl.getPreferredSize();
    	Insets insets = LikesProfilesPanel.getInsets();
    	int x = insets.left + 5;
    	int y = insets.top + 5;
    	logoutLbl.setBounds(x, y, dimension.width, dimension.height);
        
        likesPhoto = new JLabel();
        likesPhoto.setBounds(80, 70, 200, 200);  // x, y, width, height
        likesPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        likesPhoto.setVerticalAlignment(SwingConstants.CENTER);
        LikesProfilesPanel.add(likesPhoto);

        namelbl = new JLabel();
        namelbl.setSize(300, 30);
        namelbl.setLocation(30, 250);
        namelbl.setHorizontalAlignment(SwingConstants.CENTER);
        namelbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(namelbl);

        locationlbl = new JLabel();
        locationlbl.setSize(300, 30);
        locationlbl.setLocation(30, 275);
        locationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        locationlbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(locationlbl);

        aboutmelbl = new JLabel();
        aboutmelbl.setSize(300, 30);
        aboutmelbl.setLocation(30, 300);
        aboutmelbl.setHorizontalAlignment(SwingConstants.CENTER);
        aboutmelbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(aboutmelbl);

        agelbl = new JLabel();
        agelbl.setSize(300, 30);
        agelbl.setLocation(30, 325);
        agelbl.setHorizontalAlignment(SwingConstants.CENTER);
        agelbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(agelbl);

        ocupationlbl = new JLabel();
        ocupationlbl.setSize(300, 30);
        ocupationlbl.setLocation(30, 350);
        ocupationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        ocupationlbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(ocupationlbl);

        edulbl = new JLabel();
        edulbl.setSize(300, 30); 
        edulbl.setLocation(30, 375);
        edulbl.setHorizontalAlignment(SwingConstants.CENTER);
        edulbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(edulbl);

        hobieslb = new JLabel();
        hobieslb.setSize(300, 30);
        hobieslb.setLocation(30, 400);
        hobieslb.setHorizontalAlignment(SwingConstants.CENTER);
        hobieslb.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(hobieslb);

        relationshiplbl = new JLabel();
        relationshiplbl.setSize(300, 30);
        relationshiplbl.setLocation(30, 425);
        relationshiplbl.setHorizontalAlignment(SwingConstants.CENTER);
        relationshiplbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(relationshiplbl);

        genderlbl = new JLabel();
        genderlbl.setSize(300, 30);
        genderlbl.setLocation(30, 450);
        genderlbl.setHorizontalAlignment(SwingConstants.CENTER);
        genderlbl.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(genderlbl);

        interestlb = new JLabel();
        interestlb.setSize(300, 30);
        interestlb.setLocation(30, 475);
        interestlb.setHorizontalAlignment(SwingConstants.CENTER);
        interestlb.setFont(new Font("Arial", Font.PLAIN,16));
        LikesProfilesPanel.add(interestlb);

        // Navigation buttons
        JPanel buttonPanel = new JPanel();
        prevBtn = new JButton("Previous");
        nxtBtn = new JButton("Next");
        dashBtn = new JButton("Dashboard");
        prevBtn.setBounds(50, 50, 100, 30);
        nxtBtn.setBounds(160, 50, 100, 30);
        dashBtn.setBounds(90, 90, 120, 30);
        
        buttonPanel.setLayout(null);
        buttonPanel.add(prevBtn);
        buttonPanel.add(nxtBtn);
        buttonPanel.add(dashBtn);
        buttonPanel.setBounds(30, 530, 300, 130);
        LikesProfilesPanel.add(buttonPanel);
        
        showProfile(index);
        prevBtn.addActionListener(e -> showProfile(index - 1));
        nxtBtn.addActionListener(e -> showProfile(index + 1));
    
        dashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				DashboardFrame dashboardFrame = new DashboardFrame(curUserName);
				dashboardFrame.setVisible(true);
			}
        });
        
      //Modifies title for this frame
      this.setTitle("My Likes");
   
    }
    
    public ImageIcon showProfilePhoto(String userName) {
    	
        foundUser = findUserData(userList, userName);
        
        String newPath = "assets/UserPics";
        File directory = new File(newPath);
        File[] files = directory.listFiles();

        String newImageName = (foundUser.get(9).trim() + "_pic.jpg").toLowerCase();

        for (File file : files) {
        	
            String oldImageName = file.getName().trim().toLowerCase();
            
            if (newImageName.equals(oldImageName)) {
            	
                String imagePath = file.getAbsolutePath();
                ImageIcon photoIcon = new ImageIcon(imagePath);

                Image scaledImage = photoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImage);
            }
        }
        
        return null; 
    }
    
    public List<String> findUserData(List<List<String>> users, String userName) {
    	for (List<String> user : users) {

    		String uName = user.get(9).toLowerCase();
    		
    		if (uName.equals(userName.toLowerCase())) {

    			foundUser = user;

    		}}
    		return foundUser;
    	}
       
    private void getLikes() { 
    	
    	File f = new File(csvDatabaseFileManager.getFilePath("dbLikes.csv", true));
		if(!f.exists())
			return;
    	
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			
			String line;
			String del = ",";
			
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(del);
                String userName = cols[0].toLowerCase();
                if (userName.equals(curUserName.toLowerCase())) {
                	likedUsers.addAll(Arrays.asList(cols).subList(1, cols.length));
                	break;
                }
            }
                
		}  catch(FileNotFoundException e) {
            	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
            	JOptionPane.showMessageDialog((JFrame) activeWindow, "The file was not found: " + f.toString() + "\nClick OK to exit the app.");
            	System.exit(0);
            } catch(IOException e) {
            	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
            	JOptionPane.showMessageDialog((JFrame) activeWindow, "Error reading file: " + f.toString() + "\nClick OK to exit the app.");
            	System.exit(0);
            }
    }
    
    private void filterUsers() {
    	for (List<String> user : users) {
            String userName = user.get(9).toLowerCase();
            if (!userName.equals(curUserName) && likedUsers.contains(userName)) {
                filteredUsers.add(user);
            }
        }
    }
    
    private void showProfile(int i) {

        if (i < 0 || i >= filteredUsers.size()) return;
        index = i;

        List<String> user = filteredUsers.get(i);
        
        String userName = user.get(9);
        likesPhoto.setIcon(showProfilePhoto(userName));

        namelbl.setText("<html><b>Name: </b>" + user.get(0) + " " + user.get(2) + "</html>");
        locationlbl.setText("<html><b>Location: </b>" + user.get(5) + ", " + user.get(6) + "</html>");
        aboutmelbl.setText("<html><b>About me: </b>" + user.get(17) + "</html>");
        String dob = user.get(8);
        int ageYears = HelperFunctions.calculateAge(dob);
        agelbl.setText("<html><b>Age: </b>"+ Integer.toString(ageYears) + "</html>");
        ocupationlbl.setText("<html><b>Occupation: </b>"+ user.get(11) + "</html>");					
        edulbl.setText("<html><b>Education: </b>"+ user.get(12) + "</html>");
        hobieslb.setText("<html><b>Hobbies: </b>" + user.get(13) + "</html>");
        relationshiplbl.setText("<html><b>Relationship goal: </b>" + user.get(14) + "</html>");
        genderlbl.setText("<html><b>Gender: </b>" + user.get(15) + "</html>");
        interestlb.setText("<html><b>Interested in: </b>" + user.get(16) + "</html>");

        prevBtn.setEnabled(index > 0);
        nxtBtn.setEnabled(index < users.size() - 1);
    }
}
