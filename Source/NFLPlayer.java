

/**Program: NFL Player Class
 * File: NFLPlayer.java
 * Summary: Abstract NFL Player Class, A class for the creation of NFL Players with two Subclasses, OffensivePlayer, and DefensivePlayer
 * Milestone 6 Assignment 
 * Week5 CST100
 * Author: Lee Tompkins
 * Date: July 24 2016
 **/
public abstract class NFLPlayer implements Celebrator {
	// Data Fields
	protected String name;
	protected String position;
	protected  int yearsPro;
	protected  int age;
	protected  int weight;
	protected  int height;
	private String number = " ";
	// Default celebrate
	public String celebrate() {
		return "";
	}
	

	// Methods
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber(){
		return number;
	}
	
	public void  setName(String newName) {
		// Set Name 
		this.name = newName;
	}
	public void setYears(int newYearsPro){
		//Set years Pro
		yearsPro = newYearsPro;
	} 
	public void setPosition(String position) {
		//Set position
		this.position = position;
	}
	public void setWeight(int weight) {
		// set weight
		this.weight = weight;
	}
	public void setHeight(int height){
		// set height 
		this.height = height;
	}
	public void setAge(int age){
		// set age 
		this.age = age;
	}
	@Override
	public String toString() {
		return position + " " + name ;
	}

	public String toString2(){
		return position + " " + name;
	}
	public String toString3(){
		return position + " " + name;
	}
	public String toString4(){
		return position + " " + name;
	}
	public String toString5(){
		return position + " " + name;
	}
	public String toString6(){
		return position + " " + name;
	}
	public String toString7(){
		return position + " " + name;
	}
	public String toStringYearsPro(){
		// Sets random years pro (Not enough time to add more data to my csv files )
		return "Years Pro: " + (int)(Math.random() * 14);
	}
	public String toStringWeight(){
		return "Weight lbs: " + (int)(Math.random() * (320 - 200) + 200); 
	}
	public String toStringHeight(){
		return "Height inches: " + (int)(Math.random() * (82 - 68) + 68);
	}
	public String toStringNumber() {
		return "Player Number: " + number;
	}
	
	public String getName(){
		// Get player name 
		return this.name;
	}
	public String getPosition(){
		// get position 
		return position;
	}
	public int getWeight(){
		// get weight 
		return weight;
	}
	public int getAge(){
		// Get player age 
		return age;
	}
	public int getHeight(){
		// get height 
		return height;
	}
	//public String getQBs(){
		//for (int i = 0; i < 2804; i++) {
			//if (PlayerManager.class.playerArray[i].getPosition == "QB")
		//}
	//}
	// Constructors 
	
	NFLPlayer() {
		
	}
	
	NFLPlayer(String name, String playerType, int yearsPro, int careerTD, int careerTackles, int careerYards, int careerAge) {
		
	}
}