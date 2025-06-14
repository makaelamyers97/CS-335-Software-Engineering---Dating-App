package datingapp;
import java.util.ArrayList;
import java.util.Scanner;

public class datingApp {

    public static class User {

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

        public void collectUserInfo() {
            
            Scanner userInfo = new Scanner(System.in);

            this.firstName = getValidInput(userInfo, true, "[A-Za-z]{2,}", "First Name: ", 0, "Error: First name must be letters only and at least two characters.");
            this.lastName = getValidInput(userInfo, true, "[A-Za-z]{2,}", "Last Name: ", 0, "Error: Last name must be letters only and at least two characters.");
            this.middleInitial = getValidInput(userInfo, false, "[A-Za-z]?", "Middle Initial: ", 0, "Error: Middle initial must be one letter or left blank.");
            this.userName = getValidInput(userInfo, true, ".{6,}", "Username: ", 0, "Error: Username must be at least 6 characters.");
            this.phoneNumber = getValidInput(userInfo, true, "\\d{3}-\\d{3}-\\d{4}", "Phone Number (###-###-####): ", 0, "Error: Invalid phone number format.");
            this.email = getValidInput(userInfo, true, ".+@.{2,}\\..{2,}", "Email: ", 0, "Error: Invalid email format.");
            this.city = getValidInput(userInfo, true, "[A-Za-z\\s]{2,}", "City: ", 0, "Error: City must be letters only and at least two characters.");
            this.state = getValidInput(userInfo, true, "[A-Z]{2}", "State (e.g. NY): ", 1, "Error: Invalid US state abbreviation.");
            this.zipCode = getValidInput(userInfo, true, "\\d{5}", "Zip Code: ", 0, "Error: Zip code must be 5 digits.");
            this.dateOfBirth = getValidInput(userInfo, true, "\\d{2}/\\d{2}/\\d{4}", "Date of Birth (DD/MM/YYYY): ", 0, "Error: Invalid date format.");
            this.password = getValidInput(userInfo, true, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{12,}$", "Password: ", 0, "Error: Password must be 12+ characters and include upper/lowercase, a digit, and special character.");

            System.out.println(this.userName + ", welcome to Swang Song! Get ready to retire from the dating scene!");
        }
    }

    private static String getValidInput(Scanner s, boolean isRequired, String regexPattern, String msg, int checkType, String errorMsg) {
        
        while (true) {

            System.out.print(msg);
            String input = s.nextLine();

            if (isRequired && input.isEmpty()) {
                System.out.println("Error: Required field.");
                continue;
            }

            if (input.isEmpty() == false && input.matches(regexPattern) == false) {
                System.out.println(errorMsg);
                continue;
            }

            if (checkType == 1 && isValidState(input) == false) {
                System.out.println(errorMsg);
                continue;
            }

            return input;
        }
    }

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

        System.out.println("Thank you for your interest in joining Swang Song! Before going any further, we need to collect some basic information from you. Please respond to each question then press enter to continue. Let’s begin!");

        User user = new User();
        user.collectUserInfo();

    }
}