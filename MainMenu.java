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
 * @author takiyah
 *
 */

public class MainMenu extends View {
	private Button createNewGarden;
	private Button loadGarden;
	private Image backgroundImage;
	private Stage mainMenuStage;
	private Scene mainMenuScene;
	
	/**
	 * 
	 */
	
	/**
	 * 
	 * @param theStage
	 */
	public MainMenu() {
		createNewGarden = new Button("Create New Garden");
		loadGarden = new Button("Load Garden");
		
		backgroundImage = new Image("no images");
	}
	
	/**
	 * 
	 */
	public void templatePopUp() {
		System.out.println("construct instructions popup");
	}
	
	/**
	 * 
	 * @param theStage
	 */
	public void showMainMenu(Stage theStage) {
		
	}
}
