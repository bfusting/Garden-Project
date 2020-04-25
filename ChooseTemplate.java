import javafx.scene.Scene;
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
 * View that handles the creation and presentation of the screen containing Buttons
 * for choosing a square, circular or triangular garden layout or drawing the perimeter
 * manually. 
 * 
 * @author Takiyah Price
 *
 */

public class ChooseTemplate extends View {
	private Scene chooseTemplateScene;
	private ImageView squareTemplate;
	private ImageView circleTemplate;
	private ImageView triangleTemplate;
	private ImageView designYourOwn;
	private Button chooseSquare;
	private Button chooseCircle;
	private Button chooseTriangle;
	private Button chooseDesign;
	
	/**
	 * Constructor for ChooseTemplate that creates Buttons for choosing the shape of the 
	 * garden and puts them on a new Scene. Each Button has an ImageView indicating its 
	 * respective layout that will be created on click.
	 * 
	 */
	public ChooseTemplate() {
	
		
		//squareTemplate = new ImageView(new Image("no image"));
		//circleTemplate = new ImageView(new Image("no image"));
		//triangleTemplate = new ImageView(new Image("no image"));
		//designYourOwn = new ImageView(new Image("no image"));
	}
	
	/**
	 * Sets the given Stage with the chooseTemplate Scene containing the Buttons for choosing
	 * the garden shape and makes it visible to the user.
	 * 
	 * @param theStage the Stage that will be set with the chooseTemplate Scene and shown to
	 * the user
	 * 
	 * @see ChooseTemplate#chooseTemplateScene
	 */
	public void showChooseTemplate(Stage theStage) {
		
	}
	
}
