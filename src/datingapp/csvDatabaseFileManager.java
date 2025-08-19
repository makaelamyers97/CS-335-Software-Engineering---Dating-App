package datingapp;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;

//AMCN refs for accessing files and directories in Java and reading writing CSVs
//https://www.google.com/search?q=java+baseapppath&sca_esv=31b5d553926d40b3&rlz=1C1CHBF_enUS934US934&sxsrf=AE3TifO-JBVx9IcezK5UVG_vPG6e-hzzng%3A1751775570860&ei=UvlpaJafNLWSwbkPm--b6AQ&ved=0ahUKEwiWkILFsKeOAxU1STABHZv3Bk0Q4dUDCBI&uact=5&oq=java+baseapppath&gs_lp=Egxnd3Mtd2l6LXNlcnAiEGphdmEgYmFzZWFwcHBhdGgyBhAAGA0YHjIIEAAYCBgNGB4yCBAAGAgYDRgeMggQABgIGA0YHjILEAAYgAQYhgMYigUyCxAAGIAEGIYDGIoFMgsQABiABBiGAxiKBTIFEAAY7wUyBRAAGO8FMgUQABjvBUjvcFAAWOBdcAR4AZABAJgBcqABjA6qAQQxNi40uAEDyAEA-AEBmAIYoALoDsICBBAjGCfCAgoQIxiABBgnGIoFwgIKEAAYgAQYQxiKBcICCxAAGIAEGJECGIoFwgINEAAYgAQYsQMYQxiKBcICCxAuGIAEGMcBGK8BwgIFEAAYgATCAgsQABiABBixAxiDAcICBRAuGIAEwgIHEAAYgAQYCsICBhAAGBYYHsICCBAAGBYYChgewgIHEAAYgAQYDcICBRAhGKABwgIFECEYnwXCAgcQIRigARgKmAMAkgcEMTguNqAHw5IBsgcEMTQuNrgH1w7CBwYwLjcuMTfIB04&sclient=gws-wiz-serp
//https://www.google.com/search?q=java+combine+directory+and+filename&rlz=1C1CHBF_enUS934US934&oq=java+combine+filepath&gs_lcrp=EgZjaHJvbWUqCAgBEAAYFhgeMgYIABBFGDkyCAgBEAAYFhgeMggIAhAAGBYYHjINCAMQABiGAxiABBiKBTINCAQQABiGAxiABBiKBTIHCAUQABjvBTIHCAYQABjvBTIKCAcQABiABBiiBNIBCDg0ODBqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8
//https://www.google.com/search?q=java+read+csv+to+list+with+empty+columns&sca_esv=3e1e3b3b9ee4e26b&rlz=1C1CHBF_enUS934US934&sxsrf=AE3TifOOjq5nSr_dDLqtSVAe6AnmxOBQYw%3A1751783296958&ei=gBdqaM-mOomYwbkPxvmrwA8&oq=java+read+csv+to+list+with+empty&gs_lp=Egxnd3Mtd2l6LXNlcnAiIGphdmEgcmVhZCBjc3YgdG8gbGlzdCB3aXRoIGVtcHR5KgIIAzIFECEYoAEyBRAhGKABMgUQIRigATIFECEYoAEyBRAhGKABMgUQIRifBTIFECEYnwVIizdQoA9YiyVwAXgBkAEAmAFooAHlB6oBBDEwLjG4AQHIAQD4AQGYAgygAo8IwgIKEAAYsAMY1gQYR8ICBhAAGBYYHsICCBAAGIAEGKIEwgIFECEYqwLCAgsQABiABBiGAxiKBcICBRAAGO8FwgIIEAAYogQYiQWYAwCIBgGQBgiSBwQxMC4yoAfgR7IHAzkuMrgHigjCBwYwLjEwLjLIBx4&sclient=gws-wiz-serp
//https://www.google.com/search?q=java+write+to+csv+with+header&rlz=1C1CHBF_enUS934US934&oq=java+write+to+csv+with+header&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIICAEQABgWGB4yDQgCEAAYhgMYgAQYigUyDQgDEAAYhgMYgAQYigUyCggEEAAYgAQYogQyCggFEAAYgAQYogQyCggGEAAYogQYiQXSAQkxMjA1NGowajmoAgCwAgA&sourceid=chrome&ie=UTF-8
//https://www.google.com/search?q=java+append+to+csv+file&sca_esv=3e1e3b3b9ee4e26b&rlz=1C1CHBF_enUS934US934&sxsrf=AE3TifOBexCIvvi2fH-fLPFLWFK25CIiWg%3A1751783455182&ei=HxhqaI7xCoKXwbkPueWusQY&ved=0ahUKEwjO_Mb0zaeOAxWCSzABHbmyK2YQ4dUDCBI&uact=5&oq=java+append+to+csv+file&gs_lp=Egxnd3Mtd2l6LXNlcnAiF2phdmEgYXBwZW5kIHRvIGNzdiBmaWxlMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yCxAAGIAEGIYDGIoFMggQABiiBBiJBTIFEAAY7wVI1StQAFijKnAAeAGQAQCYAcwCoAGwEKoBCDIxLjEuMC4xuAEDyAEA-AEBmAIXoAKCEcICBBAjGCfCAgoQIxiABBgnGIoFwgIKEAAYgAQYQxiKBcICCxAAGIAEGJECGIoFwgIOEC4YgAQYsQMYgwEYigXCAgsQLhiABBixAxiDAcICDRAAGIAEGLEDGBQYhwLCAhEQLhiABBjUAhjHARiOBRivAcICDRAAGIAEGLEDGEMYigXCAgUQABiABMICCBAuGIAEGLEDwgIKEAAYgAQYFBiHApgDAJIHCDIwLjIuMC4xoAfjsgGyBwgyMC4yLjAuMbgHghHCBwcwLjExLjEyyAdJ&sclient=gws-wiz-serp


