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
	// Default celebrate
	void celebrate() {
	
	}
	

	// Methods
	
	public void  setName(String newName) {
		// Set Name 
		name = newName;
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
	public String getName(){
		// Get player name 
		return name;
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
	// Constructors 
	
	NFLPlayer() {
		
	}
	
	NFLPlayer(String name, String playerType, int yearsPro, int careerTD, int careerTackles, int careerYards, int careerAge) {
		
	}
}