package datingapp.gui;

import datingapp.datingApp;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AvailableProfilesFrame extends AppFrame {
    int index = 0;
    JLabel namelbl, locationlbl, aboutmelbl, agelbl, ocupationlbl, edulbl, hobieslb, relationshiplbl, genderlbl, interestlb;
    JButton nxtBtn, prevBtn, dashBtn;

    public AvailableProfilesFrame() {

        JPanel AvailableProfilesPanel = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 20);
        AvailableProfilesPanel.setBorder(yellowBorder);
        setContentPane(AvailableProfilesPanel);
        AvailableProfilesPanel.setLayout(null);

        namelbl = new JLabel();
        namelbl.setSize(300, 30); //size w, h
        namelbl.setLocation(30, 250);
        namelbl.setHorizontalAlignment(SwingConstants.CENTER);
        namelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(namelbl);

        locationlbl = new JLabel();
        locationlbl.setSize(300, 30); //size w, h
        locationlbl.setLocation(30, 275);
        locationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        locationlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(locationlbl);

        aboutmelbl = new JLabel();
        aboutmelbl.setSize(300, 30); //size w, h
        aboutmelbl.setLocation(30, 300);
        aboutmelbl.setHorizontalAlignment(SwingConstants.CENTER);
        aboutmelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(aboutmelbl);

        agelbl = new JLabel();
        agelbl.setSize(300, 30); //size w, h
        agelbl.setLocation(30, 325);
        agelbl.setHorizontalAlignment(SwingConstants.CENTER);
        agelbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(agelbl);

        ocupationlbl = new JLabel();
        ocupationlbl.setSize(300, 30); //size w, h
        ocupationlbl.setLocation(30, 350);
        ocupationlbl.setHorizontalAlignment(SwingConstants.CENTER);
        ocupationlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(ocupationlbl);

        edulbl = new JLabel();
        edulbl.setSize(300, 30); //size w, h
        edulbl.setLocation(30, 375);
        edulbl.setHorizontalAlignment(SwingConstants.CENTER);
        edulbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(edulbl);

        hobieslb = new JLabel();
        hobieslb.setSize(300, 30); //size w, h
        hobieslb.setLocation(30, 400);
        hobieslb.setHorizontalAlignment(SwingConstants.CENTER);
        hobieslb.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(hobieslb);

        relationshiplbl = new JLabel();
        relationshiplbl.setSize(300, 30); //size w, h
        relationshiplbl.setLocation(30, 425);
        relationshiplbl.setHorizontalAlignment(SwingConstants.CENTER);
        relationshiplbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(relationshiplbl);

        genderlbl = new JLabel();
        genderlbl.setSize(300, 30); //size w, h
        genderlbl.setLocation(30, 450);
        genderlbl.setHorizontalAlignment(SwingConstants.CENTER);
        genderlbl.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(genderlbl);

        interestlb = new JLabel();
        interestlb.setSize(300, 30); //size w, h
        interestlb.setLocation(30, 475);
        interestlb.setHorizontalAlignment(SwingConstants.CENTER);
        interestlb.setFont(new Font("Arial", Font.PLAIN,18));
        AvailableProfilesPanel.add(interestlb);

        // Navigation buttons
        JPanel buttonPanel = new JPanel();
        prevBtn = new JButton("Previous");
        nxtBtn = new JButton("Next");
        dashBtn = new JButton("Dashboard");
        prevBtn.setBounds(50, 0, 100, 30);
        nxtBtn.setBounds(160, 0, 100, 30);
        dashBtn.setBounds(90, 40, 120, 30);

        buttonPanel.setLayout(null);
        buttonPanel.add(prevBtn);  
        buttonPanel.add(nxtBtn);
        buttonPanel.add(dashBtn);
        buttonPanel.setBounds(30, 570, 300, 80);
        AvailableProfilesPanel.add(buttonPanel);
        
        prevBtn.addActionListener(e -> showProfile(index - 1));
        nxtBtn.addActionListener(e -> showProfile(index + 1));
    
        dashBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				DashboardFrame dashboardFrame = new DashboardFrame();
				dashboardFrame.setVisible(true);
			}
        });

        
        showProfile(index);
    }

    private void showProfile(int i) {
        List<List<String>> users = datingApp.seedData;

        if (i < 0 || i >= users.size()) return;
        index = i;

        List<String> user = users.get(i);

        namelbl.setText("Name: " + user.get(0) + " " + user.get(2));
        locationlbl.setText("Location: " + user.get(5) + ", " + user.get(6));
        aboutmelbl.setText("About me: Coming soon");
        agelbl.setText("Age: Coming soon");
        ocupationlbl.setText("Occupation: Coming soon");
        edulbl.setText("Education: Coming soon");
        hobieslb.setText("Hobbies: Coming soon");
        relationshiplbl.setText("Relationship goal: Coming soon");
        genderlbl.setText("Gender: Coming soon");
        interestlb.setText("Interested in: Coming soon");

        prevBtn.setEnabled(index > 0);
        nxtBtn.setEnabled(index < users.size() - 1);
    }
}
