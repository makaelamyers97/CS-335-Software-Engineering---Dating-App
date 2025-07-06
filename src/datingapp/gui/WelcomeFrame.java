package datingapp.gui;

import datingapp.User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import datingapp.User;

public class WelcomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WelcomeFrame(String userName) {
	//public WelcomeFrame(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 185);
		setLocationRelativeTo(null);

		contentPane = new JPanel(new BorderLayout(10, 10));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align:center;width:400px;'>" + userName + ", welcome to Swan Song!<br>" +
				"Get ready to retire from the dating scene!<br></div></html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);


	}
	}
