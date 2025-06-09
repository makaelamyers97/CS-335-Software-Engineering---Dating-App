package MidtermDatingAppTests;					//THIS MAY NEED TO BE CHANGED

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import DatingAppPkg.datingApp;					//THIS MAY NEED TO BE UPDATED

class DatingAppTests {

	//First Name tests pass if True
		@ParameterizedTest
		@DisplayName("Tests first name 2 - 4 char inputs.")
		@ValueSource(strings = {"Suzy", "Al", "Sue"})
		void testFirstNameMatchesRegex(String f) {
			assertTrue(Pattern.matches("[A-Za-z]{2,}", f));
		}
		
		//First Name pass if False
		@ParameterizedTest
		@DisplayName("Tests first name empty, single char number, symbol inputs.")
		@ValueSource(strings = {"", "Suzy123", "S", "12", "!@#$^&*()_+"})
		void testFirstNameDoesNotMatchRegex(String f) {
			assertFalse(Pattern.matches("[A-Za-z]{2,}", f));
		}
		
		//Last Name pass if True
		@ParameterizedTest
		@DisplayName("Tests last name 2 - 5 char inputs.")
		@ValueSource(strings = {"Smith", "Vu", "Roy"})
		void testLastNameMatchesRegex(String l) {
			assertTrue(Pattern.matches("[A-Za-z]{2,}", l));
		}
		//Last Name pass if False
		@ParameterizedTest
		@DisplayName("Tests last name empty, single char, number, symbol inputs.")
		@ValueSource(strings = {"", "Smith123", "V", "12", "!@#$^&*()_+"})
		void testLastNameDoesNotMatchRegex(String l) {
			assertFalse(Pattern.matches("[A-Za-z]{2,}", l));
		}
		
		//Middle initial pass if True (empty or 1 character)
		@ParameterizedTest
		@DisplayName("Tests single char for middle initial or empty")
		@ValueSource(strings = {"", "s"})
		void testMiddleInitialMatchesRegex(String mi) {
			assertTrue(Pattern.matches("[A-Za-z]?", mi));
		}
		
		//Middle initial pass if False
		@ParameterizedTest
		@DisplayName("Tests middle initial 2 char, number, symbol inputs")
		@ValueSource(strings = {"Al", "12", "!@#$^&*()_+"})
		void testMiddleInitialDoesNotMatchRegex(String mi) {
			assertFalse(Pattern.matches("[A-Za-z]?", mi));
		}
		
		//UserName pass if True
		@ParameterizedTest
		@DisplayName("Tests user name 6 and 12 char, char number combination inputs.")
		@ValueSource(strings = {"Sharky", "Knights12345"})
		void testUserNameMatchesRegex(String u) {
			assertTrue(Pattern.matches(".{6,}", u));
		}
		
		//UserName pass if False
		@ParameterizedTest
		@DisplayName("Tests user name empty, 5 char, 5 number inputs")
		@ValueSource(strings = {"shark", "", "11111"})
		void testUserNameDoesNotMatchRegex(String u) {
			assertFalse(Pattern.matches(".{6,}", u));
		}
		
		//Phone number pass if True 
		@ParameterizedTest
		@DisplayName("Tests phone number 3 digit, hyphen, 3 digit, hyphen, 4 digit input.")
		@ValueSource(strings = {"401-777-8899"})
		void testPhoneMatchesRegex(String p) {
			assertTrue(Pattern.matches("\\d{3}-\\d{3}-\\d{4}", p));
		}
		
		//Phone pass if False
		@ParameterizedTest
		@DisplayName("Tests phone number empty, text and spaces, non 10-digit inputs.")
		@ValueSource(strings = {"", "4017778899", "14017778899", "1 401 777 8899", "401 777 8899", "777 8899", "40-777-8899", "four one one"})
		void testPhoneDoesNotMatchRegex(String p) {															//LOOKUP LAMBDA
			assertFalse(Pattern.matches("\\d{3}-\\d{3}-\\d{4}", p), "Phone format is valid.");
		}
			
		//Email tests pass if True
		@ParameterizedTest
		@DisplayName("Tests email must pass formats.")
		@ValueSource(strings = {"Smith124@youremail.com","Vu@youremail.com", "V@youremail.com", "Smith@ym.com", "Vu@youremail.co", "Smith@youremail.comz"})
		void testEmailMatchesRegex(String e) {				
			//testEmailPromptInputErrorMsg
			assertTrue(Pattern.matches(".+@.{2,}\\..{2,}", e), "Fail");
			
		}
		
		//Email tests pass if False
		@ParameterizedTest	
		@DisplayName("Test email must fail formats.")
		@ValueSource(strings = {"","Smith@m.com", "V@youremail.c", "12", "#$"})
		void testEmailDoNotMatchRegex(String e) {
			
			assertFalse(Pattern.matches(".+@.{2,}\\..{2,}", e), "Fail");
		}
		
