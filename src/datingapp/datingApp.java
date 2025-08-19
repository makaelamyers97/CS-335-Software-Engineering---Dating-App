package datingapp;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.List;

import javax.swing.SwingUtilities;

import datingapp.gui.LaunchFrame;

public class datingApp {

	public static List<List<String>> seedData;
    public static boolean isValidState(String input) {

        ArrayList<String> states = new ArrayList<>();
        String[] allStates = {"AL", "AK", "AZ", "AR", "AS", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        for (int i = 0; i < allStates.length; i++) {
            states.add(allStates[i]);
        }
        if (states.contains(input)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {

    	//Get "database" for any initial use
    	seedData = csvDatabaseFileManager.readCSVRows("dbSeeds.csv", true);
    	if(seedData != null && !seedData.isEmpty()) {
    		User u = new User();
    		u.batchSetUser(u, seedData);    		
    	}
    	
    	// opens the first page of the app so the user can sign in or register
    	SwingUtilities.invokeLater(() -> new LaunchFrame().setVisible(true));
   
    }
}