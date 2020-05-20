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
import javafx.scene.shape.Circle;
import javafx.scene.paint.*;
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
	
	private final int HEIGHT = 500;
	private final int WIDTH = 250;
	private Controller c;
	private Stage stage;
	private ArrayList<String> plantNames;
	private String weRecommendMessage;
	private Label recommendationMessage;
	
	
	/** USE THIS ONE AFTER ALPHA
	 * <p>
	 * The constructor to create the Recommendations view
	 * 
	 * 
	 * @param controller 
	 * @see Recommendations
	 */
	public Recommendations(Controller controller) {
		weRecommendMessage = "This is where Recommendations will go based on GardenPlot";
		// Chanege message above
		recommendationMessage = new Label(weRecommendMessage);
	
		c = controller;
		
		
			
       
		
	}//Recommendations
	
	
	/**
	 * Creates 15 TitledPanes to display Recommended plants in along with
	 * a picture of each plant and other plant data
	 * 
	 * 
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
			Circle plantC = new Circle(20, new ImagePattern(new Image(t.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + t.getLatinName()
					 + "\nColor: " + t.getColor() + "\nBloom Time: " + t.getBloomTime().toString()));
			
			 tree1 = new TitledPane(t.getName(), groupTest);
			 
		}
		catch(Exception e) {
			 tree1 = null;
		}
		try {
			Plant t = getRecTrees()[1];
			Circle plantC = new Circle(20, new ImagePattern(new Image(t.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + t.getLatinName()
					 + "\nColor: " + t.getColor() + "\nBloom Time: " + t.getBloomTime().toString()));
			
			 tree2 = new TitledPane(t.getName(), groupTest);
		}
		catch(Exception e) {
			 tree2 = null;
		}
		try {
			Plant t = getRecTrees()[2];
			Circle plantC = new Circle(20, new ImagePattern(new Image(t.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + t.getLatinName()
					 + "\nColor: " + t.getColor() + "\nBloom Time: " + t.getBloomTime().toString()));
			
			 tree3 = new TitledPane(t.getName(), groupTest);
		}
		catch(Exception e) {
			 tree3 = null;
		}
		try {
			Plant t = getRecTrees()[3];
			Circle plantC = new Circle(20, new ImagePattern(new Image(t.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + t.getLatinName()
					 + "\nColor: " + t.getColor() + "\nBloom Time: " + t.getBloomTime().toString()));
			
			 tree4 = new TitledPane(t.getName(), groupTest);
		}
		catch(Exception e) {
			 tree4 = null;
		}
		try {
			Plant t = getRecTrees()[4];
			Circle plantC = new Circle(20, new ImagePattern(new Image(t.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + t.getLatinName()
					 + "\nColor: " + t.getColor() + "\nBloom Time: " + t.getBloomTime().toString()));
			
			 tree5 = new TitledPane(t.getName(), groupTest);
		}
		catch(Exception e) {
			 tree5 = null;
		}
		
		
		//Creating FLower TItlePanes
		try {
			Plant f = getRecFlowers()[0];
			Circle plantC = new Circle(20, new ImagePattern(new Image(f.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + f.getLatinName()
					 + "\nColor: " + f.getColor() + "\nBloom Time: " + f.getBloomTime().toString()));
			
			 flower1 = new TitledPane(f.getName(), groupTest);
		}
		catch(Exception e) {
			 flower1 = null;
		}
		try {
			Plant f = getRecFlowers()[1];
			Circle plantC = new Circle(20, new ImagePattern(new Image(f.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + f.getLatinName()
					 + "\nColor: " + f.getColor() + "\nBloom Time: " + f.getBloomTime().toString()));
			
			 flower2 = new TitledPane(f.getName(), groupTest);
		}
		catch(Exception e) {
			 flower2 = null;
		}
		try {
			Plant f = getRecFlowers()[2];
			Circle plantC = new Circle(20, new ImagePattern(new Image(f.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + f.getLatinName()
					 + "\nColor: " + f.getColor() + "\nBloom Time: " + f.getBloomTime().toString()));
			
			 flower3 = new TitledPane(f.getName(), groupTest);
		}
		catch(Exception e) {
			 flower3 = null;
		}
		try {
			Plant f = getRecFlowers()[3];
			Circle plantC = new Circle(20, new ImagePattern(new Image(f.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + f.getLatinName()
					 + "\nColor: " + f.getColor() + "\nBloom Time: " + f.getBloomTime().toString()));
			
			 flower4 = new TitledPane(f.getName(), groupTest);
		}
		catch(Exception e) {
			 flower4 = null;
		}
		try {
			Plant f = getRecFlowers()[4];
			Circle plantC = new Circle(20, new ImagePattern(new Image(f.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + f.getLatinName()
					 + "\nColor: " + f.getColor() + "\nBloom Time: " + f.getBloomTime().toString()));
			
			 flower5 = new TitledPane(f.getName(), groupTest);
		}
		catch(Exception e) {
			 flower5 = null;
		}
		
		//Creating panes for Shrubs
		try {
			Plant s = getRecShrubs()[0];
			Circle plantC = new Circle(20, new ImagePattern(new Image(s.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + s.getLatinName()
					 + "\nColor: " + s.getColor() + "\nBloom Time: " + s.getBloomTime().toString()));
			
			 shrub1 = new TitledPane(s.getName(), groupTest);
		}
		catch(Exception e) {
			 shrub1 = null;
		}
		try {
			Plant s = getRecShrubs()[1];
			Circle plantC = new Circle(20, new ImagePattern(new Image(s.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + s.getLatinName()
					 + "\nColor: " + s.getColor() + "\nBloom Time: " + s.getBloomTime().toString()));
			
			 shrub2 = new TitledPane(s.getName(), groupTest);
		}
		catch(Exception e) {
			 shrub2 = null;
		}
		try {
			Plant s = getRecShrubs()[2];
			Circle plantC = new Circle(20, new ImagePattern(new Image(s.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + s.getLatinName()
					 + "\nColor: " + s.getColor() + "\nBloom Time: " + s.getBloomTime().toString()));
			
			 shrub3 = new TitledPane(s.getName(), groupTest);
		}
		catch(Exception e) {
			 shrub3 = null;
		}
		try {
			Plant s = getRecShrubs()[3];
			Circle plantC = new Circle(20, new ImagePattern(new Image(s.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + s.getLatinName()
					 + "\nColor: " + s.getColor() + "\nBloom Time: " + s.getBloomTime().toString()));
			
			 shrub4 = new TitledPane(s.getName(), groupTest);
		}
		catch(Exception e) {
			 shrub4 = null;
		}
		try {
			Plant s = getRecShrubs()[4];
			Circle plantC = new Circle(20, new ImagePattern(new Image(s.getSeasonsImgArr()[0])));
			Group groupTest = new Group(plantC, new Text("\n\n" + s.getLatinName()
					 + "\nColor: " + s.getColor() + "\nBloom Time: " + s.getBloomTime().toString()));
			
			 shrub5 = new TitledPane(s.getName(), groupTest);
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
	 * Creates an array of Plants consisting of only Flowers.  The plants should match somewhat the preferences of the user
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
	 * Creates an array of Plants consisting of only Trees.  The plants should match somewhat the preferences of the user
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
	 * Creates an array of Plants consisting of only shrubs.  The plants should match somewhat the preferences of the user
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
