import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: foo11
*  Lab Section: foo31L
*  TA: Vineeth Gutta
*  Due: May 18th, 2foo2foo (5/18/2foo)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * @author Malachi Parks
 * <p>
 * Controller class handles the bulk of the program and communicates between the Model
 * and the View of the program and their respective subclasses. Most of the methods
 * are event handlers and getters to set the event handlers for the items in View and 
 * its subclasses.
 */
public class Controller{
	private Model model;
	private View view;
	
	/**
	 * Constructor for the Controller class where the 
	 * model attribute and view attribute are initialized
	 * 
	 * @see Controller
	 */
	public Controller() {
		model = new Model();
		view = new View();
	}//Controller
	
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
		//launch();
		start(null);
	}//main
	
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
		System.out.println("Set the stage for el Main Menu");
	}
	
	/**
	 * Takes in a MouseEvent which will be bounded to the Main Menus
	 * create new garden button
	 * <p>
	 * CreateNewGarden calls the constructor of the GardenPlot
	 * and then shows the user the preferences menu.
	 * 
	 * @param event When button is clicked to create new garden
	 */
	public void createNewGarden(MouseEvent event) {
		System.out.println("NEW GARDEN HAHAHAHAHAH");
	}//createNewGarden
	
	/**
	 * Returns the model attribute from Controller
	 * <p>
	 * Used to access the model attribute from the Controller class
	 * 
	 * @return model which is of type Model()
	 */
	public Model getModel() {
		return model;
	}
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * CreateGarden button on the Main Menu
	 * <p>
	 * Used to access the createNewGarden method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see createNewGarden
	 */
	public EventHandler<MouseEvent> getCreateNewGarden() {
		return event -> createNewGarden((MouseEvent) event);
	}//getCreateNewGarden
	
	/**
	 * Takes in a MouseEvent to determine when the save/load garden
	 * button is pressed on the mainMenu
	 * <p>
	 * Uses a filechooser popup window to allow the user to select a file
	 * to open with and serializes it into the program
	 * 
	 * @param event MouseEvent used to determine if button is clicked
	 * @see MainMenu
	 */
	public void loadGarden(MouseEvent event) {
		System.out.println("Load Garden Here");
	}//loadGarden
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * loadGarden button on the Main Menu
	 * <p>
	 * Used to access the loadGarden method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see loadGarden
	 */
	public EventHandler<MouseEvent> getLoadGarden() {
		return event -> loadGarden((MouseEvent)event);
	}//getLoadGarden
	
	/**
	 * Takes in MouseEvent to know when the exit button is closed on the 
	 * MainMenu.
	 * <p>
	 * Closes the stage the user is on and before fully closes down prompts the 
	 * user to save their garden before program shutdown.
	 * 
	 * @param event MouseEvent to determine if button is clicked
	 * @see MainMenu
	 */
	public void exit(MouseEvent event) {
		System.out.println("Exit by saving the closing");
	}//exit
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * CreateGarden button on the Main Menu
	 * <p>
	 * Used to access the exit method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see exit
	 */
	public EventHandler<MouseEvent> getExit() {
		return event -> exit((MouseEvent)event);
	}//getExit
	
	
	/**
	 * Takes in a event of type MouseEvent to know when the button
	 * of showInstructions is clicked
	 * <p>
	 * Used to Pop open a new window with the instructions using
	 * the showInstructions method under instructions.java
	 * 
	 * @param event MouseEvent to know when button is clicked
	 */
	public void instructionsShow(MouseEvent event) {
		System.out.println("Show Instructions");
	}//instructionsShow
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * instructionsShow button on the Main Menu
	 * <p>
	 * Used to access the Instructions method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see instructionsShow
	 */
	public EventHandler<MouseEvent> getInstructionShow() {
		return event -> instructionsShow((MouseEvent)event);
	}//getCreateNewGarden
	
	
	/**
	 * Takes in a MouseEvent to determine when the backBTN is clicked on
	 * any of the screens.
	 * <p>
	 * Using an array of scenes used to index back one to load the previous screen
	 * when the button is clicked. Calls on elements of show depending on what 
	 * stage was scene last
	 * 
	 * @param event MouseEvent to determine when the back button is clicked
	 * @see View
	 */
	public void backBTN(MouseEvent event) {
		System.out.println("Go Back");
	}//backBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * backBTN button on the Main Menu
	 * <p>
	 * Used to access the backBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see backBTN
	 */
	public EventHandler<MouseEvent> getBackBTN() {
		return event -> backBTN((MouseEvent) event);
	}//getBackBTN
	
	/**
	 * Takes in a MouseEvent to determine when any of the ImageViews
	 * on the ChooseTemplate page are clicked to set up the array 
	 * format of the gardenPlot
	 * <p>
	 * Used on the ChooseTemplate page of the program to set up each array
	 * then calls the GardenPlot Constructor in GardenPlot
	 * then iterate through to designate the shape
	 * of the garden individuals would like.
	 * 
	 * @param event MouseEvent to know when ImageViews are clicked
	 * @see GardenPlot
	 */
	public void chooseDesign(MouseEvent event) {
		System.out.println("Choose Templatttteeeeee");
	}//choseDesign
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * ChooseDesign button on the Main Menu
	 * <p>
	 * Used to access the chooseDesign method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see chooseDesign
	 */
	public EventHandler<MouseEvent> getChooseDesign() {
		return event -> chooseDesign((MouseEvent)event);
	}//getChooseDesign
	
	
	/**
	 * Takes in eventHandler to know when the checkboxes are checked for 
	 * Preferences which will be passed to Model to help show the important 
	 * plant near the front
	 * <p>
	 * comboCheckBox used to know which items are selected then passed to 
	 * Model for garden preferences
	 * 
	 * @param event MouseEvent to know when checkbox is clicked
	 */
	public void comboCheckBox(MouseEvent event) {
		System.out.println("click me!");
	}//comboCheckBox
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * comboCheckBox button on the Main Menu
	 * <p>
	 * Used to access the comboCheckBox method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see comboBoxCheck
	 */
	public EventHandler<MouseEvent> getComboCheckBox() {
		return event -> comboCheckBox((MouseEvent)event);
	}//getComboCheckBox
	
	
	/**
	 * Takes in a mouseEvent to know when the recommendations button
	 * on the DesignGarden page is clicked
	 * <p>
	 * Pops up information based upon the GardenTile information
	 * and then matches it against the kind of plant the user 
	 * is looking for to recommend plant placement
	 * 
	 * @param event MouseEvent to know when button is clicked
	 * @see DesignGarden
	 */
	public void recommendationsBTN(MouseEvent event) {
		System.out.println("WE RECOMMEND COVID19");
	}//recommendationsBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * recommendations button on the Main Menu
	 * <p>
	 * Used to access the recommendations method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see recommendationsBTN
	 */
	public EventHandler<MouseEvent> getRecommendationsBTN() {
		return event -> recommendationsBTN((MouseEvent)event);
	}//getRecommendationsBTN
	
	
	/**
	 * Takes in a MouseEvent to know when the change seasons button on the 
	 * FinalView pane is cliced
	 * <p>
	 * Alters the GardenPlots current seasons and swaps all the pictures from the 
	 * current season to the new season via getters and setters
	 * 
	 * @param event MouseEvent to know when changeSeasons BTN is clicked
	 * @see FinalView
	 */
	public void changeSeasonsBTN(MouseEvent event) {
		System.out.println("Now is FAAAAAAAAAAAALLLLLLLLLLLLLLLLLL");
	}//changeSeasonsBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * changeSeasonsBTN button on the Main Menu
	 * <p>
	 * Used to access the changeSeasonsBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see changeSeasonsBTN
	 */
	public EventHandler<MouseEvent> getChangeSeasonsBTN() {
		return event -> changeSeasonsBTN((MouseEvent)event);
	}//getChangeSeasons
	
	
	/**
	 * Takes in a MouseEvent to know when the mainMenuBTN is clicked on the 
	 * FinalView screen
	 * <p>
	 * Prompts user to save and takes the user back to the mainMenu by 
	 * calling save method and then closing the old stage and reopening the
	 * MainMenu stage.
	 * 
	 * @param event MouseEvent to know when the MainMenu Btn is clicked
	 * @see FinalView
	 */
	public void mainMenuBTN(MouseEvent event) {
		System.out.println("Take Me Home");
	}//mainMenuBTN
	
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mainmenu button on the Main Menu
	 * <p>
	 * Used to access the mainMenu method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see MainMenu
	 * @see mainMenuBTN
	 */
	public EventHandler<MouseEvent> getMainMenuBTN() {
		return event -> mainMenuBTN((MouseEvent)event);
	}//getMainMenuBTN
	
	/**
	 * Takes in a MouseEvent to know when the changeTab is clicked on the 
	 * FinalView screen
	 * <p>
	 * When clicking another tab uses the update array is the Model
	 * then in the view updates those arrays to show the updated pictures
	 * 
	 * @param event MouseEvent to know when the changeTab Btn is clicked
	 * @see DesignGarden
	 */
	public void changeTab(MouseEvent event) {
		System.out.println("change tabbbbb");
	}//changeTab
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * changeTab button on the Main Menu
	 * <p>
	 * Used to access the changeTab method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see changeTab
	 */
	public EventHandler<MouseEvent> getChangeTab() {
		return event -> changeTab((MouseEvent)event);
	}//getChangeTab
	
	
	/**
	 * Takes in a MouseEvent to know when the startDrag of an ImageView on the 
	 * DesignGarden screen
	 * <p>
	 * checks to see if the drag has started, if so copies the image to the 
	 * DragBoard of the drag event and sets its content to the image
	 * 
	 * @param event MouseEvent to know when the drag event starts
	 * @see DesignGarden
	 */
	public void startDrag(MouseEvent event) {
		System.out.println("Starting to drag my soul out of my bodddyyyyyy");
	}//startDrag
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Drag listener on DesignGarden
	 * <p>
	 * Used to access the startDrag method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see startDrag
	 */
	public EventHandler<MouseEvent> getStartDrag() {
		return event -> startDrag((MouseEvent)event);
	}//getStartDrag
	
	
	/**
	 * Takes in a DragEvent to know when the target drag of an ImageView on the 
	 * DesignGarden screen is over its destination
	 * <p>
	 * Checks to see if the drag event is not over the source and that the 
	 * drag event is not empty. When this occurs will allow the gridpane 
	 * tiles to accept the image from the dragboard.
	 * 
	 * @param event DragEvent to know when the drag is over target
	 * @see DesignGarden
	 */
	public void detectDrag(DragEvent event) {
		System.out.println("Tiles should be detecting drag events");
	}//detectDrag
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Drag listener on DesignGarden
	 * <p>
	 * Used to access the DetectDrag method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see DetectDrag
	 */
	public EventHandler getDetectDrag() {
		return event -> detectDrag((DragEvent)event);
	}//getDetectDrag
	
	/**
	 * Takes in a DragEvent to know when the target drag of an ImageView on the 
	 * DesignGarden screen is over its destination and makes tile turn green
	 * <p>
	 * Checks to see if the drag event is not over the source and that the 
	 * drag event is not empty. Then highlights the gridpane tile green if 
	 * its a valid drop
	 * 
	 * @param event DragEvent to know when the drag is over valid targer
	 * @see DesignGarden
	 */
	public void okayToDrop(DragEvent event) {
		System.out.println("Highlight Green if Okay");
	}//okayToDrop
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Drag listener on DesignGarden
	 * <p>
	 * Used to access the okayToDrop method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see okayToDrop
	 */
	public EventHandler<DragEvent> getOkayToDrop() {
		return event -> okayToDrop((DragEvent)event);
	}//getOkayToDrop
	
	
	/**
	 * Takes in a DragEvent to know when the target has the mouse released over it.
	 * <p>
	 * Once dropped creates a copy of the plant from the selection Array then overlays 
	 * the image from view on top of it with correct seaons
	 * 
	 * @param event DragEvent to know when the drag finished
	 * @see DesignGarden
	 */
	public void detectDragDrop(DragEvent event) {
		System.out.println("Tiles should detect drag and add that plant");
	}//detectDragDrop
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Drag listener on DesignGarden
	 * <p>
	 * Used to access the DetectDragDrop method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see DetectDragDrop
	 */
	public EventHandler<DragEvent> getDetectDragDrop() {
		return event -> detectDragDrop((DragEvent)event);
	}//getDetectDragDrop
	
	
	/**
	 * Takes in a ScrollEvent to know when the pane within the Info/Tips
	 * view is being scrolled up or down to view more information
	 * <p>
	 * Reads the direction of the mouse and scrolls up or down accordingly
	 * using scroll methods
	 * 
	 * @param event Scrollevent of moving up or down
	 * @see Info/Tips
	 */
	public void scrollPage(ScrollEvent event) {
		System.out.println("Should scroll page for information");
	}//scrollPage
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Scroll listener on DesignGarden
	 * <p>
	 * Used to access the scrollPage method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see InfoTips
	 * @see scrollPage
	 */
	public EventHandler<ScrollEvent> getScrollPage() {
		return event -> scrollPage((ScrollEvent)event);
	}//getScrollPage
	
	
	/**
	 * Takes in a MouseEvent to know when the Edit is clicked on the 
	 * FinalView screen
	 * <p>
	 * Uses Seralizable to load in the information into the model and the view
	 * accordingly
	 * 
	 * @param event MouseEvent to know when the edit Btn is clicked
	 * @see FinalView
	 */
	public void editBTN(MouseEvent event) {
		System.out.println("Loads In information");
	}//editBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on FinalView
	 * <p>
	 * Used to access the editBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see FinalView
	 * @see editBTN
	 */
	public EventHandler<MouseEvent> getEditBTN() {
		return event -> editBTN((MouseEvent)event);
	}//getEditBTN
	
	
	/**
	 * Takes in a MouseEvent to know when the save is clicked on the 
	 * FinalView screen
	 * <p>
	 * Uses the saveGarden method to save the GardenPlot information into a file for
	 * later
	 * 
	 * @param event MouseEvent to know when the saveBtn is clicked
	 * @see saveGarden
	 */
	public void saveBTN(MouseEvent event) {
		System.out.println("SAVE OFTEN");
	}//saveBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on FinalView
	 * <p>
	 * Used to access the saveBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see FinalView
	 * @see saveBTN
	 */
	public EventHandler<MouseEvent> getSaveBTN() {
		return event -> saveBTN((MouseEvent)event);
	}//getSaveBTN
	
	
	/**
	 * Takes in a MouseEvent to know when the Info/Tips is clicked on the 
	 * DesignGarden screen
	 * <p>
	 * Pops up new window of Info/Tips using the Info/Tips show method
	 * 
	 * @param event MouseEvent to know when the Info/Tips is clicked
	 * @see DesignGarden
	 */
	public void infoTipsBTN(MouseEvent event) {
		System.out.println("Displays tips");
	}//infoTipsBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on FinalView
	 * <p>
	 * Used to access the infoTipsBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see InfoTips
	 */
	public EventHandler<MouseEvent> getInfoTipsBTN() {
		return event -> infoTipsBTN((MouseEvent)event);
	}//getInfoTipsBTN
	
	/**
	 * Takes in a MouseEvent to know when the viewSeasons is clicked on the 
	 * FinalView screen
	 * <p>
	 * Changes the Gardenplots season type then updates the view accordingly
	 * First though pops open a window using viewSesonsShow method.
	 * 
	 * @param event MouseEvent to know when the viewSeasons is clicked
	 * @see DesignGarden
	 */
	public void viewSeasonsBTN(MouseEvent event) {
		System.out.println("Should be full season view");
	}//viewSeasonsBTN
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on DesignGarden
	 * <p>
	 * Used to access the viewSeasonsBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 * @see viewSesonsBTN
	 */
	public EventHandler<MouseEvent> getViewSeasonsBTN() {
		return event -> viewSeasonsBTN((MouseEvent)event);
	}//getViewSeasonsBTN
	
	/**
	 * Filechooser to choose where the user wants to save the information
	 * then using Serializable to save the information to a file
	 * 
	 * @see FinalView
	 */
	public void saveGarden() {
		System.out.println("Open fileChooser and Save file");
	}
	
	/**
	 * Filechooser to choose where the user wants to load the information from
	 * then using Serializable to load the information from a file
	 * 
	 * @see FinalView
	 */
	public void loadGarden() {
		System.out.println("Loads using fileChooser");
	}
	
	
}//Controller
