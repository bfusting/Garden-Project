import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
	private final static int HEIGHT = 600;
	private final static int WIDTH = 800;
	
	// used to anchor items in place
	private final static double bottomAnchorPoint = 200.0;
	private double leftAnchorPoint = 200.0;

	//used as the main stage which holds everything
	private AnchorPane root;
	
	// displays current gridpane from designGarden
	private GridPane seasonGP;
	
	// used to change between various seasons by setting various scenes
	private Scene springView;
	private Scene summerView;
	private Scene fallView;
	private Scene winterView;
	
	// Buttons used to swap between seasons
	private Button springBTN;
	private Button summerBTN;
	private Button fallBTN;
	private Button winterBTN;
	
	// used to display stage
	private Controller c;
	private Stage stage;
	
	/**
	 * Basic default constructor for the SeasonView when trying 
	 * to be created by any other class
	 */
	public SeasonView(Controller controller) {
		c = controller;
	}
	
	/**
	 * Returns the back button to bind an event listener to
	 * <p>
	 * Getter for springBTN
	 * 
	 * @return back button on the screen
	 */
	public Button getSpringBTN() {
		return springBTN;
	}
	
	/**
	 * Returns the next button to bind an event listener to
	 * <p>
	 * Getter for summerBTN
	 * 
	 * @return summer button on the screen
	 */
	public Button getSummerBTN() {
		return summerBTN;
	}
	
	/**
	 * Used to create a new popup window of the stage and adds the
	 * features such as the back button and a pane within the borderpane center
	 * to the currentView
	 */
	//Use after alpha
	//public void ShowSeasonView(Stage primaryStage){
	public void ShowSeasonView(){
		//Creating new instances of images
		stage = new Stage();
		
		// creating a new instance
		root = new AnchorPane();
		
		// dummy variable to see where to place future gridPane
		Rectangle r1 = new Rectangle(150,100,900,500);
		r1.setStroke(Color.LIGHTGRAY);
		r1.setFill(Color.LIGHTGRAY);
		r1.setStrokeWidth(1);
		
		// used to anchor the rectangle above buttons, can use for gridPane
		root.setTopAnchor(r1, 0.0);
		root.getChildren().add(r1);
		
		// Buttons initilization to have their own labels
		springBTN = new Button("View Spring");
		summerBTN = new Button("View Summer");
		fallBTN = new Button("View Fall");
		winterBTN = new Button("View Winter");
		
		// Binding buttons to event handlers (Event handler for each season)
		
		
		// Anchoring in AnchorPane at the bottom via for loop
		Button btnArr[] = {springBTN,summerBTN,fallBTN,winterBTN};
		for(int i=0;i<btnArr.length;i++) {
			root.setBottomAnchor(btnArr[i], bottomAnchorPoint);
		}
		
		// Anchoring Buttons in AnchorPane from left to right
		double btmPlaceArr[] = {leftAnchorPoint,leftAnchorPoint+200,
				leftAnchorPoint+400,leftAnchorPoint+600};
		for(int i=0;i<btnArr.length;i++) {
			root.setLeftAnchor(btnArr[i], btmPlaceArr[i]);
		}
		
		//adding buttons to the anchorpane
		root.getChildren().addAll(springBTN,summerBTN,fallBTN,winterBTN);
		
		// Setting the Scene with AnchorPane
		Scene scene = new Scene(root,HEIGHT,WIDTH);
		stage.setTitle("SeasonView");
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
	 
}