package datingapp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WelcomeFrame extends JFrame {
//	
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Create the frame.
//	 */
	public WelcomeFrame(String userName) {
	//public WelcomeFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 185);
		setLocationRelativeTo(null);

		JPanel contentPane = new JPanel(new BorderLayout(10, 10));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align:center;width:180px;'>" + userName + ", welcome to Swan Song!<br>" +
				"Get ready to retire from the dating scene!<br></div></html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

	    JButton signUp = new JButton("Go to Dashboard");
	    signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
	    signUp.setFocusable(false);

        signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				DashboardFrame dashboardFrame = new DashboardFrame();
				dashboardFrame.setVisible(true);
			}
	});
		contentPane.add(signUp, BorderLayout.SOUTH);
	}
	}
