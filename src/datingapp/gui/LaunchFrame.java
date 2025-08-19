package datingapp.gui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/* If user clicks sign in, open InitialFrame
 * If user clicks sign up, open RegistrationFrame
 */
public class LaunchFrame extends AppFrame {	
	
	private static final long serialVersionUID = 1L;
	AppFrame LaunchFrame = new AppFrame();{	
		    
		EmptyBorder border = new EmptyBorder(30, 0, 0, 0);
	    
	    JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));
        setContentPane(contentPane);
        
        JLabel swanSongLbl = new JLabel("Swan Song");
	    swanSongLbl.setFont(new Font("Arial", Font.BOLD, 18));
	    swanSongLbl.setForeground(Color.magenta);
	    swanSongLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
	    swanSongLbl.setBorder(border);
	    contentPane.add(swanSongLbl);
	    
	    contentPane.add(Box.createRigidArea(new Dimension(0, 40))); 
	        
	    JButton signIn = new JButton("Sign In");
	    signIn.setAlignmentX(Component.CENTER_ALIGNMENT);
	    signIn.setFocusable(false);
        contentPane.add(signIn);

        signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				SignInFrame signInFrame = new SignInFrame();
				signInFrame.setVisible(true);
			}
		});
        
	    JButton signUp = new JButton("Sign Up");
	    signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
	    signUp.setFocusable(false);
        contentPane.add(signUp);

        signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				RegistrationFrame registrationFrame = new RegistrationFrame();
				registrationFrame.setVisible(true);
			}
		});
        
        this.setTitle("Landing Page");
        
	}
}