package datingapp.gui;

import javax.swing.*;
import java.awt.event.*;

public class Logout {

	public static JLabel createLabel(JFrame curFrame) {
		//https://stackoverflow.com/questions/14735085/clicking-a-jlabel-to-open-a-new-frame
		JLabel label = new JLabel("<html><u>Logout</u></html>");
		
		label.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e) { 
		    	JFrame signInFrame = new SignInFrame();
		    	signInFrame.setVisible(true);
		    	curFrame.dispose();
		    }    
		});
		
		return label;
	}
}