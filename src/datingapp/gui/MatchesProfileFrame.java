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

public class MatchesProfileFrame extends AppFrame {
	
	private String curUserName;
	private Set<String> likedUsers = new HashSet<>();
	private List<List<String>> users = datingApp.seedData;
	private List<List<String>> filteredUsers = new ArrayList<>();
	
    int index = 0;
    JLabel namelbl, locationlbl, aboutmelbl, agelbl, ocupationlbl, edulbl, hobieslb, relationshiplbl, genderlbl, interestlb;
    JButton nxtBtn, prevBtn, dashBtn;

    public MatchesProfileFrame(String curUserName) {

    	this.curUserName = curUserName.toLowerCase();
    	getLikes();
    	//System.out.println(likedUsers);
    	filterUsers();
    	//System.out.println(filteredUsers);
    	
        JPanel AvailableProfilesPanel = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 20);
        AvailableProfilesPanel.setBorder(yellowBorder);
        setContentPane(AvailableProfilesPanel);
        AvailableProfilesPanel.setLayout(null);

        namelbl = new JLabel();
        namelbl.setSize(300, 30);
        namelbl.setLocation(30, 250);
        namelbl.setHorizontalAlignment(SwingConstants.CENTER);
        namelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(namelbl);

        locationlbl = new JLabel();
        locationlbl.setSize(300, 30);
        locationlbl.setLocation(30, 275);
        locationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        locationlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(locationlbl);

        aboutmelbl = new JLabel();
        aboutmelbl.setSize(300, 30);
        aboutmelbl.setLocation(30, 300);
        aboutmelbl.setHorizontalAlignment(SwingConstants.CENTER);
        aboutmelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(aboutmelbl);

        agelbl = new JLabel();
        agelbl.setSize(300, 30);
        agelbl.setLocation(30, 325);
        agelbl.setHorizontalAlignment(SwingConstants.CENTER);
        agelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(agelbl);

        ocupationlbl = new JLabel();
        ocupationlbl.setSize(300, 30);
        ocupationlbl.setLocation(30, 350);
        ocupationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        ocupationlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(ocupationlbl);

        edulbl = new JLabel();
        edulbl.setSize(300, 30); 
        edulbl.setLocation(30, 375);
        edulbl.setHorizontalAlignment(SwingConstants.CENTER);
        edulbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(edulbl);

        hobieslb = new JLabel();
        hobieslb.setSize(300, 30);
        hobieslb.setLocation(30, 400);
        hobieslb.setHorizontalAlignment(SwingConstants.CENTER);
        hobieslb.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(hobieslb);

        relationshiplbl = new JLabel();
        relationshiplbl.setSize(300, 30);
        relationshiplbl.setLocation(30, 425);
        relationshiplbl.setHorizontalAlignment(SwingConstants.CENTER);
        relationshiplbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(relationshiplbl);

        genderlbl = new JLabel();
        genderlbl.setSize(300, 30);
        genderlbl.setLocation(30, 450);
        genderlbl.setHorizontalAlignment(SwingConstants.CENTER);
        genderlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(genderlbl);

        interestlb = new JLabel();
        interestlb.setSize(300, 30);
        interestlb.setLocation(30, 475);
        interestlb.setHorizontalAlignment(SwingConstants.CENTER);
        interestlb.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(interestlb);

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
        AvailableProfilesPanel.add(buttonPanel);
        
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

        namelbl.setText("Name: " + user.get(0) + " " + user.get(2));
        locationlbl.setText("Location: " + user.get(5) + ", " + user.get(6));
        aboutmelbl.setText("About me: " + user.get(17));
        String dob = user.get(8);
        int ageYears = HelperFunctions.calculateAge(dob);
        agelbl.setText("Age: "+ Integer.toString(ageYears));
        ocupationlbl.setText("Occupation: "+ user.get(11));					
        edulbl.setText("Education: "+ user.get(12));
        hobieslb.setText("Hobbies: " + user.get(13));
        relationshiplbl.setText("Relationship goal: " + user.get(14));
        genderlbl.setText("Gender: " + user.get(15));
        interestlb.setText("Interested in: " + user.get(16));

        prevBtn.setEnabled(index > 0);
        nxtBtn.setEnabled(index < users.size() - 1);
    }
}
