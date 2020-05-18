import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

// 4 scene
// to summer -> to winter -> to spring -> to fall buttons

/**
 * Season View is a GUI implementation where the user can see how their garden would look
 * in different seasons such as SUMMER, WINTER, FALL
 * <p>
 * @author Malachi Parks
 *
 */
public class SeasonView extends Screen{
	// make it so one label which changes depending on season?
	// full screen season view?
	private final static int HEIGHT = 1000;
	private final static int WIDTH = 1200;
	
	// used to anchor items in place
	private final double bottomAnchorPoint = 100.0;
	private double leftAnchorPoint = 250.0;
	private final double topAnchorPoint = 0.0;
	private final double overlapPoint = 150.0;

	//used as the main stage which holds everything
	private AnchorPane root;
	
	// displays current gridpane from designGarden
	private GridPane seasonGP;
	
	// Buttons used to swap between seasons
	private Button springBTN;
	private Button summerBTN;
	private Button fallBTN;
	private Button winterBTN;
	private Button closeBTN;
	
	// used to display stage
	private Controller c;
	private Stage stage;
	private Scene scene;
	// used to show inactive square or not
	private final boolean showInactiveTiles = false;
	
	// holds the season when SeasonView starts
	private Seasons startingSeason;
	/**
	 * Basic default constructor for the SeasonView when trying 
	 * to be created by any other class
	 */
	public SeasonView(Controller controller) {
		c = controller;
		//Creating new instances of images
		stage = new Stage();
	}

	/**
	 * Used to create a new popup window of the stage and adds the
	 * features such as the back button and a pane within the borderpane center
	 * to the currentView
	 */
	//Use after alpha
	//public void ShowSeasonView(Stage primaryStage){
	public void ShowSeasonView(){
		// creating a new instance of anchorPane
		root = new AnchorPane();
		// setting up seasonsGP with controller
		seasonGP = View.drawGrid(c, showInactiveTiles);
		
		//setting Startingseason to the one in Model
		startingSeason = c.getModel().getUserPrefSeason();
		
		// dummy variable to see where to place future gridPane
		Rectangle backdrop = new Rectangle(overlapPoint,bottomAnchorPoint,
				overlapPoint*5,bottomAnchorPoint*5);
		backdrop.setStroke(Color.LIGHTGRAY);
		backdrop.setFill(Color.LIGHTGRAY);
		backdrop.setStrokeWidth(1);
		
		// used to anchor the rectangle above buttons, can use for gridPane
		root.setTopAnchor(backdrop, topAnchorPoint);
		root.getChildren().add(backdrop);
		
		// overlaying seasonsGP onto backdrop rectangle
		root.setLeftAnchor(seasonGP,overlapPoint);
		root.getChildren().add(seasonGP);
		
		// Buttons initilization to have their own labels
		springBTN = new Button("View Spring");
		summerBTN = new Button("View Summer");
		fallBTN = new Button("View Fall");
		winterBTN = new Button("View Winter");
		closeBTN = new Button("Close SeasonView");
		
		// Binding buttons to event handlers (Event handler for each season)
		springBTN.setOnMouseClicked(c.getClickOnViewSpring());
		summerBTN.setOnMouseClicked(c.getClickOnViewSummer());
		fallBTN.setOnMouseClicked(c.getClickOnViewFall());
		winterBTN.setOnMouseClicked(c.getClickOnViewWinter());
		closeBTN.setOnMouseClicked(c.getClickOnCloseSeasons());
		
		// Anchoring in AnchorPane at the bottom via for loop
		Button btnArr[] = {springBTN,summerBTN,fallBTN,winterBTN,closeBTN};
		for(int i=0;i<btnArr.length;i++) {
			root.setBottomAnchor(btnArr[i], bottomAnchorPoint);
		}
		
		// Anchoring Buttons in AnchorPane from left to right
		double btmPlaceArr[] = {leftAnchorPoint,leftAnchorPoint+125,
				leftAnchorPoint+250,leftAnchorPoint+375,leftAnchorPoint+500};
		for(int i=0;i<btnArr.length;i++) {
			root.setLeftAnchor(btnArr[i], btmPlaceArr[i]);
		}
		
		
		//adding buttons to the anchorpane
		root.getChildren().addAll(springBTN,summerBTN,fallBTN,winterBTN,closeBTN);
		
		// Setting the Scene with AnchorPane
		scene = new Scene(root,HEIGHT,WIDTH);
		//stage.setTitle("SeasonView");
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void showScreen() {
		//need to consolidate into one showScreen() method
		ShowSeasonView();
	}
	
	@Override
	public void goToPreviousScreen() {
		stage.close();
	}
	
	public void closeSeasons() {
		// set back to original season in here
		c.getModel().setUserPrefSeason(startingSeason);
		System.out.println("Closing Stage: " + c.getModel().getUserPrefSeason());
		stage.close();
	}
	
	public void setTitleToSpring() {
		stage.setTitle("Spring");
	}

	public void setTitleToSummer() {
		stage.setTitle("Summer");
	}
	
	public void setTitleToFall() {
		stage.setTitle("Fall");
	}
	
	public void setTitleToWinter() {
		stage.setTitle("Winter");
	}
	
	public void setSeasonGP(GridPane newGP) {
		seasonGP = newGP;
	}
}