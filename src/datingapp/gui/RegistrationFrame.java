//https://www.tutorialspoint.com/swingexamples/index.htm
package datingapp.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Insets;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class RegistrationFrame extends JFrame {

    public RegistrationFrame() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 90, 600, 400);
        //https://www.tutorialspoint.com/how-to-display-a-jframe-to-the-center-of-a-screen-in-java
        setLocationRelativeTo(null); //center the window screen
        setResizable(false);

        // create the panel
        JPanel contentPane = new JPanel();
        Border yellowBorder = BorderFactory.createLineBorder(Color.yellow, 20);
        contentPane.setBorder(yellowBorder);
        setContentPane(contentPane);
        contentPane.setLayout(null); // we need to control the location to make things line up cleaner

        // Name
        JLabel nameLbl = new JLabel("Name");
        nameLbl.setSize(75, 30);
        nameLbl.setLocation(50, 30);
        nameLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(nameLbl);
        
        // First
        JTextField firstTxtFld = new JTextField();
        firstTxtFld.setSize(100, 20);
        firstTxtFld.setLocation(50, 65);
        contentPane.add(firstTxtFld);

        JLabel firstLbl = new JLabel("First");
        firstLbl.setSize(100, 20);
        firstLbl.setLocation(50, 80);
        firstLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(firstLbl);
        
        // Middle
        JTextField middleTxtFld = new JTextField();
        middleTxtFld.setSize(30, 20);
        middleTxtFld.setLocation(160, 65);
        contentPane.add(middleTxtFld);

        JLabel middleLbl = new JLabel("MI");
        middleLbl.setSize(100, 20);
        middleLbl.setLocation(160, 80);
        middleLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(middleLbl);

        // Last
        JTextField lastTxtFld = new JTextField();
        lastTxtFld.setSize(100, 20);
        lastTxtFld.setLocation(200, 65);
        contentPane.add(lastTxtFld);

        JLabel lastLbl = new JLabel("Last");
        lastLbl.setSize(100, 20);
        lastLbl.setLocation(200, 80);
        lastLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(lastLbl);
        
        // Location
        JLabel locationLbl1 = new JLabel("Location");
        locationLbl1.setSize(75, 30);
        locationLbl1.setLocation(50, 110);
        locationLbl1.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(locationLbl1);
        
        // City
        JTextField cityTxtFld = new JTextField();
        cityTxtFld.setSize(100, 20);
        cityTxtFld.setLocation(50, 140);
        contentPane.add(cityTxtFld);

        JLabel cityLbl = new JLabel("City");
        cityLbl.setSize(100, 20);
        cityLbl.setLocation(50, 155);
        cityLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(cityLbl);
        
        // State
        JTextField stateTxtFld = new JTextField();
        stateTxtFld.setSize(30, 20);
        stateTxtFld.setLocation(160, 140);
        contentPane.add(stateTxtFld);
        
        JLabel stateLbl = new JLabel("State");
        stateLbl.setSize(100, 20);
        stateLbl.setLocation(160, 155);
        stateLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(stateLbl);
        
        // Zip
        JTextField zipTxtFld = new JTextField();
        zipTxtFld.setSize(100, 20);
        zipTxtFld.setLocation(50, 180);
        contentPane.add(zipTxtFld);
        
        JLabel zipLbl = new JLabel("Zip Code");
        zipLbl.setSize(100, 20);
        zipLbl.setLocation(50, 195);
        zipLbl.setFont(new Font("Arial", Font.PLAIN, 10));
        contentPane.add(zipLbl);
        
        // username
        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setSize(100, 20);
        usernameLbl.setLocation(50, 230);
        usernameLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(usernameLbl);
        
        JTextField usernameTxtFld = new JTextField();
        usernameTxtFld.setSize(100, 20);
        usernameTxtFld.setLocation(50, 255);
        contentPane.add(usernameTxtFld);
        
        // password
        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setSize(100, 20);
        passwordLbl.setLocation(50, 285);
        passwordLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(passwordLbl);
        
        JTextField passwordTxtFld = new JTextField();
        passwordTxtFld.setSize(100, 20);
        passwordTxtFld.setLocation(50, 310);
        contentPane.add(passwordTxtFld);
        
        // dob
        JLabel dobLbl = new JLabel("Date of Birth");
        dobLbl.setSize(200, 20);
        dobLbl.setLocation(350, 33);
        dobLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(dobLbl);
        
        JTextField dobTxtFld = new JTextField();
        dobTxtFld.setSize(100, 20);
        dobTxtFld.setLocation(350, 65);
        dobTxtFld.setText("DD/MMM/YYYY");
        contentPane.add(dobTxtFld);
        
        // phone
        JLabel phoneLbl = new JLabel("Phone Number");
        phoneLbl.setSize(200, 20);
        phoneLbl.setLocation(350, 110);
        phoneLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(phoneLbl);
        
        JTextField phoneTxtFld = new JTextField();
        phoneTxtFld.setSize(100, 20);
        phoneTxtFld.setLocation(350, 140);
        phoneTxtFld.setText("000-000-000");
        contentPane.add(phoneTxtFld);
        
        // email
        JLabel emailLbl = new JLabel("Email");
        emailLbl.setSize(200, 20);
        emailLbl.setLocation(350, 180);
        emailLbl.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(emailLbl);
        
        JTextField emailTxtFld = new JTextField();
        emailTxtFld.setSize(200, 20);
        emailTxtFld.setLocation(350, 210);
        emailTxtFld.setText("ex: myname@example.com");
        contentPane.add(emailTxtFld);
        
        JButton enterBtn = new JButton("ENTER");
        enterBtn.setSize(120, 30);
        enterBtn.setLocation(365, 290);
        enterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeFrame().setVisible(true);
            }
        });
        
        contentPane.add(enterBtn);
        
    }
}
