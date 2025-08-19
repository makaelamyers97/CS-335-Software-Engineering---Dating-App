
package datingapp.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
@SuppressWarnings("serial")

public class DashboardFrame extends AppFrame {
	/* Presents the user with options for displaying available profiles and
	 * Liked profiles. On available profiles, user can like and dislike profiles.
	 * Liked and disliked profiles are removed from available profiles. The 
	 * "authenticated" user's username is paired with the usernames of all their 
	 * likes in the dbLikes csv. Dislikes are saved in the dbDislikes csv.
	 * The user can go to their own profile or logout of the app. We have yet
	 * to build out the MyConversations flow. */
	public DashboardFrame(String userName) {
				
		JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));
        setContentPane(contentPane);

		EmptyBorder border = new EmptyBorder(10, 0, 0, 0);
		
		JLabel logoutLbl = Logout.createLabel(this); 
		Box topBox = Box.createHorizontalBox();
		topBox.add(Box.createHorizontalGlue());
		topBox.add(logoutLbl);
		topBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, logoutLbl.getPreferredSize().height));
		topBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.add(topBox);
		    
		JLabel swanLbl = new JLabel("Swan Song");
	    swanLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    swanLbl.setForeground(Color.magenta);
	    swanLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    swanLbl.setBorder(border);
	    contentPane.add(swanLbl);

	    JLabel retireLbl = new JLabel("Retire from the dating scene!");
	    retireLbl.setFont(new Font("Arial", Font.PLAIN, 15));
	    retireLbl.setForeground(Color.magenta);
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

	    Image image = imageIcon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);
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

        btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				MyProfileFrame MyProfileFrame = new MyProfileFrame(userName);
				MyProfileFrame.setVisible(true);
			}
		});
        
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    
	    JButton btnAllProfiles = new JButton("Available Profiles");
	    btnAllProfiles.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnAllProfiles.setBounds(150, 250, 100, 30); 
	    btnAllProfiles.setFocusable(false);
        contentPane.add(btnAllProfiles);
        
        btnAllProfiles.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();								//ADDED TO CLOSE DASH B4 GOING TO ALL PROFILES
            AvailableProfilesFrame AvailableFrame = new AvailableProfilesFrame(userName);
            AvailableFrame.setVisible(true);
        	}
        });
	    
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    
	    JButton btnMatches = new JButton("My Likes");
	    btnMatches.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnMatches.setBounds(150, 250, 100, 30); 
	    btnMatches.setFocusable(false);
        contentPane.add(btnMatches);
        btnMatches.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose(); 			//ADDED TO CLOSE DASH B4 GOING TO MYLIKES
            MyLikesProfileFrame MatchesFrame = new MyLikesProfileFrame(userName);
            MatchesFrame.setVisible(true);
        	}
        });

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