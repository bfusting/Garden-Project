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
	private static ArrayList<TitledPane> panes;
	private static int fontSize = 12;
	
	
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
		
		
		Text enteringPreferencesText= new Text("Once a template is selected the Preferences screen will appear. Each preferences screen \nwill have the following in common:\n\n" +
		"Preferred Color: The color of plants that are most desirable to you\n\n" + "Prefered Bloom Season: The season which your preferred plants will bloom in\n\n"
				+ "Light Availability: How much light your plants require to live. \n1 means they "
				+ "need minmal light to live. \n3 is a happy medium of partial shade to live\n5 means the plant needs constant sunlight\n\n"
				+ "Water Availability: How much water your plants require to live. \n1 means they need minmal water to thrive\n"
				+ "3 means the plant needs a decent amount of water to live\n"
				+ "5 means the plant needs copious amounts of water to live\n\n"
				+ "For each template there may be different preferences which are listed below.\n\n"
				+ "SQUARE OR CUSTOM:\nWidth: the width of your garden in feet\nLength: the length of your garden\n\n"
				+ "TRIANGE: The number of rows you would like to have in your triangle plot");
		texts.add(enteringPreferencesText);
		
		Text designModeText = new Text("Once in the GardenDesigner you will be presented the following:\n\n" 
				+ "SELECTION TABS: Within the tabs are the plants you can drag and drop into your garden\nthese plants are" +
				"filtered so the ones you prefer are near the front of the selection.\n\n"
				+ "DRAG N' DROP: From the selection tabs you can click, hold the button down and \nrelease on the garden plot\n"
				+ "\nTILE EDITORS: Drag and drop these images to alter the condition of a garden tile.\n\t Water Drops: Drop the water drops to make a tile wetter\n"
				+ "\t Cracked Soil: Drop the cracked soil to make a location drier\n\t Sun: Drop to increase the amount of sunlight a tile is receiving\n\t"
				+ " Dark Sun: Drop to add shade to a certain tile\n\n" 
				+ "REMOVING PLANTS: Double click on a dropped plant to remove it from the plot\n\n"
				+ "CUSTOM GARDEN: When the Custom template is choosen from the Templates section you \ncan click on the soil to activate(solid) "
				+ "or deactivate(transparent) the tile. When a tile is deactivated you cannot drop a plant onto the area");
		texts.add(designModeText);
		
		Text alternateVersionsText = new Text("Here is where it will explain how to view, edit and save generated alternate\nversions of an unfinished garden design.");
		texts.add(alternateVersionsText);
		
		Text infoTipsText = new Text("INFO & TIPS: When dragging and dropping plants into the garden\n"
				+ "the Info and Tips section will be updated as the user adds or removes plants\nfrom their garden. \n\nEach tab follows this format:\n"
				+ "\tTitle: Common Name - Latin Name\n\tPlant Color: Color varities the plant comes in\n\tBloom Time: Season the plant blooms in\n\t"
				+ "Habit: How the plant is catergorized (Flower,Tree,Shrub)\n\tWater need: How much water the plant needs\n\tLight Requirements: How much light the plnat needs to live\n\n"
				+ "RECOMMENDATIONS: Based upon the preferences inputted each tab follows the following format:\n\t"
				+ "Title: Common Name\n\tPicture: Picture of the plant\n\tLatin Name: Latin name of the plant\n\tColor: Colors the plant comes in\n\tBloom Time: The season the plant blooms in if any");
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
	
	public static void setHighlightedSection(int screenIdx) {
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