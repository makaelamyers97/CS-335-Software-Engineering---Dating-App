package datingapp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InitialFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public InitialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 185);
		setLocationRelativeTo(null);

		contentPane = new JPanel(new BorderLayout(10, 10));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align:center;width:400px;'>Thank you for your interest in joining Swan Song!<br>" +
				"Before going any further, we need to collect some basic information from you.<br>" +
				"Please respond to each question.</div></html>");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);

		JButton btnLetsBegin = new JButton("Let's Begin!");
		btnLetsBegin.setPreferredSize(new Dimension(150, 30));
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(btnLetsBegin);
		
		btnLetsBegin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				RegistrationFrame regFrame = new RegistrationFrame();
				regFrame.setVisible(true);
			}
	});
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
	}
	}
