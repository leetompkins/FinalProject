/* Program: PlayerManager 
 * File: PlayerManager.java
 * Summary: The playermanager loads all players and their stats from the CSV files for offense and defense into the player array. It has getters for positions that 
 *          return an arrayList of the players in the position. 
 * Author: Lee Tompkins 
 * Date: August 4 2016
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;





public class PlayerManager {
	public static final int MAX_PLAYERS = 2804;
	NFLPlayer[] playerArray = new NFLPlayer[MAX_PLAYERS];
	
	public ArrayList<NFLPlayer> getQBs() {
		ArrayList<NFLPlayer> qbArray = new ArrayList<NFLPlayer>();
		int j = 0;
		for (int i = 0; i < 115; i++) {
		qbArray.add(playerArray[j]);
		j++;
		}
		return qbArray;
	}
	
	public ArrayList<NFLPlayer> getRBs() {
		ArrayList<NFLPlayer> rbArray = new ArrayList<NFLPlayer>();
		int j = 115;
		for (int i = 0; i < 231; i++) {
			rbArray.add(playerArray[j]);
			j++;
		}
		return rbArray;
	}
	
	public ArrayList<NFLPlayer> getWRs() {
		ArrayList<NFLPlayer> wrArray = new ArrayList<NFLPlayer>();
		int j = 346;
		for (int i = 0; i < 381; i++) {
			wrArray.add(playerArray[j]);
			j++;
		}
		return wrArray;
	}
	
	public ArrayList<NFLPlayer> getTEs() {
		ArrayList<NFLPlayer> teArray = new ArrayList<NFLPlayer>();
		int j = 727;
		for (int i = 0; i < 200; i++) {
			teArray.add(playerArray[j]);
			j++;
		}
		return teArray;
	}
	
	public ArrayList<NFLPlayer> getOLs() {
		ArrayList<NFLPlayer> olArray = new ArrayList<NFLPlayer>();
		int j = 927;
		for (int i = 0; i < 534; i++) {
			olArray.add(playerArray[j]);
			j++;
		}
		return olArray;
	}
	
	public ArrayList<NFLPlayer> getDLs() {
		ArrayList<NFLPlayer> dlArray = new ArrayList<NFLPlayer>();
		int j = 1461;
		for (int i = 0; i < 414; i++) {
			dlArray.add(playerArray[j]);
			j++;
		}
		return dlArray;
	}
	public ArrayList<NFLPlayer> getLBs() {
		ArrayList<NFLPlayer> lbArray = new ArrayList<NFLPlayer>();
		int j = 1875;
		for (int i = 0; i < 394; i++) {
			lbArray.add(playerArray[j]);
			j++;
		}
		return lbArray;
	}
	public ArrayList<NFLPlayer> getDBs() {
		ArrayList<NFLPlayer> dbArray = new ArrayList<NFLPlayer>();
		int j = 2269;
		for (int i = 0; i < 535; i++) {
			dbArray.add(playerArray[j]);
			j++;
		}
		return dbArray;
	}
	
	
	// Player Manager Constructor 
	public PlayerManager() {
		createPlayers();
	}
	public void createPlayers(){

		final String COMMA_DELIMITER = ",";
		
		final int DEFENSE_POS_INDEX = 0;
		final int DEFENSE_NAME_INDEX = 1;
		final int DEFENSE_TACKLE_INDEX = 2;
		final int DEFENSE_SACK_INDEX = 3;
		final int DEFENSE_FORCEDFUMBLE_INDEX = 4;
		final int DEFENSE_INTERCEPTION_INDEX = 5;
		
		final int OFFENSE_POS_INDEX = 0;
		final int OFFENSE_NAME_INDEX = 1;
		final int OFFENSE_TD_INDEX = 2;
		final int OFFENSE_INTTHROWN_INDEX = 3;
		final int OFFENSE_YARDS_INDEX = 4;
		final int OFFENSE_CARRIES_INDEX = 5;
		final int OFFENSE_RECEPTIONS_INDEX = 6;
		
		//NFLPlayer[] tempArray = new NFLPlayer[2804];
		//public static void readCSVFile(String dPlayers) {
			BufferedReader fileReaderDefense = null;
			BufferedReader fileReaderOffense = null;
			int i = 1461;
			int j = 0;
			try {
				
				String line = "";
				fileReaderDefense = new BufferedReader(new FileReader("srcCSV/dPlayers.csv"));
				fileReaderOffense = new BufferedReader(new FileReader("srcCSV/oPlayers.csv"));
				fileReaderDefense.readLine();
				fileReaderOffense.readLine();
				while ((line = fileReaderOffense.readLine()) != null) {
					String[] values = line.split(COMMA_DELIMITER);
					if (values.length > 0 && j <= 1460) {
						playerArray[j] = new OffensivePlayer(values[OFFENSE_POS_INDEX] , values[OFFENSE_NAME_INDEX] , (Integer.parseInt(values[OFFENSE_TD_INDEX])) ,
								(Integer.parseInt(values[OFFENSE_INTTHROWN_INDEX])) , (Integer.parseInt(values[OFFENSE_YARDS_INDEX])) , (Integer.parseInt(values[OFFENSE_CARRIES_INDEX])) , 
								(Integer.parseInt(values[OFFENSE_RECEPTIONS_INDEX])));
						j++;
					}
				}
				while ((line = fileReaderDefense.readLine()) != null) {
					String[] values = line.split(COMMA_DELIMITER);
					if (values.length > 0 && i <= 2803) {
						
						//for (int i = 1461; i <= 2803; i++) {
							playerArray[i] = new DefensivePlayer( values[DEFENSE_POS_INDEX] , values[DEFENSE_NAME_INDEX] , (Integer.parseInt(values[DEFENSE_TACKLE_INDEX])) ,
									(Integer.parseInt(values[DEFENSE_SACK_INDEX])) , (Integer.parseInt(values[DEFENSE_FORCEDFUMBLE_INDEX])) , 
									(Integer.parseInt(values[DEFENSE_INTERCEPTION_INDEX])));
							i++;
									
						//}
					}
				}
				
				//for (int x = 0; x <= 2803; x++) {
					//System.out.println(playerArray[x].getName());
					
				//}
			}
			catch (Exception e) {
				System.out.println("Error in CSVFileReader");
				e.printStackTrace();
			} finally {
				try{
					fileReaderDefense.close();
					fileReaderOffense.close();
				} catch (IOException e) {
					System.out.println("Error while closing fileReader");
					e.printStackTrace();
				}
			}
			
	}
}
