/* Program: RegisteredUsers 
 * File: RegisteredUsers.java 
 * Summary: The registeredusers class loads already created users into an array from a csv file. 
 *          It contains the method for checking login and password information from the user upon login button click
 * Author: Lee Tompkins 
 * Date: August 3 2016
 * 
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class RegisteredUsers {
	// Data fileds
	private String[][] users = new String[500][500];
	private static final String COMMA_DELIMITER = ",";
	private static final int USER_USERNAME_INDEX = 0;
	private static final int USER_PASSWORD_INDEX = 1;
	private String userName;
	private String password;
   
	

	public String getPassword(){
		// get password
		return password;
	}
	
	public void setPassword(String password){
		// set password
		this.password = password;
	}
	
	public String getUserName(){
		// get username
		return userName;
	}
	public void setUserName(String username){
		//set username
		this.userName = username;
	}
	
		
	// check if login matches existing user 
	public boolean checkMatch(String usernameInput, String passwordInput){
		boolean match = false;
		for(int i = 0; i < 499;) {
			if (this.users[i][0] == null || this.users[i][1] == null) {
				System.out.println("NullpointCatch");
				i = 499;
			} else if (this.users[i][0].equals(usernameInput) && this.users[i][1].equals(passwordInput)){
				match = true; 
				System.out.println("MATCH");
				i = 499;
			} else {
				i++;
			}
		}
		return match;
	}
	
	
		
		
	
	
	
	public RegisteredUsers() {
		//this.userName = username;
	//	this.password = password;
	BufferedReader fileReader = null;
	
	int i = 0;
	
	
	try {
		
		String line = "";
		fileReader = new BufferedReader(new FileReader("srcCSV/users.csv"));
		
		
		
		while ((line = fileReader.readLine()) != null) {
			// split at the comma in the CSV file
			String[] values = line.split(COMMA_DELIMITER);
			if (values.length > 0 ) {
				// adds to user array at positions 
				this.users[i][0] = (values[USER_USERNAME_INDEX]);
				this.users[i][1] = (values[USER_PASSWORD_INDEX]);
				
				
				i++;
			}
		}
	
	}
		catch (Exception e) {
			System.out.println("Error in CSVFileReader");
			e.printStackTrace();
		} 		finally {
		try{
			fileReader.close();
			
		} catch (IOException e) {
			System.out.println("Error while closing fileReader");
			e.printStackTrace();
		}
	}

	}
}

