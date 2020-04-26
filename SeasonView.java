import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
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
 * Season View is a GUI implementation where the user can see how their garden would look
 * in different seasons such as SUMMER, WINTER, FALL
 *
 */
public class SeasonView{
	// make it so one label which changes depending on season?
	// full screen season view?
	private final static int HEIGHT = 600;
	private final static int WIDTH = 800;
	private Label yourGarden;
	private Label currSeason;
	private BorderPane currView;
	private Scene seasonView;
	private Button backBTN;
	private Button exitBTN;
	private Button nextBTN;
	
	/**
	 * Basic default constructor for the SeasonView when trying 
	 * to be created by any other class
	 */
	public SeasonView() {
		yourGarden = new Label("Your Garden");
		currSeason = new Label("Spring");
		currView = new BorderPane();
		seasonView = null;
	}
	
	/**
	 * Returns type Label which displays the current season name in the SeasonsView
	 * pane.
	 * <p>
	 * Getter for CurrSeason attribute
	 * 
	 * @return Label which represents the scenes current seasons
	 * @see currSeason
	 */
	public Label getCurrSeason() {
		return currSeason;
	}

	/**
	 * Returns type Scene which displays the current season of the SeasonsView
	 * pane.
	 * <p>
	 * Getter for seasonView attribute
	 * 
	 * @return scene which represents the current season on the screen
	 * @see seasonView
	 * 
	public Scene getSeasonView() {
		return seasonView;
	}
	
	/**
	 * Returns the back button to bind an event listener to
	 * <p>
	 * Getter for backBTN
	 * 
	 * @return back button on the screen
	 */
	public Button getbackBTN() {
		return backBTN;
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
		Stage stage = new Stage();
		BorderPane bPane = new BorderPane();
		FlowPane fPane = new FlowPane();
		HBox hPane = new HBox();
		backBTN = new Button("Back a Season");
		nextBTN = new Button("Next Season");
		exitBTN = new Button("Close Window");
		
		// Stacking items within items buttons -> HBox --> Bottom of bpane
		hPane.getChildren().add(backBTN);
		hPane.getChildren().add(exitBTN);
		hPane.getChildren().add(nextBTN);
		bPane.setBottom(hPane);
		bPane.setCenter(fPane);
		
		// Setting the Scene with bPane
		Scene scene = new Scene(bPane,500,500);
		stage.setTitle("SeasonView");
		stage.setScene(scene);
		stage.show();
		//seasonView = new Scene(currView,HEIGHT,WIDTH);
		//seasonWindow.setScene(seasonView);
	}
}
