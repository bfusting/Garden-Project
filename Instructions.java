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
 */

public class Instructions extends View {
	private Label instructions;
	private Scene instructionsScene;
	private Stage instructionsStage;
	private String text;
	
	
	/**
	 * 
	 */
	public Instructions() {
		text = "instructions undefined";
		instructions = new Label(text);
		
		instructionsScene = new Scene(instructions);
		instructionsStage = new Stage();
		instructionsStage.setScene(instructionsScene);
	}
	
	/**
	 * 
	 * @return text
	 */
	public String getText() {
		return text;
	}
}
