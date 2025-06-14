package datingapp.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.BorderFactory;
import java.awt.event.*;

public class RegistrationFrame extends JFrame {

    public RegistrationFrame() {
        setTitle("User Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 25);
        setContentPane(contentPane);

        int leftCol = 0;

        addLabel(contentPane, gbc, "Name:", leftCol, 0);
        addTextField(contentPane, gbc, "First", leftCol, 1, 1);
        addTextField(contentPane, gbc, "MI", leftCol + 1, 1, 1);
        addTextField(contentPane, gbc, "Last", leftCol + 2, 1, 1);

        addLabel(contentPane, gbc, "Location:", leftCol, 2);
        addTextField(contentPane, gbc, "City", leftCol, 3, 1);
        addTextField(contentPane, gbc, "State", leftCol + 1, 3, 1);
        addTextField(contentPane, gbc, "Zip Code", leftCol, 4, 1);

        addLabel(contentPane, gbc, "Username:", leftCol, 5);
        addTextField(contentPane, gbc, "", leftCol, 6, 2);

        addLabel(contentPane, gbc, "Password:", leftCol, 7);
        addPasswordField(contentPane, gbc, "", leftCol, 8, 2);

        int rightCol = 4;

        addLabel(contentPane, gbc, "Date of Birth:", rightCol, 0);
        addTextField(contentPane, gbc, "DD/MM/YYYY", rightCol, 1, 2);

        addLabel(contentPane, gbc, "Phone Number:", rightCol, 2);
        addTextField(contentPane, gbc, "000-000-0000", rightCol, 3, 2);

        addLabel(contentPane, gbc, "Email:", rightCol, 4);
        addTextField(contentPane, gbc, "example@example.com", rightCol, 5, 2);

        gbc.gridy = 6;

        JButton enterBtn = new JButton("ENTER");
        enterBtn.setPreferredSize(new Dimension(120, 30));
        enterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new WelcomeFrame().setVisible(true);
            }
        });

        gbc.gridx = rightCol;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(enterBtn, gbc);
    }

    private void addLabel(JPanel panel, GridBagConstraints gbc, String text, int x, int y) {
    	GridBagConstraints copy_gbc = (GridBagConstraints) gbc.clone();
    	copy_gbc.gridx = x;
    	copy_gbc.gridy = y;
    	copy_gbc.gridwidth = 1;
    	copy_gbc.anchor = GridBagConstraints.WEST;
    	copy_gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel(text), copy_gbc);
    }

    private void addTextField(JPanel panel, GridBagConstraints gbc, String placeholder, int x, int y, int width) {
    	GridBagConstraints copy_gbc = (GridBagConstraints) gbc.clone();
    	copy_gbc.gridx = x;
    	copy_gbc.gridy = y;
    	copy_gbc.gridwidth = width;
    	copy_gbc.anchor = GridBagConstraints.WEST;
    	copy_gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JTextField(placeholder, 10), copy_gbc);
    }

    private void addPasswordField(JPanel panel, GridBagConstraints gbc, String placeholder, int x, int y, int width) {
    	GridBagConstraints copy_gbc = (GridBagConstraints) gbc.clone();
    	copy_gbc.gridx = x;
    	copy_gbc.gridy = y;
    	copy_gbc.gridwidth = width;
    	copy_gbc.anchor = GridBagConstraints.WEST;
    	copy_gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(new JPasswordField(10), copy_gbc);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationFrame().setVisible(true));
    }
}
