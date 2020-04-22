import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
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
 * @author takiyah
 * 
 * View that handles the creation and presentation of the instructions screen, where the user can
 * read a detailed explanation of the program controls from the main menu or view them in a
 * separate window while editing. 
 *
 */

public class Instructions extends View {
	private Label instructions;
	private Scene instructionsScene;
	private Stage instructionsStage;
	private String text;
	
	
	/**
	 * Constructor for the Instructions class. Initializes the instructions and the label holding them,
	 * and creates a new Scene to present the screen as well as a new stage so the instructions can be
	 * viewed simultaneously as the main screen.
	 */
	public Instructions() {
		text = "instructions undefined";
		instructions = new Label(text);
		
		instructionsScene = new Scene(instructions);
		instructionsStage = new Stage();
		instructionsStage.setScene(instructionsScene);
	}
	
	/**
	 * Gets the String text detailing how to use the program
	 * @return text the instructions detailing how to use this program
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Makes the instructions screen visible to the user. Will appear on the main screen or
	 * in a separate smaller window depending on whether the primary stage or a separate stage
	 * has been passed in.
	 * 
	 * @param theStage the Stage that will be set to instructionsStage and shown to the user
	 */
	public void showInstructions(Stage theStage) {
		
	}
	
	
	
	
}
