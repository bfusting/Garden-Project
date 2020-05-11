import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.TitledPane;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: foo11
*  Lab Section: foo31L
*  TA: Vineeth Gutta
*  Due: May 18th, 2020 (5/18/2020)
*
*  This file contains the contents for the project for CISC275. The project for the 
*  class is to make gardening software for the township of Arden, DE to help
*  promote forest edge preservation. 
*  
*/

/**
 * 
 * @author Malachi Parks 
 * 
 * Used in the Design Garden tab, by clicking the recommendations button
 * reviews what plants the users should place in their garden based upon
 * the garden requirements and plant preferences
 *
 */
public class Recommendations extends Screen{
	private String weRecommendMessage;
	private Label recommendationMessage;
	private Image plantImage;
	private String name;
	private Seasons bloomTime;
	private int light;
	private int water;
	private ArrayList<String> animalsFed;
	private final int HEIGHT = 500;
	private final int WIDTH = 250;
	private Controller c;
	private Stage stage;
	private ArrayList<String> plantNames;
	/** USE THIS ONE AFTER ALPHA
	 * Takes in an image i which is the image of a plant
	 * date which is a date of when the plant comes into bloom
	 * lightNeed which is rated on a scale of 0-5 where 0 means no light where 5 needs a lot of light
	 * waterNeed which is rated on a scale of 0-5 where 0 means no water where 5 needs a lot of water
	 * <p>
	 * The constructor to create the Recommendations view
	 * 
	 * @param i Image of the plant recommended
	 * @param givenName name of the plant
	 * @param lightNeed light need of the plant recommended
	 * @param waterNeed water need of the plant recommended
	 * @see Recommendations
	 */
	/*
	public Recommendations(Image i, String givenName, Date date, int lightNeed, int waterNeed) {
		weRecommendMessage = "Hello World";
		// Chanege message above
		recommendationMessage = new Label(weRecommendMessage);
		plantImage = i;
		bloomTime = date;
		name = givenName;
		light = lightNeed;
		water = waterNeed;
		animalsFed = new ArrayList<String>();
	}//Recommendations
	
	/** USE THIS ONE AFTER ALPHA
	 * Takes in an image i which is the image of a plant
	 * date which is a date of when the plant comes into bloom
	 * lightNeed which is rated on a scale of 0-5 where 0 means no light where 5 needs a lot of light
	 * waterNeed which is rated on a scale of 0-5 where 0 means no water where 5 needs a lot of water
	 * <p>
	 * The constructor to create the Recommendations view
	 * 
	 * @param i Image of the plant recommended
	 * @param givenName name of the plant
	 * @param lightNeed light need of the plant recommended
	 * @param waterNeed water need of the plant recommended
	 * @see Recommendations
	 */
	public Recommendations(Controller controller) {
		weRecommendMessage = "This is where Recommendations will go based on GardenPlot";
		// Chanege message above
		recommendationMessage = new Label(weRecommendMessage);
		plantImage = null;
		bloomTime = null;
		name = null;
		light = 0;
		water = 0;
		animalsFed = new ArrayList<String>();
		c = controller;
		
		
			
       
		
	}//Recommendations
	
	/**
	 * Returns the message used to set the label in the Recommendations View
	 * <p>
	 * Getter for Recommendation Message
	 * 
	 * @return String representing the static message saying "We recommend the user
	 * chooses these plants based upon preferences and gardenType"
	 * @see recommendationMessaage
	 */
	public String getWeRecommendationMessage() {
		return weRecommendMessage;
	}
	
	/**
	 * Takes in a new string which is the new Recommendations message for the 
	 * Recommendations Page
	 * <p>
	 * Setter for WeRecommendationMessage
	 * 
	 * @param s new string to set the Recommendations view message
	 * @see recommendationMessage
	 */
	public void setWeRecommendationMessage(String s) {
		weRecommendMessage = s;
	}
	
	/**
	 * Returns the image of the plant in recommendations - would return the 
	 * plantImage attribute. PlantImage will be used in an ImageView
	 * <p>
	 * Getter for plantImage Attribute
	 * 
	 * @return plantImage which is the image of a plant used in recommendations
	 * @see ImageView
	 * @see Image
	 */
	public Image getPlantImage() {
		return plantImage;
	}
	
	/**
	 * Returns a string representing the latin name of the plant
	 * <p>
	 * Getter for name attribute
	 * 
	 * @return string representing the name of the plant recommended
	 * @Plant
	 */
	public String getName() {
		return "hi";
	}
	
	/**
	 * Returns a Seasons Enumeration representing when the bloom time of the plant begins
	 * <p>
	 * Getter for bloomTime attribute
	 * 
	 * @return date representing the beginning bloom time of the plant
	 * @see Plant
	 */
	public Seasons getBloomTime() {
		return bloomTime;
	}
	
