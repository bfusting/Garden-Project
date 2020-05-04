import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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

//Last edited: 5-1-20 2:29AM

/**
 * 
 *  Screen that handles the creation and presentation of the instructions screen, where the user can
 * read a detailed explanation of the program controls in a separate window whenever they press an
 * instructions Button.
 * 
 * @see Screen
 * @author Takiyah Price
 */

public class Instructions extends Screen {
	private Stage instructionsStage;
	private final int dimensions = 500;
	private final double distFromSide = 5.0;
	
	
	
	/**
	 * Constructor for the Instructions class, which creates the Texts containing the instructions for each component of the program,
	 * anchors them to a new Scene and sets a new Stage with it.
	 */
	public Instructions() {
		ArrayList<Text> texts = new ArrayList<Text>();
		
		Text chooseTemplateText = new Text("Here is where it will explain how to choose a template. You can choose a \npreset rectangular, square or circular plot or draw the parameters yourself.");
		texts.add(chooseTemplateText);
		
		
		Text enteringPreferencesText= new Text("Here is where it will explain how to enter land characteristics and the meaning\nof each one, as well as personal preferences.");
		texts.add(enteringPreferencesText);
		
		Text designModeText = new Text("Here is where it will explain how the add plants to the garden and the other\nfeatures available in editing mode, such as viewing information on the\nselected plant.");
		texts.add(designModeText);
		
		Text alternateVersionsText = new Text("Here is where it will explain how to view, edit and save generated alternate\nversions of an unfinished garden design.");
		texts.add(alternateVersionsText);
		
		Text infoTipsText = new Text("Here is where it will explain where to find info and maintenance tips on the\nplants currently in the garden design.");
		texts.add(infoTipsText);
		
		Text loadGardenText = new Text("Here is where it will explain how to load in an exisiting Garden and how to\nsave a design after editing.");
		texts.add(loadGardenText);
		
		
		
		
		for (Text t: texts) {
			AnchorPane.setLeftAnchor(t, distFromSide);
			AnchorPane.setRightAnchor(t, distFromSide);
			AnchorPane.setTopAnchor(t, distFromSide);
		}
		AnchorPane chooseTemplateAP = new AnchorPane(chooseTemplateText);
		AnchorPane enterPrefsAP = new AnchorPane(enteringPreferencesText);
		AnchorPane designModeAP = new AnchorPane(designModeText);
		AnchorPane altVersionsAP = new AnchorPane(alternateVersionsText);
		AnchorPane infoTipsAP = new AnchorPane(infoTipsText);
		AnchorPane loadGardenAP = new AnchorPane(loadGardenText);
		
		
	
		
		Accordion accord = new Accordion();
		VBox root = new VBox(accord);
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		TitledPane choosingTemplatePane = new TitledPane("Choosing a Template or Drawing a Custom Plot",chooseTemplateAP);
		TitledPane enteringPreferencesPane = new TitledPane("Entering Garden Characteristics and Preferences", enterPrefsAP);
		TitledPane designModePane = new TitledPane("Editing Your Garden Design",designModeAP);
		TitledPane alternateVersionsPane = new TitledPane("Saving and Editing Alternate Versions",altVersionsAP);
		TitledPane infoTipsPane = new TitledPane("Viewing Plant Info and Maintenance Tips",infoTipsAP);
		TitledPane loadingGardenPane = new TitledPane("Loading an Existing Garden Design", loadGardenAP);
		
		accord.getPanes().addAll(choosingTemplatePane,enteringPreferencesPane,designModePane,alternateVersionsPane,infoTipsPane,loadingGardenPane);
		
		
		
		
		instructionsStage = new Stage();
		instructionsStage.setScene(new Scene(root,dimensions,dimensions));
		instructionsStage.setTitle("Instructions");
		
	}
	
	
	
	@Override
	public void showScreen() {
		instructionsStage.show();
		instructionsStage.toFront();
	}
	
	@Override
	public void closeScreen() {
		instructionsStage.close();
	}
	
	
	
	
	
}