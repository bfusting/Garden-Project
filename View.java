import javafx.application.Application;
import javafx.application.Platform;


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

//last edited: 5-1-20 2:28AM


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
	
	static final int primarySceneWidth = 1200;
	static final int primarySceneHeight = 800;
	
	
	/**
	 * Constructor for the View that creates the Controller and passes itself into the Controller's constructor. 
	 * 
	 * @see Controller
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
		mainMenuScreen.showScreen();
		primaryStage.show();
		
		
		
		
	}
	
	
	/**
	 * Closes the application, meaning all windows are closed.
	 */
	public void exit() {
		System.out.println("Close all the windows");
		
		Platform.exit();
		
	}
	
	/*
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
	
	
	public void showMainMenuScreen() {
		currentPrimaryScreen = mainMenuScreen;
		mainMenuScreen.showMainMenu(primaryStage);
		
	}
	
	
	public void showInstructionsScreen() {
		instructionsScreen.showInstructions();
	}
	
	
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
	
	*/
	
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
