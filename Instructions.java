import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
	private Text instructionsText;
	private Scene instructionsScene;
	private Stage instructionsStage;
	//private String text;
	private String choosingTemplateText;
	private String enteringPreferencesText;
	private String designModeText;
	private String alternateVersionsText;
	private String infoTipsText;
	private String loadingGardenText;
	
	
	
	/**
	 * Constructor for the Instructions class that creates the String text and the Label holding them,
	 * and creates a new Scene to present the screen and a new Stage to be viewed simultaneously as the 
	 * main screen.
	 */
	public Instructions() {
		//text = "instructions undefined";
		//instructions = new Label(text);
		choosingTemplateText= "Here is where it will explain how to choose a template. You can choose a preset rectangular, square or circular plot or draw the parameters yourself.";
		enteringPreferencesText = "Here is where it will explain how to enter land characteristics and the meaning of each one, as well as personal preferences.";
		designModeText= "Here is where it will explain how the add plants to the garden and the other features available in editing mode, such as viewing information on the selected plant.";
		alternateVersionsText = "Here is where it will explain how to view, edit and save generated alternate versions of an unfinished garden design.";
		infoTipsText = "Here is where it will explain where to find info and maintenance tips on the plants currently in the garden design.";
		loadingGardenText= "Here is where it will explain how to load in an exisiting Garden and how to save a design after editing.";
		
		
		Accordion accord = new Accordion();
		VBox root = new VBox(accord);
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		TitledPane choosingTemplatePane = new TitledPane("Choosing a Template or Drawing a Custom Plot",new Label(choosingTemplateText));
		TitledPane enteringPreferencesPane = new TitledPane("Entering Garden Characteristics and Preferences", new Label(enteringPreferencesText));
		TitledPane designModePane = new TitledPane("Editing Your Garden Design",new Label(designModeText));
		TitledPane alternateVersionsPane = new TitledPane("Saving and Editing Alternate Versions",new Label(alternateVersionsText));
		TitledPane infoTipsPane = new TitledPane("Viewing Plant Info and Maintenance Tips",new Label(infoTipsText));
		TitledPane loadingGardenPane = new TitledPane("Loading an Existing Garden Design", new Label(loadingGardenText));
		
		accord.getPanes().addAll(choosingTemplatePane,enteringPreferencesPane,designModePane,alternateVersionsPane,infoTipsPane,loadingGardenPane);
		
		
		//instructionsScene = new Scene(instructions,500,500);
		instructionsScene = new Scene(root,500,500);
		instructionsStage = new Stage();
		instructionsStage.setScene(instructionsScene);
		instructionsStage.setTitle("Instructions");
	}
	
	/**
	 * Gets the String text detailing how to use the program
	 * @return text the instructions detailing how to use this program
	 */
	/*public String getText() {
		return text;
	}*/
	
	
	public void showInstructions() {
		instructionsStage.show();
		
	}
	
	
	
	
}