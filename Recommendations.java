import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
*  Authors: Team 11-3: Bradley Fusting, Takiyah Price, Kelsey McRae, Malachi Parks
*  Class Section: foo11
*  Lab Section: foo31L
*  TA: Vineeth Gutta
*  Due: May 18th, 2foo2foo (5/18/2020)
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
 */
public class Recommendations extends View{
	private String weRecommendMessage;
	private Label recommendationMessage;
	private Image plantImage;
	private String name;
	private Date bloomTime;
	private int light;
	private int water;
	private ArrayList<String> animalsFed;
	private final int HEIGHT = 500;
	private final int WIDTH = 250;
	
	/**
	 * 
	 * @param i
	 * @param givenName
	 * @param lightNeed
	 * @param waterNeed
	 */
	public Recommendations(Image i, String givenName, Date date, int lightNeed, int waterNeed) {
		weRecommendMessage = "Hello World";
		recommendationMessage = new Label(weRecommendMessage);
		plantImage = i;
		bloomTime = date;
		name = givenName;
		light = lightNeed;
		water = waterNeed;
		animalsFed = new ArrayList<String>();
	}//Recommendations
	
	/**
	 * 
	 * @return
	 */
	public String getWeRecommendationMessage() {
		return "HELLO WORLD";
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setWeRecommendationMessage(String s) {
		weRecommendMessage = s;
	}
	
	/**
	 * 
	 * @return
	 */
	public Image getPlantImage() {
		return new Image("Hello World");
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return "hi";
	}
	
	/**
	 * 
	 * @return
	 */
	public Date getBloomTime() {
		return new Date(06,11,2020);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLightReq() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getWaterReq() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getAnimalsFed(){
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("Dog");
		aList.add("Cat");
		return aList;
	}
	
	/**
	 * 
	 * @param stage
	 */
	public void start(Stage stage) {
    	stage.setTitle("Recommendations");
    	BorderPane bPane = new BorderPane();
    	bPane.setCenter(recommendationMessage);
    	Scene scene = new Scene(bPane, WIDTH, HEIGHT);
    	stage.setScene(scene);
        stage.show();
	}
}
