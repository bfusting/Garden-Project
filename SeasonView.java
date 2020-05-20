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
import javafx.stage.Modality;
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
	private boolean shown;
	
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
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setOnCloseRequest(c.getSeasonViewCloseRequest());
		shown= false;
		
		// creating a new instance of anchorPane
				root = new AnchorPane();

				// dummy variable to see where to place future gridPane
				Rectangle backdrop = new Rectangle(overlapPoint,bottomAnchorPoint,
						overlapPoint*5,bottomAnchorPoint*5);
				backdrop.setStroke(Color.LIGHTGRAY);
				backdrop.setFill(Color.LIGHTGRAY);
				backdrop.setStrokeWidth(1);
				
				// used to anchor the rectangle above buttons, can use for gridPane
				AnchorPane.setTopAnchor(backdrop, topAnchorPoint);
				root.getChildren().add(backdrop);
				
				// Buttons initialization to have their own labels
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
					AnchorPane.setBottomAnchor(btnArr[i], bottomAnchorPoint);
				}
				
				// Anchoring Buttons in AnchorPane from left to right
				double btmPlaceArr[] = {leftAnchorPoint,leftAnchorPoint+125,
						leftAnchorPoint+250,leftAnchorPoint+375,leftAnchorPoint+500};
				for(int i=0;i<btnArr.length;i++) {
					AnchorPane.setLeftAnchor(btnArr[i], btmPlaceArr[i]);
				}
				
				
				//adding buttons to the Anchor pane
				root.getChildren().addAll(springBTN,summerBTN,fallBTN,winterBTN,closeBTN);
				
				// Setting the Scene with AnchorPane
				scene = new Scene(root,HEIGHT,WIDTH);
				stage.setTitle("Season View");
	}

	
	
	/**
	 * Upon start, if the screen isn't show the method will pull in the users
	 * preferred season and set it to the startingSeason. Then will set shown to 
	 * true. Removes the gridpane and redraws it using the drawGrid method in view.
	 * Reanchors the grid pane over the rectangle then adds it to the scene and shows
	 * the scene. 
	 */
	@Override
	public void showScreen() {
		if (!shown) {
			startingSeason=c.getModel().getUserPrefSeason();
			shown = true;
		}
		root.getChildren().remove(seasonGP);
		seasonGP=View.drawGrid(c, showInactiveTiles);
		
		// overlaying seasonsGP onto backdrop rectangle
		AnchorPane.setLeftAnchor(seasonGP,overlapPoint);
		
		root.getChildren().add(seasonGP);
		stage.setScene(scene);
		stage.show();
		
	}
	
	@Override
	public void goToPreviousScreen() {
		stage.close();
	}
	
	@Override
	public void closeScreen() {
		// set back to original season in here
		c.getModel().setUserPrefSeason(startingSeason);
		System.out.println("Closing Stage: " + startingSeason);
		stage.close();
	}
	
	/**
	 * Sets the stage's title to Spring when the user views the spring version of their design.
	 */
	public void setTitleToSpring() {
		stage.setTitle("Spring");
	}
	
	/**
	 * Sets the stage's title to Summer when the user views the summer version of their design.
	 */
	public void setTitleToSummer() {
		stage.setTitle("Summer");
	}
	
	/**
	 * Sets the stage's title to Fall when the user views the fall version of their design.
	 */
	public void setTitleToFall() {
		stage.setTitle("Fall");
	}
	
	/**
	 * Sets the stage's title to Winter when the user views the winter version of their design.
	 */
	public void setTitleToWinter() {
		stage.setTitle("Winter");
	}
	
	
}