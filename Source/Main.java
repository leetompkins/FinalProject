/**  Program: NFL Drafter 
 *   File:    Main.java
 *   Summary: CST100 Final Project  
 *   		  Upon launch, Player arrays are loaded from CSV files. Users are loaded from CSV files. An intro is shown in the primary stage for 4 seconds
 *            The main login screen appears after intro. User can login with an already created username and password, or register a new one, which saves it to the CSV file
 *            User moves between tabs to see available players to draft and players in the roster that have already been drafted. Players can be sorted by relevant attributes such as Tackles.
 *            The number of drafted players is shown for each position, and players that have been drafted can be removed from the roster and added to the draftable list for their position.
 *            Default login and password are: admin and password.
 *  Author:   Lee Tompkins
 *  Date:     August 6 2016
 **/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class Main extends Application {
		
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	
   @Override
	public void start(Stage primaryStage) throws Exception {
	   
	  
	//   getClass().getClassLoader().getResourceAsStream("srcImages/Splash_NFLDrafter.png");
	   Image splashImage = new Image("srcImages/Splash_NFLDrafter.png");
	   ImageView ivSplash = new ImageView(splashImage);
	   HBox sPane = new HBox(ivSplash);
	   
	   
	   
		Scene splash = new Scene(sPane, 1920, 1080);
		
			
		
		
		//Initialize userName variable
		String userName = "";
	
		PlayerManager players = new PlayerManager();
		
		//Initialize Users
		//Login Grid
		GridPane gridLogin = new GridPane();
		GridPane gridInnerLogin = new GridPane();
		gridInnerLogin.setAlignment(Pos.CENTER);
		gridLogin.setAlignment(Pos.CENTER);
		gridLogin.setHgap(10);
		gridLogin.setVgap(12);
		// Create labels and text fields 
		Label labelUsername = new Label("UserName");
		Label labelPassword = new Label("Password");
		TextField tfUsername = new TextField();
		PasswordField pfPassword = new PasswordField();
		//Create buttons 
		Button btnLogin = new Button("Login");
		Button btnRegister = new Button("Register");
		// Create Hbox for buttons 
		HBox loginButtons = new HBox();
		loginButtons.setSpacing(20);
		loginButtons.setAlignment(Pos.BOTTOM_CENTER);
		loginButtons.getChildren().addAll(btnLogin, btnRegister);
		gridLogin.add(labelUsername, 0, 0);
		gridLogin.add(tfUsername, 1, 0);
		gridLogin.add(labelPassword, 0, 1);
		gridLogin.add(pfPassword, 1, 1);
		gridInnerLogin.add(loginButtons, 0, 0);
		gridLogin.add(gridInnerLogin, 0, 2, 2, 1);
		// Register  Button event handler 
		btnRegister.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				String username = tfUsername.getText();
				String password = pfPassword.getText();
				RegisterUser user = new RegisterUser(username, password);
				
			}
		});

				
		
		
		//END LOGIN PAGE
		//BEGIN TEAM TAB
		
		//Team Grid
		BorderPane gridTeam1 = new BorderPane();
		FlowPane gridTeam = new FlowPane();
		gridTeam1.setCenter(gridTeam);
		
		// Set links For All Teams (HARDCODED)
		Label labelPickATeam = new Label("PICK A TEAM");
		Hyperlink bRavens = new Hyperlink("Baltimore Ravens");
		Hyperlink cBengals = new Hyperlink("Cincinnati Bengals");
		Hyperlink cBrowns = new Hyperlink("Cleveland Browns");
		Hyperlink pSteelers = new Hyperlink("Pittsburg Steelers");
		Hyperlink hTexans = new Hyperlink("Houston Texans");
		Hyperlink iColts = new Hyperlink("Indianapolis Colts");
		Hyperlink jJaguars = new Hyperlink("Jacksonville Jaguars");
		Hyperlink tTitans = new Hyperlink("Tennessee Titans");
		Hyperlink bBills = new Hyperlink("Buffalo Bills");
		Hyperlink mDolphins = new Hyperlink("Miami Dolphins");
		Hyperlink nPatriots = new Hyperlink("New England Patriots");
		Hyperlink nJets = new Hyperlink("New York Jets");
		Hyperlink dBroncos = new Hyperlink("Denver Broncos");
		Hyperlink kChiefs = new Hyperlink("Kansas City Chiefs");
		Hyperlink oRaiders = new Hyperlink("Oakland Raiders");
		Hyperlink sChargers = new Hyperlink("San Diego Chargers");
		Hyperlink cBears = new Hyperlink("Chicago Bears");
		Hyperlink dLions = new Hyperlink("Detriot Lions");
		Hyperlink gPackers = new Hyperlink("GreenBay Packers");
		Hyperlink mVikings = new Hyperlink("Minnesota Vikings");
		Hyperlink aFalcons = new Hyperlink("Atlanta Falcons");
		Hyperlink cPanthers = new Hyperlink("Carolina Panthers");
		Hyperlink nSaints = new Hyperlink("New Orleans Saints");
		Hyperlink tBuccaneers = new Hyperlink("Tampa bay Buccaneers");
		Hyperlink dCowboys = new Hyperlink("Dallas Cowboys");
		Hyperlink nGiants = new Hyperlink("New York Giants");
		Hyperlink pEagles = new Hyperlink("Philadelphia Eagles");
		Hyperlink wRedskins = new Hyperlink("Washington Redskins");
		Hyperlink aCardinals = new Hyperlink("Arizona Cardinals");
		Hyperlink lRams = new Hyperlink("Los Angeles Rams");
		Hyperlink s49ers = new Hyperlink("San Francisco 49ers");
		Hyperlink sSeahawks = new Hyperlink("Seattle Seahawks");
		StackPane teamLabel = new StackPane();
		teamLabel.getChildren().add(labelPickATeam);
		gridTeam1.setTop(teamLabel);

		labelPickATeam.setAlignment(Pos.TOP_CENTER);
		// Add all hyperlinks to the FlowPane
		gridTeam.getChildren().addAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
		// Set actions for each Hyperlink - change page to show Team name selected (HARDCODED)
		bRavens.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Baltimore Ravens");
				labelPickATeam.setFont(Font.font("srcImages/Tahoma", FontWeight.NORMAL, 40));
				Image ravens_logo = new Image("srcImages/ravens.png");
				ImageView ivRavens = new ImageView(ravens_logo);
				gridTeam1.setCenter(ivRavens);
			}});
		cBengals.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Cincinnati Bengals");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image bengals_logo = new Image("srcImages/bengals.png");
				ImageView ivBengals = new ImageView(bengals_logo);
				gridTeam1.setCenter(ivBengals);
			 }});
		cBrowns.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Cleveland Browns");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image browns_logo = new Image("srcImages/browns.png");
				ImageView ivBrowns = new ImageView(browns_logo);
				gridTeam1.setCenter(ivBrowns);
			 }});
		pSteelers.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Pittsburg Steelers");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image steelers_logo = new Image("srcImages/steelers.png");
				ImageView ivSteelers = new ImageView(steelers_logo);
				gridTeam1.setCenter(ivSteelers);
			}});
		hTexans.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Houstan Texans");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image texans_logo = new Image("srcImages/texans.png");
				ImageView ivTexans = new ImageView(texans_logo);
				gridTeam1.setCenter(ivTexans);
			 }});
		iColts.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Indianapolis Colts");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image colts_logo = new Image("srcImages/colts.png");
				ImageView ivColts = new ImageView(colts_logo);
				gridTeam1.setCenter(ivColts);
			}});
		jJaguars.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Jacksonville Jaguars");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image jaguars_logo = new Image("srcImages/jaguars.png");
				ImageView ivJaguars = new ImageView(jaguars_logo);
				gridTeam1.setCenter(ivJaguars);
			 }});
		tTitans.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Tennessee Titans");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image titans_logo = new Image("srcImages/titans.png");
				ImageView ivTitans = new ImageView(titans_logo);
				gridTeam1.setCenter(ivTitans);
			 }});
		bBills.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Buffalo Bills");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image bills_logo = new Image("srcImages/bills.png");
				ImageView ivBills = new ImageView(bills_logo);
				gridTeam1.setCenter(ivBills);
			 }});
		mDolphins.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Miami Dolphins");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image dolphins_logo = new Image("srcImages/dolphins.png");
				ImageView ivDolphins = new ImageView(dolphins_logo);
				gridTeam1.setCenter(ivDolphins);
			}});
		nPatriots.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("New England Patriots");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image patriots_logo = new Image("srcImages/patriots.png");
				ImageView ivPatriots = new ImageView(patriots_logo);
				gridTeam1.setCenter(ivPatriots);
			 }});
		nJets.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("New York Jests");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image jets_logo = new Image("srcImages/jets.png");
				ImageView ivJets = new ImageView(jets_logo);
				gridTeam1.setCenter(ivJets);
			 }});
		dBroncos.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Denver Broncos");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image broncos_logo = new Image("srcImages/broncos.png");
				ImageView ivBroncos = new ImageView(broncos_logo);
				gridTeam1.setCenter(ivBroncos);
			 }});
		kChiefs.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
					labelPickATeam.setText("Kansas City Chiefs");
					labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
					Image chiefs_logo = new Image("srcImages/chiefs.png");
					ImageView ivChiefs = new ImageView(chiefs_logo);
					gridTeam1.setCenter(ivChiefs);
			 }});
		oRaiders.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Oakland Raiders");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image raiders_logo = new Image("srcImages/raiders.png");
				ImageView ivRaiders = new ImageView(raiders_logo);
				gridTeam1.setCenter(ivRaiders);
			}});
		sChargers.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
					labelPickATeam.setText("San Diego Chargers");
					labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
					Image chargers_logo = new Image("srcImages/chargers.png");
					ImageView ivChargers = new ImageView(chargers_logo);
					gridTeam1.setCenter(ivChargers);
			 }});
		cBears.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
					labelPickATeam.setText("Chicago Bears");
					labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
					Image bears_logo = new Image("srcImages/bears.png");
					ImageView ivBears = new ImageView(bears_logo);
					gridTeam1.setCenter(ivBears);
			 }});
		dLions.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Detroit Lions");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image lions_logo = new Image("srcImages/lions.png");
				ImageView ivLions = new ImageView(lions_logo);
				gridTeam1.setCenter(ivLions);
			 }});
		gPackers.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("GreenBay Packers");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image packers_logo = new Image("srcImages/packers.png");
				ImageView ivPackers = new ImageView(packers_logo);
				gridTeam1.setCenter(ivPackers);
			 }});
		mVikings.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Minnesota Vikings");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image vikings_logo = new Image("srcImages/vikings.png");
				ImageView ivVikings = new ImageView(vikings_logo);
				gridTeam1.setCenter(ivVikings);
			 }});
		aFalcons.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
					labelPickATeam.setText("Atlanta Falcons");
					labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
					Image falcons_logo = new Image("srcImages/falcons.png");
					ImageView ivFalcons = new ImageView(falcons_logo);
					gridTeam1.setCenter(ivFalcons);
			 }});
		cPanthers.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Carolina Panthers");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image panthers_logo = new Image("srcImages/panthers.png");
				ImageView ivPanthers = new ImageView(panthers_logo);
				gridTeam1.setCenter(ivPanthers);
			 }});
		nSaints.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("New Orleans Saints");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image saints_logo = new Image("srcImages/saints.png");
				ImageView ivSaints = new ImageView(saints_logo);
				gridTeam1.setCenter(ivSaints);
			 }});
		tBuccaneers.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			 public void handle(ActionEvent event) {
				 gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
					labelPickATeam.setText("Tampa Bay Buccaneers");
					labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
					Image buccaneers_logo = new Image("srcImages/bucaneers.png");
					ImageView ivBucaneers = new ImageView(buccaneers_logo);
					gridTeam1.setCenter(ivBucaneers);
			 }});
		dCowboys.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Dallas Cowboys");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image cowboys_logo = new Image("srcImages/cowboys.png");
				ImageView ivCowboys = new ImageView(cowboys_logo);
				gridTeam1.setCenter(ivCowboys);
			 }});
		nGiants.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("New York Giants");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image giants_logo = new Image("srcImages/giants.png");
				ImageView ivGiants = new ImageView(giants_logo);
				gridTeam1.setCenter(ivGiants);
			 }});
		pEagles.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Philadelphia Eagles");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image eagles_logo = new Image("srcImages/eagles.png");
				ImageView ivEagles = new ImageView(eagles_logo);
				gridTeam1.setCenter(ivEagles);
			}});
		wRedskins.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Washington Redskins");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image redskins_logo = new Image("srcImages/redskins.png");
				ImageView ivRedskins = new ImageView(redskins_logo);
				gridTeam1.setCenter(ivRedskins);
			}});
		aCardinals.setOnAction(new EventHandler<ActionEvent>() { 
			@Override 
			public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Arizona Cardinals");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image cardinals_logo = new Image("srcImages/cardinals.png");
				ImageView ivCardinals = new ImageView(cardinals_logo);
				gridTeam1.setCenter(ivCardinals);
			}});
		lRams.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Los Angeles Rams");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image rams_logo = new Image("srcImages/rams.png");
				ImageView ivRams = new ImageView(rams_logo);
				gridTeam1.setCenter(ivRams);
			 }});
		s49ers.setOnAction(new EventHandler<ActionEvent>() { 
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("San Fransico 49ers");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image four9ers_logo = new Image("srcImages/49ers.png");
				ImageView iv49ers = new ImageView(four9ers_logo);
				gridTeam1.setCenter(iv49ers);
			 }});
		sSeahawks.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			 public void handle(ActionEvent event) {
				gridTeam.getChildren().removeAll(bRavens, cBengals, cBrowns, pSteelers, hTexans, iColts, jJaguars, tTitans, bBills, mDolphins, nPatriots, nJets, dBroncos, kChiefs, oRaiders, sChargers, cBears, dLions, gPackers, mVikings, aFalcons, cPanthers, nSaints, tBuccaneers, dCowboys, nGiants, pEagles, wRedskins, aCardinals, lRams, s49ers, sSeahawks);
				labelPickATeam.setText("Seattle Seahawks");
				labelPickATeam.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
				Image seahawks_logo = new Image("srcImages/seahawks.png");
				ImageView ivSeahawks = new ImageView(seahawks_logo);
				gridTeam1.setCenter(ivSeahawks);
			 }});
		
		
		
		// End TEAM TAB 
		// Create Tab For Defense 
		TabPane mainDefenseDraft = new TabPane();
		// Set Tabs to be unable to close; 
		mainDefenseDraft.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Begin DLinemen Drafting TAB
		
		Tab dLinemen = new Tab("Defensive Linemen");
		
		// Create Roster Array for D Linemen
		ArrayList<NFLPlayer> dLineRoster = new ArrayList<NFLPlayer>();
		// Create label for the number of Dline in roster
		Label numberOfDLine = new Label("Number of DLinemen in Roster: " + dLineRoster.size());
		//Set label style
		numberOfDLine.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfDLine.setAlignment(Pos.TOP_CENTER);
	
		// Defense Drafting Grid 
		BorderPane gridDLine = new BorderPane();
		
		
		
		// Content for the Dlinemen tab 
		ListView<String> dlListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> dlListView = new ListView<NFLPlayer>();
		dlListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsDL = new VBox();
		TextField setPlayerNumDL = new TextField();
		Label labelSetNumDL = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumDL.setText("0");
		FlowPane bottomButtonsPaneDL = new FlowPane();
		bottomButtonsPaneDL.setAlignment(Pos.CENTER);
		Button dlSackSort = new Button("Sort By Sacks");
		Button dlInterceptionSort = new Button("Sort By Interceptions");
		Button dlFFSort = new Button("Sort By Forced Fumbles");
		Button dlTacklesSort = new Button("Sort By Tackles");
		Button draftButton = new Button("Draft Selected Player");
		Button btnRefreshDL = new Button("Refresh");
		TextField celebrateField = new TextField();
		celebrateField.setAlignment(Pos.TOP_CENTER);
		celebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> dlArray = players.getDLs();
		ObservableList<NFLPlayer> dlObservableList = FXCollections.observableArrayList(dlArray);
		dlListView.setItems(dlObservableList);
			NFLPlayer[] selectedNFLPlayerDL = new NFLPlayer[1];
		// Show in List selected Player Stats 
		dlListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			String[] stats = new String[8];
		
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			
			selectedNFLPlayerDL[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			dlListViewStats.setItems(playerStats);
			draftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					dLineRoster.add(selectedNFLPlayerDL[0]);
					celebrateField.setText(selectedNFLPlayerDL[0].celebrate());
					numberOfDLine.setText("Number of DLinemen in Roster: " + dLineRoster.size());
					newValue.setNumber(setPlayerNumDL.getText());
					dlObservableList.remove(newValue);
					setPlayerNumDL.setText("0");
				}
				
			});
			// Refresh list
			btnRefreshDL.setOnAction(new EventHandler<ActionEvent>() {
				// Refreshes List and Number of position in roster
				@Override
				public void handle(ActionEvent arg0) {
					dlListView.setItems(dlObservableList);
					numberOfDLine.setText("Number of DLinemen in Roster: " + dLineRoster.size());
					
				}
				
			});
			
			
			
		});
		// Sort by tackles 
		dlTacklesSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(dlObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((DefensivePlayer)p2).getCareerTackles() - ((DefensivePlayer) p1).getCareerTackles();
				}
				});
				}
			});
		// Sort for sacks
		dlSackSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(dlObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((DefensivePlayer)p2).getCareerSacks() - ((DefensivePlayer) p1).getCareerSacks();
				}
				});
				}
			});
		//Sort for Interceptions
		dlInterceptionSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(dlObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((DefensivePlayer)p2).getCareerInterceptions() - ((DefensivePlayer) p1).getCareerInterceptions();
				}
				});
				}
			});
		// Sort for Forced Fumbles
		dlFFSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(dlObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((DefensivePlayer)p2).getForcedFumbles() - ((DefensivePlayer) p1).getForcedFumbles();
				}
				});
				}
			});
		
		
		
		BorderPane centerButtons = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for gridDline
		
		
		textFieldsDL.getChildren().addAll(celebrateField, labelSetNumDL, setPlayerNumDL);
		bottomButtonsPaneDL.getChildren().addAll(btnRefreshDL, dlTacklesSort, dlSackSort, dlInterceptionSort, dlFFSort);
		centerButtons.setTop(textFieldsDL);
		centerButtons.setCenter(draftButton);
		centerButtons.setBottom(bottomButtonsPaneDL);
		gridDLine.setCenter(centerButtons);
		gridDLine.setTop(numberOfDLine);
		gridDLine.setRight(dlListViewStats);
		gridDLine.setLeft(dlListView);
		dLinemen.setContent(gridDLine);
		
		
		
		
		// End DLine Drafting TAB
		// Being Linbacker Drafting Tab
		
		Tab lBacker = new Tab("LineBackers");
		
		// Create Roster Array for LineBackers
		ArrayList<NFLPlayer> lBackerRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfLbackers = new Label("Number of LineBackers in Roster: " + lBackerRoster.size());
		numberOfLbackers.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfLbackers.setAlignment(Pos.TOP_CENTER);
		GridPane gridLinebackerRoster = new GridPane();
		gridLinebackerRoster.setAlignment(Pos.CENTER);
		gridLinebackerRoster.setHgap(10);
		gridLinebackerRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridLinebacker = new BorderPane();

		
		
		// Content for the LineBacker tab 
		ListView<String> linebackerListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> linebackerListView = new ListView<NFLPlayer>();
		dlListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsLB = new VBox();
		TextField setPlayerNumLB = new TextField();
		Label labelSetNumLB = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumLB.setText("0");
		FlowPane bottomButtonsPaneLB = new FlowPane();
		bottomButtonsPaneLB.setAlignment(Pos.CENTER);
		Button lbSackSort = new Button("Sort By Sacks");
		Button lbInterceptionSort = new Button("Sort By Interceptions");
		Button lbFFSort = new Button("Sort By Forced Fumbles");
		Button lbTacklesSort = new Button("Sort By Tackles");
		Button lbdraftButton = new Button("Draft Selected Player");
		Button btnRefreshLB = new Button("Refresh");
		TextField lbcelebrateField = new TextField();
		celebrateField.setAlignment(Pos.TOP_CENTER);
		celebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> lbArray = players.getLBs();
		ObservableList<NFLPlayer> lbObservableList = FXCollections.observableArrayList(lbArray);
		linebackerListView.setItems(lbObservableList);
			NFLPlayer[] selectedNFLPlayerLB = new NFLPlayer[1];
		// Show in List selected Player Stats 
		linebackerListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerLB[0] = newValue;
			
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			linebackerListViewStats.setItems(playerStats);
			lbdraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					lBackerRoster.add(selectedNFLPlayerLB[0]);
					lbcelebrateField.setText(selectedNFLPlayerLB[0].celebrate());
					numberOfLbackers.setText("Number of Linebackers in Roster: " + lBackerRoster.size());
					newValue.setNumber(setPlayerNumLB.getText());
					lbObservableList.remove(newValue);
					setPlayerNumLB.setText("0");
				}
				
			});
			btnRefreshLB.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					linebackerListView.setItems(lbObservableList);
					numberOfLbackers.setText("Number of LineBackers in Roster: " + lBackerRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by tackles 
				lbTacklesSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(lbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerTackles() - ((DefensivePlayer) p1).getCareerTackles();
						}
						});
						}
					});
				// Sort for sacks
				lbSackSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(lbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerSacks() - ((DefensivePlayer) p1).getCareerSacks();
						}
						});
						}
					});
				//Sort for Interceptions
				lbInterceptionSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(lbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerInterceptions() - ((DefensivePlayer) p1).getCareerInterceptions();
						}
						});
						}
					});
				// Sort for Forced Fumbles
				lbFFSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(lbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getForcedFumbles() - ((DefensivePlayer) p1).getForcedFumbles();
						}
						});
						}
					});
		
		
		
		
		BorderPane centerButtonslb = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for gridDline
		textFieldsLB.getChildren().addAll(lbcelebrateField, labelSetNumLB, setPlayerNumLB);
		bottomButtonsPaneLB.getChildren().addAll(btnRefreshLB, lbTacklesSort, lbSackSort, lbInterceptionSort, lbFFSort);
		centerButtonslb.setTop(textFieldsLB);
		centerButtonslb.setCenter(lbdraftButton);
		centerButtonslb.setBottom(bottomButtonsPaneLB);
		gridLinebacker.setCenter(centerButtonslb);
		gridLinebacker.setTop(numberOfLbackers);
		gridLinebacker.setRight(linebackerListViewStats);
		gridLinebacker.setLeft(linebackerListView);
		lBacker.setContent(gridLinebacker);
		
		
		
		
		// End LineBacker Drafting TAB
		// Being DefensiveBack TAB
		
		
		
		
		
		
		
		
		
		Tab dBack = new Tab("Defensive Backs");
		
		// Create Roster Array for DefensiveBacks
		ArrayList<NFLPlayer> dBackRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfDBacks = new Label("Number of Defensive Backs in Roster: " + dBackRoster.size());
		numberOfDBacks.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfDBacks.setAlignment(Pos.TOP_CENTER);
		GridPane gridDBacksRoster = new GridPane();
		gridDBacksRoster.setAlignment(Pos.CENTER);
		gridDBacksRoster.setHgap(10);
		gridDBacksRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridDBacks = new BorderPane();

		
		
		// Content for the LineBacker tab 
		ListView<String> dBacksListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> dBacksListView = new ListView<NFLPlayer>();
		dBacksListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsDB = new VBox();
		TextField setPlayerNumDB = new TextField();
		Label labelSetNumDB = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumDB.setText("0");
		FlowPane bottomButtonsPaneDB = new FlowPane();
		bottomButtonsPaneDB.setAlignment(Pos.CENTER);
		Button dbSackSort = new Button("Sort By Sacks");
		Button dbInterceptionSort = new Button("Sort By Interceptions");
		Button dbFFSort = new Button("Sort By Forced Fumbles");
		Button dbTacklesSort = new Button("Sort By Tackles");
		Button dbdraftButton = new Button("Draft Selected Player");
		Button btnRefreshDB = new Button("Refresh");
		TextField dbcelebrateField = new TextField();
		dbcelebrateField.setAlignment(Pos.TOP_CENTER);
		dbcelebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> dbArray = players.getDBs();
		ObservableList<NFLPlayer> dbObservableList = FXCollections.observableArrayList(dbArray);
		dBacksListView.setItems(dbObservableList);
			NFLPlayer[] selectedNFLPlayerDB = new NFLPlayer[1];
			
		// Show in List selected Player Stats 
		dBacksListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerDB[0] = newValue;
			
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			dBacksListViewStats.setItems(playerStats);
			dbdraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					dBackRoster.add(selectedNFLPlayerDB[0]);
					dbcelebrateField.setText(selectedNFLPlayerDB[0].celebrate());
					numberOfDBacks.setText("Number of Defensive Backs in Roster: " + dBackRoster.size());
					newValue.setNumber(setPlayerNumDB.getText());
					dbObservableList.remove(newValue);
					setPlayerNumDB.setText("0");
					
				}
				
			});
			btnRefreshDB.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					dBacksListView.setItems(dbObservableList);
					numberOfDBacks.setText("Number of Defensive Backs in Roster: " + dBackRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by tackles 
				dbTacklesSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(dbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerTackles() - ((DefensivePlayer) p1).getCareerTackles();
						}
						});
						}
					});
				// Sort for sacks
				dbSackSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(dbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerSacks() - ((DefensivePlayer) p1).getCareerSacks();
						}
						});
						}
					});
				//Sort for Interceptions
				dbInterceptionSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(dbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getCareerInterceptions() - ((DefensivePlayer) p1).getCareerInterceptions();
						}
						});
						}
					});
				// Sort for Forced Fumbles
				dbFFSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(dbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((DefensivePlayer)p2).getForcedFumbles() - ((DefensivePlayer) p1).getForcedFumbles();
						}
						});
						}
					});
		
		
		
		
		BorderPane centerButtonsdb = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for gridDline
		textFieldsDB.getChildren().addAll(dbcelebrateField, labelSetNumDB, setPlayerNumDB);
		bottomButtonsPaneDB.getChildren().addAll(btnRefreshDB, dbTacklesSort, dbSackSort, dbInterceptionSort, dbFFSort);
		centerButtonsdb.setTop(textFieldsDB);
		centerButtonsdb.setCenter(dbdraftButton);
		centerButtonsdb.setBottom(bottomButtonsPaneDB);
		gridDBacks.setCenter(centerButtonsdb);
		gridDBacks.setTop(numberOfDBacks);
		gridDBacks.setRight(dBacksListViewStats);
		gridDBacks.setLeft(dBacksListView);
		dBack.setContent(gridDBacks);
		

		
		
		
		
		//END Tab for Defensive Backs
		// ADD all Tabs to mainDefense Tab
		
		
		
		
		
		
		
		

		mainDefenseDraft.getTabs().addAll(dLinemen,lBacker,dBack);
		
		
		
		// Create Main Tab pane for Offensive Drafting 
		TabPane mainOffenseDraft = new TabPane();
		mainOffenseDraft.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Create Tabs for the main Tab pane 
		//Create Quaterbacks tab
		Tab qbTab = new Tab("Quaterbacks");
		
		
		// Create Roster Array for Runningbacks
		ArrayList<NFLPlayer> qbRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfQBs = new Label("Number of Quaterbacks in Roster: " + qbRoster.size());
		numberOfQBs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfQBs.setAlignment(Pos.TOP_CENTER);
		GridPane gridQBRoster = new GridPane();
		gridQBRoster.setAlignment(Pos.CENTER);
		gridQBRoster.setHgap(10);
		gridQBRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridQBs = new BorderPane();
		
		
		
		// Content for the QB tab 
		ListView<String> qbListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> qbListView = new ListView<NFLPlayer>();
		qbListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsQB = new VBox();
		TextField setPlayerNumQB = new TextField();
		Label labelSetNumQB = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumQB.setText("0");
		FlowPane bottomButtonsPaneQB = new FlowPane();
		bottomButtonsPaneQB.setAlignment(Pos.CENTER);
		Button qbInterceptionsThrownSort = new Button("Sort By Interceptions Thrown");
		Button qbTDSort = new Button("Sort By Touchdowns");
		Button qbYDSort = new Button("Sort By Passing Yards");
		Button qbdraftButton = new Button("Draft Selected Player");
		Button btnRefreshQB = new Button("Refresh");
		
		TextField qbcelebrateField = new TextField();
		qbcelebrateField.setAlignment(Pos.TOP_CENTER);
		qbcelebrateField.setPrefWidth(150);
			ArrayList<NFLPlayer> qbArray = players.getQBs();
		ObservableList<NFLPlayer> qbObservableList = FXCollections.observableArrayList(qbArray);
		qbListView.setItems(qbObservableList);
			NFLPlayer[] selectedNFLPlayerQB = new NFLPlayer[1];
		// Show in List selected Player Stats 
		qbListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerQB[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			qbListViewStats.setItems(playerStats);
			qbdraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					qbRoster.add(selectedNFLPlayerQB[0]);
					qbcelebrateField.setText(selectedNFLPlayerQB[0].celebrate());
					numberOfQBs.setText("Number of Quaterbacks in Roster: " + qbRoster.size());
					newValue.setNumber(setPlayerNumQB.getText());
					qbArray.remove(selectedNFLPlayerQB[0]);
					qbObservableList.remove(selectedNFLPlayerQB[0]);
					setPlayerNumQB.setText("0");
					
					
				}
				
			});
			btnRefreshQB.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					qbListView.setItems(qbObservableList);
					numberOfQBs.setText("Number of Quaterbacks in Roster: " + qbRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by Touchdowns
		qbTDSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(qbObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((OffensivePlayer)p2).getCareerTouchdowns() - ((OffensivePlayer) p1).getCareerTouchdowns();
				}
				});
				}
			});
		qbYDSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(qbObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((OffensivePlayer)p2).getCareerYards() - ((OffensivePlayer) p1).getCareerYards();
				}
				});
				}
			});
		qbInterceptionsThrownSort.setOnAction(new EventHandler<ActionEvent>() {
			// Sorts List by Tackles 
			@Override 
			public void handle(ActionEvent arg0) {
				Collections.sort(qbObservableList, new Comparator<NFLPlayer>(){
				@Override 
				public int compare(NFLPlayer p1, NFLPlayer p2) {
					return ((OffensivePlayer)p2).getCareerInterceptionsThrown() - ((OffensivePlayer) p1).getCareerInterceptionsThrown();
				}
				});
				}
			});
		
		
		
		
		BorderPane centerButtonsQB = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for gridDline
		textFieldsQB.getChildren().addAll(qbcelebrateField, labelSetNumQB, setPlayerNumQB);
		bottomButtonsPaneQB.getChildren().addAll(btnRefreshQB, qbTDSort, qbYDSort, qbInterceptionsThrownSort);
		centerButtonsQB.setTop(textFieldsQB);
		centerButtonsQB.setCenter(qbdraftButton);
		centerButtonsQB.setBottom(bottomButtonsPaneQB);
		gridQBs.setCenter(centerButtonsQB);
		gridQBs.setTop(numberOfQBs);
		gridQBs.setRight(qbListViewStats);
		gridQBs.setLeft(qbListView);
		qbTab.setContent(gridQBs);
		
		
		
		// End Quaterbacks TAB 
		//Begin Runningbacks Tab 
		
		
		
		
		
		Tab rbTab = new Tab("Runningbacks");
		
		
		// Create Roster Array for Runningbacks
		ArrayList<NFLPlayer> rbRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfRBs = new Label("Number of Runningbacks in Roster: " + rbRoster.size());
		numberOfRBs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfRBs.setAlignment(Pos.TOP_CENTER);
		GridPane gridRBRoster = new GridPane();
		gridRBRoster.setAlignment(Pos.CENTER);
		gridRBRoster.setHgap(10);
		gridRBRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridRBs = new BorderPane();
	
		
		
		// Content for the LineBacker tab 
		ListView<String> rbListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> rbListView = new ListView<NFLPlayer>();
		rbListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsRB = new VBox();
		TextField setPlayerNumRB = new TextField();
		Label labelSetNumRB = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumRB.setText("0");
		FlowPane bottomButtonsPaneRB = new FlowPane();
		bottomButtonsPaneRB.setAlignment(Pos.CENTER);
		Button rbCarriesSort = new Button("Sort By Carries");
		Button rbYDSort = new Button("Sort By Rushing Yards");
		Button rbTDSort = new Button("Sort By Touchdowns");
		Button rbdraftButton = new Button("Draft Selected Player");
		Button btnRefreshRB = new Button("Refresh");
		TextField rbcelebrateField = new TextField();
		rbcelebrateField.setAlignment(Pos.TOP_CENTER);
		rbcelebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> rbArray = players.getRBs();
		ObservableList<NFLPlayer> rbObservableList = FXCollections.observableArrayList(rbArray);
		rbListView.setItems(rbObservableList);
			NFLPlayer[] selectedNFLPlayerRB = new NFLPlayer[1];
		// Show in List selected Player Stats 
		rbListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerRB[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			rbListViewStats.setItems(playerStats);
			rbdraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					rbRoster.add(selectedNFLPlayerRB[0]);
					rbcelebrateField.setText(selectedNFLPlayerRB[0].celebrate());
					numberOfRBs.setText("Number of Runningbacks in Roster: " + rbRoster.size());
					newValue.setNumber(setPlayerNumRB.getText());
					rbObservableList.remove(newValue);
					setPlayerNumRB.setText("0");
				}
				
			});
			btnRefreshRB.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					rbListView.setItems(rbObservableList);
					numberOfRBs.setText("Number of Runningbacks in Roster: " + rbRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by Touchdowns
				rbTDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(rbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerTouchdowns() - ((OffensivePlayer) p1).getCareerTouchdowns();
						}
						});
						}
					});
				// Sort by yards 
				rbYDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(rbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerYards() - ((OffensivePlayer) p1).getCareerYards();
						}
						});
						}
					});
				rbCarriesSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(rbObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerCarries() - ((OffensivePlayer) p1).getCareerCarries();
						}
						});
						}
					});
		
		
		
		
		BorderPane centerButtonsRB = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for RB
		textFieldsRB.getChildren().addAll(rbcelebrateField, labelSetNumRB, setPlayerNumRB);
		bottomButtonsPaneRB.getChildren().addAll(btnRefreshRB, rbTDSort, rbYDSort, rbCarriesSort);
		centerButtonsRB.setTop(textFieldsRB);
		centerButtonsRB.setCenter(rbdraftButton);
		centerButtonsRB.setBottom(bottomButtonsPaneRB);
		gridRBs.setCenter(centerButtonsRB);
		gridRBs.setTop(numberOfRBs);
		gridRBs.setRight(rbListViewStats);
		gridRBs.setLeft(rbListView);
		rbTab.setContent(gridRBs);
		
		
		
		// End Runningbacks TAB 
		// Begin Wide Recievers Tab 
		Tab wrTab = new Tab("Wide Recievers");
		
		
		// Create Roster Array for Wide Recievers
		ArrayList<NFLPlayer> wrRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfWRs = new Label("Number of Wide Recievers in Roster: " + wrRoster.size());
		numberOfWRs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfWRs.setAlignment(Pos.TOP_CENTER);
		GridPane gridWRRoster = new GridPane();
		gridWRRoster.setAlignment(Pos.CENTER);
		gridWRRoster.setHgap(10);
		gridWRRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridWRs = new BorderPane();
		
		
		
		// Content for the LineBacker tab 
		ListView<String> wrListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> wrListView = new ListView<NFLPlayer>();
		wrListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsWR = new VBox();
		TextField setPlayerNumWR = new TextField();
		Label labelSetNumWR = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumWR.setText("0");
		FlowPane bottomButtonsPaneWR = new FlowPane();
		bottomButtonsPaneWR.setAlignment(Pos.CENTER);
		Button wrReceptionsSort = new Button("Sort By Receptions");
		Button wrYDSort = new Button("Sort By Recieving Yards");
		Button wrTDSort = new Button("Sort By Touchdowns");
		Button wrdraftButton = new Button("Draft Selected Player");
		Button btnRefreshWR = new Button("Refresh");
		TextField wrcelebrateField = new TextField();
		wrcelebrateField.setAlignment(Pos.TOP_CENTER);
		wrcelebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> wrArray = players.getWRs();
		ObservableList<NFLPlayer> wrObservableList = FXCollections.observableArrayList(wrArray);
		wrListView.setItems(wrObservableList);
			NFLPlayer[] selectedNFLPlayerWR = new NFLPlayer[1];
		// Show in List selected Player Stats 
		wrListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerWR[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			wrListViewStats.setItems(playerStats);
			wrdraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					wrRoster.add(selectedNFLPlayerWR[0]);
					wrcelebrateField.setText(selectedNFLPlayerWR[0].celebrate());
					numberOfWRs.setText("Number of Wide Recievers in Roster: " + wrRoster.size());
					newValue.setNumber(setPlayerNumWR.getText());
					wrObservableList.remove(newValue);
					setPlayerNumWR.setText("0");
				}
				
			});
			btnRefreshWR.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					wrListView.setItems(wrObservableList);
					numberOfWRs.setText("Number of Wide Recievers in Roster: " + wrRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by Touchdowns
				wrTDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(wrObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerTouchdowns() - ((OffensivePlayer) p1).getCareerTouchdowns();
						}
						});
						}
					});
				// Sort by yards 
				wrYDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(wrObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerYards() - ((OffensivePlayer) p1).getCareerYards();
						}
						});
						}
					});
				wrReceptionsSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(wrObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerReceptions() - ((OffensivePlayer) p1).getCareerReceptions();
						}
						});
						}
					});
		
		
		
		
		BorderPane centerButtonsWR = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for WR
		textFieldsWR.getChildren().addAll(wrcelebrateField, labelSetNumWR, setPlayerNumWR);
		bottomButtonsPaneWR.getChildren().addAll(btnRefreshWR, wrTDSort, wrYDSort, wrReceptionsSort);
		centerButtonsWR.setTop(textFieldsWR);
		centerButtonsWR.setCenter(wrdraftButton);
		centerButtonsWR.setBottom(bottomButtonsPaneWR);
		gridWRs.setCenter(centerButtonsWR);
		gridWRs.setTop(numberOfWRs);
		gridWRs.setRight(wrListViewStats);
		gridWRs.setLeft(wrListView);
		wrTab.setContent(gridWRs);
		
		
		
		//End WR Tab 
		//Begin TE Tab 
		Tab teTab = new Tab("Tight Ends");
		
		
		// Create Roster Array for Wide Recievers
		ArrayList<NFLPlayer> teRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfTEs = new Label("Number of Tightends in Roster: " + teRoster.size());
		numberOfTEs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfTEs.setAlignment(Pos.TOP_CENTER);
		GridPane gridTERoster = new GridPane();
		gridTERoster.setAlignment(Pos.CENTER);
		gridTERoster.setHgap(10);
		gridTERoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridTEs = new BorderPane();
		
		
		
		// Content for the LineBacker tab 
		ListView<String> teListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> teListView = new ListView<NFLPlayer>();
		teListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsTE = new VBox();
		TextField setPlayerNumTE = new TextField();
		Label labelSetNumTE = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumTE.setText("0");
		FlowPane bottomButtonsPaneTE = new FlowPane();
		bottomButtonsPaneTE.setAlignment(Pos.CENTER);
		Button teReceptionsSort = new Button("Sort By Receptions");
		Button teYDSort = new Button("Sort By Recieving Yards");
		Button teTDSort = new Button("Sort By Touchdowns");
		Button tedraftButton = new Button("Draft Selected Player");
		Button btnRefreshTE = new Button("Refresh");
		TextField tecelebrateField = new TextField();
		tecelebrateField.setAlignment(Pos.TOP_CENTER);
		tecelebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> teArray = players.getTEs();
		ObservableList<NFLPlayer> teObservableList = FXCollections.observableArrayList(teArray);
		teListView.setItems(teObservableList);
			NFLPlayer[] selectedNFLPlayerTE = new NFLPlayer[1];
		// Show in List selected Player Stats 
		teListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerTE[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			teListViewStats.setItems(playerStats);
			tedraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					teRoster.add(selectedNFLPlayerTE[0]);
					tecelebrateField.setText(selectedNFLPlayerTE[0].celebrate());
					numberOfTEs.setText("Number of TightEnds in Roster: " + teRoster.size());
					newValue.setNumber(setPlayerNumTE.getText());
					teObservableList.remove(newValue);
					setPlayerNumTE.setText("0");
				}
				
			});
			btnRefreshTE.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					teListView.setItems(teObservableList);
					numberOfTEs.setText("Number of TightEnds in Roster: " + teRoster.size());
					
				}
				
			});
			
			
		});
		// Sort by Touchdowns
				teTDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(teObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerTouchdowns() - ((OffensivePlayer) p1).getCareerTouchdowns();
						}
						});
						}
					});
				// Sort by yards 
				teYDSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(teObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerYards() - ((OffensivePlayer) p1).getCareerYards();
						}
						});
						}
					});
				teReceptionsSort.setOnAction(new EventHandler<ActionEvent>() {
					// Sorts List by Tackles 
					@Override 
					public void handle(ActionEvent arg0) {
						Collections.sort(teObservableList, new Comparator<NFLPlayer>(){
						@Override 
						public int compare(NFLPlayer p1, NFLPlayer p2) {
							return ((OffensivePlayer)p2).getCareerReceptions() - ((OffensivePlayer) p1).getCareerReceptions();
						}
						});
						}
					});
		
		
		
		
		BorderPane centerButtonsTE = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for RB
		textFieldsTE.getChildren().addAll(tecelebrateField, labelSetNumTE, setPlayerNumTE);
		bottomButtonsPaneTE.getChildren().addAll(btnRefreshTE, teTDSort, teYDSort, teReceptionsSort);
		centerButtonsTE.setTop(textFieldsTE);
		centerButtonsTE.setCenter(tedraftButton);
		centerButtonsTE.setBottom(bottomButtonsPaneTE);
		gridTEs.setCenter(centerButtonsTE);
		gridTEs.setTop(numberOfTEs);
		gridTEs.setRight(teListViewStats);
		gridTEs.setLeft(teListView);
		teTab.setContent(gridTEs);
		
		
		
		
		//END TE TAB 
		//Begin OL Tab 
		Tab olTab = new Tab("Offensive Linemen");
		
		
		// Create Roster Array for Offensive Linemen
		ArrayList<NFLPlayer> olRoster = new ArrayList<NFLPlayer>();
		
		Label numberOfOLs = new Label("Number of Offensive Linemen in Roster: " + olRoster.size());
		numberOfOLs.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		numberOfOLs.setAlignment(Pos.TOP_CENTER);
		GridPane gridOLRoster = new GridPane();
		gridOLRoster.setAlignment(Pos.CENTER);
		gridOLRoster.setHgap(10);
		gridOLRoster.setVgap(12);
		// Defense Drafting Grid 
		BorderPane gridOLs = new BorderPane();
	
		
		
		// Content for the LineBacker tab 
		ListView<String> olListViewStats = new ListView<String>();
		
		
		ListView<NFLPlayer> olListView = new ListView<NFLPlayer>();
		olListView.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(null);
					} else {
						setText(item.position + " " + item.name);
					}
				}
			};
		});
		VBox textFieldsOL = new VBox();
		TextField setPlayerNumOL = new TextField();
		Label labelSetNumOL = new Label("Enter Player Number to Set When Drafted");
		setPlayerNumOL.setText("0");
		FlowPane bottomButtonsPaneOL = new FlowPane();
		bottomButtonsPaneOL.setAlignment(Pos.CENTER);

		Button oldraftButton = new Button("Draft Selected Player");
		Button btnRefreshOL = new Button("Refresh");
		TextField olcelebrateField = new TextField();
		olcelebrateField.setAlignment(Pos.TOP_CENTER);
		olcelebrateField.setPrefWidth(150);
		ArrayList<NFLPlayer> olArray = players.getOLs();
		ObservableList<NFLPlayer> olObservableList = FXCollections.observableArrayList(olArray);
		olListView.setItems(olObservableList);
			NFLPlayer[] selectedNFLPlayerOL = new NFLPlayer[1];
		// Show in List selected Player Stats 
		olListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			
			String[] stats = new String[8];
			
			stats[0] =  newValue.toString();
			stats[1] =  newValue.toString2();
			stats[2] =  newValue.toString3();
			stats[3] =  newValue.toString4();
			stats[4] =  newValue.toString5();
			stats[5] =  newValue.toStringYearsPro();
			stats[6] =  newValue.toStringWeight();
			stats[7] =  newValue.toStringHeight();
			selectedNFLPlayerOL[0] = newValue;
			ObservableList<String> playerStats = FXCollections.observableArrayList(stats);
			olListViewStats.setItems(playerStats);
			oldraftButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					olRoster.add(selectedNFLPlayerOL[0]);
					olcelebrateField.setText(selectedNFLPlayerOL[0].celebrate());
					numberOfOLs.setText("Number of Offensive Linemen in Roster: " + olRoster.size());
					newValue.setNumber(setPlayerNumOL.getText());
					olObservableList.remove(newValue);
					setPlayerNumOL.setText("0");
				}
				
			});
			btnRefreshOL.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					olListView.setItems(olObservableList);
					numberOfOLs.setText("Number of Offensive Linemen in Roster: " + olRoster.size());
					
				}
				
			});
			
			
		});

		
		
		
		BorderPane centerButtonsOL = new BorderPane();
		
	
		// Add Draft Button, TextField, Set all locations for gridDline
		textFieldsOL.getChildren().addAll(olcelebrateField, labelSetNumOL, setPlayerNumOL);
		bottomButtonsPaneOL.getChildren().addAll(btnRefreshOL);
		centerButtonsOL.setTop(textFieldsOL);
		centerButtonsOL.setCenter(oldraftButton);
		centerButtonsOL.setBottom(bottomButtonsPaneOL);
		gridOLs.setCenter(centerButtonsOL);
		gridOLs.setTop(numberOfOLs);
		gridOLs.setRight(olListViewStats);
		gridOLs.setLeft(olListView);
		olTab.setContent(gridOLs);
		
		
		
		
		// END OL Tab 
		
		// Add All Offensive Tabs
		mainOffenseDraft.getTabs().addAll(qbTab,rbTab,wrTab,teTab,olTab);
		
		
		// Set Roster page Content
		
		
		
		
		GridPane gridRoster = new GridPane();
		gridRoster.setAlignment(Pos.CENTER);
		gridRoster.setHgap(10);
		gridRoster.setVgap(12);
		BorderPane rosterDefenseBPane = new BorderPane();
		BorderPane rosterOffenseBPane = new BorderPane();
		
		
		VBox totalsD = new VBox();
		totalsD.setAlignment(Pos.CENTER);
		Label totalDL = new Label("DL's in Roster: " + dLineRoster.size());
		Label totalLB = new Label("LB's in Roster: " + lBackerRoster.size());
		Label totalDB = new Label("DB's in Roster: " + dBackRoster.size());
		totalsD.getChildren().addAll(totalDL, totalLB, totalDB);
		rosterDefenseBPane.setBottom(totalsD);
		VBox totalsO = new VBox();
		totalsO.setAlignment(Pos.CENTER);
		Label totalQB = new Label("QB's in Roster: " + qbRoster.size());
		Label totalRB = new Label("RB's in Roster: " + rbRoster.size());
		Label totalWR = new Label("WR's in Roster: " + wrRoster.size());
		Label totalTE = new Label("TE's in Roster: " + teRoster.size());
		Label totalOL = new Label("OL's in Roster: " + olRoster.size());
		totalsO.getChildren().addAll(totalQB, totalRB, totalWR, totalTE, totalOL);
		rosterOffenseBPane.setBottom(totalsO);
		
		
		
		//ListView<NFLPlayer> offensiveRoster = new ListView<NFLPlayer>();
		ObservableList<NFLPlayer> offensiveRosterList = FXCollections.observableArrayList();
		offensiveRosterList.addAll(qbRoster);
		offensiveRosterList.addAll(rbRoster);
		offensiveRosterList.addAll(wrRoster);
		offensiveRosterList.addAll(teRoster);
		offensiveRosterList.addAll(olRoster);
		
		ObservableList<NFLPlayer> defensiveRosterList = FXCollections.observableArrayList();
		defensiveRosterList.addAll(lBackerRoster);
		defensiveRosterList.addAll(dBackRoster);
		defensiveRosterList.addAll(dLineRoster);
	
		
		
		
		// Button for refreshing Roster Lists 
		Button btnRefresh = new Button("REFRESH LISTS");
		btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			 public void handle(ActionEvent event) {
			
				defensiveRosterList.removeAll(dLineRoster);
				defensiveRosterList.removeAll(lBackerRoster);
				defensiveRosterList.removeAll(dBackRoster);
				defensiveRosterList.addAll(dLineRoster);
				defensiveRosterList.addAll(lBackerRoster);
				defensiveRosterList.addAll(dBackRoster);
				offensiveRosterList.removeAll(qbRoster);
				offensiveRosterList.removeAll(rbRoster);
				offensiveRosterList.removeAll(wrRoster);
				offensiveRosterList.removeAll(teRoster);
				offensiveRosterList.removeAll(olRoster);
				offensiveRosterList.addAll(qbRoster);
				offensiveRosterList.addAll(rbRoster);
				offensiveRosterList.addAll(wrRoster);
				offensiveRosterList.addAll(teRoster);
				offensiveRosterList.addAll(olRoster);	
				totalQB.setText("QB's in Roster: " + qbRoster.size());
				totalRB.setText("RB's in Roster: " + rbRoster.size());
				totalWR.setText("WR's in Roster: " + wrRoster.size());
				totalTE.setText("TE's in Roster: " + teRoster.size());
				totalOL.setText("OL's in Roster: " + olRoster.size());
				totalDL.setText("DL's in Roster: " + dLineRoster.size());
				totalLB.setText("LB's in Roster: " + lBackerRoster.size());
				totalDB.setText("DB's in Roster: " + dBackRoster.size());
			}
			
		});
		
		
		
		
		// Roster for defense 
		ListView<NFLPlayer> defensiveRoster = new ListView<NFLPlayer>();
		defensiveRoster.setItems(defensiveRosterList);
		defensiveRoster.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(" ");
					} else {
						setText(item.toStringNumber() + "//" + item.position + " " + item.name + "//" + item.toString2() + "//" + item.toString3() + "//" + item.toString4() + "//" + item.toString5());
					}
				}
			};
		});
		// Buttons for removing already drafted offensive Players 
		Button btnRemoveDPlayer = new Button("Remove Defensive Player");
		// Array to hold the currently selected NFLPlayer Object
		NFLPlayer[] selectedNFLPlayerDRoster = new NFLPlayer[1];
		defensiveRoster.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedNFLPlayerDRoster[0] = newValue;
			
		// Method for the button remove offensive drafted player
		btnRemoveDPlayer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// Switch case for adding NFLPlayer back to the correct Draft tables
			switch (selectedNFLPlayerDRoster[0].getPosition()) {
				case "DL": {
					dlArray.add(selectedNFLPlayerDRoster[0]);
					dlObservableList.add(selectedNFLPlayerDRoster[0]);
					dLineRoster.remove(selectedNFLPlayerDRoster[0]);
					defensiveRosterList.remove(selectedNFLPlayerDRoster[0]);
					break;
				}
				case "LB": {
					lbArray.add(selectedNFLPlayerDRoster[0]);
					lbObservableList.add(selectedNFLPlayerDRoster[0]);
					lBackerRoster.remove(selectedNFLPlayerDRoster[0]);
					defensiveRosterList.remove(selectedNFLPlayerDRoster[0]);
					break;
				}
				case "DB": {
					dbArray.add(selectedNFLPlayerDRoster[0]);
					dbObservableList.add(selectedNFLPlayerDRoster[0]);
					dBackRoster.remove(selectedNFLPlayerDRoster[0]);
					defensiveRosterList.remove(selectedNFLPlayerDRoster[0]);
					break;
				}
				
			}

			}
			
		});

	});
		// Set Defensive Roster Borderpane Contents 
				rosterDefenseBPane.setBottom(totalsD);
				rosterDefenseBPane.setRight(defensiveRoster);
				rosterDefenseBPane.setTop(btnRemoveDPlayer);
				// Set Offensive Roster Borderpane Contents 
		
		
		ListView<NFLPlayer> offensiveRoster = new ListView<NFLPlayer>();
		offensiveRoster.setItems(offensiveRosterList);
		offensiveRoster.setCellFactory((list) -> {
			return new ListCell<NFLPlayer>() {
				@Override
				protected void updateItem(NFLPlayer item, boolean empty) {
					super.updateItem(item, empty);
					if (item == null || empty) {
						setText(" ");
					} else {
						setText(item.toStringNumber() + "//" + item.position + " " + item.name + "//" + item.toString2() + "//" + item.toString3() + "//" + item.toString4() + "//" + item.toString5() + "//" + item.toString6());
					}
				}
			};
		});
		// Buttons for removing already drafted offensive Players 
		Button btnRemoveOPlayer = new Button("Remove Offensive Player");
		// Array to hold the currently selected NFLPlayer Object
		NFLPlayer[] selectedNFLPlayerORoster = new NFLPlayer[1];
		offensiveRoster.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			selectedNFLPlayerORoster[0] = newValue;
			
		// Method for the button remove offensive drafted player
		btnRemoveOPlayer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// Switch case for adding NFLPlayer back to the correct Draft tables
			switch (selectedNFLPlayerORoster[0].getPosition()) {
				case "QB": {
					qbArray.add(selectedNFLPlayerORoster[0]);
					qbObservableList.add(selectedNFLPlayerORoster[0]);
					qbRoster.remove(selectedNFLPlayerORoster[0]);
					offensiveRosterList.remove(selectedNFLPlayerORoster[0]);
					break;
				}
				case "RB": {
					rbArray.add(selectedNFLPlayerORoster[0]);
					rbObservableList.add(selectedNFLPlayerORoster[0]);
					rbRoster.remove(selectedNFLPlayerORoster[0]);
					offensiveRosterList.remove(selectedNFLPlayerORoster[0]);
					break;
				}
				case "WR": {
					wrArray.add(selectedNFLPlayerORoster[0]);
					wrObservableList.add(selectedNFLPlayerORoster[0]);
					wrRoster.remove(selectedNFLPlayerORoster[0]);
					offensiveRosterList.remove(selectedNFLPlayerORoster[0]);
					break;
				}
				case "TE": {
					teArray.add(selectedNFLPlayerORoster[0]);
					teObservableList.add(selectedNFLPlayerORoster[0]);
					teRoster.remove(selectedNFLPlayerORoster[0]);
					offensiveRosterList.remove(selectedNFLPlayerORoster[0]);
					break;
					
				}
				case "OL": {
					olArray.add(selectedNFLPlayerORoster[0]);
					olObservableList.add(selectedNFLPlayerORoster[0]);
					olRoster.remove(selectedNFLPlayerORoster[0]);
					offensiveRosterList.remove(selectedNFLPlayerORoster[0]);
					break;
					
				}
				
			}

			}
			
		});

	});
		
		// Set Roster contents for Defense
		rosterOffenseBPane.setBottom(totalsO);
		rosterOffenseBPane.setLeft(offensiveRoster);
		rosterOffenseBPane.setTop(btnRemoveOPlayer);
		// Set overall Roster Contents
		gridRoster.add(btnRefresh, 0, 1);
		gridRoster.add(rosterDefenseBPane, 0, 0);
		gridRoster.add(rosterOffenseBPane, 1, 0);
		
		
		
		
		
		
		// Main Tab Pane - contains all tabs for the program 
		TabPane mainTabPane = new TabPane();
		mainTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// Login Tab
		Tab tabLogin = new Tab();
		tabLogin.setText("Login");
		tabLogin.setContent(gridLogin);
		// Team Tab 
		Tab tabTeam = new Tab();
		tabTeam.setText("Team");
		tabTeam.setContent(gridTeam1);
		//Roster Tab
		Tab tabRoster = new Tab();
		tabRoster.setText("Roster");
		tabRoster.setContent(gridRoster);
		
		//Defense Tab
		Tab tabDefense = new Tab();
		tabDefense.setText("Defense Drafter");
		tabDefense.setContent(mainDefenseDraft);
		//Offense Tab 
		Tab tabOffense = new Tab();
		tabOffense.setText("Offense Drafter");
		tabOffense.setContent(mainOffenseDraft);
		//Add login Tab
		mainTabPane.getTabs().add(tabLogin);
		
		
		// Login Button Controls, reveals all tabs 
		btnLogin.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String username = tfUsername.getText();
				String password = pfPassword.getText();
				RegisteredUsers registeredUsers = new RegisteredUsers();
				
				
				if (registeredUsers.checkMatch(username, password) == true) {
					
					
					mainTabPane.getTabs().add(tabTeam);
					mainTabPane.getTabs().add(tabRoster);
					mainTabPane.getTabs().add(tabDefense);
					mainTabPane.getTabs().add(tabOffense);
					mainTabPane.getTabs().remove(tabLogin);
				
				} else {
					tfUsername.setText("Incorrect");
					pfPassword.setText("Incorrect");
				}
			}
		});
		
		
	
	
		// Set Intro Screen then sleep 4 seconds
		primaryStage.show();
		primaryStage.getIcons().add(new Image("srcImages/NFL_ICO.png"));
		primaryStage.setScene(splash);
		primaryStage.setTitle("NFL Drafter");
		primaryStage.centerOnScreen();
		Thread.sleep(4000);
		//Show mainTabPan
		Scene scene = new Scene(mainTabPane, 1280, 720);
		primaryStage.setScene(scene);
		
	}
}

