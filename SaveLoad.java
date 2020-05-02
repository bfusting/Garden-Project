import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

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
 * Screen that handles the creation and presentation of the saving and loading screens, which
 * allow the user to save the design they are working on or any of the generated designs from the
 * final view screen, or load an existing design to continue their progress. Contains a FileChooser 
 * that will be displayed on a separate window using the SaveLoad Stage with a save or load dialog 
 * depending on whether it has been accessed through the save Button or LoadGarden Button.
 * 
 * 
 * @author Takiyah Price
 *
 */

//last edited: 5-2-20 3:08PM

public class SaveLoad extends Screen{
	private FileChooser fileChooser;
	private double nonEditableOpacity = 0.85;
	private double EditableOpacity = 1.0;
	
	/**
	 * Constructor for SaveLoad that creates the SaveLoad Stage that will be bound to
	 * a new FileChooser.
	 * 
	 */
	public SaveLoad() {
		
		fileChooser = new FileChooser();
		
	}
	
	/**
	 * Displays the fileChooser's save dialog when the user clicks the save Button.
	 */
	public File showSaveWindow(Stage s) {
		//super.getPreviousScreen().setUneditable();
		Stage z = new Stage();
		//s.setAlwaysOnTop(true);
		s.setOpacity(nonEditableOpacity);
		File file = fileChooser.showSaveDialog(s);
		s.setOpacity(EditableOpacity);
		return file;
	}
	
	/**
	 * Displays the fileChooser's load dialog when the user clicks the loadGarden Button
	 * from the main menu.
	 * 
	 * @see MainMenu
	 */
	public File showLoadWindow(Stage s) {
		//super.getPreviousScreen().setUneditable();
		s.setOpacity(nonEditableOpacity);
		
		File file = fileChooser.showOpenDialog(s);
		s.setOpacity(EditableOpacity);
		return file;
	}
	
	@Override
	public String toString() {
		return "Save/Load";
	}
	
	@Override
	public void goToPreviousScreen() {
		//super.getPreviousScreen().setEditable();
	}
}

