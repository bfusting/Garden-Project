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
 *  View that handles the creation and presentation of the instructions screen, where the user can
 * read a detailed explanation of the program controls from the main menu or view them in a
 * separate window while editing. 
 * 
 * @see View
 * @author Takiyah Price
 */

public class Instructions {
	private Label instructions;
	private Scene instructionsScene;
	private Stage instructionsStage;
	private String text;
	
	
	/**
	 * Constructor for the Instructions class that creates the String text and the Label holding them,
	 * and creates a new Scene to present the screen and a new Stage to be viewed simultaneously as the 
	 * main screen.
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
	
	
	public void showInstructions() {
		//instructionsStage.show();
	}
	
	
	
	
}
