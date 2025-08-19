package datingapp.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
@SuppressWarnings("serial")
public class WelcomeFrame extends AppFrame {

	/* Displays a welcome message. When the Dashboard button is clicked,
	 * takes the user to their dashboard.
	 */
	public WelcomeFrame(String userName, String firstName) {

		JPanel contentPane = new JPanel(new BorderLayout(10, 10));
		Border yellowBorder = BorderFactory.createLineBorder(Color.pink, 20);	
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                yellowBorder, new EmptyBorder(20, 20, 20, 20)));

		setContentPane(contentPane);

    	JLabel logoutLbl = Logout.createLabel(this);
    	contentPane.add(logoutLbl);
    	Dimension dimension = logoutLbl.getPreferredSize();
    	Insets insets = contentPane.getInsets();
    	int x = insets.left + 5;
    	int y = insets.top + 5;
    	logoutLbl.setBounds(x, y, dimension.width, dimension.height);

		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align:center;width:200px;'>" +"<br><br><br>" + firstName + ", welcome to Swan Song!<br>" +
				"Get ready to retire from the dating scene!<br></div></html>");
		
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
