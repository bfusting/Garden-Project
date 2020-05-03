import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
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
 * General class for handling the navigation through the program. Contains 
 * each Screen that will be shown to the user and defines how they interact by calling
 * each Screen's methods accordingly.
 * 
 * @see Screen
 * 
 * @author Takiyah Price 
 */

//last edited: 5-2-20 5:37PM


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
	private SeasonView seasonViewScreen;
	private Recommendations recommendationsScreen;
	private Exit exitScreen;
	
	private Screen currentPrimaryScreen;
	
	static final int primarySceneWidth = 1200;
	static final int primarySceneHeight = 800;
	static final double nonEditableOpacity = 0.85;
	static final double EditableOpacity = 1.0;
	static final Color borderColor = Color.color(0.082, 0.533, 0.478);
	
	
	private FileChooser fileChooser;
	
	/**
	 * Constructor for the View that creates the Controller and passes itself into the Controller's constructor. 
	 * 
	 * @see Controller
	 */
	public View() {
		con = new Controller(this);
		fileChooser = new FileChooser();
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
	 * Takes in parameter theStage and uses it to initialize its reference to the primary Stage
	 * <p>
	 * Start is used to for the start of the program where it starts with the main menu
	 * 
	 * @param theStage primary stage which will be set with mainMenuScreen's scene
	 */
	public void start(Stage theStage) {
		primaryStage = theStage;
		
		mainMenuScreen = new MainMenu(con,primaryStage);
		
		instructionsScreen = new Instructions();
	
		exitScreen = new Exit(con);
		
		chooseTemplateScreen = new ChooseTemplate(con,primaryStage);
		chooseTemplateScreen.setPreviousScreen(mainMenuScreen);
		
		designGardenScreen = new DesignGarden(con,primaryStage);
		designGardenScreen.setPreviousScreen(chooseTemplateScreen);
		
		
		
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
		mainMenuScreen.showScreen();
		//chooseTemplateScreen.showScreen();
		primaryStage.show();
		
		
		
		
	}
	
	
	/**
	 * Closes the application, meaning all windows are closed.
	 */
	public void exit() {
		System.out.println("Close all the windows");
		
		Platform.exit();
		
	}
	
	
	
	/**
	 * Returns the designGardenScreen, which handles the screen for editing the garden.
	 * 
	 * @return the Screen designGardenScreen, which handles the Scene and visual components of the screen
	 * where the user can edit their garden
	 */
	public DesignGarden getDesignGardenScreen() {
		return designGardenScreen;
	}
	
	/**
	 * Goes to the last Screen and sets currentPrimaryScreen back one Screen to reflect the change.
	 *
	 */
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
		case "saveGarden":
			
			if (currentPrimaryScreen.equals(exitScreen)) {
				exitScreen.closeScreen();
				
				if (con.saveGarden(showSaveLoad(true))) {
					exit();
				} else {
					goToLastScreen();
				}
			} 
			else {
				con.saveGarden(showSaveLoad(true));
			}
			break;
			
		case "loadGarden":
			if (con.loadGarden(showSaveLoad(false))) {
				show("designGardenScreen");
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
	
	/**
	 * Shows a save or load dialog depending on whether the user pressed a save or load button,
	 * momentarily lowering the opacity of the primaryStage behind it to visually communicate
	 * that it cannot be accessed while the dialog is open.
	 * 
	 * @param isSaving a boolean specifying whether to open a save or load dialog; true for a 
	 * save dialog and false for an open dialog.
	 * @return the File returned by the FileChooser; null if the user cancelled the process,
	 * a new File if the user is saving a design and an existing File if the user is loading an design.
	 */
	public File showSaveLoad(boolean isSaving) {
		primaryStage.setOpacity(nonEditableOpacity);
		File file = null;
		if (isSaving) {
			file = fileChooser.showSaveDialog(primaryStage);
		} else {
			file = fileChooser.showOpenDialog(primaryStage);
		}
		
		primaryStage.setOpacity(EditableOpacity);
		return file;
	}
	
	
	
	
		
	
}
