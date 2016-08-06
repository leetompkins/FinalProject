/* Program: RegisterUsers 
 * File: RegisterUser.java
 * Summary: RegisterUser class is initialized just before the register button in the Main.class 
 *          This class handles new user username and passwords upon clicking the register button. It writes the new user information to the users.csv file
 * Author: Lee Tompkins 
 * Date: August 4 2016
 * 
 */
import java.io.FileWriter;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;




public class RegisterUser {
	//private List<User> users = new ArrayList<User>();
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPERATOR = "\n";
	//private static final int USER_USERNAME_INDEX = 0;
	//private static final int USER_PASSWORD_INDEX = 1;
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	
	
	public RegisterUser(String userName, String password){
		int lineCounter = 0;
		this.userName = userName;
		this.password = password;
		
		BufferedReader fileReader = null;
		try{
			String line = "";
			fileReader = new BufferedReader(new FileReader("srcCSV/users.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				if (values.length > 0) {
					lineCounter++;
				
				} else;
			}
		}
			catch (Exception e) {
				System.out.println("Error in FileReader");
				e.printStackTrace();
			} finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.out.println("Error while closing fileReader");
					e.printStackTrace();
				}
			
		
	
		FileWriter fileWriter = null;
		try{
			//for(int i = 0; i <= lineCounter; i++) {
				//fileWriter.append(NEW_LINE_SEPERATOR);
		//	}
			System.out.println(lineCounter);
			fileWriter = new FileWriter("srcCSV/users.csv", true);
			fileWriter.append(userName);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(password);
			fileWriter.append(NEW_LINE_SEPERATOR);
		
		System.out.println("Username added successfully");
	} catch (Exception e) {
		System.out.println("error in fileWriter");
		e.printStackTrace();
	} finally {
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Error while closing / flushing fileWriter");
			e.printStackTrace();
		}
	}
	}
	}
}