public class csvDatabaseFileManager {

	public static String baseAppPath = System.getProperty("user.dir");
	
	public static String getFilePath(String fileName, Boolean isDbSeed) {
		String filePath = "";
		if (!isDbSeed) {
			filePath = Paths.get(baseAppPath).resolve(fileName).toString();
			//System.out.println(filePath);
		}
		else {			
			filePath = Paths.get(baseAppPath, "assets").resolve(fileName).toString();
			//System.out.println(filePath);
		}
		
		return filePath.toString();
	}
	
	public static List<List<String>> readCSVRows(String fileName, Boolean isDbSeed) {
		List<List<String>> data = new ArrayList<>();
				
		File f = new File(getFilePath(fileName, isDbSeed));
		if(!f.exists())
			return data;

		String line;
		String del = ",";
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			
			br.readLine(); //skip header
			
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(del, -1); // -1 allows us to include empty strings
                data.add(Arrays.asList(cols));    
                }
		}  
        catch(FileNotFoundException e) {
        	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        	JOptionPane.showMessageDialog((JFrame) activeWindow, "The file was not found: " + fileName + "\nClick OK to exit the app.");
        	System.exit(0);
        } catch(IOException e) {
        	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        	JOptionPane.showMessageDialog((JFrame) activeWindow, "Error reading file: " + fileName + "\nClick OK to exit the app.");
        	System.exit(0);
        }
		
		return data;
	}
	
	//NOT USED
	public static void createEmptyUserCSV() {						
		File f = new File(getFilePath("users.csv", false));
		try (PrintWriter writer = new PrintWriter(new FileWriter(f))) {
			writer.println("FirstName,MiddleInit,LastName,PhoneNum,Email,City,State,ZipCode,DateOfBirth,UserName,Password,Occupation");
			
		} catch (IOException e) {
			Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        	JOptionPane.showMessageDialog((JFrame) activeWindow, "Error writing the local user file. \nClick OK to exit the app.");
        	System.exit(0);
		}
		
	}
	
	public static void writeUserToCSV(User user) {
		File f = new File(getFilePath("dbSeeds.csv", true));
		
		try (FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw)) {
			pw.println(user.toString());
					
		}catch(FileNotFoundException e) {
        	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        	JOptionPane.showMessageDialog((JFrame) activeWindow, "The user file was not found:\nClick OK to exit the app.");
        	System.exit(0);
        } catch(IOException e) {
        	Window activeWindow = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
        	JOptionPane.showMessageDialog((JFrame) activeWindow, "Error writing to user file:\nClick OK to exit the app.");
        	System.exit(0);
        }
	}
	
	//Not Used
	public static void getUserFromCSV(String userName) {
		
		//Searches Assets/DbSeeds using readCSVRows()
		readCSVRows("dbSeeds.csv", true);
		//String searchFor = userInput
		//if userInput = userName
		//go to profile/user page
		//display data

	}
}
