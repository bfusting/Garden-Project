import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

//last edited: 4-29-20 2:21PM


public class View extends Application{
	private Stage primaryStage;
	private Controller con;
	
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
	private Exit exitScreen;
	
	private Screen currentPrimaryScreen;
		
	
	
	/**
	 * Constructor for the View that creates the instructions, exit, back and main menu Buttons
	 * and sets primaryStage to the Stage created at the start of the program. 
	 * 
	 */
	public View() {
	
		con = new Controller(this);
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
		primaryStage = theStage;
		
		mainMenuScreen = new MainMenu(con,primaryStage);
		//mainMenuScreen.setPreviousScreen(mainMenuScreen);
		
		instructionsScreen = new Instructions();
	
		exitScreen = new Exit(con);
		
		chooseTemplateScreen = new ChooseTemplate(con,primaryStage);
		chooseTemplateScreen.setPreviousScreen(mainMenuScreen);
		
		designGardenScreen = new DesignGarden(con,primaryStage);
		designGardenScreen.setPreviousScreen(chooseTemplateScreen);
		
		saveLoadScreen = new SaveLoad();
		
		finalViewScreen = new FinalView(con,primaryStage);
		finalViewScreen.setPreviousScreen(designGardenScreen);
		
		// InfoTips should take in a plant from model
		//infoTipsScreen = new InfoTips(null, 0, null, 0, 0, false, null, null);
		infoTipsScreen = new InfoTips();
		
		seasonViewScreen = new SeasonView(con);
		// InfoTips should take in a plant from model
		
		recommendationsScreen = new Recommendations(con);
		recommendationsScreen.setPreviousScreen(designGardenScreen);
		
		preferencesScreen = new Preferences(con);
		preferencesScreen.setPreviousScreen(chooseTemplateScreen);
		
		
		currentPrimaryScreen = mainMenuScreen;
		
		
		System.out.println("Set the stage for el Main Menu");
		mainMenuScreen.showMainMenu(primaryStage);
		primaryStage.show();
		
		/*exitScreen.setPreviousScreen(currentPrimaryScreen);
		exitScreen.showExitWithSave();
		currentPrimaryScreen = exitScreen;*/
		
		
		
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
		System.out.println("Close all the windows");
		//primaryStage.close();
		//exitScreen.closeExit();
		//instructionsScreen.closeInstructions();
		//instructionsScreen.closeScreen();
		Platform.exit();
		
	}
	
	/**
	 * Closes all open windows after the user saves or quits without saving.
	 */
	public void showExitScreen() {
		System.out.println("leaving so soon? :(");
		exitScreen.setPreviousScreen(currentPrimaryScreen);
		
		
		if (currentPrimaryScreen.equals(finalViewScreen)) {
			exitScreen.showExitWithSave();
		}
		else {
			exitScreen.showExitWithoutSave();
		}
		
		currentPrimaryScreen = exitScreen;
		
	}
	
	/**
	 * Makes the MainMenu Stage visible to the user.
	 * 
	 */
	public void showMainMenuScreen() {
		currentPrimaryScreen = mainMenuScreen;
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
		//can delete
		chooseTemplateScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = chooseTemplateScreen;
		
		chooseTemplateScreen.showChooseTemplate(primaryStage);
		
	}
	
	public void showDesignGardenScreen() {
		designGardenScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = designGardenScreen;
		designGardenScreen.showDesignGarden(primaryStage);
	}
	
	public File showSaveGardenScreen() {
		//exitScreen.closeExit();
		saveLoadScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = saveLoadScreen;
		
		return saveLoadScreen.showSaveWindow();
	}
	
	public File showLoadGardenScreen() {
		saveLoadScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = saveLoadScreen;
		return saveLoadScreen.showLoadWindow();
	}
	
	public void showFinalViewScreen() {
		finalViewScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = finalViewScreen;
		finalViewScreen.showFinalView(primaryStage);
	}
	
	public void showInfoTipsScreen() {
		//should have two show methods with one that takes a Stage?
		infoTipsScreen.showInfoTips(primaryStage);
	}
	
	public void showPreferencesScreen() {
		preferencesScreen.setPreviousScreen(currentPrimaryScreen);
		currentPrimaryScreen = preferencesScreen;
		preferencesScreen.showPreferences(primaryStage);
	}
	
