package datingapp.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppFrame extends JFrame{

public AppFrame() {				//can be used with all user gui files
		
		//Create the white inner pane for this page
		JPanel innerPanel = new JPanel();
		innerPanel.setBackground(Color.white);
		innerPanel.setBounds(20, 20, 320, 630); //x,y, w, h
		
		this.setTitle("Swan Song");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(375, 712); 	//x, y 812
		this.getContentPane().setBackground(Color.yellow);
		this.setVisible(false);
		this.add(innerPanel);

	}
}