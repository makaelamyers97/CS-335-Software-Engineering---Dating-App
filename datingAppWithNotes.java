import java.util.ArrayList;
import java.util.Scanner;

public class datingAppWithNotes {

    public static class User {

        // all the user registration info
        private String firstName;
        private String lastName;
        private String middleInitial;
        private String userName;
        private String phoneNumber;
        private String email;
        private String city;
        private String state;
        private String zipCode;
        private String dateOfBirth;
        private String password;

        // public - accessed outside the class, part of class's public interface
        // void - not returning anything
        public void collectUserInfo() {
            
            // reads user input 
            Scanner userInfo = new Scanner(System.in);

            // collects user's first name, required, regex pattern, console view, no checkpoint, error message
            this.firstName = getValidInput(userInfo, true, "[A-Za-z]{2,}", "First Name: ", 0, "Error: First name must be letters only and at least two characters.");
            // collects user's last name, required, regex pattern, console view, no checkpoint, error message
            this.lastName = getValidInput(userInfo, true, "[A-Za-z]{2,}", "Last Name: ", 0, "Error: Last name must be letters only and at least two characters.");
            // collects user's middle initial, not required, regex pattern, console view, no checkpoint, error message
            this.middleInitial = getValidInput(userInfo, false, "[A-Za-z]?", "Middle Initial: ", 0, "Error: Middle initial must be one letter or left blank.");
            // collects user's username', required, regex pattern, console view, no checkpoint, error message
            this.userName = getValidInput(userInfo, true, ".{6,}", "Username: ", 0, "Error: Username must be at least 6 characters.");
            // collects user's phone number, required, regex pattern, console view, no checkpoint, error message
            this.phoneNumber = getValidInput(userInfo, true, "\\d{3}-\\d{3}-\\d{4}", "Phone Number (###-###-####): ", 0, "Error: Invalid phone number format.");
            // collects user's email, required, regex pattern, console view, no checkpoint, error message
            this.email = getValidInput(userInfo, true, ".+@.{2,}\\..{2,}", "Email: ", 0, "Error: Invalid email format.");
            // collects user's city, required, regex pattern, console view, no checkpoint, error message
            this.city = getValidInput(userInfo, true, "[A-Za-z\\s]{2,}", "City: ", 0, "Error: City must be letters only and at least two characters.");
            // collects user's state, required, regex pattern, console view, checkpoint 1, error message
            this.state = getValidInput(userInfo, true, "[A-Z]{2}", "State (e.g. NY): ", 1, "Error: Invalid US state abbreviation.");
            // collects user's zip code', required, regex pattern, console view, no checkpoint, error message
            this.zipCode = getValidInput(userInfo, true, "\\d{5}", "Zip Code: ", 0, "Error: Zip code must be 5 digits.");
            // collects user's birthday', required, regex pattern, console view, no checkpoint, error message
            this.dateOfBirth = getValidInput(userInfo, true, "\\d{2}/\\d{2}/\\d{4}", "Date of Birth (DD/MM/YYYY): ", 0, "Error: Invalid date format.");
            // collects user's password', required, regex pattern, console view, no checkpoint, error message
            this.password = getValidInput(userInfo, true, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{12,}$", "Password: ", 0, "Error: Password must be 12+ characters and include upper/lowercase, a digit, and special character.");

            // prints message welcoming new user
            System.out.println(this.userName + ", welcome to Swang Song! Get ready to retire from the dating scene!");
        }
    }

    // private - not accessible outside class, not public facing
    // static - returns a value
    // from collectUserInfo(): s = userInfo, isRequired = true/false , regexPattern = regex pattern, msg = console view, checkType = no checktype/1, errorMsg = error message
    private static String getValidInput(Scanner s, boolean isRequired, String regexPattern, String msg, int checkType, String errorMsg) {
        
        // infinite loop
        while (true) {

            // prints out console view message
            System.out.print(msg);
            // saves userInfo (scanner from collectUserInfo()) as variable input
            String input = s.nextLine();

            // if the input is required but is empty...
            if (isRequired && input.isEmpty()) {
                // print specific error message below
                System.out.println("Error: Required field.");
                // repeats question to ask user again
                continue;
            }

            // if input is not empty BUT it does not match it's required regex pattern...
            if (input.isEmpty() == false && input.matches(regexPattern) == false) {
                // print out error message assigned to that input (i.e. firtName, lastName, etc)
                System.out.println(errorMsg);
                // repeats question to ask user again
                continue;
            }

            // if checktype is 1 (i.e. state) and the input is not a valid state in the state array via the isValidState() function...
            if (checkType == 1 && isValidState(input) == false) {
                // print out error message assigned to state input
                System.out.println(errorMsg);
                // repeats question to ask user again
                continue;
            }

            // return user input
            return input;
        }
    }

    // boolean - has to be boolean instead of string so it can be compared to false in getValidInput() function
    // pass in user input from getValidInput() function
    private static boolean isValidState(String input) {

        // create a new array list called states
        ArrayList<String> states = new ArrayList<>();
        // creates a new array with all the possible state abbreviations 
        String[] allStates = {"AL", "AK", "AZ", "AR", "AS", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};

        // loops through the array of state abbreviations
        for (int i = 0; i < allStates.length; i++) {
            // adds each one to array list
            states.add(allStates[i]);
        }
        // if the user input is in the array list...
        if (states.contains(input)) {
            // return true
            return true;
        }
        // otherwise...
        else {
            // return false
            return false;
        }
    }

    public static void main(String[] args) {

        // print initial message to new user saying we need to collect some registration information 
        System.out.println("Thank you for your interest in joining Swang Song! Before going any further, we need to collect some basic information from you. Please respond to each question then press enter to continue. Let’s begin!");

        // create new user
        User user = new User();
        // collect user information 
        user.collectUserInfo();

    }
}