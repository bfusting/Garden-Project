import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
	private boolean DEBUG;
	/**
	 * Constructor for the Controller class where the 
	 * model attribute and view attribute are initialized. 
	 * Creates new view for each of the View subclassses 
	 * to access their methods
	 * 
	 * @see Controller
	 */
	public Controller(View passedInView) {
		model = new Model();
		
		this.view = passedInView;
		DEBUG = true;
	}//Controller
	
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
		if(DEBUG) { System.out.println("Created new Garden Plot");};
		//model.setUserPlot(new GardenPlot());
		model = new Model();
		//model.setUserPlot(new GardenPlot());
		view.createNew();
		view.show("chooseTemplateScreen");
		System.out.println("CHOOSE YOUR FIGHTER");
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
		
		//view.show("loadGarden");
		loadGarden(view.showSaveLoad(false));
		/*File file = view.showLoadGardenScreen();
		if (file!=null) {
		//presumably update Model here with file contents and tell all the information to view
		view.showDesignGardenScreen();
		} else {
			view.goToLastScreen();
		}*/
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
		
		if (view.getCurrentPrimaryScreen().equals("Main Menu")) {
			view.exit();
		} else {
		view.show("exitScreen");
		}
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
		//view.showInstructionsScreen();
		view.show("instructionsScreen");
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
		view.goToLastScreen();
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
	public void designTime(MouseEvent event) {
		int circleSize = 7;
		int maxRows = 4;
		
		if (model.getUserTemplate().toLowerCase().equals("triangle")) {
			model.setUserLength(Math.min(model.getUserLength(), maxRows ));
			model.setUserWidth(2*model.getUserLength());
		}
		else if (model.getUserTemplate().toLowerCase().equals("circle")) {
			model.setUserLength(circleSize);
			model.setUserWidth(circleSize);
		}
		
		
		System.out.println("Final preferences:\nColor: "+model.getUserPrefColor()+", Season: "+model.getUserPrefSeason()+", Light level: "+model.getUserPrefLight()+"\nWater level: "+model.getUserPrefWater()+", Length: "+ model.getUserLength()+", Width: "+model.getUserWidth());
		
		model.createUserPlot();
		model.updateArrs();
		model.updateGardenTileSettings();
		System.out.println("Make Garden");
		//view.showDesignGardenScreen();
		view.show("designGardenScreen");
	}//choseDesign
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * DesignTime button on the Main Menu
	 * <p>
	 * Used to access the DesignTime method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignTime
	 */
	public EventHandler<MouseEvent> getDesignTime() {
		return event -> designTime((MouseEvent)event);
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
		//Recommendations r = new Recommendations(this);
		//r.showRecommendations();
		view.show("recommendationsScreen");
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
		//view.showSeasonViewScreen();
		view.show("seasonViewScreen");
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
		view.show("mainMenuScreen");
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
		//Didn't use a node because can't call ImageView methods on it
		ImageView n = (ImageView)event.getSource();

		//Create dragboard to hold data
        Dragboard dBoard = n.startDragAndDrop(TransferMode.ANY);

        //Use clipboard to copy data the add to Dragboard
        ClipboardContent content = new ClipboardContent();
        //Need to edit to pull in right plant from model when dragging
        content.putImage(n.getImage());
        dBoard.setContent(content);
        
        
        event.consume();
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
        if (event.getGestureSource() != event.getTarget()
        		&& event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        
        event.consume();
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
	public EventHandler<DragEvent> getDetectDrag() {
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
		if(event.getGestureSource() != event.getTarget() && 
				event.getDragboard().hasImage()) {
			//Visual Indicator that drag n drop is valid, spaces are currently
			//labels so didn't know how to handle
			//(Label)this.setFill(Color.DARKGREEN);
		}
		
		event.consume();
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
	 * the image from view on top of it with correct seasons
	 * 
	 * @param event DragEvent to know when the drag finished
	 * @see DesignGarden
	 */
	public void detectDragDrop(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean worked = false;
		//Node n = event.getPickResult().getIntersectedNode();
		Node n = event.getPickResult().getIntersectedNode();
		if(DEBUG) {System.out.println(n.toString());}
		int index = view.getDesignGardenScreen().getGridPaneInd();
		int circleIndex = view.getDesignGardenScreen().getSelectGardenType().
			    getSelectionModel().getSelectedIndex();
		// getting rows and columns to drop into gridPane
		Integer colIndex = GridPane.getColumnIndex(n);
		Integer rowIndex = GridPane.getRowIndex(n);
		GardenTile tile = model.getUserPlot().getLayout()[rowIndex][colIndex];
		if (tile.isEmpty() && tile.isActive()) {
		if(n != view.getDesignGardenScreen().getPlot() && db.hasImage() && 
				view.getDesignGardenScreen().getHoverEditTile() == false) {
			if(DEBUG) {System.out.println("Column: " + colIndex + " Row: " + rowIndex);}
			if(circleIndex<=2) { // drag and drop circle
				// dropping plants
				Circle c = new Circle();
				c = this.createCirlceSizes(db.getImage(), circleIndex);
				c.setOnMouseClicked(getRemoveFromTile());
				view.getDesignGardenScreen().getPlot().add(c, colIndex, rowIndex, 1, 1);//add(iv, column, row);
			}
			else { // add square image to path
				// dropping paths
				ImageView imgV = new ImageView();
				imgV = createSquareSize(db.getImage());
				imgV.setOnMouseClicked(getRemoveFromTile());
				view.getDesignGardenScreen().getPlot().add(imgV, colIndex,rowIndex,1,1);
			}
			// Model side of plant drop
			changeTabIndex(rowIndex,colIndex,index);
			System.out.println(Model.getUsedPlants());
			worked = true;
		}
		else if(n != view.getDesignGardenScreen().getPlot() && db.hasImage() &&
				view.getDesignGardenScreen().getHoverEditTile() == true) {
			view.getDesignGardenScreen().setHoverEditTile(false);
			
			if(DEBUG) {System.out.println("Column: " + colIndex + " Row: " + rowIndex);}
			//int index = view.getDesignGardenScreen().getGridPaneInd();//items held in gridpane of 4. 0 is add water, 1 is less water, 2 is add sun, 3 is remove water
			int editorIdx = view.getDesignGardenScreen().getDraggedTileEditorIdx();
			System.out.println("Dropped Tile editor index "+editorIdx );
			switch(editorIdx) {
			// increases wetness of tile
			case 0: tile.setWaterLevel(
					tile.getWaterLevel()+1);
					break;
			// less water of tile dropped on
			case 1: tile.setWaterLevel(
				tile.getWaterLevel()-1);
				break;
			// more light of tile dropped on 
			case 2: tile.setSunLightLevel(
					tile.getSunLightLevel()+1);
					break;
			// less light of tile dropped on
			case 3: tile.setSunLightLevel(
				tile.getSunLightLevel()-1);
				break;
			//default: 
				//if(DEBUG) {System.out.println("Failed to place tile editor");}
				//view.getDesignGardenScreen().setHoverEditTile(false);
			}//switch
			view.getDesignGardenScreen().setHoverEditTile(false);
			if(DEBUG) {System.out.println("bool set to false");}
			worked = true;
		}
		event.setDropCompleted(worked);
		if(DEBUG) {System.out.println("Dropped Successfully");}
		event.consume();
		}
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
		view.show("saveGarden");
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
		view.show("infoTipsScreen");
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
		//view.showSeasonViewScreen();
		view.show("seasonViewScreen");
	}//viewSeasonsBTN
	
	/**
	 * Takes in a MouseEvent to know when the a template in 
	 * the template selection is clicked
	 * <p>
	 * Changes the screen to the preferences screen by popping up preferences
	 * window when clicked
	 * 
	 * @param event MouseEvent to know when the a template is clicked
	 * @see ChooseTemplate
	 */
	public void templateToPref(MouseEvent event) {
		String template = view.sendTemplate();
		
		model.setUserTemplate(template);
		System.out.println("Template sent to model: "+template);
		view.show("preferencesScreen");
	}
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on chooseTemplate page
	 * <p>
	 * Used to access the templateBTNs method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see ChooseTemplate
	 */
	public EventHandler<MouseEvent> getTemplateToPref() {
		return event -> templateToPref((MouseEvent)event);
	}
	
	
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
	 * Takes in a MouseEvent to know when the a finalView button 
	 * is clicked in DesignGarden
	 * <p>
	 * Changes the screen to the finalView when the button is clicked
	 * 
	 * @param event MouseEvent to know when the a finalView button is clicked
	 * @see DesignGarden
	 */
	public void finalViewBTN(MouseEvent event) {
		view.getDesignGardenScreen().hideAddOnInfo();
		view.show("finalViewScreen");
	}
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on DesignGarden page
	 * <p>
	 * Used to access the finalViewBTN method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see finalViewBTN
	 */
	public EventHandler<MouseEvent> getFinalViewBTN() {
		return event -> finalViewBTN((MouseEvent)event);
	}
	
	/**
	 * Deserializes the Model from the contents of the File selected by the user in the open dialog.
	 * 
	 * @param file The file selected by the user in an open dialog.
	 * @return a boolean indicating whether the file had contents that were deserialized successfully
	 */
	public boolean loadGarden(File file) {
		
		if (file!=null) {
			try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

				model = (Model) ois.readObject();
				
				System.out.println("Loading...Shape: "+ model.getUserTemplate()+" Color:  "+model.getUserPrefColor()+", Season: "+model.getUserPrefSeason()
				+", Light level: "+model.getUserPrefLight()+"\nWater level: "+model.getUserPrefWater()+", Length: "+ model.getUserLength()
				+", Width: "+model.getUserWidth()+"\n total Prefs Set: "+model.getPrefsSet());
				if (model.getUserPlot()!=null) {
					view.createNew();
					view.show("designGardenScreen");
				} else {
					view.createNew();
					view.loadPreferences(model.getUserPrefColor(),model.getUserPrefSeason()!=null ? model.getUserPrefSeason().name() : "", model.getUserPrefWater(), model.getUserPrefLight(), model.getUserLength(), model.getUserWidth());
					view.show("preferencesScreen");
				}
				return true;
			}
			catch (InvalidClassException e) {
				System.out.println("show error screen here");
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("File not loaded");
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public EventHandler<MouseEvent> getCloseAllWindows() {
		return event -> closeAllWindows((MouseEvent) event);	
	}
	
	/**
	 * 
	 * @param event
	 */
	public void closeAllWindows(MouseEvent event) {
		System.out.println("Closing program...");
		view.exit();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public EventHandler<MouseEvent> getSaveAndQuit() {
		
		return event -> saveAndQuit((MouseEvent) event);
		
	}
	
	/**
	 * 
	 * @param event
	 */
	public void saveAndQuit(MouseEvent event) {
		saveBTN(event);
		//should return a boolean or something to make sure file was saved successfully/isn't null
		//closeAllWindows(event);
	}
	
	/**
	 * Writes the contents of Model into the empty File chosen by the user from the save dialog.
	 * 
	 * @param file The empty File with the name specified by the user
	 * @return a boolean specifying whether or not the File was written to and saved successfully
	 */
	public boolean saveGarden(File file) {
		if (file!=null) {
			
			try {
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(model);
				oos.close();
				return true;
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on DesignGarden page
	 * <p>
	 * Used to access the Tiles in Design Garden method and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see DesignGarden
	 */
	public EventHandler<MouseEvent> getMouseEnter() {
		return event -> mouseEnter((MouseEvent) event);
	}
	
	/**
	 * Takes in a mouseEvent named event and passes it to the method
	 * mouseEntered in View which when hovering on the Template selections
	 * will make a border appear around the item selected.
	 * 
	 * @param event MouseEvent of hovering over template choice
	 * @see View#mouseEntered(Object)
	 */
	public void mouseEnter(MouseEvent event) {
		view.mouseEntered(event.getSource());
	}
	
	/**
	 * Returns an Event Handler to bind to an eventListener for the
	 * Mouse listener on Template page
	 * <p>
	 * Used to access the tile in Template buttons and bind it using a
	 * lambda function to an eventListner
	 * 
	 * @return EventHandler used to bind to listeners
	 * @see ChooseTemplate
	 * @see Controller#getMouseExit()
	 */
	public EventHandler<MouseEvent> getMouseExit() {
		return event -> mouseExit((MouseEvent)event);
	}
	
	/**
	 * 
	 * @param event
	 */
	public void mouseExit(MouseEvent event) {
		
		view.mouseExited(event.getSource());
	}
	
	/**
	 * 
	 * @return
	 */
	public EventHandler<WindowEvent> getExitStage() {
		return event -> exitStage((WindowEvent)event);
	}
	
	/**
	 * 
	 * @param event
	 */
	public void exitStage(WindowEvent event) {
		if (!view.getCurrentPrimaryScreen().equals("Main Menu")) {
			event.consume();
			view.show("exitScreen");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public EventHandler<MouseEvent> getMouseClicked() {
		return event -> mouseClicked((MouseEvent)event);
	}
	
	/**
	 * 
	 * @param event
	 */
	public void mouseClicked(MouseEvent event) {
		view.mouseClicked(event.getSource());
	}
	
	public EventHandler<MouseEvent> getMainMenuWarning() {
		return event -> mainMenuWarning((MouseEvent)event);
	}
	
	public void mainMenuWarning(MouseEvent event) {
		view.show("mainMenuWarning");
	}
	

	public EventHandler<ActionEvent> getPreferenceChanged() {
		return event-> preferenceChanged((ActionEvent)event);
	}
	
	public void preferenceChanged(ActionEvent event) {
		view.mouseClicked(event.getSource());	
	}
	/**
	 * Sends the preference modified from its default value to Model.
	 * 
	 * @param color A String representing the color chosen by the user. Ignored if empty String.
	 * @param season Seasons enum representing the season chosen by the user. Ignored if null.
	 * @param light An int, the amount of light the user specifies their garden receives. Ignored if 0.
	 * @param water An int, the water level the user specifies their garden has. Ignored if 0.
	 * @param length An int, the length the user has chosen for their garden. Ignored if 0.
	 * @param width An int, the width the user has chosen for their garden. Ignored if 0.
	 */
	public void setPreferences(String color, Seasons season, int light,int water,int length, int width) {
		model.setUserPrefColor(color);
		model.setUserPrefSeason(season);
		model.setUserPrefLight(light);
		model.setUserPrefWater(water);
		model.setUserLength(length);
		model.setUserWidth(width);
		
		
		System.out.println("Total prefs set: "+model.getPrefsSet());
	}
	
	/**
	 * Returns the number of preference properties that have been set in Model.
	 * @return an int, the number of preferences that have been modified from their default value.
	 */
	public int getPrefsSet() {
		return model.getPrefsSet();
	}
	
	public boolean verifySettings() {
		return (model.necessaryPrefsSet() && model.getPrefsSet()>=view.getCurrentTotalPrefs());
	}
	

    public void mouseEnterPlantSelection(MouseEvent event) {
	Node n = (Node)event.getSource();
	Integer row = GridPane.getRowIndex(n);
	Integer col = GridPane.getColumnIndex(n);
	if (DEBUG) {System.out.println("row "+ row + " col " + col);}
	view.getDesignGardenScreen().setGridPaneInd(col);
	if(view.getDesignGardenScreen().getTileEditGP().isHover() == true) {
	    view.getDesignGardenScreen().setHoverEditTile(true);
	    if(DEBUG) {System.out.println("bool set to true");}
	}
	System.out.println("Index "+view.getDesignGardenScreen().getSelectGardenType().
		    getSelectionModel().getSelectedIndex());
	
    
    int tabidx = view.getDesignGardenScreen().getSelectGardenType().getSelectionModel().getSelectedIndex();
    
    if (tabidx<=2) {
    	Plant p=null;
    switch (tabidx) {
    case 0:
    	 p = model.getFlowerArr().get(col);
    	break;
    case 1:
    	p = model.getTreeArr().get(col);
    	break;
    case 2:
    	p = model.getShrubArr().get(col);
    	break;
    }
    view.getDesignGardenScreen().showAddOnInfo("Name: "+p.getName()+"\n"+p.toString());
    }
    else if (tabidx<=4) {
    	AddOn a = null;
    	switch(tabidx) {
    	case 3:
    		a = model.getPathwaysArr().get(col);
    		break;
    	case 4:
    		a = model.getSceneryArr().get(col);
    		break;
    	}
    	view.getDesignGardenScreen().showAddOnInfo(a.getDescription());
    }
    
}
    	
    
    
    /**
     * 
     * @return
     */
    public EventHandler<MouseEvent> getMouseEnterPlantSelection(){
	return event -> mouseEnterPlantSelection((MouseEvent) event);
    }
    
    /**
     * Returns an arrayList which is the arrayList of plants to choose from
     * based on the tab selected.
     * <p>
     * Used in the drag and drop method to select the plant in the correct location
     * to select the correct array to choose the plant from. 
     * 
     * @return arrayList of plants from model. If none are available returns null
     * @see Controller#detectDragDrop(DragEvent)
     */
    public ArrayList<AddOn> changeTabIndex(int rowIndex,int colIndex,int index) {
	// get the current tab selected in design garden
	int t = view.getDesignGardenScreen().getSelectGardenType().
	    getSelectionModel().getSelectedIndex();
	ArrayList<AddOn> temp = new ArrayList<AddOn>();
	GardenTile tile = model.getUserPlot().getLayout()[rowIndex][colIndex];
	switch(t) {
	case 0:
		temp.addAll(model.getFlowerArr());
		tile.setPlant((Plant)temp.get(index));
		Model.getUsedPlants().add((Plant)temp.get(index));
		break;
	case 1: 
		temp.addAll(model.getTreeArr());
		tile.setPlant((Plant)temp.get(index));
		Model.getUsedPlants().add((Plant)temp.get(index));
		break;
	case 2:
		temp.addAll(model.getShrubArr());
		tile.setPlant((Plant)temp.get(index));
		Model.getUsedPlants().add((Plant)temp.get(index));
		break;
	case 3:
		temp.addAll(model.getPathwaysArr());
		tile.setAddOn(temp.get(index));
		break;
	case 4:
		temp.addAll(model.getSceneryArr());
		tile.setAddOn(temp.get(index));
	}//switch
	return temp;
    }
    
    /**
     * Takes in a DragEvent to know when the target has the mouse released over it.
     * <p>
     * Once dropped will alter the waterLevel or SunLevel depending which image was dropped
     * on the tile. 
     * 
     * @param event DragEvent to know when the drag finished
     * @see DesignGarden
     */
    public void detectSunWaterDragDrop(DragEvent event) {
	Dragboard db = event.getDragboard();
	boolean worked = false;
	//Node n = event.getPickResult().getIntersectedNode();
	Node n = event.getPickResult().getIntersectedNode();
	if(DEBUG) {System.out.println(n.toString());}
	if(n != view.getDesignGardenScreen().getPlot() && db.hasImage()) {
	    Integer colIndex = GridPane.getColumnIndex(n);
	    Integer rowIndex = GridPane.getRowIndex(n);
	    if(DEBUG) {System.out.println("Column: " + colIndex + " Row: " + rowIndex);}
	    int index = 0;//items held in gridpane of 4. 0 is add water, 1 is less water, 2 is add sun, 3 is remove water
	    switch(index) {
		// increases wetness of tile
	    case 0: model.getUserPlot().getLayout()[rowIndex][colIndex].setWaterLevel(
										      model.getUserPlot().getLayout()[rowIndex][colIndex].getWaterLevel()+1);
		// less water of tile dropped on
	    case 1: model.getUserPlot().getLayout()[rowIndex][colIndex].setWaterLevel(
										      model.getUserPlot().getLayout()[rowIndex][colIndex].getWaterLevel()-1);
		// more light of tile dropped on 
	    case 2: model.getUserPlot().getLayout()[rowIndex][colIndex].setSunLightLevel(
											 model.getUserPlot().getLayout()[rowIndex][colIndex].getSunLightLevel()+1);
		// less light of tile dropped on
	    case 3: model.getUserPlot().getLayout()[rowIndex][colIndex].setSunLightLevel(
											 model.getUserPlot().getLayout()[rowIndex][colIndex].getSunLightLevel()-1);
	    }//switch
	    worked = true;
	}
	event.setDropCompleted(worked);
	if(DEBUG) {System.out.println("Tile Sun/Water Altered");}
	event.consume();
    }//detectSunWaterDragDrop
    
    /**
     * Returns an Event Handler to bind to an eventListener for the
     * Drag listener on DesignGarden
     * <p>
     * Used to access the DetectSunWaterDragDrop method and bind it using a
     * lambda function to an eventListner
     * 
     * @return EventHandler used to bind to listeners
     * @see DesignGarden
     * @see DetectSunWaterDetectDragDrop
     */
    public EventHandler<DragEvent> getDetectSunWaterDetectDragDrop() {
    	return event -> detectSunWaterDragDrop((DragEvent)event);
    }//getDetectDragDrop
    
    /**
     * Getter for view attribute in controller
     * <p>
     * @return View the current view in the model
     */
    public View getView() {
    	return view;
    }
    
    /**
     * Closes the screen and moves the plants back into the gardenScreen
     * <p>
     * @param event representing clicking on the button
     * @see DesignGarden
     */
    public void clickOnCloseSeasons(MouseEvent event) {
    	view.getSeasonViewScreen().closeScreen();
    }
    
    /**
     * Returns an Event Handler to bind to an eventListener for the
     * onCLick listener on seasonView closeButton
     * <p>
     * Used to access the clickOnCloseSeasons method and bind it using a
     * lambda function to an eventListner
     * 
     * @return EventHandler used to bind to listeners
     * @see SeasonView
     * @see clickOnCloseSeasons
     */
    public EventHandler<MouseEvent> getClickOnCloseSeasons(){
    	return event -> clickOnCloseSeasons((MouseEvent)event);
    }
    
    /**
     * Gets the user selected template from model.
     * @return A String representing the template chosen.
     * @see Model#getUserTemplate()
     */
    public String getTemplateFromModel() {
	return model.getUserTemplate();
    }
    
    /**
     * Gets the length of the garden from Model.
     * @return An int, the length attribute in model.
     * @see Model#getUserLength()
     */
    public int getLengthFromModel() {
	return model.getUserLength();
    }

    /**
     * Gets the width of the garden from Model.
     * @return An int, the width attribute in model.
     */
    public int getWidthFromModel() {
	return model.getUserWidth();
    }
    
    /**
     * Returns the String containing the filename of the image representing the plant at the given location in 
     * the garden grid.
     * @param x The row coordinate in the user plot.
     * @param y The column coordinate in the user plot.
     * @return A String containing the name of the image representing the AddOn at the given location.
     */
    public String getImgNameFromModel(int row,int col) {
         return model.getTileContentsName(row,col);
    }

    /**
     * Takes in a parameter of an image which will be used to set the pattern of the 
     * circle to the passed in image. Int i represents which tab is selected from 
     * plants to pathways which determines the circle size. Returns a circle which 
     * will be added to the designGarden
     * <p>
     * Used within the drag and drop method to drop pretty circles of the images
     * instead of sized imageViews of the image.
     * 
     * @param img image from dragboard passed in within dragEvent
     * @param i index of tab selected
     * @return circle with image inside to be dropped in DesignGarden
     * @see DesignGarden.java
     * @see #detectDragDrop(DragEvent)
     */
    public Circle createCirlceSizes(Image img, int i) {
    	double tileSize = 89.0;
    	//depending on what tab index is selected determines size
    	if(DEBUG) {System.out.println("Index Selected: " + i);}
    	// used for dragging in plants
    	Circle c = new Circle();
    	switch(i) {
    	// used to drop plants circle size
    	case 0: c.setRadius(25);c.setFill(new ImagePattern(img)); return c;
    	// used to drop under tree circle size
    	case 1: c.setRadius(45);c.setFill(new ImagePattern(img)); return c;
    	// used to drop shrubs circle size
    	case 2: c.setRadius(30);c.setFill(new ImagePattern(img)); return c;
    	// used to drop undergrowth circle size
    	}
    	return null;
    }
    
    /**
     * Sets the DesignGarden screen's String arrays of image names corresponding to the selection of images to be dropped.
     */
    public void setSelectionArrs() {
		int currSeasonIdx = model.getUserPrefSeason().ordinal();
    	ArrayList<Plant> flowers = model.getFlowerArr();
		ArrayList<Plant> trees = model.getTreeArr();
		ArrayList<Plant> shrubs = model.getShrubArr();
		ArrayList<AddOn> paths = model.getPathwaysArr();
		ArrayList<AddOn> scenery = model.getSceneryArr();
		String[] flowerImgNames= new String[flowers.size()];
		String[] treeImgNames= new String[trees.size()];
		String[] shrubImgNames = new String[shrubs.size()];
		String[] pathImgNames = new String[paths.size()];
		String[] sceneryImgNames = new String[scenery.size()];
		
		for (int i=0;i<flowers.size();i++) {
			flowerImgNames[i]=flowers.get(i).getSeasonsImgArr()[currSeasonIdx];
		}
		for (int i=0;i<trees.size();i++) {
			treeImgNames[i]=trees.get(i).getSeasonsImgArr()[currSeasonIdx];
		}
		for (int i=0;i<shrubs.size();i++) {
			shrubImgNames[i]=shrubs.get(i).getSeasonsImgArr()[currSeasonIdx];
		}
		for (int i=0;i<paths.size();i++) {
			pathImgNames[i]=paths.get(i).getName();
		}
		for (int i=0;i<scenery.size();i++) {
			sceneryImgNames[i]=scenery.get(i).getName();
		}
		
		view.getDesignGardenScreen().setSelectionArrays(flowerImgNames, treeImgNames, shrubImgNames,pathImgNames,sceneryImgNames);
		
	}
    /**
     * Takes in an Image to resize as an ImageView and returns an ImageView which will
     * be added to the designGarden for paths and the other items as well.
     * 
     * @param img image take in in to create imageView from
     * @return ImageView created which will be dragged and dropped onto the DesignGarden
     * @see #detectDragDrop(DragEvent)
     */
    public ImageView createSquareSize(Image img) {
    double tileSize = 89.0;
    // used for dragging in everything thats not plants
    ImageView imgV = new ImageView(img);
    imgV.setPreserveRatio(true);
    imgV.setFitHeight(tileSize);
    imgV.setFitWidth(tileSize);
    return imgV;
}
 
    /**
     * Returns an EventHandler to bind to the MouseEvent listener for the tiles on the DesignGarden Screen.
     * @return An EventHandler to bind to the listeners for the tiles in the garden grid.
     */
    public EventHandler<MouseEvent> getGardenTileClicked() {
    	return event -> gardenTileClicked((MouseEvent)event);
    }
    
    
    public void gardenTileClicked(MouseEvent event) {
    	if (event.getSource().getClass().equals(ImageView.class) && event.getClickCount()==1) {
    	ImageView n = (ImageView) event.getSource();
    	int rowIdx = GridPane.getRowIndex(n);
    	int colIdx = GridPane.getColumnIndex(n);
    	GardenTile clickedTile = model.getUserPlot().getLayout()[rowIdx][colIdx];
    	
    	if (clickedTile.getIsActive() && clickedTile.isEmpty()) {
    		clickedTile.setIsActive(false);
    		view.setActiveImg(n, false);
    		//do something to make it fade
    	} else if (!clickedTile.getIsActive() && clickedTile.isEmpty()) {
    		clickedTile.setIsActive(true);
    		view.setActiveImg(n, true);
    	}
    	}
    }
    
    /**
     * Returns an EventHandler to bind to the MouseEvent listener for the plant or AddOn ImageViews added to the grid
     * in designGarden.
     * @return An EventHandler for MouseEvents to bind to the AddOn ImageViews added to the grid in DesignGarden.
     */
    public EventHandler<MouseEvent> getRemoveFromTile() {
    	return event -> removeFromTile((MouseEvent)event);
    }
    
    /**
     * Removes the plant from the grid in DesignGarden when the user clicks on it twice.
     * @param event
     */
    public void removeFromTile(MouseEvent event) {
    	if (event.getClickCount()==2) {
    		Node n = (Node) event.getSource();
    		GardenTile tile = model.getUserPlot().getLayout()[GridPane.getRowIndex(n)][GridPane.getColumnIndex(n)];
    		if (tile.getPlant()!=null) {
    			Model.getUsedPlants().remove(tile.getPlant());
    		}
    		view.getDesignGardenScreen().getPlot().getChildren().remove(n);
    		tile.setEmpty();
    	}
    	System.out.println("clicked");
    }
    
    /**
     * Takes in an mouseEvent for a button so when the button of ViewSpring
     * is clicked sets the title, sets the season In Model and then redraws
     * the gridPane in seasonView.
     * 
     * @see SeasonView#setTitleToSpring()
     * @see SeasonView#setSeasonGP(GridPane)
     * @see SeasonView
     */
    public void clickOnViewSpring(MouseEvent event) {
    	view.getSeasonViewScreen().setTitleToSpring();
    	model.setUserPrefSeason(Seasons.SPRING);
    	if(DEBUG) {System.out.println("Current Season: " + model.getUserPrefSeason());}
    	//view.getSeasonViewScreen().setSeasonGP(view.drawGrid(this, false));
    	view.getSeasonViewScreen().showScreen();
    }
    
    /**
     * Getter for clickOnViewSpring method in controller
     * 
     * @return MouseEvent handler for viewSpring button in SeasonView
     * @see Controller#clickOnViewSpring(MouseEvent)
     */
    public EventHandler<MouseEvent> getClickOnViewSpring(){
    	return event -> clickOnViewSpring((MouseEvent)event);
    }
    
    /**
     * Takes in an mouseEvent for a button so when the button of ViewSummer
     * is clicked sets the title, sets the season In Model and then redraws
     * the gridPane in seasonView.
     * 
     * @param event a MouseEvent when clicking on a button
     * 
     * @see SeasonView#setTitleToSummer()
     * @see SeasonView#setSeasonGP(GridPane)
     * @see SeasonView
     */
    public void clickOnViewSummer(MouseEvent event) {
    	view.getSeasonViewScreen().setTitleToSummer();
    	model.setUserPrefSeason(Seasons.SUMMER);
    	if(DEBUG) {System.out.println("Current Season: " + model.getUserPrefSeason());}
    	//view.getSeasonViewScreen().setSeasonGP(view.drawGrid(this, false));
    	view.getSeasonViewScreen().showScreen();
    }
    
    /**
     * Getter for clickOnViewSummer method in controller
     * 
     * @return MouseEvent handler for viewSummer button in SeasonView
     * @see Controller#clickOnViewSummer(MouseEvent)
     */
    public EventHandler<MouseEvent> getClickOnViewSummer(){
    	return event -> clickOnViewSummer((MouseEvent)event);
    }
    
    /**
     * Takes in an mouseEvent for a button so when the button of ViewFall
     * is clicked sets the title, sets the season In Model and then redraws
     * the gridPane in seasonView.
     * 
     * @param event a MouseEvent when clicking on a button
     * 
     * @see SeasonView#setTitleToFall()
     * @see SeasonView#setSeasonGP(GridPane)
     * @see SeasonView
     */
    public void clickOnViewFall(MouseEvent event) {
    	view.getSeasonViewScreen().setTitleToFall();
    	model.setUserPrefSeason(Seasons.AUTUMN);
    	if(DEBUG) {System.out.println("Current Season: " + model.getUserPrefSeason());}
    	//view.getSeasonViewScreen().setSeasonGP(view.drawGrid(this, false));
    	view.getSeasonViewScreen().showScreen();
    }
    
    /**
     * Getter for clickOnViewFall method in controller
     * 
     * @return MouseEvent handler for viewFall button in SeasonView
     * @see Controller#clickOnViewFall(MouseEvent)
     */
    public EventHandler<MouseEvent> getClickOnViewFall(){
    	return event -> clickOnViewFall((MouseEvent)event);
    }
    
    /**
     * Takes in an mouseEvent for a button so when the button of ViewWinter
     * is clicked sets the title, sets the season In Model and then redraws
     * the gridPane in seasonView.
     * 
     * @param event a MouseEvent when clicking on a button
     * 
     * @see SeasonView#setTitleToWinter()
     * @see SeasonView#setSeasonGP(GridPane)
     * @see SeasonView
     */
    public void clickOnViewWinter(MouseEvent event) {
    	view.getSeasonViewScreen().setTitleToWinter();
    	model.setUserPrefSeason(Seasons.WINTER);
    	if(DEBUG) {System.out.println("Current Season: " + model.getUserPrefSeason());}
    	//view.getSeasonViewScreen().setSeasonGP(view.drawGrid(this, false));
    	view.getSeasonViewScreen().showScreen();
    }
    
    /**
     * Getter for clickOnViewWinter method in controller
     * 
     * @return MouseEvent handler for viewWinter button in SeasonView
     * @see Controller#clickOnViewWinter(MouseEvent)
     */
    public EventHandler<MouseEvent> getClickOnViewWinter(){
    	return event -> clickOnViewWinter((MouseEvent)event);
    }
    
    public EventHandler<WindowEvent> getSeasonViewCloseRequest() {
    	return event -> seasonViewCloseRequest((WindowEvent) event);
    }
    
    public void seasonViewCloseRequest(WindowEvent event) {
    	view.getSeasonViewScreen().closeScreen();
    }
    
    public EventHandler<MouseEvent> getHoverEmptyTiles() {
    	return event -> hoverEmptyTiles((MouseEvent)event);
    }
    
    public void hoverEmptyTiles(MouseEvent event) {
    	Node n = (Node)event.getSource();
    	Integer row = GridPane.getRowIndex(n);
    	Integer col = GridPane.getColumnIndex(n);
    	GardenTile tile = model.getUserPlot().getLayout()[row][col];
    	
    	
    	if (tile.isActive() && tile.isEmpty()) {
    		String recs = model.getRecs(row, col);
    		if (recs.equals("")) {
    			recs="No plants match these sunlight\nand water levels.";
    		}
    		view.getDesignGardenScreen().showAddOnInfo(tile.toString()+"\nRecommendations:\n"+recs);
    	}
    }
    
    public void startDragForTileEditors(MouseEvent event) {
		ImageView n = (ImageView)event.getSource();

        Dragboard dBoard = n.startDragAndDrop(TransferMode.ANY);

        //Use clipboard to copy data the add to Dragboard
        ClipboardContent content = new ClipboardContent();
        //Need to edit to pull in right plant from model when dragging
        content.putImage(n.getImage());
        dBoard.setContent(content);
        
        //System.out.println("Dragging tile editor index: "+GridPane.getColumnIndex((Node)event.getSource()));
        if(dBoard.hasImage() &&
				view.getDesignGardenScreen().getHoverEditTile() == true) {
        view.getDesignGardenScreen().setDraggedTileEditorIdx(GridPane.getColumnIndex((Node)event.getSource()));
        }
        event.consume();
	}
    
    public EventHandler<MouseEvent> getStartDragForTileEditors() {
    	return event -> startDragForTileEditors((MouseEvent) event);
    }
}//Controller





