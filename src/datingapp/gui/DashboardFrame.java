package datingapp.gui;

import datingapp.datingApp;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DashboardFrame extends AppFrame {								//CHANGED JFrame TO AppFrame
	    	
	AppFrame DashboardFrame = new AppFrame(); {								//ADDED, COMMENT OUT 30-36
	    	
	    	    
	    	    JPanel contentPane = new JPanel();
	            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	            Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 20);
	            contentPane.setBorder(BorderFactory.createCompoundBorder(
	                    yellowBorder, new EmptyBorder(20, 20, 20, 20)));
	            setContentPane(contentPane);

	    		EmptyBorder border = new EmptyBorder(10, 0, 0, 0);
	    	    
	    		JLabel swanLbl = new JLabel("Swan Song");
	    	    swanLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    	    swanLbl.setForeground(Color.GREEN);
	    	    swanLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    swanLbl.setBorder(border);
	    	    contentPane.add(swanLbl);

	    	    JLabel retireLbl = new JLabel("Retire from the dating scene!");
	    	    retireLbl.setFont(new Font("Arial", Font.PLAIN, 15));
	    	    retireLbl.setForeground(Color.GREEN);
	    	    retireLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    retireLbl.setBorder(border);
	    	    contentPane.add(retireLbl);
	    	       
	    	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    
	    	    // BEGIN ADD IMAGE
	    	    
	    	    JLabel imageLabel = new JLabel();
	    	    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

	    	    String basePath = System.getProperty("user.dir");
	    	    String imagePath = Paths.get(basePath, "assets", "swans_with_background.JPG").toString();
	    	    ImageIcon imageIcon = new ImageIcon(imagePath);

	    	    Image image = imageIcon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);		//ADJUSTED IMAGE FROM 350 TO FIT ON THE FRAME
	    	    imageIcon = new ImageIcon(image);

	    	    imageLabel.setIcon(imageIcon);
	    	    contentPane.add(imageLabel);

	    	    // END ADD IMAGE
	    	    
	    	    contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
	    	 
	    	    JButton btnMyProfile = new JButton("My Profile");
	    	    btnMyProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    btnMyProfile.setBounds(150, 250, 100, 30); 
	    	    btnMyProfile.setFocusable(false);
	            contentPane.add(btnMyProfile);
	            
	    	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    
	    	    JButton btnAllProfiles = new JButton("Available Profiles");
	    	    btnAllProfiles.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    btnAllProfiles.setBounds(150, 250, 100, 30); 
	    	    btnAllProfiles.setFocusable(false);
	            contentPane.add(btnAllProfiles);
	            
	            btnAllProfiles.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent e) {
	                AvailableProfilesFrame AvailableFrame = new AvailableProfilesFrame();
	                AvailableFrame.setVisible(true);
	            	}
	            });
	    	    
	    	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    	    
	    	    JButton btnMatches = new JButton("My Matches");
	    	    btnMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    btnMatches.setBounds(150, 250, 100, 30); 
	    	    btnMatches.setFocusable(false);
	            contentPane.add(btnMatches);
	            
	    	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    
	    	    JButton btnConvos = new JButton("My Conversations");
	    	    btnConvos.setAlignmentX(Component.CENTER_ALIGNMENT);
	    	    btnConvos.setBounds(150, 250, 100, 30); 
	    	    btnConvos.setFocusable(false);
	            contentPane.add(btnConvos);
	            
	            //Modifies the AppFrame for this page
	            this.setTitle("Dashboard");
	            
	    	}

	    }
