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
@SuppressWarnings("serial")
public class SignInFrame extends AppFrame {	
	
	AppFrame signInFrame = new AppFrame();{	
	
//	public SignInFrame() {
//		
//	    setTitle("User Sign In");
//	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    setBounds(100, 90, 450, 550);
//	    setLocationRelativeTo(null); 
//	    setResizable(false);
	    
	    JPanel contentPane = new JPanel();
//	    https://www.geeksforgeeks.org/java/java-awt-boxlayout-class/
//	    use boxlayout() class to get elements to stack on top of eachother without running out of space
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));
        setContentPane(contentPane);

//        get space between elements
		EmptyBorder border = new EmptyBorder(10, 0, 0, 0);
	    
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
	    
//	    https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
	    //contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	       
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    
	    // BEGIN ADD IMAGE
	    JLabel imageLabel = new JLabel();
	    imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

	    String basePath = System.getProperty("user.dir");
	    String imagePath = Paths.get(basePath, "assets", "swans_with_background.JPG").toString();
	    ImageIcon imageIcon = new ImageIcon(imagePath);

	    Image image = imageIcon.getImage().getScaledInstance(200, 120, Image.SCALE_SMOOTH);				//CHANGED 350 TO 200 TO ACCOMMODATE FRAME
	    imageIcon = new ImageIcon(image);

	    imageLabel.setIcon(imageIcon);
	    contentPane.add(imageLabel);

	    // END ADD IMAGE
	    
	    contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
	    
	    JLabel usernameLbl = new JLabel("Username:");
	    usernameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    usernameLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    contentPane.add(usernameLbl);
	    
	    JTextField usernameTxtFld = new JTextField(15); 
	    usernameTxtFld.setMaximumSize(new Dimension(200, 30));
	    usernameTxtFld.setAlignmentX(Component.CENTER_ALIGNMENT);
	    contentPane.add(usernameTxtFld);
	    
	    
	    JButton btnForgotUser = new JButton("Forgot Username");
	    btnForgotUser.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnForgotUser.setBounds(150, 250, 100, 30); 
	    btnForgotUser.setFocusable(false);
        contentPane.add(btnForgotUser);
        
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 

	    JLabel passwordLbl = new JLabel("Password:");
	    passwordLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    passwordLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    contentPane.add(passwordLbl);
	    
	    JPasswordField passwordTxtFld = new JPasswordField(15);
	    passwordTxtFld.setMaximumSize(new Dimension(200, 30)); 
	    passwordTxtFld.setAlignmentX(Component.CENTER_ALIGNMENT);
	    contentPane.add(passwordTxtFld);
	    
	    JButton btnForgotPass = new JButton("Forgot Password");
	    btnForgotPass.setAlignmentX(Component.CENTER_ALIGNMENT);
	    btnForgotPass.setBounds(150, 250, 100, 30); 
	    btnForgotPass.setFocusable(false);
        contentPane.add(btnForgotPass);
	    
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    	    
	    JButton btnLogin = new JButton("Login");
	    btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setBounds(150, 250, 100, 30); 
        btnLogin.setFocusable(false);
        contentPane.add(btnLogin);
        
        

		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				dispose();
				Boolean isAuthenticated = false;
				for (List<String> row : datingApp.seedData) {	
					
					String username = row.get(9);
					String pw = row.get(10);
										
					if (username.toLowerCase().equals(usernameTxtFld.getText().toLowerCase())
							&& pw.equals(passwordTxtFld.getText())) {
						
						isAuthenticated = true;
						
						DashboardFrame profile = new DashboardFrame(username);						
						profile.setVisible(true);
						
						break;
					}
		    			
				}
				
    			if(!isAuthenticated) {
    				Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
	            	JOptionPane.showMessageDialog((JFrame) activeWindow, "You have entered an invalid username or password.\nClick OK to exit the app.");
	            	System.exit(0);
    			}
				
			}
		});   
		
		//Modifies the AppFrame for this page
		this.setTitle("Sign In");
	}
}