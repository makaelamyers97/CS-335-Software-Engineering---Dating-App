package datingapp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class WelcomeFrame extends AppFrame {
//	
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Create the frame.
//	 */
	public WelcomeFrame(String userName) {
	//public WelcomeFrame(User user) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		setSize(500, 185);
//		setLocationRelativeTo(null);
		

		JPanel contentPane = new JPanel(new BorderLayout(10, 10));
		Border yellowBorder = BorderFactory.createLineBorder(Color.YELLOW, 20);	
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));

		setContentPane(contentPane);

		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align:center;width:200px;'>" +"<br><br><br>" + userName + ", welcome to Swan Song!<br>" +
				"Get ready to retire from the dating scene!<br></div></html>");
		//lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

	    JButton signUp = new JButton("Go to Dashboard");
	    signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
	    signUp.setFocusable(false);

        signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				DashboardFrame dashboardFrame = new DashboardFrame(userName);
				dashboardFrame.setVisible(true);
			}
	});
		contentPane.add(signUp, BorderLayout.SOUTH);
		
		//Modified the AppFrame for this page
		this.setTitle("Welcome");
	}
	}
