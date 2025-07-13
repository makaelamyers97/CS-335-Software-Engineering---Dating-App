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

    	//Get "database"
    	seedData = csvDatabaseFileManager.readCSVRows("dbSeeds.csv", true);
    	if(seedData != null && !seedData.isEmpty()) {
    		User u = new User();
    		u.batchSetUser(u, seedData);    		
    	}
    	
    	//List<List<String>> localData = csvFileManager.readCSVRows("users.csv", false);
    	//if(localData != null && !localData.isEmpty()) {
    		
        	//for (List<String> row : localData)
        		//System.out.println(row);   
    		
    		//User u = new User();
    		//u.batchSetUser(u, localData);    		
    	//}
    	//else {
    		//csvFileManager.createEmptyUserCSV();
    	//} 	
    	
    	
    	SwingUtilities.invokeLater(() -> new LaunchFrame().setVisible(true));
    	
    }
}