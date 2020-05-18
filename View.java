import java.io.File;
import java.util.HashSet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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

//last edited: 5-10-20 7:00PM


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
	static final int borderWidth = 20;
	static final Color settingsBorderColor = Color.web("#4e824a");
	static final Color settingsBackgroundColor = Color.web("#a5c96b");
	static final Border settingsBorder = new Border(new BorderStroke(settingsBorderColor,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(borderWidth)));
	static final Background settingsBackground = new Background(new BackgroundFill(View.settingsBackgroundColor, CornerRadii.EMPTY, new Insets(borderWidth)));
	static final Image settingsAccentImg = new Image("img/v850-sasi-13.jpg");
	
	static final Color designingBorderColor = Color.web("#194f3a");
	static final Color designingBackgroundColor = Color.web("#a3dcbc");
	static final Image designingAccentImg = new Image("img/v698-bb-2-leaves_1.jpg");
	static final Background designBackground = new Background(new BackgroundFill(designingBackgroundColor,CornerRadii.EMPTY,Insets.EMPTY));
	
	static final Font backNextBTNFont = Font.font("Verdana",FontWeight.BOLD,FontPosture.ITALIC,20);
	
	private final static String activeSoilImgName = "img/soil.jpg";
	private final static String inactiveSoilImgName = "img/soilinactive.jpeg";
	
	private FileChooser fileChooser;
	
	/**
	 * Constructor for the View that creates the Controller and passes itself into the Controller's constructor and creates a FileChooser for when
	 * when the user loads a saved design.
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
		primaryStage.setOnCloseRequest(con.getExitStage());
		
		mainMenuScreen = new MainMenu(con,primaryStage);
		instructionsScreen = new Instructions();
		exitScreen = new Exit(con);
		finalViewScreen = new FinalView(con,primaryStage);
		infoTipsScreen = new InfoTips();
		//seasonViewScreen = new SeasonView(con);
		recommendationsScreen = new Recommendations(con);
		
		createNew();
		
		
		
		
		
		//finalViewScreen.setPreviousScreen(designGardenScreen);
		
		
		
		
		//recommendationsScreen.setPreviousScreen(designGardenScreen);
		
		
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
			if (currentPrimaryScreen.equals(exitScreen)) {
				exitScreen.goToPreviousScreen();
			}
			currentPrimaryScreen = mainMenuScreen;
			mainMenuScreen.showScreen();
			break;
		case "instructionsScreen":
			
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
			infoTipsScreen.showInfoTips();
			break;
		case "preferencesScreen":
			currentPrimaryScreen = preferencesScreen;
			preferencesScreen.showScreen();
			break;
		case "saveGarden":
			
			if (currentPrimaryScreen.equals(exitScreen)) {
				exitScreen.closeScreen();
				
				if (con.saveGarden(showSaveLoad(true))) {
					if (exitScreen.getExitCase().equals("mainMenuWarning")) {
						show("mainMenuScreen");
					}
					else {
						exit();
					}
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
			
			seasonViewScreen.showScreen();
			break;
		case "recommendationsScreen":
			//recommendationsScreen = new Recommendations(con);
			recommendationsScreen.showScreen();
			break;
		case "exitScreen":
			System.out.println("leaving so soon? :(");
			exitScreen.setPreviousScreen(currentPrimaryScreen);
			if (currentPrimaryScreen.equals(finalViewScreen) || currentPrimaryScreen.equals(designGardenScreen) || currentPrimaryScreen.equals(preferencesScreen)) {
				exitScreen.showScreen("exitSave");
			} else {
				exitScreen.showScreen("exitNoSave");
			}
		
			currentPrimaryScreen = exitScreen;
			break;
		case "mainMenuWarning":
			exitScreen.setPreviousScreen(currentPrimaryScreen);
			currentPrimaryScreen = exitScreen;
			exitScreen.showScreen("mainMenuWarning");
			
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
		ExtensionFilter npgFilter = new ExtensionFilter("Native Plant Garden Design files (.npgd)","*.npgd");
		fileChooser.getExtensionFilters().add(npgFilter);
		
		if (isSaving) {
			fileChooser.setInitialFileName("MyGarden");
			
			
			
			file = fileChooser.showSaveDialog(primaryStage);
		} else {
			
			file = fileChooser.showOpenDialog(primaryStage);
		}
		
		primaryStage.setOpacity(EditableOpacity);
		return file;
	}
	
	/**
	 * Calls the appropriate Screen's methods to manage the mouse entering a Node belonging to that Screen. Behavior
	 * is relative to the current primary Screen being shown to the user. To be called by the Controller.
	 * 
	 * @param o an Object, the source of the mouseEntered event being handled, which can be cast relative to the current Screen.
	 * 
	 * @see Controller#mouseClicked(javafx.scene.input.MouseEvent)
	 */
	public void mouseEntered(Object o) {
		if (currentPrimaryScreen.equals(chooseTemplateScreen)) {
			chooseTemplateScreen.mouseInside((Shape) o);
		}
		
	}
	
	/**
	 * Calls the appropriate Screen's methods to manage the mouse exiting a Node belonging to that Screen. Behavior
	 * is relative to the current primary Screen being shown to the user. To be called by the Controller.
	 * 
	 * @param o an Object, the source of the mouseExited event being handled, which can be cast relative to the current Screen.
	 * 
	 * @see Controller#mouseExit(javafx.scene.input.MouseEvent)
	 */
	public void mouseExited(Object o) {
		if (currentPrimaryScreen.equals(chooseTemplateScreen)) {
			chooseTemplateScreen.mouseOutside((Shape) o);
		}
	}
	
	/**
	 * Calls the appropriate Screen's methods to manage the mouse clicking a Node belonging to that Screen. Behavior
	 * is relative to the current primary Screen being shown to the user. To be called by the Controller.
	 * 
	 * @param o an Object, the source of the mouseClicked event being handled, which can be cast relative to the current Screen.
	 * 
	 * @see Controller#mouseClicked(javafx.scene.input.MouseEvent)
	 */
	public void mouseClicked(Object o) {
		if (currentPrimaryScreen.equals(chooseTemplateScreen)) {
			chooseTemplateScreen.mouseClicked((Shape) o);
			preferencesScreen.changePrefsSetText();
		}
		else if (currentPrimaryScreen.equals(preferencesScreen)) {
			preferencesScreen.sendPreference((Control) o);
			preferencesScreen.changePrefsSetText();
			if (con.verifySettings()) {
				preferencesScreen.allowStartCreating();
			}
		}
	}
	
	public int getCurrentTotalPrefs() {
		return preferencesScreen.getTotalPrefs();
	}
	
	/**
	 * Gets the String representation of the template selected by the user on the Choose Template Screen. To be
	 * called by the Controller in order to update the model with the shape.
	 * 
	 * @return the name of the selected template as a String.
	 * 
	 * @see ChooseTemplate#getSelectedTemplate()
	 * @see GardenPlot#shape
	 */
	public String sendTemplate() {
		return chooseTemplateScreen.getSelectedTemplate();
	}
	
	
	/**
	 * Returns the String representation of the current primary Screen being viewed.
	 */
	public String getCurrentPrimaryScreen() {
		return String.valueOf(currentPrimaryScreen);
	}
	
	/**
	 * Passes the user preferences to the preferences screen to set up the Screen when loading a saved design with unfinished preferences.
	 * @param colorPref The user preferred color for the plants.
	 * @param seasonPref The user preferred season to view the plants in while designing.
	 * @param waterPref The general water availability specified by the user.
	 * @param lightPref The general light availability specified by the user.
	 * @param lengthPref The length of the garden if rectangular, or the number of rows if triangular.
	 * @param widthPref The width of the garden.
	 */
	public void loadPreferences(String colorPref, String seasonPref, int waterPref,int lightPref, int lengthPref, int widthPref) {
		
		preferencesScreen.setValues(colorPref,seasonPref,waterPref,lightPref,lengthPref,widthPref);
	}
	
	/**
	 * Reinstantiates the templates, preferences and design Screens. To be called when the user clicks the 'Create New Garden' button from the main menu.
	 */
	public void createNew() {
		chooseTemplateScreen = new ChooseTemplate(con,primaryStage);
		chooseTemplateScreen.setPreviousScreen(mainMenuScreen);
		preferencesScreen = new Preferences(con,primaryStage);
		preferencesScreen.setPreviousScreen(chooseTemplateScreen);
		designGardenScreen = new DesignGarden(con,primaryStage);
		designGardenScreen.setPreviousScreen(preferencesScreen);
		
		finalViewScreen.setPreviousScreen(designGardenScreen);
		recommendationsScreen.setPreviousScreen(designGardenScreen);
		seasonViewScreen = new SeasonView(con);
		
	}
	
	/**
	 * Returns the SeasonView Screen.
	 * @return the SeasonView Screen.
	 * @see SeasonView
	 */
	public SeasonView getSeasonViewScreen() {
		return seasonViewScreen;
	}
	
	/**
	 * Returns the FinalView Screen.
	 * @return the FinalView Screen.
	 * 
	 * @see FinalView
	 */
	public FinalView getFinalViewScreen() {
		return finalViewScreen;
	}
	
	
	public static GridPane drawGrid(Controller con,boolean drawInactiveTiles) {
		GridPane gp = new GridPane();
		int soilImgSize = 89;
		int AddOnImgSize = 80;
		
		for (int i=0;i<con.getLengthFromModel();i++) {
			for (int j=0; j<con.getWidthFromModel();j++) {
				ImageView soilImg = new ImageView(new Image(activeSoilImgName));
					soilImg.setPreserveRatio(true);
					soilImg.setFitHeight(soilImgSize);
					soilImg.setFitWidth(soilImgSize);
					gp.add(soilImg, j, i,1,1);
					
					gp.setGridLinesVisible(false);
					//gp.setAlignment(Pos.BASELINE_CENTER);
					gp.setPadding(new Insets(10));
					String addOnImgName = con.getImgNameFromModel(i, j);
					if  (addOnImgName.equals("inactive")) {
						if (drawInactiveTiles && con.getTemplateFromModel().toLowerCase().equals("custom")) {
							ImageView inactiveSoilImg = new ImageView(new Image(inactiveSoilImgName));
							inactiveSoilImg.setPreserveRatio(true);
							inactiveSoilImg.setFitHeight(soilImgSize);
							inactiveSoilImg.setFitWidth(soilImgSize);
							gp.add(inactiveSoilImg, j, i,1,1);
						} else {
						gp.getChildren().remove(soilImg);
						}
					}
					else if (!addOnImgName.equals("") && addOnImgName!=null && !addOnImgName.equals("null")) {
						ImageView addOnIV = new ImageView(new Image(addOnImgName));
						addOnIV.setFitHeight(AddOnImgSize);
						addOnIV.setFitWidth(AddOnImgSize);
						addOnIV.setOnMouseClicked(con.getRemoveFromTile());
						gp.add(addOnIV, j, i, 1,1);
					}
					
					
				}
			}
		return gp;
		
	}
	
	/**
	 * Changes the given empty soil ImageView in the DesignGarden screen's GridPane to the image for an active tile 
	 * if the boolean 'active' is true or for an inactive tile is active is false. To be called by the controller when
	 * the user has chosen the custom template and clicks an empty tile.
	 * 
	 * @param soilIV the ImageView being set with a new Image.
	 * @param active a boolean, true if soilIV is being set with the Image for an active tile and false if
	 * it is being set with the Image for an inactive tile.
	 */
	public void setActiveImg(ImageView soilIV,boolean active) {
		
		if (active) {
			soilIV.setImage(new Image(activeSoilImgName));
		}
		else {
			soilIV.setImage(new Image(inactiveSoilImgName));
		}
	}
	
	
	
}
