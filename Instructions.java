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
	private final int height=600;
	private final int width=500;
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
		
		
		Text enteringPreferencesText= new Text("Once a template is selected the Preferences screen will appear. Each\npreferences screen will have the following in common:\n\n" +
		"Preferred Color: The color of plants that are most desirable to you.\n\n" + "Prefered Bloom Season: The season which your preferred plants will bloom in.\n\n"
				+ "Light Availability: How much light your plants require to live. \n1 means they "
				+ "need minimal light to live. \n3 is a happy medium of partial shade to live.\n5 means the plant needs constant sunlight\n\n"
				+ "Water Availability: How much water your plants require to live. \n1 means they need minimal water to thrive.\n"
				+ "3 means the plant needs a decent amount of water to live.\n"
				+ "5 means the plant needs copious amounts of water to live.\n\n"
				+ "For each template there may be different preferences which are listed below.\n\n"
				+ "SQUARE OR CUSTOM:\nWidth: the width of your garden in feet.\nLength: the length of your garden.\n\n"
				+ "TRIANGLE: The number of rows you would like to have in your triangular plot.");
		texts.add(enteringPreferencesText);
		
		Text designModeText = new Text("Once in the GardenDesigner you will be presented the following:\n\n" 
				+ "SELECTION TABS: Within the tabs are the plants you can drag and drop into\nyour garden. These plants are" +
				"filtered so the ones you prefer are near the front\nof the selection.\n\n"
				+ "DRAG N' DROP: From the selection tabs you can click, hold the button down\n and release on the garden plot.\n"
				+ "\nTILE EDITORS: Drag and drop these images to alter the condition of a garden\ntile.\n\t Water Drops: Drop the water drops to make a tile wetter.\n"
				+ "\t Cracked Soil: Drop the cracked soil to make a location drier.\n\t Sun: Drop to increase the amount of sunlight a tile is receiving.\n\t"
				+ " Dark Sun: Drop to add shade to a certain tile.\n\n" 
				+ "REMOVING PLANTS: Double click on a dropped plant to remove it from the\nplot.\n\n"
				+ "CUSTOM GARDEN: When the Custom template is chosen from the\nTemplates section, you can click on the soil to activate (solid) "
				+ "or deactivate\n(translucent) the tile. When a tile is deactivated you cannot drop a plant onto\nthe area and it will disappear in the Final View.");
		texts.add(designModeText);
		
		
		Text infoTipsText = new Text("INFO & TIPS: When dragging and dropping plants into the garden\n"
				+ "the Info and Tips section will be updated as the user adds or removes plants\nfrom their garden. \n\nEach tab follows this format:\n"
				+ "\tTitle: Common Name - Latin Name\n\tPlant Color: Color varieties the plant comes in.\n\tBloom Time: Season the plant blooms in.\n\t"
				+ "Habit: How the plant is catergorized (Flower,Tree,Shrub).\n\tWater need: How much water the plant needs.\n\tLight Requirements: How much light the plant needs to live.\n\n"
				+ "RECOMMENDATIONS: Based upon the preferences input. Each tab follows\nthis format:\n\t"
				+ "Title: Common Name\n\tPicture: Picture of the plant.\n\tLatin Name: Latin name of the plant.\n\tColor: Colors the plant comes in.\n\tBloom Time: The season the plant blooms in, if any.");
		texts.add(infoTipsText);
		
		Text loadGardenText = new Text("SAVING: Click on the save button and specify a file name and location to save\nyour newly made masterpiece.\n" +
		"\nLOADING: From the Main Menu, click on 'Load Garden,' select a file and\nedit it to your hearts content.");
		texts.add(loadGardenText);
		
		Text seasonViewText = new Text("In the Garden Designer, click on the 'View Seasons' button. A new screen will\npop up to show your garden in alternate seasons. "
				+ "\n\nClick on each 'View Season' button to see how the garden would look in each\nseason.\n\n"
				+ "Once you are done looking at the seasons, click on the 'Close SeasonView'\nbutton to return.");
		texts.add(seasonViewText);
		
		for (Text t: texts) {
			AnchorPane.setLeftAnchor(t, distFromSide);
			AnchorPane.setRightAnchor(t, distFromSide);
			AnchorPane.setTopAnchor(t, distFromSide);
		}
		AnchorPane chooseTemplateAP = new AnchorPane(chooseTemplateText);
		AnchorPane enterPrefsAP = new AnchorPane(enteringPreferencesText);
		AnchorPane designModeAP = new AnchorPane(designModeText);
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
		TitledPane infoTipsPane = new TitledPane("Viewing Plant Info and Recommendations",infoTipsAP);
		panes.add(infoTipsPane);
		TitledPane loadingGardenPane = new TitledPane("Saving and Loading an Existing Garden Design", loadGardenAP);
		panes.add(loadingGardenPane);
		TitledPane seasonViewPane = new TitledPane("Viewing Your Garden in Different Seasons",seasonViewAP);
		panes.add(seasonViewPane);
		panes.forEach(cell -> cell.setFont(Font.font("Verdana",FontWeight.NORMAL,fontSize)));
		
		accord.getPanes().addAll(panes);
		
		
		instructionsStage = new Stage();
		instructionsStage.setScene(new Scene(root,width,height));
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
	/**
	 * Bolds the titles of the relevant sections of the instructions depending on where the user is in the application.
	 * @param screenIdx the index of the section to highlight corresponding to the ArrayList of TitledPanes.
	 */
	public static void setHighlightedSection(int screenIdx) {
		for (int i=0;i<panes.size();i++) {
			if (i==screenIdx) {
				panes.get(i).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			} else {
				panes.get(i).setFont(Font.font("Verdana",FontWeight.NORMAL,fontSize));
			}
		}
		if (screenIdx==2) {
			panes.get(3).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			panes.get(4).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
		}else if (screenIdx==3) {
			panes.get(4).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			panes.get(3).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
			panes.get(5).setFont(Font.font("Verdana",FontWeight.BOLD,fontSize));
		}
	}
	
	
	
}