		//City tests pass if True
		@ParameterizedTest
		@DisplayName("Test city 2 or more char no digit inputs.")
		@ValueSource(strings = {"Boston", "bo" })
		void testCityMatchesRegex(String c) {
			assertTrue(Pattern.matches("[A-Za-z\\\\s]{2,}", c), "City regex does not match.");
		}
		
		//City tests pass if False
		@ParameterizedTest
		@DisplayName("Test city empty, single char, digit inputs.")
		@ValueSource(strings = {"", "B", "Boston123", "12" })
		void testCityDoesNotMatchRegex(String c) {
			assertFalse(Pattern.matches("[A-Za-z\\\\s]{2,}", c), "City format is valid.");
		}
			
		//State tests pass if True
		@ParameterizedTest
		@DisplayName("Tests state PATTERN for 2 char no digit inputs.")
		@ValueSource(strings = {"MA", "NO"})
		void testStateMatchesRegex(String st) {
			assertTrue(Pattern.matches("[A-Z]{2}", st), "State pattern invalid");
		}
		
		//State tests pass if False
		@ParameterizedTest
		@DisplayName("Tests state empty, single char, > 2 char, digit inputs")
		@ValueSource(strings = {"", "Massachusetts", "Mass123", "123", "ma", "Ma"})
		void testStateDoesNotMatchRegex(String st) {
			assertFalse(Pattern.matches("[A-Z]{2}", st), "State pattern is valid");
		}
		
		
		//Verify every state is in array
		@Test
		@DisplayName("Test 50 state abbreviations & DC.")
		void testStateContainsEveryAbbreviation() {
			String[] testStatesArray = {"AL", "AK", "AR", "AZ", "CA", "CO","CT", "DC", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA",
					"KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV","NY",
					"OK", "OH", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV","WY"};
					
					for (String abbreviation : testStatesArray) {
						//assertTrue(abbreviation + "Abbreviation not in array.", EmailInput.isValidState(abbreviation));
						assertTrue(datingApp.isValidState(abbreviation), abbreviation + " is not in array.");			//MAKAELA YOUR FUNCTION NEEDS TO BE PUBLIC FOR ME TO TEST THIS. LINE 68
					}
		}
		
		//Zipcode tests pass if True
		@ParameterizedTest
		@DisplayName("Test zipcode is 5 digits")
		@ValueSource(strings = {"12345"})
		void testZipcodeMatchesRegex(String z) {
			assertTrue(Pattern.matches("\\d{5}", z), "Zip is invalid");
		}
		
		//Zipcode tests pass if False
		@ParameterizedTest
		@DisplayName("Test zipcode is > 5 < 5 digits or empty or char inputs.")
		@ValueSource(strings = {"", "abc", "1244", "1a2bc"})
		void testZipcodeDoesNotMatchRegex(String z) {
			assertFalse(Pattern.matches("\\d{5}", z), "Zip is valid");
		}
		
		//Date of birth passes if True
		@ParameterizedTest
		@DisplayName("Tests dob is mm/dd/yyyy format.")
		@ValueSource(strings = {"02/29/1988", "02/08/2028", "02/29/1888" })
		void testDOBMatchesRegex(String d) {
			assertTrue(Pattern.matches("\\d{2}/\\d{2}/\\d{4}", d), "Date of Birth format is invalid");
		}
		
		//Date of birth passes if False
		@ParameterizedTest
		@DisplayName("Tests dob is mm/dd/yyyy format.")
		@ValueSource(strings = {"", "2/29/1988", "02/29/88", "2/29/88", "02-29-1988", "2-29-1988","02-29-88", "2-29-88", "February 29, 1988"})
		void testDOBDoesNotMatchRegex(String d) {
			assertFalse(Pattern.matches("\\d{2}/\\d{2}/\\d{4}", d), "Date of Birth format is valid");
		}
		
		//Password tests pass if True
		@ParameterizedTest
		@DisplayName("Test password meets requirements")
		@ValueSource(strings = {"“Enterhere!25", "“EnterHere!?2025"})
		void testPasswordMatchesRegex(String pw) {
			assertTrue(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{12,}$", pw), "Password is invalid");
		}
		
		//Password test pass if False
		@ParameterizedTest
		@DisplayName("Test password does not meet requirements.")
		@ValueSource(strings = {"", "“Enter123!", "enterhere123!", "ENTERHERE23!", "Enterhere!!!", "“E1234567890!", "“Enterhere123"})
		void testPasswordDoesNotMatchRegex(String pw) {
			assertFalse(Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[^a-zA-Z0-9]).{12,}$", pw), "Password is valid");
		}


}

/*
 *Sources: 
 * @Parameterized--https://mcaden.medium.com/writing-parameterized-unit-tests-in-java-with-junit-5-run-the-same-test-with-various-inputs-ea0b7d66d31
 *Junit Basics--https://www.youtube.com/watch?v=2E3WqYupx7c&list=PLqq-6Pq4lTTa4ad5JISViSb2FVG8Vwa4o
*/
