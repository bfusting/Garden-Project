import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class ChooseTemplate extends View {
	ImageView squareTemplate;
	ImageView circleTemplate;
	ImageView triangleTemplate;
	ImageView designYourOwn;
	Button chooseSquare;
	Button chooseCircle;
	Button chooseTriangle;
	Button chooseDesign;
	
	/**
	 * 
	 * @param theStage
	 */
	public ChooseTemplate() {
	
		
		squareTemplate = new ImageView(new Image("no image"));
		circleTemplate = new ImageView(new Image("no image"));
		triangleTemplate = new ImageView(new Image("no image"));
		designYourOwn = new ImageView(new Image("no image"));
	}
	
	/**
	 * 
	 */
	public void showDesignWindow() {
		
	}
	
	/*
	 * 
	 */
	public void showGardenPlot() {
		
	}
	
	/**
	 * 
	 */
	public void preferencesPopUp() {
		
	}
	
	/**
	 * 
	 */
	public void showChooseTemplate() {
		
	}
	
}