	/**
	 * Returns a int representing the light amount the plant requires to function.
	 * The range is from 0 which is minimal light to 5 which is max light. All information
	 * should correlate to a plant
	 * <p>
	 * Getter for light attribute
	 * 
	 * @return int representing light requirement
	 * @see Plant
	 */
	public int getLightReq() {
		return light;
	}
	
	/**
	 * Returns a int representing the water amount the plant requires to function.
	 * The range is from 0 which is minimal water to 5 which is max water. All information
	 * should correlate to a plant
	 * <p>
	 * Getter for water attribute
	 * 
	 * @return int representing water requirement
	 * @see Plant
	 */
	public int getWaterReq() {
		return water;
	}
	
	/**
	 * Returns a ArrayList of Strings representing the animals the plant feeds
	 * in the ecosystem. Correlates to the animals feed by a specific plant within 
	 * the plant class
	 * <p>
	 * Getter for animalsFed attribute
	 * 
	 * @return ArrayList of animals feed by plant
	 * @see Plant
	 */
	public ArrayList<String> getAnimalsFed(){
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("Dog");
		aList.add("Cat");
		return aList;
	}
	
	/**
	 * Takes in a stage which is used to create the Recommendations window in JavaFX.
	 * <p>
	 * showRecommendations is used to pop open a new window in JavaFX and then sets the 
	 * center of the border pane to the recommendation message (may swap to the top later on)
	 * and then shows the scene
	 * 
	 * @param stage primary stage used of the window view
	 * @see Stage
	 * @see Scene
	 */
	public void showRecommendations() {
	
		ArrayList<Text> texts = new ArrayList<Text>();
		texts.add(new Text("Tree"));
		texts.add(new Text("Shrub"));
		texts.add(new Text("Flower"));
		
		TitledPane treeTest = null;
		TitledPane shrubTest = null;
		TitledPane flowerTest = null;
	
		for(Text t : texts) {
			AnchorPane.setLeftAnchor(t, 5.0);
			AnchorPane.setRightAnchor(t, 5.0);
			AnchorPane.setTopAnchor(t, 5.0);
		}
	
	AnchorPane treeAccord = new AnchorPane(new Text("Trees"));
	AnchorPane shrubAccord = new AnchorPane(new Text("Shrubs"));
	AnchorPane flowerAccord = new AnchorPane(new Text("Flowers"));
	
	Accordion accord = new Accordion();
	VBox root = new VBox(accord);
	root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
	
	try {
		for(int i = 0; i < this.getRecPlants().length; i++) {
			if(this.getRecPlants()[i] != null) {
				treeTest = new TitledPane("Trees", new Text(this.getRecPlants()[i].getName()));
				shrubTest = new TitledPane("Shrubs", new Text(this.getRecPlants()[i].getName()));
				flowerTest = new TitledPane("Flowers", new Text(this.getRecPlants()[i].getName()));
			}
		}
		
	}
	catch(Exception e) {
		treeTest = new TitledPane("Trees", new Text("No Recommendations"));
		shrubTest = new TitledPane("Shrubs", new Text("No Recommendations"));
		flowerTest = new TitledPane("Flowers", new Text("No Recommendations"));
		
	}
	
	accord.getPanes().addAll(treeTest, flowerTest, shrubTest);
	
	stage = new Stage();
	stage.setTitle("Recommendations");
	BorderPane bPane = new BorderPane();
	bPane.setCenter(recommendationMessage);
	Scene scene = new Scene(root, WIDTH, HEIGHT);
	stage.setScene(scene);
	}
	



	@Override
	public void showScreen() {
		//should consolidate into one showScreen method
		showRecommendations();
		stage.show();
		stage.toFront();
		

	}
	
	@Override
	public void closeScreen() {
		stage.close();
	}
	

	
	
	
	/**
	 * Creates and returns a 2D array of recommended addons to be displayed on the Recommendations screen
	 * @return
	 * returns rec - the 2D array of recommended addOns
	 */
	public Plant[] getRecPlants() {
		Plant[] rec= {};
		int count = 0;
		for(int i = 0; i < this.c.getModel().getUserPlot().getWidth(); i++) {
			for(int k = 0; k < this.c.getModel().getUserPlot().getLength(); k++) {
			
				
				//getting recommended plants from every gardenTile
				//This might want to be changed to include fewer tiles, like every other tile or something
				for(int j = 0; j < this.c.getModel().getUserPlot().getLayout()[i][k].getRecommendations(
						this.c.getModel().getUserPlot().getSurroundingInfo(i, k)).length; j++) {
					rec[count] = this.c.getModel().getUserPlot().getLayout()[i][k].getRecommendations(
							this.c.getModel().getUserPlot().getSurroundingInfo(i, k))[j];
					
				}
				
			
				
				count++;
			}
			
		}
		
		
		return rec;
		
	}
	

}
