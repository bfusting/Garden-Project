import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javafx.scene.Group;
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

		
		
		TitledPane shrubTest = null;
		
		
		TitledPane tree1 = null;
		TitledPane tree2 = null;
		TitledPane tree3 = null;
		TitledPane tree4 = null;
		TitledPane tree5 = null;
		
		TitledPane flower1 = null;
		TitledPane flower2 = null;
		TitledPane flower3 = null;
		TitledPane flower4 = null;
		TitledPane flower5 = null;
		
		TitledPane shrub1 = null;
		TitledPane shrub2 = null;
		TitledPane shrub3 = null;
		TitledPane shrub4 = null;
		TitledPane shrub5 = null;
		
		//Creating Tree TItledPanes
		try {
			Plant t = getRecTrees()[0];
			 tree1 = new TitledPane(t.getName(), new Text(t.getLatinName()
					 + "\n Color: " + t.getColor() + "\n Bloom Time: " + t.getBloomTime().toString()));
		}
		catch(Exception e) {
			 tree1 = null;
		}
		try {
			Plant t = getRecTrees()[1];
			 tree2 = new TitledPane(t.getName(), new Text(t.getLatinName()
					 + "\n Color: " + t.getColor() + "\n Bloom Time: " + t.getBloomTime().toString()));
		}
		catch(Exception e) {
			 tree2 = null;
		}
		try {
			Plant t = getRecTrees()[2];
			 tree3 = new TitledPane(t.getName(), new Text(t.getLatinName()
					 + "\n Color: " + t.getColor() + "\n Bloom Time: " + t.getBloomTime().toString()));
		}
		catch(Exception e) {
			 tree3 = null;
		}
		try {
			Plant t = getRecTrees()[3];
			 tree4 = new TitledPane(t.getName(), new Text(t.getLatinName()
					 + "\n Color: " + t.getColor() + "\n Bloom Time: " + t.getBloomTime().toString()));
		}
		catch(Exception e) {
			 tree4 = null;
		}
		try {
			Plant t = getRecTrees()[4];
			 tree5 = new TitledPane(t.getName(), new Text(t.getLatinName()
					 + "\n Color: " + t.getColor() + "\n Bloom Time: " + t.getBloomTime().toString()));
		}
		catch(Exception e) {
			 tree5 = null;
		}
		
		
		//Creating FLower TItlePanes
		try {
			Plant f = getRecFlowers()[0];
			flower1 = new TitledPane(getRecFlowers()[0].getName(), new Text(getRecFlowers()[0].getLatinName()
					 + "\n Color: " + f.getColor() + "\n Bloom Time: " + f.getBloomTime().toString()));
		}
		catch(Exception e) {
			 flower1 = null;
		}
		try {
			Plant f = getRecFlowers()[1];
			 flower2 = new TitledPane(f.getName(), new Text(f.getLatinName()
					 + "\n Color: " + f.getColor() + "\n Bloom Time: " + f.getBloomTime().toString()));
		}
		catch(Exception e) {
			 flower2 = null;
		}
		try {
			Plant f = getRecFlowers()[2];
			 flower3 = new TitledPane(f.getName(), new Text(f.getLatinName()
					 + "\n Color: " + f.getColor() + "\n Bloom Time: " + f.getBloomTime().toString()));
		}
		catch(Exception e) {
			 flower3 = null;
		}
		try {
			Plant f = getRecFlowers()[3];
			 flower4 = new TitledPane(f.getName(), new Text(f.getLatinName()
					 + "\n Color: " + f.getColor() + "\n Bloom Time: " + f.getBloomTime().toString()));
		}
		catch(Exception e) {
			 flower4 = null;
		}
		try {
			Plant f = getRecFlowers()[4];
			 flower5 = new TitledPane(f.getName(), new Text(f.getLatinName()
					 + "\n Color: " + f.getColor() + "\n Bloom Time: " + f.getBloomTime().toString()));
		}
		catch(Exception e) {
			 flower5 = null;
		}
		
		//Creating panes for Shrubs
		try {
			Plant s = getRecShrubs()[0];
			shrub1 = new TitledPane(s.getName(), new Text(s.getLatinName()
					+ "\n Color: " + s.getColor() + "\n Bloom Time: " + s.getBloomTime().toString()));
		}
		catch(Exception e) {
			 shrub1 = null;
		}
		try {
			Plant s = getRecShrubs()[1];
			 shrub2 = new TitledPane(s.getName(), new Text(s.getLatinName()
					 + "\n Color: " + s.getColor() + "\n Bloom Time: " + s.getBloomTime().toString()));
		}
		catch(Exception e) {
			 shrub2 = null;
		}
		try {
			Plant s = getRecShrubs()[2];
			 shrub3 = new TitledPane(s.getName(), new Text(s.getLatinName()
					 + "\n Color: " + s.getColor() + "\n Bloom Time:" + s.getBloomTime().toString()));
		}
		catch(Exception e) {
			 shrub3 = null;
		}
		try {
			Plant s = getRecShrubs()[3];
			 shrub4 = new TitledPane(s.getName(), new Text(s.getLatinName()
					 + "\n Color: " + s.getColor() + "\n Bloom Time:" + s.getBloomTime().toString()));
		}
		catch(Exception e) {
			 shrub4 = null;
		}
		try {
			Plant s = getRecShrubs()[4];
			 shrub5 = new TitledPane(s.getName(), new Text(s.getLatinName()
					 + "\n Color: " + s.getColor() + "\n Bloom Time:" + s.getBloomTime().toString()));
		}
		catch(Exception e) {
			 shrub5 = null;
		}
		
		ArrayList<TitledPane> paneList = new ArrayList<TitledPane>();
		
		paneList.add(tree1);
		paneList.add(tree2);
		paneList.add(tree3);
		paneList.add(tree4);
		paneList.add(tree5);
		paneList.add(flower1);
		paneList.add(flower2);
		paneList.add(flower3);
		paneList.add(flower4);
		paneList.add(flower5);
		paneList.add(shrub1);
		paneList.add(shrub2);
		paneList.add(shrub3);
		paneList.add(shrub4);
		paneList.add(shrub5);
		
		
		
		
		
		
		for(Text t : texts) {
			AnchorPane.setLeftAnchor(t, 5.0);
			AnchorPane.setRightAnchor(t, 5.0);
			AnchorPane.setTopAnchor(t, 5.0);
		}

	
	Accordion accord = new Accordion();
	VBox root = new VBox(accord);
	root.setBackground(new Background(new BackgroundFill(Color.DARKOLIVEGREEN,CornerRadii.EMPTY,Insets.EMPTY)));
	
	
	
	for(TitledPane tp : paneList) {
		if(tp != null) {
			accord.getPanes().add(tp);
		}
	}
	
	
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
	public Plant[] getRecFlowers() {
		Plant[] rec = new Plant[5];
		int count = 0;
		for(Plant p : this.c.getModel().getFlowerArr()) {
			if(p.getColor() == this.c.getModel().getUserPrefColor()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getFlowerArr()) {
			if(p.getBloomTime() == this.c.getModel().getUserPrefSeason()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getFlowerArr()) {
			if(p.getSunLightNeed() == this.c.getModel().getUserPrefLight()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getFlowerArr()) {
			if(p.getWaterNeed() == this.c.getModel().getUserPrefWater()) {
				rec[count] = p;
				count++;
			}
		}
		
		return rec;
	}
	
	/**
	 * 
	 * @return
	 */
	public Plant[] getRecTrees() {
		Plant[] rec = new Plant[5];
		int count = 0;
		for(Plant p : this.c.getModel().getTreeArr()) {
			if(p.getColor() == this.c.getModel().getUserPrefColor() && count < 5) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getTreeArr()) {
			if(p.getBloomTime() == this.c.getModel().getUserPrefSeason() && count < 5) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getTreeArr()) {
			if(p.getSunLightNeed() == this.c.getModel().getUserPrefLight() && count < 5) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getTreeArr()) {
			if(p.getWaterNeed() == this.c.getModel().getUserPrefWater() && count < 5) {
				rec[count] = p;
				count++;
			}
		}
		
		
		
		return rec;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Plant[] getRecShrubs() {
		Plant[] rec = new Plant[5];
		int count = 0;
		for(Plant p : this.c.getModel().getShrubArr()) {
			if(p.getColor() == this.c.getModel().getUserPrefColor()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getShrubArr()) {
			if(p.getBloomTime() == this.c.getModel().getUserPrefSeason()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getShrubArr()) {
			if(p.getSunLightNeed() == this.c.getModel().getUserPrefLight()) {
				rec[count] = p;
				count++;
			}
		}
		
		for(Plant p : this.c.getModel().getShrubArr()) {
			if(p.getWaterNeed() == this.c.getModel().getUserPrefWater()) {
				rec[count] = p;
				count++;
			}
		}
		
		
		return rec;
		
	}

	
	
}
