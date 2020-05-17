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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
	private ArrayList<Text> texts;
	private ArrayList<TitledPane> panes;
	private int fontSize = 12;
	
	
	/**
	 * Constructor for the Instructions class, which creates the Texts containing the instructions for each component of the program,
	 * anchors them to a new Scene and sets a new Stage with it.
	 */
	public Instructions() {
		texts = new ArrayList<Text>();
		panes = new ArrayList<TitledPane>();
		
		Text chooseTemplateText = new Text("To choose a template, click on a shape, then click 'To Preferences' to enter\nmore information about the garden, including the template dimensions if\nselecting a Square, Triangle or Custom plot."
				+ "\n\nSQUARE: For a rectangular or square grid with maximum dimensions of 6x9.\n\nCIRCLE: For a circular garden in a 5x5 grid. \n\nTRIANGLE: For a triangular grid with up to 4 rows."
				+ "\n\nCUSTOM: For a rectangular or square grid with maximum dimensions of 6x9,\nto be drawn into custom shapes when in Design Mode.See 'Editing Your\nGarden Design' for more details on drawing a custom shape.");
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
		
		Text seasonViewText = new Text("Here is where it will explain how to view different seasons.");
		texts.add(seasonViewText);
		
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
		AnchorPane seasonViewAP = new AnchorPane(seasonViewText);
		
		Accordion accord = new Accordion();
		VBox root = new VBox(accord);
		root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
		
		
		TitledPane choosingTemplatePane = new TitledPane("Choosing a Template",chooseTemplateAP);
		panes.add(choosingTemplatePane);
		TitledPane enteringPreferencesPane = new TitledPane("Entering Garden Characteristics and Preferences", enterPrefsAP);
		panes.add(enteringPreferencesPane);
		TitledPane designModePane = new TitledPane("Editing Your Garden Design",designModeAP);
		panes.add(designModePane);
		TitledPane alternateVersionsPane = new TitledPane("Saving and Editing Alternate Versions",altVersionsAP);
		panes.add(alternateVersionsPane);
		TitledPane infoTipsPane = new TitledPane("Viewing Plant Info and Recommendations",infoTipsAP);
		panes.add(infoTipsPane);
		TitledPane loadingGardenPane = new TitledPane("Loading an Existing Garden Design", loadGardenAP);
		panes.add(loadingGardenPane);
		TitledPane seasonViewPane = new TitledPane("Viewing Your Garden in Different Seasons",seasonViewAP);
		panes.add(seasonViewPane);
		panes.forEach(cell -> cell.setFont(Font.font("Verdana",FontWeight.NORMAL,fontSize)));
		
		accord.getPanes().addAll(panes);
		
		
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
	
	public void setHighlightedSection(int screenIdx) {
		for (int i=0;i<panes.size();i++) {
			if (i==screenIdx) {
				panes.get(i).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			} else {
				panes.get(i).setFont(Font.font("Verdana",FontWeight.NORMAL,fontSize));
			}
		}
		if (screenIdx==2) {
			panes.get(4).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
		}else if (screenIdx==3) {
			panes.get(4).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			panes.get(3).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			panes.get(6).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
		}
	}
	
	
	
}