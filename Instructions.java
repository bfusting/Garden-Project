import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
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

//Last edited: 4-26-20 3:42PM

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
	private Scene instructionsScene;
	private Stage instructionsStage;
	
	
	
	
	/**
	 * Constructor for the Instructions class that creates the String text and the Label holding them,
	 * and creates a new Scene to present the screen and a new Stage to be viewed simultaneously as the 
	 * main screen.
	 */
	public Instructions() {
		ArrayList<Text> texts = new ArrayList<Text>();
		
		Text chooseTemplateText = new Text("Here is where it will explain how to choose a template. You can choose a \npreset rectangular, square or circular plot or draw the parameters yourself.");
		texts.add(chooseTemplateText);
		
		
		Text enteringPreferencesText= new Text("Here is where it will explain how to enter land characteristics and the meaning\nof each one, as well as personal preferences.");
		texts.add(enteringPreferencesText);
		
		Text designModeText = new Text("Here is where it will explain how the add plants to the garden and the other\nfeatures available in editing mode, such as viewing information on the\nselected plant.");
		texts.add(designModeText);
		
		Text alternateVersionsText = new Text("Here is where it will explain how to view, edit and save generated alternate versions\nof an unfinished garden design.");
		texts.add(alternateVersionsText);
		
		Text infoTipsText = new Text("Here is where it will explain where to find info and maintenance tips on the plants currently in the garden design.");
		texts.add(infoTipsText);
		
		Text loadGardenText = new Text("Here is where it will explain how to load in an exisiting Garden and how to save a design after editing.");
		texts.add(loadGardenText);
		
		
		//AnchorPane textAP = new AnchorPane();
		
		for (Text t: texts) {
			AnchorPane.setLeftAnchor(t, 5.0);
			AnchorPane.setRightAnchor(t, 5.0);
			AnchorPane.setTopAnchor(t, 5.0);
		}
		AnchorPane chooseTemplateAP = new AnchorPane(chooseTemplateText);
		AnchorPane enterPrefsAP = new AnchorPane(enteringPreferencesText);
		AnchorPane designModeAP = new AnchorPane(designModeText);
		AnchorPane altVersionsAP = new AnchorPane(alternateVersionsText);
		AnchorPane infoTipsAP = new AnchorPane(infoTipsText);
		AnchorPane loadGardenAP = new AnchorPane(loadGardenText);
		
		
		
		/*/AnchorPane.setLeftAnchor(chooseTemplateText, 5.0);
		//AnchorPane.setLeftAnchor(enteringPreferencesText,5.0);
		AnchorPane.setLeftAnchor(designModeText,5.0);
		AnchorPane.setLeftAnchor(alternateVersionsText, 5.0);
		AnchorPane.setLeftAnchor(infoTipsText, 5.0);
		AnchorPane.setLeftAnchor(loadGardenText, 5.0);
		
		AnchorPane.setLeftAnchor(infoTipsText, 5.0);
		AnchorPane.setRightAnchor(chooseTemplateText, 5.0);
		AnchorPane.setTopAnchor(chooseTemplateText, 5.0);*/
		
		//textAP.getChildren().add(chooseTemplateText);
		
		Accordion accord = new Accordion();
		VBox root = new VBox(accord);
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		TitledPane choosingTemplatePane = new TitledPane("Choosing a Template or Drawing a Custom Plot",chooseTemplateAP);
		//chooseTemplateText.wrappingWidthProperty().bind(choosingTemplatePane.widthProperty());
		TitledPane enteringPreferencesPane = new TitledPane("Entering Garden Characteristics and Preferences", enterPrefsAP);
		TitledPane designModePane = new TitledPane("Editing Your Garden Design",designModeAP);
		TitledPane alternateVersionsPane = new TitledPane("Saving and Editing Alternate Versions",altVersionsAP);
		TitledPane infoTipsPane = new TitledPane("Viewing Plant Info and Maintenance Tips",infoTipsAP);
		TitledPane loadingGardenPane = new TitledPane("Loading an Existing Garden Design", loadGardenAP);
		
		accord.getPanes().addAll(choosingTemplatePane,enteringPreferencesPane,designModePane,alternateVersionsPane,infoTipsPane,loadingGardenPane);
		
		
		
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
		instructionsStage.toFront();
		
	}
	
	
	
	
}