# FinalProject
MileStoneCST100_Project_NFL


Final Project:  NFL Drafter 

Summary: 

- The NFL_Drafter application contains over 2800 NFL players with actual 2015 Stats
- Stats are loaded in through two custom made CSV files 
- The program has an application logo and launch image 
- Users login or register their username and passsword to a CSV file through the program login screen 
- Users have the option to pick a team, which then diaplays the team logo 
- Users have the option utilizing tabs to draft for offense and defense by position 
- Player lists are sortable by player stats, for example: Sort the Linebacker list by tackles, sacks, ect...
- Players have the option to add a number for the player upon draft, or leave as default number "0" 
- Upon drafting a player, the player will appear in the roster tab, showing their Number, Name, Stats, ect... 
     - Also the celebration of the player is shown in the top text field to represent their draft celebration 
- The number of drafted players by position is logged and shows the total player for each postition 
- The user has the option to remove drafted players from the roster, and they are automatically added back to their draftable list

How it was done: 

- Teams are hyperlinks, and upon clicking the link for the team, invokes the hyperlink action event to add the logo and the team name to the team tab 
- Player stats (age, years pro, height, weight) are randomized as the information could not be found in bulk form online
- All ListViews that display stats do so with the use of overriding public String methods (stats are displayed as Strings not ints) 
- Number of players in a roster is done by invoking exampleList.size() method 
- All visual elements are made with javafx
- all lists are ListViews with the type NFLPlayer
- Offensive player and Defensive player objects are subtypes of the abstract NFLPlayer class 
- The PlayerManager class invokes the methods for reading the player stat CSV files, which stores the NFLPlayers in the main     playerArray
- Players are added to the list by utilizing ObservableList<NFLPlayer> 
- Player stats are shown upon click by utilizing the ListViews selectionModel, selectedItemProperty, and a listener and adding the current observable object to another list on the same tab
- Specific stats are shown on the seperate list for the selected player by invoking methods to return Strings for the stats ObservableList<String> 
- The initial program image is shown for 4 seconds by invoking the Thread.sleep(4000) before the main login page is added to the primary scene 
- Basic visual Structure is primaryStage > MainTabs > Tab > BorderPane > (ListView, buttons, labels, panes, boxes, ect....) 
 

Source .java files and images are in the Source folder, 
The runnable jar and required resources are in the Applet folder






  