	public void showSeasonViewScreen() {
		//can delete
		//should take in a Stage
		seasonViewScreen.ShowSeasonView();
	}
	
	public void showRecommendationsScreen() {
		recommendationsScreen.showRecommendations();
	}
	
	public DesignGarden getDesignGardenScreen() {
		return designGardenScreen;
	}
	
	public void goToLastScreen() {
		System.out.println("Was showing: "+currentPrimaryScreen);
		currentPrimaryScreen.goToPreviousScreen();
		currentPrimaryScreen = currentPrimaryScreen.getPreviousScreen();
	}
	
	/**
	 * Makes the Screen specified by the given String visible to the user by invoking
	 * the necessary Screen's showScreen method.
	 * 
	 * @param screen the String representing the name of the Screen to be shown
	 * 
	 * @see Screen
	 * @see Screen#showScreen()
	 */
	public void show(String screen) {
		
		
		switch (screen) {
		case "mainMenuScreen":
			currentPrimaryScreen = mainMenuScreen;
			mainMenuScreen.showScreen();
			break;
		case "instructionsScreen":
			//instructionsScreen.setPreviousScreen(currentPrimaryScreen);
			//currentPrimaryScreen = instructionsScreen;
			instructionsScreen.showScreen();
			break;
		case "chooseTemplateScreen":
			currentPrimaryScreen = chooseTemplateScreen;
			chooseTemplateScreen.showScreen();
			break;
		case "designGardenScreen":
			currentPrimaryScreen = designGardenScreen;
			designGardenScreen.showScreen();
			break;
		case "finalViewScreen":
			currentPrimaryScreen = finalViewScreen;
			finalViewScreen.showScreen();
			break;
		case "infoTipsScreen":
			infoTipsScreen.setPreviousScreen(currentPrimaryScreen);
			//currentPrimaryScreen = infoTipsScreen;
			//infoTipsScreen.showScreen();
			infoTipsScreen.showInfoTips(primaryStage);
			break;
		case "preferencesScreen":
			currentPrimaryScreen = preferencesScreen;
			//preferencesScreen.showScreen();
			preferencesScreen.showPreferences(primaryStage);
			break;
		case "saveGardenScreen":
			//exitScreen.closeExit();
			//saveLoadScreen.setPreviousScreen(currentPrimaryScreen);
			//currentPrimaryScreen = saveLoadScreen;
			
			//con.saveGardenTemp(saveLoadScreen.showSaveWindow());
			if (currentPrimaryScreen.equals(exitScreen)) {
				exitScreen.closeScreen();
				saveLoadScreen.setPreviousScreen(exitScreen.getPreviousScreen());
				
				
				if (con.saveGardenTemp(saveLoadScreen.showSaveWindow())) {
					exit();
				}
				/*else {
					currentPrimaryScreen = exitScreen.getPreviousScreen();
					
				}*/
			} else {
				saveLoadScreen.setPreviousScreen(currentPrimaryScreen);
				con.saveGardenTemp(saveLoadScreen.showSaveWindow());
				//con.saveGardenTemp(saveLoadScreen.showSaveWindow());
				//currentPrimaryScreen.setEditable();
			}
			currentPrimaryScreen = saveLoadScreen;
			goToLastScreen();
			
			break;
		case "loadGardenScreen":
			saveLoadScreen.setPreviousScreen(currentPrimaryScreen);
			currentPrimaryScreen = saveLoadScreen;
			if (con.saveGardenTemp(saveLoadScreen.showLoadWindow())) {
				show("designGardenScreen");
			} else {
				goToLastScreen();
			}
			break;
		case "seasonViewScreen":
			seasonViewScreen.setPreviousScreen(currentPrimaryScreen);
			//currentPrimaryScreen = seasonViewScreen;
			
			seasonViewScreen.showScreen();
			break;
		case "recommendationsScreen":
			//why is it like this? Why are you creating a new one?
			recommendationsScreen = new Recommendations(con);
			recommendationsScreen.showScreen();
			break;
		case "exitScreen":
			System.out.println("leaving so soon? :(");
			exitScreen.setPreviousScreen(currentPrimaryScreen);
			
			
			if (currentPrimaryScreen.equals(finalViewScreen)) {
				exitScreen.showExitWithSave();
			}
			else {
				exitScreen.showExitWithoutSave();
			}
			
			currentPrimaryScreen = exitScreen;
		}
		

	}
	
	
	
	
		
	
}
