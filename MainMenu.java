import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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
 * View that handles the creation and presentation of the main menu screen. Contains 
 * the visual components for the main menu window that will be made visible at the start
 * of the program, including options for creating a new garden, loading an existing garden,
 * viewing the instructions and exiting the program.
 *
 *
 * @author Takiyah Price
 */

public class MainMenu extends View {
	private Button createNewGarden;
	private Button loadGarden;
	private Image backgroundImage;
	private Stage mainMenuStage;
	private Scene mainMenuScene;
	
	
	/**
	 * Constructor for the Main Menu that creates new Buttons for creating or loading a garden and 
	 * the background Image for the window, then sets a new Stage with a Scene containing these components.
	 */
	public MainMenu() {
		createNewGarden = new Button("Create New Garden");
		loadGarden = new Button("Load Garden");
		
		backgroundImage = new Image("no images");
	}
	
	
	/**
	 * Makes the MainMenu Stage visible to the user.
	 * 
	 * @param theStage the Stage that will be set to mainMenuStage and shown to the user
	 */
	public void showMainMenu(Stage theStage) {
		
	}
}
