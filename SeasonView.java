import javafx.scene.Scene;
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
	
	/**
	 * 
	 */
	public SeasonView() {
		yourGarden = new Label("Your Garden");
		currSeason = new Label("Spring");
		currView = new BorderPane();
		seasonView = new Scene(currView,HEIGHT,WIDTH);
		seasonWindow = new Stage();
		seasonWindow.setScene(seasonView);
	}
	
	/**
	 * 
	 * @return
	 */
	public Label getCurrSeason() {
		return currSeason;
	}

	/**
	 * 
	 * @return
	 */
	public Scene getSeasonView() {
		return seasonView;
	}
	
	/**
	 * 
	 * @return
	 */
	public Stage getSeasonWindow() {
		return seasonWindow;
	}
}
