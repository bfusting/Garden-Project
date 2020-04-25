import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: 011
*  Lab Section: 031L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/20)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * General class for handling the visual components of the program. Contains 
 * the Buttons that are used on multiple screens and manages the primary
 * screen that the user is viewing at any point as well as a secondary window 
 * for saving before quitting to be shown when the user presses the exit button.
 * 
 * @author Takiyah Price 
 */


public class View extends Application{
	private Button instructionsButton;
	private Button exitButton;
	private Button saveButton;
	private Button backButton;
	private Button mainMenu;
	private Stage primaryStage;
	private Stage exitStage;
	private Scene exitScene;
	
	private Controller imc;
	private MainMenu mainMenuScreen;
	private Instructions instructionsScreen;
	private ChooseTemplate chooseTemplateScreen;
	private DesignGarden designGardenScreen;
	private FinalView finalViewScreen;
	private InfoTips infoTipsScreen;
	private Preferences preferencesScreen;
	private SaveLoad saveLoadScreen;
	private SeasonView seasonViewScreen;
	private Recommendations recommendationsScreen;
	
	
		
	
	
	/**
	 * Constructor for the View that creates the instructions, exit, back and main menu Buttons
	 * and sets primaryStage to the Stage created at the start of the program. 
	 * 
	 */
	public View() {
		//imc = new Controller();
		
		mainMenuScreen = new MainMenu();
		instructionsScreen = new Instructions();
		chooseTemplateScreen = new ChooseTemplate();
		//designGardenScreen = new DesignGarden();
		saveLoadScreen = new SaveLoad();
		//finalViewScreen = new FinalView(null);
		// InfoTips should take in a plant from model
		//infoTipsScreen = new InfoTips(null, 0, null, 0, 0, false, null, null);
		//seasonViewScreen = new SeasonView();
		// InfoTips should take in a plant from model
		//recommendationsScreen = new Recommendations(null, null, null, 0, 0);
		
		
		
	}
	
	/**
	 * Takes in the parameter tofu which is a Array of strings passed into the main 
	 * method and used within the program
	 * <p>
	 * Main runs the whole program, usually launchs everything however for now just prints 
	 * a simple statement.
	 * 
	 * @param tofu string array of arguments
	 * @see main
	 */
	public static void main(String[] tofu) {
		//System.out.println("Hello World");
		launch();
	}//main
	
	@Override
	/**
	 * Takes in parameter theStage and creates a new scene
	 * for the main menu and sets the stage with that scene
	 * and then shows the stage.
	 * <p>
	 * Start is used to for the start of the program where it starts with the main menu
	 * 
	 * @param theStage primary stage that is the mainmenu
	 */
	public void start(Stage theStage) {
		//Initializing Buttons, Stages, and Scenes
		primaryStage = theStage;
		
		instructionsButton = new Button("Instructions");
		exitButton = new Button("Exit");
		saveButton = new Button("Save");
		backButton = new Button("Back");
		mainMenu = new Button("Main Menu");
		//
		
		System.out.println("Set the stage for el Main Menu");
	}
	
	
	/**
	 * Creates a window to ask if the user would like to save before exiting by
	 * creating a new Stage with a Scene containing the save Button and a Button for closing
	 * the program, then sets the new Stage to exitStage and makes it visible to the user.
	 * 
	 * @see View#exitStage
	 * @see View#exitScene
	 * @see View#saveButton
	 */
	public void exit() {
		System.out.println("create window to ask user to save before exiting");
		
	}
	
	/**
	 * Closes all open windows after the user saves or quits without saving.
	 */
	public void close() {
		System.out.println("close application (meaning close all open windows)");
	}
	
	/**
	 * Makes the MainMenu Stage visible to the user.
	 * 
	 */
	public void showMainMenuScreen() {
		//primaryStage.setScene(mainMenuView.getScene());
		mainMenuScreen.showMainMenu(primaryStage);
	}
	
	/**
	 * Makes the instructions screen visible to the user. Will appear on the main screen or
	 * in a separate smaller window depending on whether the primary Stage or a separate Stage
	 * has been passed in.
	 * 
	 */
	public void showInstructionsScreen() {
		instructionsScreen.showInstructions();
	}
	
	/**
	 * Sets the given Stage with the chooseTemplate Scene containing the Buttons for choosing
	 * the garden shape and makes it visible to the user.
	 * 
	 * 
	 * 
	 * @see ChooseTemplate#chooseTemplateScene
	 */
	public void showChooseTemplateScreen() {
		chooseTemplateScreen.showChooseTemplate(primaryStage);
		
	}
	
	public void showDesignGardenScreen() {
		designGardenScreen.showDesignGarden(primaryStage);
	}
	
	public void showSaveGardenScreen() {
		saveLoadScreen.showSaveWindow();
	}
	
	public void showLoadGardenScreen() {
		saveLoadScreen.showSaveWindow();
	}
	
	public void showFinalViewScreen() {
		finalViewScreen.showFinalView(primaryStage);;
	}
	
	public void showInfoTipsScreen() {
		//should have two show methods with one that takes a Stage?
		infoTipsScreen.showInfoTips(primaryStage);
	}
	
	public void showPreferencesScreen() {
		preferencesScreen.showPreferences(primaryStage);
	}
	
	public void showSeasonViewScreen() {
		//should take in a Stage
		seasonViewScreen.ShowSeasonView();
	}
	
	
	
	
		
	
}

