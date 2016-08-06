/**Program: DefensivePlayer Class
 * File: DefensivePlayer.java
 * Summary: A class for the creation of Defensive NFL players, this class is a subclass of NFLPlayer 
 * Milestone 6 Assignment 
 * Week5 CST100
 * Author: Lee Tompkins
 * Date: July 24 2016
 **/





class DefensivePlayer extends NFLPlayer {
	private int careerTackles;
	private int careerSacks;
	private int careerInterceptions;
	private int forcedFumbles;
	private double ffToTackleRatio;
	private double sackToTackleRatio;

	
	
	@Override
	// tackles
	public String toString2(){
		return "2015 season Tackles: " + careerTackles;
	}
	@Override
	//sacks
	public String toString3(){
		return "2015 season Sacks: " + careerSacks;
	}
	@Override 
	//interceptions
	public String toString4(){
		return "2015 season Interceptions: " + careerInterceptions;
	}
	@Override
	// forced fumbles
	public String toString5(){
		return "2015 season Forced Fumbles: " + forcedFumbles;
	}
	@Override
	// FF tp Tck ration
	public String toString6(){
		return "2015 season ForcedFumble:Tackle Ratio: " + ffToTackleRatio;
	}
	@Override
	// Sack to tackle ratio
	public String toString7(){
		return "2015 season Tackles:Sack Ratio: " + sackToTackleRatio;
	}
	public DefensivePlayer(){
		
	}
	// Constructors with specified parameters 
	public DefensivePlayer(String name, String position, int height, int weight, int age, int yearsPro, int careerTackles, int careerSacks, int careerInterceptions ){
		this.name = name;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.yearsPro = yearsPro;
		this.careerTackles = careerTackles;
		this.careerSacks = careerSacks;
		this.careerInterceptions = careerInterceptions;
	}
	public DefensivePlayer(String position, String name, int careerTackles, int careerSacks, int forcedFumbles, int careerInterceptions){
		this.position = position;
		this.name = name;
		this.careerTackles = careerTackles;
		this.careerSacks = careerSacks;
		this.careerInterceptions = careerInterceptions;
		this.forcedFumbles = forcedFumbles;
		if (careerTackles == 0) {
			this.sackToTackleRatio = 0;
			this.ffToTackleRatio = 0;
		} else {
			this.sackToTackleRatio =  forcedFumbles/careerTackles;
			this.ffToTackleRatio = careerSacks/careerTackles;
		}
	}
	public int getCareerTackles() {
		// get tackles
		return careerTackles;
	}
	public void setCareerTackles(int careerTackles) {
		// set tackles
		this.careerTackles = careerTackles;
	}
	public int getCareerSacks() {
		// get sacks
		return careerSacks;
	}
	public void setCareerSacks(int careerSacks) {
		// set sacks
		this.careerSacks = careerSacks;
	}
	public int getCareerInterceptions() {
		// get interceptions
		return careerInterceptions;
	}
	public void setCareerInterceptions(int careerInterceptions) {
		// set interceptions
		this.careerInterceptions = careerInterceptions;
	}
	public double getAverageTackles() {
        // Returns average tackles per year
        return (careerTackles / yearsPro);
    }
	public double getAverageSacks(){
		// get average sacks per year
		return(careerSacks / yearsPro);
	}
	public double getAverageInterceptions(){
		// get average interactions per year
		return(careerInterceptions / yearsPro);
	}
	public int getForcedFumbles(){
		// get FF
		return forcedFumbles;
	}
	public void setForcedFumbles(int ff){
		// set FF
		this.forcedFumbles = ff;
	}


	
	
	// Celebrate for player celebration upon being drafted 
	@Override
	public String celebrate() {
		int randomNum = 0; 
		randomNum = (int) (Math.random() * 4);
		String saying = "";
		
		switch (randomNum) {
			case 0: {
				saying = " celebrates his draft and shouts with joy!";
				break;
			}
			case 1: {
				saying = name + " celebrates his draft and does a happy backflip!";
				break;
		}
			case 2: {
				saying = name + " celebrates his draft and dances with joy!";
				break;
			}
			case 3: {
				saying = name + " celebrates his draft and cries tears of joy!";
				break;
			}
			case 4: {
				saying = name + " celebrates his draft and does his famous sack dance!";
				break;
			}
		}
		return saying;
	}
}
