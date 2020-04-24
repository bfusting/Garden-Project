import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
public class SeasonView extends View{
	// make it so one label which changes depending on season?
	// full screen season view?
	private final static int HEIGHT = 600;
	private final static int WIDTH = 800;
	private Label yourGarden;
	private Label currSeason;
	private BorderPane currView;
	private Scene seasonView;
	private Stage seasonWindow;
	private Button backBTN;
	
	/**
	 * Basic default constructor for the SeasonView when trying 
	 * to be created by any other class
	 */
	public SeasonView() {
		yourGarden = new Label("Your Garden");
		currSeason = new Label("Spring");
		currView = new BorderPane();
		seasonView = null;
		seasonWindow = new Stage();
		
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
	 * Returns type Stage which displays the window for the SeasonView
	 * <p>
	 * Getter for seasonWindow attribute
	 * 
	 * @return stage which represents the current window of SeasonView
	 * @see seasonWindow
	 * 
	 */
	public Stage getSeasonWindow() {
		return seasonWindow;
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
	public void ShowSeasonView(){
		System.out.println("Creates the new window");
		//seasonView = new Scene(currView,HEIGHT,WIDTH);
		//seasonWindow.setScene(seasonView);
		//backBTN = new Button("Back");
	}
}
