import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
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
 * View that handles the creation and presentation of the saving and loading screens, which
 * allow the user to save the design they are working on or any of the generated designs from the
 * final view screen, or load an existing design to continue their progress. Contains a FileChooser 
 * that will be displayed on a separate window using the SaveLoad Stage with a save or load dialog 
 * depending on whether it has been accessed through the save Button or LoadGarden Button.
 * 
 * @see View
 * @see FinalView
 * @author Takiyah Price
 *
 */


public class SaveLoad {
	private FileChooser fileChooser;
	private Stage SaveLoadStage;
	//private Scene SaveLoadScene;
	
	/**
	 * Constructor for SaveLoad that creates the SaveLoad Stage that will be bound to
	 * a new FileChooser.
	 * 
	 */
	public SaveLoad() {
		SaveLoadStage = new Stage();
		SaveLoadStage.setWidth(600);
		SaveLoadStage.setHeight(400);
		fileChooser = new FileChooser();
	}
	
	/**
	 * Displays the fileChooser's save dialog when the user clicks the save Button.
	 */
	public File showSaveWindow() {
		return fileChooser.showSaveDialog(SaveLoadStage);
	}
	
	/**
	 * Displays the fileChooser's load dialog when the user clicks the loadGarden Button
	 * from the main menu.
	 * 
	 * @see MainMenu
	 */
	public File showLoadWindow() {
		return fileChooser.showOpenDialog(SaveLoadStage);
	}
	
	
}

