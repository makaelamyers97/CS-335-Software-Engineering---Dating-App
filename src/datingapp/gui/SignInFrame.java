package datingapp.gui;

import datingapp.User;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class SignInFrame extends JFrame {
	
	
	public SignInFrame() {
		
	    setTitle("User Sign In");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 90, 450, 450);
	    setLocationRelativeTo(null); 
	    setResizable(false);
	    
	    JPanel contentPane = new JPanel();
//	    https://www.geeksforgeeks.org/java/java-awt-boxlayout-class/
//	    use boxlayout() class to get elements to stack on top of eachother without running out of space
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));
        setContentPane(contentPane);

//        get space between elements
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
	    
//	    https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    
//	    JLabel label = new JLabel();
//        label.setIcon(new ImageIcon(new ImageIcon("\\assets\\swansDraft.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT)));
//        contentPane.add(label);
        
	    contentPane.add(Box.createRigidArea(new Dimension(0, 20))); 
	    
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
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				User user = new User();
				WelcomeFrame welcomeFrame = new WelcomeFrame(user);
				welcomeFrame.setVisible(true);
			}
		});   
	}
}